package com.paring.datastructures;

public class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
        return this.start - o.start;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Interval)) {
            return false;
        }
        Interval i = (Interval) obj;
        return Integer.compare(start, i.start) == 0
                && Integer.compare(end, i.end) == 0;
    }
}
