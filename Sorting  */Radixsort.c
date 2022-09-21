#include<stdio.h>
int getMax(int array[], int n) {
    int max = array[0];
    int i;
    for (i = 1; i < n; i++)
        if (array[i] > max)
            max = array[i];
    return max;
}
void countSort(int arr[], int n, int a) {
    int output[n];
    int i, count[10] = { 0 };
    for (i = 0; i < n; i++)
        count[(arr[i] / a) % 10]++;
    for (i = 1; i < 10; i++)
        count[i] += count[i - 1];
    for (i = n - 1; i >= 0; i--) {
        output[count[(arr[i] / a) % 10] - 1] = arr[i];
        count[(arr[i] / a) % 10]--;
    }
    for (i = 0; i < n; i++)
        arr[i] = output[i];
}
void radixsort(int arr[], int n) {
    int m = getMax(arr, n);
    int a;
    for (a = 1; m / a > 0; a *= 10)
        countsort(arr, n, a);
}
void print(int arr[], int n) {
    int i;
    for (i = 0; i < n; i++)
        printf("%d ", arr[i]);
}
int main() {
           int n,i;
           scanf("%d",&n);
           int arr[n];
    for(i=0;i<n;i++)
        {
           scanf("%d",&arr[i]);
           }
    radixsort(arr, n);
    print(arr, n);
    return 0;
}
