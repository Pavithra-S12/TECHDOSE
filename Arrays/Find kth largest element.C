#include <stdio.h>

int main() {
    int i,j,n,temp,k;
    scanf("%d",&n);
    int arr[n];
    for(int i=0;i<n;i++){
     scanf("%d",&arr[i]);
    }
    printf("The k value is ");
    scanf("%d",&k);
    for (i = 0; i < n-1; i++)
    {
        for (j = 0; j < n-1-i; j++)
        {
            if (arr[j] > arr[j+1])
            {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    printf("The sorted array is ");
    for(i=0;i<n;i++){
        printf("%d\t",arr[i]);
    }
    printf("\n\n%d'th largest element is %d",k,arr[k-1]);

    return 0;
}