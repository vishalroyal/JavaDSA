package Practise;



public class MyHashmap<K,V>{

    public static int DEFAULT_CAP=16;

    Entry [] hashtable;

    public MyHashmap()
    {
        hashtable=new Entry[DEFAULT_CAP];
    }

    class Entry<K,V>
    {
        K key;
        V value;
        Entry next;

        public Entry(K k,V v)
        {
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

    public void put(K key,V value)
    {
        int hashCode=key.hashCode() % hashtable.length;
        Entry node=hashtable[hashCode];

        if(node==null)
        {
            Entry newNode=new Entry(key,value);
            hashtable[hashCode]=newNode;
        }else {
            Entry previousNode=node;
            while(node!=null)
            {
                if(key.equals(node.key)) {
                    node.value = value;
                    return;
                }
                previousNode=node;
                node=node.next;
            }
            Entry newNode=new Entry(key,value);
            previousNode.next=newNode;
        }
    }


}
