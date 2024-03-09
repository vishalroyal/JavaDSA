package CustomCollections;





public class CustomMap <K,V>{

    private static final int INITIAL_SIZE =1<< 14;
    private static final int MAX_SIZE=1<<30;

    Entry[] hashTable;

    public CustomMap()
    {
        hashTable=new Entry[INITIAL_SIZE];
    }
    public CustomMap(int capacity)
    {
        int tableSize=tableSizeFor(capacity);
         hashTable= new Entry[tableSize];

    }
    final int tableSizeFor(int cap)
    {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAX_SIZE) ? MAX_SIZE : n + 1;

    }
    class Entry<K,V>{
        K key;
        V value;
        Entry next;

        Entry(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }

    public void put(K key, V value)
    {

        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if(node == null)
        {
            Entry newNode=new Entry(key, value);
            hashTable[hashCode]=  newNode;
        }
        else {
            Entry previousNode = node;
            while(node!=null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            Entry newNode=new Entry(key,value);
            previousNode.next=newNode;
        }
    }

    public V get(K key)
    {
        int hashCode=key.hashCode() % hashTable.length;
        Entry node=hashTable[hashCode];
        if(node!=null)
        {
            while(node!=null)
            {
                if(key.equals(node.key))
                {
                    return (V) node.value;
                }
                node=node.next;
            }
        }

        return null;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (Entry<K, V> entry : hashTable) {
            Entry<K, V> current = entry;
            while (current != null) {
                sb.append(current.key).append("=").append(current.value).append(", ");
                current = current.next;
            }
        }

        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2); // Remove the last comma and space
        }

        sb.append("}");
        return sb.toString();
    }




    public static void main(String args[])
    {
        CustomMap<String, Object> newha=new CustomMap<>();
        newha.put("as","abc");
        newha.put("as1","abc");
        System.out.println(newha);
    }






}
