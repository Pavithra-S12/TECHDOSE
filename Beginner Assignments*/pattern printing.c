int main()
{
    int n,i,j;
    printf("Enter the number");
    scanf("%d",&n);
    for(i=1; i<=n; i++)
    {
        for(j=5; j>=i; j--)
        {
            printf("%d",j);
        }
        printf("\n");
    }
    return 0;
}
