package hashmapandhashfunction.customhashmap;

public class Main {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Insert values
        map.put("Ishan", 25);
        map.put("Naman", 30);
        map.put("Om", 28);

        // Retrieve values
        System.out.println("Ishan Age: " + map.get("Ishan")); // Output: 25
        System.out.println("Naman Age: " + map.get("Naman")); // Output: 30

        // Remove a key
        map.remove("Ishan");
        System.out.println("Ishan Age after removal: " + map.get("Ishan")); // Output: null

        // Print remaining entries
        System.out.println("Remaining Key-Value Pairs:");
        map.printHashMap();
    }
}

