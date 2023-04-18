package adt;

public interface HashMapInterface<K, V> {

    void put(K key, V value);


    V get(K key);


    V remove(K key);


    boolean containsKey(K key);


    int size();


    void clear();

    void resizeTable();

    boolean isEmpty();

    boolean containsValue(V value);

}