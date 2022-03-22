package com.mps2022.laboratorio2.comparator;

import com.mps2022.laboratorio2.DequeNode;

import java.util.Comparator;

public class IncreasingComparator implements Comparator<DequeNode<Integer>> {
    @Override
    public int compare(DequeNode<Integer> o1, DequeNode<Integer> o2) {

        if(o1.getItem()<o2.getItem())
            return -1;
        else if(o1.getItem()>o2.getItem())
            return 1;
        else if(o1.getItem().equals(o2.getItem()))
            return 0;

        return -1;
    }
}
