package org.ajurcz.top150.L380;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.valueOf;

class RandomizedSet {
    List<Integer> set = new ArrayList<>();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        } else {
            set.addLast(val);
            return true;
        }
    }

    public boolean remove(int val) {
        return set.remove(valueOf(val));
    }

    public int getRandom() {
        var index = (int) (Math.random() * set.size());
        return set.get(index);
    }
}
