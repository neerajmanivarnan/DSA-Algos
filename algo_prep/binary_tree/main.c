#include <stdio.h>

int main()
{
  const int num = 10;
  int *ptr = (int *)&num;
  *ptr = 20;

  printf("var = %d\n", num);
}
