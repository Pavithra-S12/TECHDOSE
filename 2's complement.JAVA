import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int mask=1;
	    while((n&mask)==0)
	    {
	        mask<<=1;
	    }
	    while(mask<n)
	    {
	        mask<<=1;
	        n=n^mask;
	    }
	    System.out.println(n);
	}
}