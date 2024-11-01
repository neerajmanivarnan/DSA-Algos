#include<stdio.h>
#include<string.h>
#include<ctype.h>

char fir[20][20];  // Store FIRST sets
char fol[20][20];  // Store FOLLOW sets
int follow_size[20] = {0};  // Track size of FOLLOW sets for each variable
int first_size[20] = {0};   // Track size of FIRST sets
int c1=0;

int is_in_follow(char symbol, int idx) {
    for (int i = 0; i < follow_size[idx]; i++) {
        if (fol[idx][i] == symbol) {
            return 1;  // Symbol is already in the FOLLOW set
        }
    }
    return 0;  // Symbol is not in the FOLLOW set
}

int is_in_first(char symbol, int idx) {
    for (int i = 0; i < first_size[idx]; i++) {
        if (fir[idx][i] == symbol) {
            return 1;  // Symbol is already in the FIRST set
        }
    }
    return 0;  // Symbol is not in the FIRST set
}

void find_first(char symbol, char grammar[20][20], int np, int *epsilon_present, int idx) {
    for (int i = 0; i < np; i++) {
        if (grammar[i][0] == symbol) {
            // If it's a terminal or epsilon, add it to the FIRST set
            if (!isupper(grammar[i][2])) {
                if (grammar[i][2] == 'e') {
                    *epsilon_present = 1;
                } else {
                    if (!is_in_first(grammar[i][2], idx)) {
                        printf("%c\t", grammar[i][2]);
                        fir[idx][first_size[idx]++] = grammar[i][2];
                    }
                }
            } else {
                // If it's a non-terminal, recursively find its FIRST
                int epsilon = 0;
                find_first(grammar[i][2], grammar, np, &epsilon, idx);
                if (epsilon) {
                    int j = 3;
                    while (grammar[i][j] != '\0' && isupper(grammar[i][j])) {
                        epsilon = 0;
                        find_first(grammar[i][j], grammar, np, &epsilon, idx);
                        if (!epsilon) break;
                        j++;
                    }
                    if (grammar[i][j] == '\0') {
                        *epsilon_present = 1;  // Propagate epsilon
                    }
                }
            }
        }
    }
}

void follow(char symbol, char grammar[20][20], int np, char variables[20], int nv) {
    int symbol_index;
    for (symbol_index = 0; symbol_index < nv; symbol_index++) {
        if (variables[symbol_index] == symbol) break;
    }

    if (grammar[0][0] == symbol && !is_in_follow('$', symbol_index)) {
        // Add $ to FOLLOW of the start symbol
        fol[symbol_index][follow_size[symbol_index]++] = '$';
        printf("$\t");
    }

    for (int i = 0; i < np; i++) {
        for (int j = 2; j < strlen(grammar[i]); j++) {
            if (grammar[i][j] == symbol) {
                // If symbol is followed by a terminal
                if (grammar[i][j + 1] != '\0' && !isupper(grammar[i][j + 1])) {
                    if (!is_in_follow(grammar[i][j + 1], symbol_index)) {
                        fol[symbol_index][follow_size[symbol_index]++] = grammar[i][j + 1];
                        printf("%c\t", grammar[i][j + 1]);
                    }
                }
                // If symbol is followed by a non-terminal
                else if (grammar[i][j + 1] != '\0' && isupper(grammar[i][j + 1])) {
                    int next_index;
                    int epsilon_present = 0;

                    // Find the index of the next variable
                    for (next_index = 0; next_index < nv; next_index++) {
                        if (variables[next_index] == grammar[i][j + 1]) break;
                    }

                    find_first(grammar[i][j + 1], grammar, np, &epsilon_present, next_index);

                    for (int k = 0; k < first_size[next_index]; k++) {
                        if (fir[next_index][k] != 'e' && !is_in_follow(fir[next_index][k], symbol_index)) {
                            fol[symbol_index][follow_size[symbol_index]++] = fir[next_index][k];
                            printf("%c\t", fir[next_index][k]);
                        }
                    }

                    // If epsilon is in the first set of the next variable, add FOLLOW of the LHS
                    if (epsilon_present) {
                        if (grammar[i][j + 2] == '\0' && grammar[i][0] != symbol) {
                            follow(grammar[i][0], grammar, np, variables, nv); // FOLLOW of LHS
                        }
                    }
                }
                // If symbol is at the end of a production, add FOLLOW(LHS) to FOLLOW(symbol)
                else if (grammar[i][j + 1] == '\0' && grammar[i][0] != symbol) {
                    int lhs_index;
                    // Find the index of the LHS of the production
                    for (lhs_index = 0; lhs_index < nv; lhs_index++) {
                        if (variables[lhs_index] == grammar[i][0]) break;
                    }
                    // Add FOLLOW(LHS) to FOLLOW(symbol)
                    for (int k = 0; k < follow_size[lhs_index]; k++) {
                        if (!is_in_follow(fol[lhs_index][k], symbol_index)) {
                            fol[symbol_index][follow_size[symbol_index]++] = fol[lhs_index][k];
                            printf("%c\t", fol[lhs_index][k]);
                        }
                    }
                }
            }
        }
    }
}

int main() {
    int np, nv;
    char grammar[20][20];
    char variables[20];
// ----------------------------------------------
    printf("Enter the number of Productions: ");
    scanf("%d", &np);
// ----------------------------------------------
    printf("Enter the productions:\n");
    for (int i = 0; i < np; i++) {
        printf("Production %d: ", i + 1);
        scanf("%s", grammar[i]);
    }

// ----------------------------------------------

    printf("Enter the number of variables: ");
    scanf("%d", &nv);

// ----------------------------------------------

    printf("Enter the Variables:\n");
    for (int i = 0; i < nv; i++) {
        printf("Variable %d: ", i + 1);
        scanf(" %c", &variables[i]);
    }

// ----------------------------------------------
    printf("\nFIRST sets:\n");
    for (int i = 0; i < nv; i++) {
        int epsilon_present = 0;
        printf("FIRST(%c) = { ", variables[i]);
        find_first(variables[i], grammar, np, &epsilon_present, i);
        if (epsilon_present) {
            printf("e ");
            fir[i][first_size[i]++] = 'e';
        }
        printf("}\n");
    }

    printf("\nFOLLOW sets:\n");
    for (int i = 0; i < nv; i++) {
        printf("FOLLOW(%c) = { ", variables[i]);
        follow(variables[i], grammar, np, variables, nv);
        printf("}\n");
    }

    return 0;
}


