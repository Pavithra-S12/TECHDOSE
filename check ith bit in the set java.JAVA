import java.util.*;
public class Main
{
    public static void main (String[] args) {
            Scanner sc=new Scanner(System.in);
            int x=sc.nextInt();
            int y=sc.nextInt();
            int z=1;
            z<<=y-1;
            if((x&z)!=0)
            System.out.println("yes");
            else
            System.out.println("no");
        }
}