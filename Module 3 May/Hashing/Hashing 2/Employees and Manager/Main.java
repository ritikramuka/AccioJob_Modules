import java.io.*;
import java.util.*;

class Solution {

	// faith: returns number of people under mgr
	public int cntOfEmployeeUnderMrg(HashMap<String, ArrayList<String>> directReport, String mgr, TreeMap<String, Integer> underMe) {
		if (directReport.containsKey(mgr) == false) {
			underMe.put(mgr, 0);
			return 0;
		}
		
		int cnt = 0;
		for (String emp : directReport.get(mgr)) {
			cnt += cntOfEmployeeUnderMrg(directReport, emp, underMe) + 1;
		}
		underMe.put(mgr, cnt);
		return cnt;
	}

    public void EmpUnderManager(Map<String, String> emp)
	{
		// create a direct reportees hashmap
		HashMap<String, ArrayList<String>> directReport = new HashMap<>();

		String ceo = "";
		for (String employee : emp.keySet()) {
			String mgr = emp.get(employee);

			if (mgr.equals(employee)) {
				ceo = employee;
				continue;
			}

			if (directReport.containsKey(mgr) == true) {
				ArrayList<String> underThisMgr = directReport.get(mgr);
				underThisMgr.add(employee);
				directReport.put(mgr, underThisMgr);
			} else {
				ArrayList<String> underThisMgr = new ArrayList<>();
				underThisMgr.add(employee);
				directReport.put(mgr, underThisMgr);
			}
		}

		TreeMap<String, Integer> underMe = new TreeMap<>();
		cntOfEmployeeUnderMrg(directReport, ceo, underMe);

		for (String key : underMe.keySet()) {
			System.out.println(key + " " + underMe.get(key));
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