#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#define MAX_STATES 100
#define MAX_SYMBOLS 26

typedef struct {
    int transitions[MAX_STATES][MAX_SYMBOLS];
    bool epsilonTransitions[MAX_STATES][MAX_STATES];
    int numStates;
    int numSymbols;
} NFA;

// Epsilon closure array and visited array
bool epsilonClosure[MAX_STATES][MAX_STATES];
bool visited[MAX_STATES];

// Function prototypes
void computeEpsilonClosure(NFA *nfa, int state);
void convertNFA(NFA *nfa, NFA *nfa_no_epsilon);
void printNFA(NFA *nfa);

int main() {
    NFA nfa, nfa_no_epsilon;

    // Initialize NFA (Example initialization; you should read it from input)
    nfa.numStates = 3;
    nfa.numSymbols = 2;
    
    // Initialize transitions to -1 (no transitions)
    for (int i = 0; i < MAX_STATES; i++) {
        for (int j = 0; j < MAX_SYMBOLS; j++) {
            nfa.transitions[i][j] = -1;
        }
    }
    
    // Example transitions
    nfa.transitions[0][0] = 1; // state 0 on 'a' goes to state 1
    nfa.transitions[1][1] = 2; // state 1 on 'b' goes to state 2
    
    // Example epsilon transitions
    nfa.epsilonTransitions[0][1] = true; // state 0 has epsilon transition to state 1
    nfa.epsilonTransitions[1][2] = true; // state 1 has epsilon transition to state 2
    
    // Convert NFA with epsilon transitions to NFA without epsilon transitions
    convertNFA(&nfa, &nfa_no_epsilon);
    
    // Print the resulting NFA without epsilon transitions
    printNFA(&nfa_no_epsilon);
    
    return 0;
}

void computeEpsilonClosure(NFA *nfa, int state) {
    if (visited[state]) return;
    visited[state] = true;
    epsilonClosure[state][state] = true;
    
    for (int i = 0; i < nfa->numStates; i++) {
        if (nfa->epsilonTransitions[state][i]) {
            computeEpsilonClosure(nfa, i);
            for (int j = 0; j < nfa->numStates; j++) {
                if (epsilonClosure[i][j]) {
                    epsilonClosure[state][j] = true;
                }
            }
        }
    }
}

void convertNFA(NFA *nfa, NFA *nfa_no_epsilon) {
    // Compute epsilon closure for each state
    for (int i = 0; i < nfa->numStates; i++) {
        for (int j = 0; j < nfa->numStates; j++) {
            epsilonClosure[i][j] = false;
        }
    }
    
    for (int i = 0; i < nfa->numStates; i++) {
        for (int j = 0; j < nfa->numStates; j++) {
            visited[j] = false;
        }
        computeEpsilonClosure(nfa, i);
    }
    
    // Initialize NFA without epsilon transitions
    nfa_no_epsilon->numStates = nfa->numStates;
    nfa_no_epsilon->numSymbols = nfa->numSymbols;
    for (int i = 0; i < nfa->numStates; i++) {
        for (int j = 0; j < nfa->numSymbols; j++) {
            nfa_no_epsilon->transitions[i][j] = -1;
        }
    }
    
    // Update transitions for NFA without epsilon transitions
    for (int i = 0; i < nfa->numStates; i++) {
        for (int j = 0; j < nfa->numSymbols; j++) {
            int nextState = nfa.transitions[i][j];
            if (nextState != -1) {
                for (int k = 0; k < nfa->numStates; k++) {
                    if (epsilonClosure[nextState][k]) {
                        nfa_no_epsilon->transitions[i][j] = k;
                    }
                }
            }
        }
    }
}

void printNFA(NFA *nfa) {
    printf("NFA Transitions:\n");
    for (int i = 0; i < nfa->numStates; i++) {
        for (int j = 0; j < nfa->numSymbols; j++) {
            if (nfa->transitions[i][j] != -1) {
                printf("State %d on symbol %c goes to state %d\n", i, 'a' + j, nfa->transitions[i][j]);
            }
        }
    }
}

