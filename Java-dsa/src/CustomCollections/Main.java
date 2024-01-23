package CustomCollections;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

// Custom implementation of a Map called VishalMap
class Main<K, V> extends AbstractMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private Entry<K, V>[] table;

    public Main() {
        this.table = new Entry[DEFAULT_CAPACITY];
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        // Implement entrySet() as needed
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (key.equals(entry.getKey())) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
            entry = entry.next;
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;

        return null;
    }

    // Add other methods as needed based on your requirements

    // Example: Override toString() to provide a custom string representation


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("VishalMap{");
        for (int i = 0; i < table.length; i++) {
            result.append("\n\t").append(i).append(": ");
            Entry<K, V> entry = table[i];
            while (entry != null) {
                result.append(entry).append(" -> ");
                entry = entry.next;
            }
            result.append("null");
        }
        result.append("\n}");
        return result.toString();

    }




    private int getIndex(K key) {
        return key.hashCode() % DEFAULT_CAPACITY;
    }

    static class Entry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }


    public static void main(String[] args) {
        // Create an instance of VishalMap
        Main<String, String> fgfh = new Main<>();

        // Put entries into the custom map
        fgfh.put("Key1", "Value1");
        fgfh.put("Key2", "Value2");
        fgfh.put("Key3", "Value3");

        // Print the custom map
        System.out.println(fgfh);
    }

}