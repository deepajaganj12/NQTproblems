package githubproblems;

import java.util.Scanner;

public class sumofArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i]=sc.nextInt();
        }
        int sum=0;
        for (int i : a) {
            sum+=i;
        }
        System.out.println(sum);
    }
}
