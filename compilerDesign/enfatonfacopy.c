#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#define MAX_STATES 100
#define MAX_SYMBOLS 26

typedef struct {
    int transitions[MAX_STATES][MAX_SYMBOLS];  // Transition table
    bool epsilonTransitions[MAX_STATES][MAX_STATES];  // Epsilon transitions
    int numStates;
    int numSymbols;
} NFA;

// Function Prototypes
void computeEpsilonClosure(NFA *nfa, bool closure[MAX_STATES], int state);
void convertNFA(NFA *nfa, NFA *nfa_no_epsilon);
void printNFA(NFA *nfa);

int main() {
    NFA nfa, nfa_no_epsilon;

    // Example NFA initialization
    nfa.numStates = 3;
    nfa.numSymbols = 2;  // 'a' and 'b'

    // Initialize transitions to -1 (indicating no transition)
    for (int i = 0; i < MAX_STATES; i++) {
        for (int j = 0; j < MAX_SYMBOLS; j++) {
            nfa.transitions[i][j] = -1;
        }
    }

    // Example state transitions and epsilon transitions
    nfa.transitions[0][0] = 1;  // From state 0 on 'a' to state 1
    nfa.transitions[1][1] = 2;  // From state 1 on 'b' to state 2

    nfa.epsilonTransitions[0][1] = true;  // Epsilon transition from 0 to 1
    nfa.epsilonTransitions[1][2] = true;  // Epsilon transition from 1 to 2

    // Convert NFA with epsilon transitions to NFA without them
    convertNFA(&nfa, &nfa_no_epsilon);

    // Print the new NFA without epsilon transitions
    printNFA(&nfa_no_epsilon);

    return 0;
}

// Compute epsilon closure for a given state
void computeEpsilonClosure(NFA *nfa, bool closure[MAX_STATES], int state) {
    if (closure[state]) return;  // Already visited
    closure[state] = true;

    for (int next = 0; next < nfa->numStates; next++) {
        if (nfa->epsilonTransitions[state][next]) {
            computeEpsilonClosure(nfa, closure, next);
        }
    }
}

// Convert NFA with epsilon transitions to NFA without epsilon transitions
void convertNFA(NFA *nfa, NFA *nfa_no_epsilon) {
    // Initialize the new NFA
    nfa_no_epsilon->numStates = nfa->numStates;
    nfa_no_epsilon->numSymbols = nfa->numSymbols;

    // Initialize all transitions to -1
    for (int i = 0; i < MAX_STATES; i++) {
        for (int j = 0; j < MAX_SYMBOLS; j++) {
            nfa_no_epsilon->transitions[i][j] = -1;
        }
    }

    // Compute epsilon closure for each state
    bool closure[MAX_STATES];
    for (int i = 0; i < nfa->numStates; i++) {
        // Reset closure array for each state
        for (int j = 0; j < nfa->numStates; j++) {
            closure[j] = false;
        }
        computeEpsilonClosure(nfa, closure, i);

        // For each symbol, update transitions based on the epsilon closure
        for (int symbol = 0; symbol < nfa->numSymbols; symbol++) {
            for (int j = 0; j < nfa->numStates; j++) {
                if (closure[j] && nfa->transitions[j][symbol] != -1) {
                    nfa_no_epsilon->transitions[i][symbol] = nfa->transitions[j][symbol];
                }
            }
        }
    }
}

// Print the transitions of the NFA
void printNFA(NFA *nfa) {
    printf("NFA Transitions:\n");
    for (int i = 0; i < nfa->numStates; i++) {
        for (int j = 0; j < nfa->numSymbols; j++) {
            if (nfa->transitions[i][j] != -1) {
                printf("State %d on symbol '%c' -> State %d\n", 
                       i, 'a' + j, nfa->transitions[i][j]);
            }
        }
    }
}
