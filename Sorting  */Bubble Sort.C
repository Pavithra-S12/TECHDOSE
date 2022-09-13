#include <stdio.h>
int main()
{
    int a[1000],n,i,j,temp;
    scanf("%d", &n);
    printf("\nEnter the Array Elements :  ");
    for(i=0;i<n;i++)
        scanf("%d",&a[i]);
    for(i=0;i<n-1;i++)
    {
        for(j=0;j<n-i-1;j++)
        {
            if(a[j]>a[j+1])
            {
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
            }
        }
    }
    printf("\nSorted elements in array is : ");
    for(i=0;i<n;i++)
    {
        printf("%d ",a[i]);
    }
    return 0;
}