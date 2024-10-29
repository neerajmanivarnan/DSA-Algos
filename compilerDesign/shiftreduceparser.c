#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define SUCCESS 1
#define FAILED 0

//data structure to store the productions 
typedef struct productionrules{
  char lhs[10];
  char rhs[10];
}production;



int main(){


  production prod[10]; // defining a ds for storing the productions
  int rulescount; // store the number of production rules
  char temp[50]; // temp char array to store the production and tokenize 
  char* token1; // storing the lhs of the token to move to the ds
  char* token2; // storing the rhs of the token to move to the ds


  printf("Enter the number of productions : ");
  scanf("%d",&rulescount);


  printf("\n"); // LOOP to enter the production rules
  printf("\t\t\t-----ENTER THE PRODUCTION RULES: -----\n"); // LOOP to enter the production rules
  printf("\n"); // LOOP to enter the production rules
  for(int i=0;i<rulescount;i++){

    printf("Enter the production number %d : ",i+1);
    scanf("%s",temp);

    token1 =  strtok(temp,"->");
    if(token1 == NULL) {
      printf("Error occured : Enter a valid string\n");
      return FAILED;
    }

    token2 =  strtok(NULL,"->");
    if(token2 == NULL) {
      printf("Error occured : Enter a valid string\n");
      return FAILED;
    }

    strcpy(prod[i].lhs,token1);
    strcpy(prod[i].rhs,token2);

  }

  for (int i=0;i<rulescount;i++) {
    printf("LHS = %s\t",prod[i].lhs);
    printf("RHS = %s\n",prod[i].rhs);
  }

  return 0;
}
