import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int a=sc.nextInt();
        int b=1;
        while(b<<1 <=a)
        {
            b<<=1;
        }
        System.out.println(b);
    }
}
