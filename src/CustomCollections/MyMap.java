package CustomCollections;

public class MyMap <K,V>{

    public static final int DEFAULT_SIZE=16;


    Entry[] hashTable;
    public MyMap() {
     hashTable=new Entry[DEFAULT_SIZE];
    }
    class Entry<K,V> {
        K key;
        V value;
        Entry next;

        Entry(K k, V v) {
            key=k;
            value=v;
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

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }
    }




        public void put (K key, V value) {
        int hashCode=key.hashCode() % hashTable.length;
        Entry node=hashTable[hashCode];

        if(node==null)
        {
           Entry newNode=new Entry(key, value);
            hashTable[hashCode]= newNode;
        }
        else {
            Entry previousNode=node;
            while(node!=null)
            {
                if(key.equals(node.key))
                {
                    node.value=value;
                    return;
                }
                previousNode=node;
                node=node.next;
            }
            Entry newNode=new Entry(key,value);
            previousNode.next=newNode;
        }

    }

    public V get(K key) {
        int hashCode=key.hashCode() % hashTable.length;
        Entry newNode=hashTable[hashCode];

        while(newNode!=null) {
            if(newNode.key.equals(key))
            {
                return (V) newNode.value;
            }
            newNode=newNode.next;
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

    public static void main(String args[]) {

        MyMap<Integer, String> map = new MyMap<>();
        map.put(1, "hi");
        map.put(2, "my");
        map.put(3, "name");
        map.put(4, "is");
        map.put(5, "Shrayansh");
        map.put(6, "how");
        map.put(7, "are");

        System.out.println(map);


    }






}
