#include <stdio.h>
#include <string.h>

#define MAX_STATES 50
#define MAX_ALPHABETS 10

int n=0, m=0, finalStates[MAX_STATES], nFinal;
char states[MAX_STATES], alphabets[MAX_ALPHABETS];
int transition[MAX_STATES][MAX_ALPHABETS];
int minimizedTransition[MAX_STATES][MAX_ALPHABETS];
int partition[MAX_STATES], newPartition[MAX_STATES];
int partitionSize, newPartitionSize;



//--------------------PRINTING DFA---------------------------- 

void printDFA(int trans[MAX_STATES][MAX_ALPHABETS], int numStates) {
    for (int i = 0; i < numStates; i++) {
        for (int j = 0; j < m; j++) {
            printf("δ(%c, %c) = %c\n", states[i], alphabets[j], states[trans[i][j]]);
        }
    }
}





//------------------INITILIASING PARTITION ------------------

void initializePartition() {
    for (int i = 0; i < n; i++) {
        if (finalStates[i]) {
            partition[i] = 1;
        } else {
            partition[i] = 0;
        }
    }
    partitionSize = 2; // Two partitions: final and non-final
}







//------------------ITILIASING PARTITION ------------------
int areEquivalent(int state1, int state2) {
    for (int i = 0; i < m; i++) {
        int nextState1 = transition[state1][i];
        int nextState2 = transition[state2][i];
        if (partition[nextState1] != partition[nextState2]) {
            return 0;
        }
    }
    return 1;
}





//-------------------MINIMIZING DFA-------------------------

void minimizeDFA() {
    initializePartition();

    int changed;
    do {
        changed = 0;
        newPartitionSize = 0;

        for (int i = 0; i < n; i++) {
            newPartition[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (newPartition[i] == -1) {
                newPartition[i] = newPartitionSize++;
                for (int j = i + 1; j < n; j++) {
                    if (partition[i] == partition[j] && areEquivalent(i, j)) {
                        newPartition[j] = newPartition[i];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (partition[i] != newPartition[i]) {
                changed = 1;
                partition[i] = newPartition[i];
            }
        }
    } while (changed);
}


//---------------------CONSTRUCTING MINIMIZED DFA--------------------------

void constructMinimizedDFA() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            minimizedTransition[partition[i]][j] = partition[transition[i][j]];
        }
    }
}





//---------------------MAIN-----------------
int main() {
    printf("Enter the number of states: ");
    scanf("%d", &n);

    printf("Enter the states: ");
    for (int i = 0; i < n; i++) {
        scanf(" %c", &states[i]);
    }

    printf("Enter the number of alphabets: ");
    scanf("%d", &m);

    printf("Enter the alphabets: ");
    for (int i = 0; i < m; i++) {
        scanf(" %c", &alphabets[i]);
    }

    printf("Enter the transition table (format: state alphabet next_state):\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            char nextState;
            printf("δ(%c, %c) = ", states[i], alphabets[j]);
            scanf(" %c", &nextState);
            for (int k = 0; k < n; k++) {
                if (states[k] == nextState) {
                    transition[i][j] = k;
                    break;
                }
            }
        }
    }

    printf("Enter the number of final states: ");
    scanf("%d", &nFinal);

    printf("Enter the final states: ");
    for (int i = 0; i < nFinal; i++) {
        char finalState;
        scanf(" %c", &finalState);
        for (int j = 0; j < n; j++) {
            if (states[j] == finalState) {
                finalStates[j] = 1;
                break;
            }
        }
    }

    minimizeDFA();
    constructMinimizedDFA();

    printf("Minimized DFA:\n");
    printDFA(minimizedTransition, newPartitionSize);

    return 0;
}
