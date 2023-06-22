import java.io.*;
import java.util.*;

class Solution {

	// Faith: number of people directly reporting to emp
	public int peopleUnderMe(String emp, HashMap<String, ArrayList<String>> directReportees, TreeMap<String, Integer> ans) {
		// base case
		if (directReportees.containsKey(emp) == false) {
			ans.put(emp, 0);
			return 0;
		}
		
		int numOfPeopleUnderMe = 0;
		for (String directReporting : directReportees.get(emp)) {
			numOfPeopleUnderMe += peopleUnderMe(directReporting, directReportees, ans) + 1;
		}

		ans.put(emp, numOfPeopleUnderMe);

		return numOfPeopleUnderMe;
	}

    public void EmpUnderManager(Map<String, String> emp)
	{
		HashMap<String, ArrayList<String>> directReportees = new HashMap<>();
		String ceo = "";

		for (String employee : emp.keySet()) {
			String manager = emp.get(employee);

			if (manager.equals(employee) == true) {
				ceo = manager;
				continue;
			}

			if (directReportees.containsKey(manager) == true) {
				ArrayList<String> directRoprting = directReportees.get(manager);
				directRoprting.add(employee);
				directReportees.put(manager, directRoprting);
			} else {
				ArrayList<String> directRoprting = new ArrayList<>();
				directRoprting.add(employee);
				directReportees.put(manager, directRoprting);
			}
		}

		TreeMap<String, Integer> ans = new TreeMap<>();

		peopleUnderMe(ceo, directReportees, ans);

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