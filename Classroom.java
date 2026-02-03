import java.util.HashMap;
import java.util.HashSet;

public class Classroom {

    public static void majorityElement(int nums[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i =0; i<n; i++){
            if (map.containsKey(nums[i])){ // true
                map.put(nums[i], map.get(nums[i]) + 1
                );
            }else {  //false
                map.put(nums[i], 1);
            }
        }

        for (int key : map.keySet()){
            if (map.get(key) > n/3){
                System.out.println(key);
            }
        }

    }

    public static int union(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for (int j = 0; j< arr2.length; j++){
            set.add(arr2[j]);
        }

        return set.size();
    }

    public static int intersection(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        int count = 0;

        for (int i = 0; i< arr1.length; i++){
            set.add(arr1[i]);
        }

        for (int j = 0; j<arr2.length; j++){
            if (set.contains(arr2[j])){
                count++;
                set.remove(arr2[j]);
            }
        }
        return count;

    }

    public static String getStart(HashMap<String, String> tick){
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tick.keySet()){
            // key-> key ; val-> tick.get(key)
            revMap.put(tick.get(key), key);
        }

        for (String key : tick.keySet()){
            if (!revMap.containsKey(key)){
                return key;
            }
        }

        return  null;

    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

//        majorityElement(nums);

        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);

        while (tickets.containsKey(start)){
            System.out.print(start + "->");
            start =tickets.get(start);
        }
        System.out.println(start);

        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int ans = 0;

        for (int j = 0; j<arr.length; j++){
            sum+= arr[j];

            if (map.containsKey(sum - k)){
                ans += map.get(sum-1);
            }

            if (map.containsKey(sum)){
                map.put(sum, map.get(sum) +1);
            }else {
                map.put(sum, 1);
            }
        }
        System.out.println(ans);

    }
}
