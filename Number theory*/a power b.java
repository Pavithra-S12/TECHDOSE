package Day4NumberTheory;
import java.util.Scanner;

public class aPowerb {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int res=1;
        while(b>0){
            if(b%2==1){
                res*=a;
            }
            a=(a*a);
            b/=2;
        }
        System.out.print("a power of b is " + res);
    }
}