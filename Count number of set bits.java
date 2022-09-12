import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=1,
        z=0;
        while(x!=0)
        {
            if((y&x)!=0)
            {
                z++;
            }
            x>>=1;
        }
        System.out.println(z);
    }
}