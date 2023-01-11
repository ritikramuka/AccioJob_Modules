import java.io.*;
import java.util.*;

class Solution {
    int rec(String ceo, HashMap<String, ArrayList<String>> mngrAndDirect, TreeMap<String, Integer> ans) {
        // base case the emp is not a manager
        if (mngrAndDirect.containsKey(ceo) == false) {
            ans.put(ceo, 0);
            return 1;
        }

        int cnt = 0;
        for (String emp : mngrAndDirect.get(ceo)) {
            cnt += rec(emp, mngrAndDirect, ans);
        }

        ans.put(ceo, cnt);

        return cnt + 1;
    }

    public void EmpUnderManager(Map<String, String> emp) {
        HashMap<String, ArrayList<String>> mngrAndDirect = new HashMap();
        String ceo = "";

        for (String employee : emp.keySet()) {
            String myManager = emp.get(employee);

            if (myManager.equals(employee)) {
                ceo = employee;
                continue;
            }

            if (mngrAndDirect.containsKey(myManager)) {
                ArrayList<String> temp = mngrAndDirect.get(myManager);
                temp.add(employee);
                mngrAndDirect.put(myManager, temp);
            } else {
                ArrayList<String> newList = new ArrayList();
                newList.add(employee);
                mngrAndDirect.put(myManager, newList);
            }
        }

        TreeMap<String, Integer> ans = new TreeMap();
        rec(ceo, mngrAndDirect, ans);

        for (String key : ans.keySet()) {
            System.out.println(key + " " + ans.get(key));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String, String> emp = new HashMap<String, String>();
        for (int i = 0; i < n; ++i) {
            emp.put(sc.next(), sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp);
    }
}