import java.util.*;

public class SubsetSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the input from the user
        System.out.println("enter number of elements in set");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("enter elements in set");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("enter sum");
        int sum = scanner.nextInt();

        // Find all possible subsets with sum equal to sum
        findSubsets(arr, 0, sum, new ArrayList<>());
    }

    private static void findSubsets(int[] arr, int i, int sum, ArrayList<Integer> subset) {
        // Base case
        if (sum == 0) {
            System.out.println(subset);
            return;
        }

        // If we have reached the end of the array, there are no more subsets to consider
        if (i == arr.length) {
            return;
        }

        // Recursively consider two cases:
        // 1. Exclude the current element
        findSubsets(arr, i + 1, sum, subset);

        // 2. Include the current element
        subset.add(arr[i]);
        findSubsets(arr, i + 1, sum - arr[i], subset);

        // Remove the current element from the subset
        subset.remove(subset.size() - 1);
    }
}
