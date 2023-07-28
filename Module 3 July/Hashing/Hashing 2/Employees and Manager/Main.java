import java.io.*;
import java.util.*;

class Solution {

	public int numberOfEmpUnderMe(String emp_name, HashMap<String, ArrayList<String>> directReportees, TreeMap<String, Integer> ans) {
		if (directReportees.containsKey(emp_name) == false) {
			ans.put(emp_name, 0);
			return 0;
		}

		int total = 0;
		for (String direct : directReportees.get(emp_name)) {
			int cnt = numberOfEmpUnderMe(direct, directReportees, ans);
			total += (cnt + 1);
		}

		ans.put(emp_name, total);

		return total;
	}

    public void EmpUnderManager(Map<String, String> emp)
	{
		// Key -> manager, value -> emps under him
		HashMap<String, ArrayList<String>> directReportees = new HashMap();

		String ceo = "";

		for (String emp_name : emp.keySet()) {
			String mngr_name = emp.get(emp_name);

			if (mngr_name.equals(emp_name) == true) {
				// CEO
				ceo = emp_name;
				continue;
			}

			if (directReportees.containsKey(mngr_name) == true) {
				ArrayList<String> my_team = directReportees.get(mngr_name);
				my_team.add(emp_name);
				directReportees.put(mngr_name, my_team);
			} else {
				ArrayList<String> my_team = new ArrayList();
				my_team.add(emp_name);
				directReportees.put(mngr_name, my_team);
			}
		}

		TreeMap<String, Integer> ans = new TreeMap();
		numberOfEmpUnderMe(ceo, directReportees, ans);

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
        Map<String,String> emp = new HashMap<String, String>();
        for(int i=0;i<n;++i){
			emp.put(sc.next(),sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp); 
    }
}