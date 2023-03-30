import java.io.*;
import java.util.*;

class Solution {

    // TC: O(N*logN)
    int peopleUnderMe(String emp, HashMap<String, ArrayList<String>> direct, TreeMap<String, Integer> ans) {
        if (direct.containsKey(emp) == false) {
            ans.put(emp, 0);
            return 1;
        }

        int cnt = 0;
        for (String employee : direct.get(emp)) {
            cnt += peopleUnderMe(employee, direct, ans);
        }

        ans.put(emp, cnt);

        return cnt + 1;
    }

    // TC: O(N*logN)
    public void EmpUnderManager(Map<String, String> emp) {
        // direct -> {manager, {list of direct reporties}}
        HashMap<String, ArrayList<String>> direct = new HashMap<>();

        // ceo will be the root of the organization
        String ceo = "";

        for (String employee : emp.keySet()) {
            String manager = emp.get(employee);

            if (manager.equals(employee) == true) {
                ceo = employee;
                continue;
            }

            if (direct.containsKey(manager) == true) {
                ArrayList<String> people = direct.get(manager);
                people.add(employee);
                direct.put(manager, people);
            } else {
                ArrayList<String> people = new ArrayList<>();
                people.add(employee);
                direct.put(manager, people);
            }
        }

        // TreeMap -> stores in inc order/ lexo order
        TreeMap<String, Integer> ans = new TreeMap<>();
        peopleUnderMe(ceo, direct, ans);

        for (String employee : ans.keySet()) {
            System.out.println(employee + " " + ans.get(employee));
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