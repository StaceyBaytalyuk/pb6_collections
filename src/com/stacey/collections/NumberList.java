package com.stacey.collections;

import java.util.List;

public class NumberList {
    private List<Integer> list;

    public NumberList(List<Integer> list) {
        this.list = list;
    }

    public boolean add(int number) {
        return list.add(number);
    }

    public int remove(int number) {
        return list.remove(list.indexOf(number));
    }

    public int closestNumber(int number) {
        int idClosest = 0;
        int min = Math.abs(number - list.get(idClosest));

        for (int i = 1; i < list.size(); i++) {
            int curr = Math.abs(number - list.get(i));
            if ( curr < min ) {
                min = curr;
                idClosest = i;
            }
        }
        return list.get(idClosest);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
