import java.util.*;
public class Main
{   
	public static void main(String[] args) { 
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int k=sc.nextInt();
	    int f=n/k;
	    int a[]=new int[n];
	    for(int i=0;i<n;i++)
	    a[i]=sc.nextInt();
	   int freq[]=new int[10000];
	   for(int i=0;i<n;i++)
	   freq[a[i]]++; 
	   for(int i=0;i<freq.length;i++)
	   { 
	     if(freq[i]==f)
	     System.out.print(i+" ");
	   }

	}
}