import java.io.*;
import java.util.*;

class Solution {

	// faith -> returns number of people managed by this emp
	int rec (String emp, HashMap<String, ArrayList<String>> directReportee, TreeMap<String, Integer> underMe) {
		if (directReportee.containsKey(emp) == false) {
			underMe.put(emp, 0);
			return 0;
		}
		
		int cnt = 0;
		for (String directs : directReportee.get(emp)) {
			cnt += rec(directs, directReportee, underMe) + 1;
		}

		underMe.put(emp, cnt);

		return cnt;
	}

	// TC: O(N*logN)
    public void EmpUnderManager(Map<String, String> emp) {
		HashMap<String, ArrayList<String>> directReportee = new HashMap<>();
		String ceo = "";
		for (String employee : emp.keySet()) {
			String mgr = emp.get(employee);
			if (employee.equals(mgr) == true) {
				ceo = employee;
				continue;
			}
			ArrayList<String> people = directReportee.getOrDefault(mgr, new ArrayList<>());
			people.add(employee);
			directReportee.put(mgr, people);
		}

		TreeMap<String, Integer> underMe = new TreeMap<>();
		rec(ceo, directReportee, underMe);

		for (String employee : underMe.keySet()) {
			System.out.println(employee + " " + underMe.get(employee));
		}
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String,String> emp = new HashMap<String, String>();
        for(int i=0;i<n;++i){
			emp.put(sc.next(),sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp); 
    }
}