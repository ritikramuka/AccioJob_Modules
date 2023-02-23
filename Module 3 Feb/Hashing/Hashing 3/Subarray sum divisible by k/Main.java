import java.io.*;
import java.util.*;

public class Main {

    public static int subarrayDivisbleByK(int arr[], int n, int k) {
        // Write code here
        HashMap<Integer, Integer> remFreqMap = new HashMap<>();
        remFreqMap.put(0, 1);

        int ans = 0;
        int runningSum = 0;

        for (int num : arr) {
            runningSum += num;

            int rem = runningSum % k;

            if (rem < k) {
                rem += k;
            }

            if (remFreqMap.containsKey(rem)) {
                ans += remFreqMap.get(rem);
            }

            remFreqMap.put(rem, remFreqMap.getOrDefault(rem, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        int result = subarrayDivisbleByK(arr, n, k);
        System.out.print(result);
        System.out.println('\n');
    }
}