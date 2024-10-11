#include <stdio.h>
#include <stdlib.h>

int main() {
    char *input;
    int size = 0;
    char ch;
    int i = 0;   
    int flag = 1; 

    
    input = (char *)malloc(sizeof(char));

    if (input == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    printf("Enter characters (enter 'a' to stop):\n");

    while (flag) {  
        
        ch = getchar();

        if (ch == '\n') {
              break;
        }

        switch (i) {
            case 0:  
                if (ch != 'a') {
                    flag = 0;  
                } else {
                    input[size] = ch;  
                    size++;
                    i++;  
                }
                break;
            case 1:  
                if (ch != 'b') {
                    flag = 0;  
                } else {
                    input[size] = ch;  
                    size++;
                    i++;  
                }
                break;

            default:
                
                input[size] = ch;  
                size++;
                i++;
                break;
        }

        
        input = (char *)realloc(input, (size + 1) * sizeof(char));

        if (input == NULL) {
            printf("Memory reallocation failed\n");
            return 1;
        }
    }

    
    input[size] = '\0';

    if(flag){
      printf("You entered: %s\n", input);

    }else {
        printf("String not accepted");
    } 
    
    free(input);

    return 0;
}
