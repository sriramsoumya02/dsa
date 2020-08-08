package com.paring.datastructures;

import java.util.Stack;

public class MinStack {
    private Stack st;
    private Stack min;
    private int minumTillnow;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        st = new Stack();
        min = new Stack();
    }

    public void push(int x) {
        if (st.isEmpty()) {
            minumTillnow = x;
        } else {
            if (minumTillnow > x)
                minumTillnow = x;
        }
        min.push(minumTillnow);
        st.push(x);
    }

    public void pop() {
        st.pop();
        min.pop();
        if (!min.isEmpty())
            minumTillnow = (int) min.peek();
        else
            minumTillnow = Integer.MIN_VALUE;
    }

    public int top() {
        return (int) st.peek();
    }

    public int getMin() {
        return (int) min.peek();
    }
}
