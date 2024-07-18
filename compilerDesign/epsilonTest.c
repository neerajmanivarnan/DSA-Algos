#include<stdio.h>

void closure(int start,int matrix[10][10],int numberOfStates,int visited[]);


int main(){

	int numberOfStates;

	printf("Enter number of states : ");
	scanf("%d",&numberOfStates);

	int matrix[10][10];

	for(int i=0;i<numberOfStates;i++){
		for(int j=0;j<numberOfStates;j++){
			printf("\nEnter the input symbol from q%d to q%d (0 for epsilon & 1 for other) : ",i,j);
			scanf("%d",&matrix[i][j]);
		}
	}


	for(int i=0;i<numberOfStates;i++){
		int visited[10] = {0};
		printf("\nEpsilon closure of q%d : ",i);
		closure(i,matrix,numberOfStates,visited);

		if(!visited[i]){
		
			printf("q%d", i) ;
		
		}
	}


	return 0;
}


void closure(int start,int matrix[10][10],int numberOfStates,int visited[]){

	for(int i=0;i<numberOfStates;i++){
		if(!matrix[start][i]){
			
			if(visited[i]){
				return;
			}	

			visited[i] = 1;
			printf("q%d",i);
			closure(i,matrix,numberOfStates,visited);
		        	

		}
	}



}



