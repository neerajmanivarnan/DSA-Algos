#include <stdio.h>

#define MAX_LENGTH 100

void generate_assembly(FILE * input,FILE * output){
  char line[MAX_LENGTH];
  char op[10],arg1[10],arg2[10],result[10];
  while(fgets(line,sizeof(line),input)){
    op[0] = arg1[0] = arg2[0] = result[0] = '\0';
    
    if (sscanf(input, "%s = %s",result,arg1) == 2 && strchr(line,'+') == NULL && strchr(line,'-') == NULL && strchr(line,'*') == NULL&& strchr(line,'/') == NULL && strchr(line,'+') == NULL     )
  }




}


int main(){
  
  FILE * input = fopen("input.txt","r");

  char line[100];

  while (fgets(line,sizeof(line),input )){
    printf("%s",line);

  }

  return 0
},
