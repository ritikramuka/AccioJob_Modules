import java.util.*;

public class Main
{
	static HashMap<Integer, Integer>[] mapArray;
	static int snap_num;
	
    public static void SnapshotArray(int length) {
	    mapArray = new HashMap[length];
		snap_num = 0;
	}

    public static void set(int index, int val) {
		if (mapArray[index] == null) {
			mapArray[index] = new HashMap<>();
		}

		mapArray[index].put(snap_num, val);
    }

    public static int snap() {
		int snap_clicked = snap_num;
		snap_num += 1;
		return snap_clicked;
    }

    public static int get(int index, int snap_id) {
		if (mapArray[index] == null) {
			return 0;
		}

		while (snap_id >= 0 && mapArray[index].containsKey(snap_id) == false) {
			snap_id--;
		}

		if (snap_id < 0) {
			return 0;
		}

		return mapArray[index].get(snap_id);
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
