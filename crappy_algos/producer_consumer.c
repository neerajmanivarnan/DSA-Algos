#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>

int *buffer; //buffer in which producer produces into and consumes from
int top = -1; // tracks the size of the buffer


// random number which decides to either produce or consume 
int randomGen(){
  
  srand(time(NULL));
  int random_number = rand() % 10;
  sleep(1);
  return random_number;
}

// produces and adds it into the buffer
int produce(int *buffer,int size){
  if (top == size-1){
    printf("\nBuffer overflow");
    return 0;
  }

  top++;
  buffer[top] = 8;
  printf("\nItem produced : Buffer Size = %d",top);
  return 1;
}

// consumes from the buffer 
int consume(int *buffer,int size){
  
  if (top < 0 ){
    printf("\nBuffer underflow");
    return 0;
  }

  int popped_value = buffer[top];
  top--;
  printf("\nItem consumed : Buffer Size = %d",top);
  return 1;

}


int main() {

    int buffer_size;
    printf("\nEnter the size of the buffer : ");
    scanf("%d",&buffer_size);

    buffer  = (int *)malloc(sizeof(int) * buffer_size);
    int result;
    int generated_number;
   
    produce(buffer,buffer_size);    // prevents consuming from empty buffer
   
    while(1){

      generated_number = randomGen();
      if (generated_number < 5){
          result  = produce(buffer,buffer_size);
          if(!result) break;
      }else if (generated_number >= 5){
          result = consume(buffer,buffer_size);  
          if(!result) break;
      } 

    }    

    return 0;
}
