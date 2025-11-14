import java.util.*;

public class IntersectionExample {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        int b[] = {3, 4, 5, 6};

        Set<Integer> setA = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for (int x : a) setA.add(x);

        for (int x : b) {
            if (setA.contains(x))
                intersection.add(x);
        }

        System.out.println("Intersection: " + intersection);
    }
}
