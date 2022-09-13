#include<stdio.h>

int main()
{
    int i,j,n,c;
    scanf("%d",&n);
    int a[n];
    for(i=0;i<n;i++){
        scanf("%d",&a[i]);
    }for(i=1;i<n;i++){
        c=a[i];
        j=i-1;
        while((c<a[j]) && (j>=0)){
            a[j+1]=a[j];
            j=j-1;
        }
        a[j+1]=c;
    }for(i=0;i<n;i++){
        printf("%d ",a[i]);
    }
    return 0;
}
