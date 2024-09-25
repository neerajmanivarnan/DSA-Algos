#include <ctype.h>
#include <stdio.h>

#define MAX 20 // Increase the array size to handle larger grammars

int n;                     // Number of productions
char production[MAX][MAX]; // Array to store the productions
char first[MAX][MAX];      // Array to store the first sets

// Function declarations
void findFirst(char, int, int);
void addToFirst(char, char);

// Main function
int main() {
  int i;
  char choice;

  printf("Enter the number of productions: ");
  scanf("%d", &n);

  printf("Enter the productions (e.g., E=E+T):\n");
  for (i = 0; i < n; i++) {
    scanf("%s", production[i]);
  }

  // Initialize the first array
  for (i = 0; i < MAX; i++) {
    first[i][0] = '\0'; // Set first sets as empty initially
  }

  // Find the First set for each production
  for (i = 0; i < n; i++) {
    findFirst(production[i][0], 0, 0); // Call findFirst for each non-terminal
  }

  // Display the First sets
  printf("\nFirst Sets:\n");
  for (i = 0; i < n; i++) {
    printf("First(%c) = { %s }\n", production[i][0],
           first[production[i][0] - 'A']);
  }

  return 0;
}

// Function to find the First set
void findFirst(char symbol, int q1, int q2) {
  int i, j;

  // If the symbol is a terminal, return
  if (!(isupper(symbol))) {
    return;
  }

  // Check each production rule
  for (i = 0; i < n; i++) {
    if (production[i][0] == symbol) { // If production is for the given symbol
      if (production[i][2] == symbol) {
        continue; // Avoid infinite recursion
      }

      // If the symbol leads to a terminal, add it to First set
      if (islower(production[i][2])) {
        addToFirst(symbol, production[i][2]);
      } else {
        // If it leads to a non-terminal, find the First of the non-terminal
        findFirst(production[i][2], q1, q2);
      }
    }
  }
}

// Function to add a terminal to the First set (without duplication)
void addToFirst(char symbol, char terminal) {
  int i;
  // Find the index of the First set for the symbol
  int index = symbol - 'A';

  // Check if the terminal is already in the First set
  for (i = 0; first[index][i] != '\0'; i++) {
    if (first[index][i] == terminal) {
      return; // Terminal already exists, do nothing
    }
  }

  // Add the terminal to the First set
  first[index][i] = terminal;
  first[index][i + 1] = '\0'; // Null-terminate the string
}
