import java.util.*;

public class Main
{
	static HashMap<Integer, Integer>[] hashMapArray;
	static int snapId;
	
    public static void SnapshotArray(int length) {
	    hashMapArray = new HashMap[length];
		snapId = 0;
	}

    public static void set(int index, int val) {
		if (hashMapArray[index] == null) {
			hashMapArray[index] = new HashMap<>();
		}

		hashMapArray[index].put(snapId, val);
    }

    public static int snap() {
		int snapNum = snapId;
		snapId++;
		return snapNum;
    }

    public static int get(int index, int snap_id) {
		if (hashMapArray[index] == null) {
			return 0;
		}

		while (snap_id >= 0 && hashMapArray[index].containsKey(snap_id) == false) {
			snap_id--;
		}

		if (snap_id == -1) {
			return 0;
		}

		return hashMapArray[index].get(snap_id);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String temp;
		int param1, param2;
		param1 = input.nextInt();
        SnapshotArray(param1);
        String[] arr = new String[n];
		for (int i = 0; i < n; i++){

            temp = input.next();
		    if(temp.equals("set") || temp.equals("get"))
            {
              param1 = input.nextInt();
              param2 = input.nextInt();
              if(temp.equals("set"))
              {
                  set(param1, param2);
              }
              else{
                  System.out.println(get(param1, param2));
              }
            }
            else{
                System.out.println(snap());
            }
		}
        
	}
}
