import java.util.Scanner;

public class majorityElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int [n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();   
        }
        int m=n/2;
        int count=0;
        for (int i : a) {
            if(i>m){
                count++;
            }
        }
        System.out.println(count);
    }
}