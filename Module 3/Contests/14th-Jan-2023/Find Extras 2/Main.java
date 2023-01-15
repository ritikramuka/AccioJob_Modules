import java.util.*;

class Solution {
    public ArrayList<Integer> duplicateBookIDS(int[] book) {
        // Write code here
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int id : book) {
            freqMap.put(id, freqMap.getOrDefault(id, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int id : freqMap.keySet()) {
            if (freqMap.get(id) > 1) {
                list.add(id);
            }
        }

        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        ArrayList<Integer> res = Obj.duplicateBookIDS(arr);
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();
        sc.close();
    }
}