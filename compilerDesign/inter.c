#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

#define MAX 100

char operand[MAX];
char post[MAX];
int top=0;
int x=0;

int precedence(char a){
    if(a == '$')
		return 6;
	  if(a=='^')
	  	return 5;
	  if(a=='*'|| a== '/')
	  	return 4;
	  if(a=='+' || a=='-')
	  	return 3;

}

int isoperand(char a){

  return a=='+'||a=='-'||a=='*'||a=='/'||a=='^'||a=='$';

}
	
void postfix(char exp[])
	{ for(int i=0;exp[i]!='\0';i++)
		{if(isalpha(exp[i]))
			{post[x++]=exp[i];
			}
		 else
		 	{if(top==0)
		 		{operand[top++] = exp[i];
		 		}
		 	 else if(precedence(exp[i])>precedence(operand[top-1]))
		 	 	{
		 	 	 operand[top++] = exp[i];
		 	 	}
		 	 else if(precedence(exp[i])<=precedence(operand[top-1]))
		 	 	{while(top!=-1 && precedence(exp[i])<=precedence(operand[top-1]))
		 	 		{post[x++] = operand[--top];
		 	 		}
		 	 	 operand[top++]= exp[i];
		 	 	}
		 	}
		}
	 while(top!=-1)
	 	{post[x++]=operand[--top];
	 	}
	 printf("POSTFIX:: %s\n",post);
	}

void generate()
	{int x=65;
	 for(int i=0;post[i]!='\0';i++)
	 	{if(isoperand(post[i]))
	 		{int j=i-1;
	 		  char a = post[j];
	 		  int k =i-1;
	 		 while(a==post[k])
	 		 	{k--;
	 		 	}
	 		 if(post[i]=='$')
	 			{post[i]='-';
	 			 printf("%c = %c %c\n",(char)x,post[i],post[i-1]);
	 			 post[i]=(char)x;
	 			 int j=i-1;
		 		 char a =post[j];
		 		 while(post[j]==a)
		 		 	{post[j--]=(char)x;
		 		 	}
		 		 j=i-2;
		 		 post[i]=(char)x;
		 		 a=post[j];
		 		 while(post[j]==a)
		 		 	{post[j]=(char)x;
		 		 	}
		 		 x++;
		 		 x++;	 
	 			}
	 		else
	 			{
		 		 printf("%c = %c %c %c\n",(char)x,post[k],post[i],post[i-1]);
		 		 j=i-1;
		 		 a =post[j];
		 		 while(post[j]==a)
		 		 	{post[j--]=(char)x;
		 		 	}
		 		 j=i-2;
		 		 post[i]=(char)x;
		 		 a=post[j];
		 		 while(post[j]==a)
		 		 	{post[j--]=(char)x;
		 		 	}
		 		 x++;
	 			}
	 		 
	 		}
	 	}
	 	
	}
	
void main(){

   char exp[MAX];
	 printf("ENTER THE EXPRESSION:: ");
	 scanf(" %s",exp);
	 
   for(int i=0;exp[i]!='\0';i++){
      if(exp[i]=='+'||exp[i]=='-'||exp[i]=='*'||exp[i]=='/'||exp[i]=='^'){
        if(exp[i+1]=='-'){
            exp[i+1]='$';
	 			}
	 		}
	 }
	 
	 postfix(exp);
	 generate();
	
}

