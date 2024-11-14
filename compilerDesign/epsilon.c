#include<stdio.h>

void efsilonClosure(int start, int transitionDiagram[10][10], int numberOfStates, int visited[]) {

    for (int i = 0; i < numberOfStates; i++) {

        if (transitionDiagram[start][i] == 0) {

            if (visited[i]) {
                return;
            }
            visited[i] = 1;
            printf("q%d ", i);
            efsilonClosure(i, transitionDiagram, numberOfStates, visited);
        }
    }

}

void main() {

    int numberOfStates;
    int transitionDiagram[10][10];
    printf("Enter number of states :- ");
    scanf("%d", & numberOfStates);
    printf("0 is efsilon\n1 is some/no transition\n");

    for (int i = 0; i < numberOfStates; i++) {

        for (int j = 0; j < numberOfStates; j++) {

            printf("Enter input symbol corresponding to transition between q%d & q%d :- ", i, j);
            scanf("%d", & transitionDiagram[i][j]);

        }

    }

    for (int i = 0; i < numberOfStates; i++) {

        int visited[10] = {
            0
        };
        printf("Epsilon closure of q%d is :- ", i);
        efsilonClosure(i, transitionDiagram, numberOfStates, visited);

        if (!visited[i]) {
            printf("q%d", i);
        }

        printf("\n");

    }

}
