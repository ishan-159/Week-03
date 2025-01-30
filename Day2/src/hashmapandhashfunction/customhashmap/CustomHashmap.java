package hashmapandhashfunction.customhashmap;

import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets; // Array of linked lists

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    public CustomHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
    }

    // Hash function: Computes an index based on key
    private int hashFunction(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = hashFunction(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // Check if key exists and update value
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value
                return;
            }
        }

        // Key not found, add new entry
        buckets[index].add(new Entry<>(key, value));
    }

    // Retrieve value for a given key
    public V get(K key) {
        int index = hashFunction(key);

        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }

        return null; // Key not found
    }

    // Remove a key-value pair
    public void remove(K key) {
        int index = hashFunction(key);

        if (buckets[index] != null) {
            buckets[index].removeIf(entry -> entry.key.equals(key));
        }
    }

    // Print all key-value pairs (for testing)
    public void printHashMap() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.println("Key: " + entry.key + ", Value: " + entry.value);
                }
            }
        }
    }
}
