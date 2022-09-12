package Day4NumberTheory;
import java.util.Scanner;
public class nCr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        int mat[][]=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<=i;j++){
                if(j==0||i==j){
                    mat[i][j]=1;
                }else{
                    mat[i][j]=(mat[i-1][j-1]+mat[i-1][j]);
                }
            }
        }
        System.out.print(mat[n][r]);
    }
}