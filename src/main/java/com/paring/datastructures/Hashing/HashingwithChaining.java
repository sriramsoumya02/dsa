package com.paring.datastructures.Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

// Java program to demonstrate implementation of our
// own hash table with chaining for collision detection
public class HashingwithChaining {
    int bucket;
    ArrayList<LinkedList<Integer>> table;

    public HashingwithChaining(int bucket) {
        this.bucket = bucket;
        this.table = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < bucket; i++) {
            table.add(new LinkedList<Integer>());
        }
    }

    private int hashing(int input) {
        return input % this.bucket;
    }

    public void insert(int data) {
        if (isExists(data))
            table.get(hashing(data)).remove(data);
        else
            table.get(hashing(data)).add(data);
    }

    public boolean isExists(int data) {
        return table.get(hashing(data)).contains(data);
    }

    public void delete(int data) {
        table.get(hashing(data)).remove((Integer) data);
    }

    public static void main(String[] args) {
        HashingwithChaining mh = new HashingwithChaining(7);
        mh.insert(10);
        mh.insert(20);
        mh.insert(15);
        mh.insert(7);
        System.out.println(mh.isExists(10));
        mh.delete(15);
        System.out.println(mh.isExists(15));
    }
}
