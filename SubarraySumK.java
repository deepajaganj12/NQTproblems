import java.util.HashMap;

public class SubarraySumK {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1); 
        for (int num : nums) {
            sum += num;

            if (prefixSums.containsKey(sum - k)) {
                count += prefixSums.get(sum - k);
            }

            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k)); 
    }
}
