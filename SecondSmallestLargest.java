import java.util.Arrays;
import java.util.Scanner;

public class SecondSmallestLargest {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();

        }
        Arrays.sort(a);
        System.out.println(" Second Smallest : "+a[1]);
        System.out.println(" Second Largest : "+a[n-2]);
        sc.close();

    }
}