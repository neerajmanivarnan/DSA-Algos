#include<stdio.h>



int main(){


  int numberOfProductions,numberOfVariables;
  char grammar[20][20];


  printf("\nEnter the number of productions : ");
  scanf("%d",&numberOfProductions);

  
  printf("\nEnter the number of non-terminals : ");
  scanf("%d",&numberOfVariables);

  for (int i =0;i<numberOfProductions;i++) {
    printf("\nEnter the production grammar : ");
    scanf("%s",grammar[i]);
  }

  // for (int i =0;i<numberOfProductions;i++) {
  //   printf("%s\n",grammar[i]);
  //   // scanf("%s",grammar[i]);
  // }
  printf("FIRST SET : ");
  for (int i=0;i<numberOfVariables;i++) {
    int epsilon_present = 0;
    printf("FIRST(%c) = { ",numberOfVariables[i]);
    find_first();
    if (epsilon_present){
      printf("e ");
      fir[i]
    }

  } 



  return 0;
}
