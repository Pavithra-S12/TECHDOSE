#include<stdio.h>

void mergesort(int a[],int l,int h);
void merge(int a[],int l,int m,int h);
int main(){
    int a[100],n,i;
    scanf("%d",&n);
    printf("Enter array elements: ");
    for(i=0;i<n;i++)
        scanf("%d",&a[i]);
    mergesort(a,0,n-1);
    printf("\nSorted array is: ");
    for(i=0;i<n;i++){
        printf("%d ",a[i]);
    }
    return 0;
}
void mergesort(int a[],int l,int h){
    int m;
    if(l<h){
        m=(l+h)/2;
        mergesort(a,l,m);           //divide 1st part of array
        mergesort(a,m+1,h);         //divide 2nd part of array
        mergesort(a,l,m,h);         //combining 1st and 2nd part
    }
}
void merge(int a[],int l,int m,int h){
    int b[100];
    int i,j,k;
    i=l;
    j=m+1;
    k=h;
    while(i<=m && j<=h){
        if(a[i]<=a[j]){
            b[k++]=a[i++];
        }else{
            b[k++]=a[j++];
        }
    }if(i>m){
        while(j<=h){
            b[k++]=a[j++];
        }
    }else{
        while(i<=m){
            b[k++]=a[i++];
        }
    }
    for(i=l;i<=h;i++){
        a[i]=b[i];
    }
}