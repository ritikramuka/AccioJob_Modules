import java.util.*;

public class Main {
    static int[] avoidFlood(int[] rains) {
        // Write your code here
        int n = rains.length;
        int[] ans = new int[n];

        // {lake -> last time rained}
        HashMap<Integer, Integer> lastRain = new HashMap<>();

        TreeSet<Integer> dry = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];

            if (lake == 0) {
                // this is drying day
                dry.add(i);

                // by default value, when you don't use this dry day
                ans[i] = 1;
            } else {
                if (lastRain.containsKey(lake) == false) {
                    // never rained here
                    lastRain.put(lake, i);
                } else {
                    Integer dryOnThisDay = dry.higher(lastRain.get(lake));
                    if (dryOnThisDay == null) {
                        // flooding
                        return new int[0];
                    } else {
                        ans[dryOnThisDay] = lake;
                        lastRain.put(lake, i);
                        dry.remove(dryOnThisDay);
                    }
                }
                ans[i] = -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] rains = new int[n];
        for (int i = 0; i < n; i++) {
            rains[i] = input.nextInt();
        }
        int[] ans = avoidFlood(rains);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
            System.out.print(" ");
        }
        if (ans.length == 0)
            System.out.print(" ");
    }
}
