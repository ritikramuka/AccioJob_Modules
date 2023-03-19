import java.io.*;
import java.util.*;

class Accio {
    // TC: O(N), SC: O(N)
    public static int[] solve(int[] arr) {
        // Your Code Here

        int[] ans = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                int idx = st.pop();
                int dist = idx - i;
                ans[idx] = dist;
            }

            st.push(i);
        }

        while (st.size() > 0) {
            ans[st.pop()] = -1;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        Accio Obj = new Accio();
        int[] result = Obj.solve(arr1);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println('\n');
    }
}