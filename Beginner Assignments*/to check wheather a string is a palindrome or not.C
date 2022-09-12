#include <stdio.h>
#include <string.h>
int main()
{
   int len,ctr=0;
   char a[10];
   printf("Enter the string");
   scanf("%s",&a);
   len=strlen(a);
   for(int i=0; i<len; i++)
   {
       if(a[i]==a[len-i-1])
       ctr++;
   }
   if(len=ctr)
   {
       printf("palindrome");
   }
   else
   {
       printf("Not a palindrome");
   }
}
