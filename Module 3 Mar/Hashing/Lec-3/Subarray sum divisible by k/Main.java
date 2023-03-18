import java.io.*;
import java.util.*;

public class Main {

    public static int subarrayDivisbleByK(int arr[], int n, int k) {
        // Write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int runningSum = 0;
        map.put(0, 1);

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];

            int rem = runningSum % k;

            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {
                ans += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
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