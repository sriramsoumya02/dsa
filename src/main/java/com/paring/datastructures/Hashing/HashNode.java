package com.paring.datastructures.Hashing;

public class HashNode<K, V> {
    K key;
    V value;
    public HashNode next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
