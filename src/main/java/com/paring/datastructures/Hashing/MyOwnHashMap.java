package com.paring.datastructures.Hashing;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
public class MyOwnHashMap<K, V> {
    ArrayList<HashNode<K, V>> map;
    int bucket;
    private int size;

    public MyOwnHashMap(int bucket) {
        this.bucket = bucket;
        map = new ArrayList<HashNode<K, V>>();
        for (int i = 0; i < bucket; i++) {
            map.add(null);
        }
    }

    public int getBucketIndex(K key) {
        return key.hashCode() % bucket;
    }

    public void put(K k, V v) {
        int hashValue = getBucketIndex(k);
        HashNode head = map.get(hashValue);
        while (head != null) {
            if (head.key == k) {
                head.value = v;
            }
            head = head.next;
        }
        head = map.get(hashValue);
        HashNode h = new HashNode(k, v);
        h.next = head;
    }
}
