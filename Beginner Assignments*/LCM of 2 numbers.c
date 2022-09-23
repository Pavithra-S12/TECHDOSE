#include <stdio.h>


int main()

{
   
int n1,n2,max,flag=1;
   
printf("ENTER TWO NUMBERS:\n");
   
scanf("%d %d",&n1,&n2);
   
max=(n1>n2)?n1:n2;
  
 while(flag)
{
       
if(max%n1==0&&max%n2==0)
{
           
printf("LCM %d",max);

break;       
}
   
}
   
++max;

    
return 0;

}