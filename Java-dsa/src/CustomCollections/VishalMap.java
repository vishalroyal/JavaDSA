package CustomCollections;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VishalMap<K,V> extends AbstractMap<K,V> {

    private Map<K, V> internalMap;

    public VishalMap() {
        this.internalMap = new HashMap<>();
    }

    @Override
    public V put(K key, V value) {
        return internalMap.put(key, value);
    }

    @Override
    public String toString() {
        return internalMap.toString();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

}


