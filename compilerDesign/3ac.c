#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX 100

void main(){
   char exp[MAX];
	 int x=65;
	 printf("ENTER THE EXPRESSION:: ");
	 scanf(" %s",exp);
	 
	 if(exp[2]=='-'){
      exp[2]='$';
	 }
	 
	 for(int i=0;exp[i]!='\0';i++){
      if(exp[i]=='*'||exp[i]=='+'||exp[i]=='-'||exp[i]=='/'||exp[i]=='^'){
          if(exp[i+1]=='-'){
            exp[i+1]='$';
	 			  }
	 		}
	 }
	 	
	 for(int i=0;exp[i]!='\0';i++){
      if(exp[i]=='$'){
          printf("%c = - %c\n",(char)x,exp[i+1]);
	 		    exp[i]= (char)x;
	 		    exp[i+1]=(char)x;
	 		    x++;
	 		}
	 }
	 
   for(int i=strlen(exp)-1;i>=0;i--){
      if(exp[i]=='^'){
          printf("%c = %c %c %c\n",(char)x,exp[i-1],exp[i],exp[i+1]);
		 	    int j = i-1;
  		 	  char a = exp[i-1];
		 	  
          while(exp[j]==a){
              exp[j--]=(char)x;
		 	 	  }
		 	 
          exp[i]=(char)x;
		 	    j=i+1;
		 	    a=exp[i+1];
		 	 
       while(exp[j]==a)
		 	 	{exp[j++]=(char)x;
		 	 	}
		 	 x++;
	 		}
	 	 
	 	}

	 for(int i=0;exp[i]!='\0';i++)
	 	{if(exp[i]=='/' || exp[i]=='*')
	 		{printf("%c = %c %c %c\n",(char)x,exp[i-1],exp[i],exp[i+1]);
		 	 int j = i-1;
		 	 char a = exp[i-1];
		 	 while(exp[j]==a)
		 	 	{exp[j--]=(char)x;
		 	 	}
		 	 exp[i]=(char)x;
		 	 j=i+1;
		 	 a=exp[i+1];
		 	 while(exp[j]==a)
		 	 	{exp[j++]=(char)x;
		 	 	}
		 	 x++;
	 		}
	 	 
	 	}
	 for(int i=0;exp[i]!='\0';i++)
	 	{if(exp[i]=='+'||exp[i]=='-')
	 		{printf("%c = %c %c %c\n",(char)x,exp[i-1],exp[i],exp[i+1]);
		 	 int j = i-1;
		 	 char a = exp[i-1];
		 	 while(exp[j]==a)
		 	 	{exp[j--]=(char)x;
		 	 	}
		 	 exp[i]=(char)x;
		 	 j=i+1;
		 	 a=exp[i+1];
		 	 while(exp[j]==a)
		 	 	{exp[j++]=(char)x;
		 	 	}
		 	 x++;
	 		}
	 	 
	 	}
	 if(exp[1]=='=')
	 printf("%c %c %c\n",exp[0],exp[1],exp[2]);
	}
