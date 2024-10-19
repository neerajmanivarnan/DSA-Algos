#include <stdio.h>
#include <stdlib.h>

void main() {
    	char str[20];
    	printf("Enter the string:\n");
    	scanf("%s",str);
    	char ch=str[0];
    	int count=0,i=0;
    	while(ch!='\0') {
        		ch=str[i];
        		if(ch=='*' || ch=='/' || ch=='+' || ch=='-' || ch=='^') {
            			if(str[i+1]=='-') {
            				str[i+1]='$';
            				i++;
            				count++;
            			}
        			count++;
        		}
        		i++;
    	}//printf("%s\n",str);
    	for(int i=0; i<count; i++) {
        		ch=str[0];

        		int pos=-1,ctr=0,pr=0;
        		while(ch!='\0') {
        			ch=str[ctr];
			if((ch=='-' || ch=='+') && pos == -1) {
				pr=1;
				pos=ctr;
			}
			else if((ch=='/' || ch=='*') && pr<3) {
				pr=3;
				pos=ctr;
			}
			else if(ch=='^' && pr<=5) {
				pr=5;
				pos=ctr;
			}
			else if(ch=='$' && pr <=6) {
				pr =6;
				pos=ctr;
			}
			ctr++;//printf("%c\n",str[ctr-1]);
		}
		ctr=pos;
		char a=0,b=0;
		if(pr==6) {
			printf("T%d = -%c\n",i,str[ctr+1]);
			str[ctr]=(char)(i+48);
			str[ctr+1]=(char)(48+i);
		}
		else {
			if(str[ctr-1] >= 48 && str[ctr-1] <=57) {
				a='T';
			}
			if(str[ctr+1] >= 48 && str[ctr+1] <=57) {
				b='T';
			}
			printf("T%d = %c%c %c %c%c\n",i,a,str[ctr-1],str[ctr],b,str[ctr+1]);
			int x=ctr-1;


			while((x-1)>0 && (str[x-1]== str[ctr-1])) {
				str[x-1]=(char)(i+48);
				x--;
				if(str[x-1]!= str[ctr-1]) {
					break;
				}
			}
			x=ctr+1;
			while((str[x+1]!='\0') && (str[x+1]== str[ctr+1])) {
				str[x+1]=(char)(i+48);
				x++;
				if(str[x+1]!= str[ctr+1]) {
					break;
				}
			}

			str[ctr-1]=(char)(i+48);
			str[ctr]=(char)(i+48);
			str[ctr+1]=(char)(i+48);

		}

	}
}
