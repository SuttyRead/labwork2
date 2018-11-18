package com.ua.sutty.lab8;

import interfaces.task8.CyclicCollection;
import interfaces.task8.CyclicItem;

import java.io.Serializable;

public class CyclicCollectionImpl implements CyclicCollection, Serializable {

    private CyclicItem firstCyclicItem;
    private CyclicItem lastCyclicItem;
    private int length;

    @Override
    public boolean add(CyclicItem cyclicItem) {
        if (length == 0) {
            this.firstCyclicItem = cyclicItem;
            this.firstCyclicItem.setNextItem(this.firstCyclicItem);
            this.lastCyclicItem = this.firstCyclicItem;
            length++;
        } else {
            if (matchCheck(cyclicItem)) {
                throw new IllegalArgumentException();
            } else {
                this.lastCyclicItem.setNextItem(cyclicItem);
                this.lastCyclicItem = cyclicItem;
                this.lastCyclicItem.setNextItem(this.firstCyclicItem);
                length++;
            }
        }
        return true;
    }

    @Override
    public void insertAfter(CyclicItem cyclicItem, CyclicItem newCyclicItem) {
        if (cyclicItem == null || newCyclicItem == null) {
            throw new NullPointerException();
        }
        if (!matchCheck(cyclicItem)) {
            throw new IllegalArgumentException();
        }
        if (matchCheck(newCyclicItem)) {
            throw new IllegalArgumentException();
        }
        CyclicItem currentItem = this.firstCyclicItem;
        CyclicItem nextItem = this.firstCyclicItem.nextItem();
        for (int i = 0; i < length; i++) {
            if (currentItem.equals(cyclicItem)) {
                if (length > 2) {
                    currentItem.setNextItem(newCyclicItem);
                    newCyclicItem.setNextItem(nextItem);
                    length++;
                    return;
                } else if (length == 2) {
                    currentItem.setNextItem(newCyclicItem);
                    newCyclicItem.setNextItem(nextItem);
                    this.firstCyclicItem = nextItem;
                    length++;
                    return;
                }
            }
            lastCyclicItem = currentItem;
            currentItem = nextItem;
            nextItem = nextItem.nextItem();
        }
    }

    @Override
    public CyclicItem getFirst() {
        if (this.firstCyclicItem == null) {
            throw new NullPointerException();
        }
        return this.firstCyclicItem;
    }

    @Override
    public boolean remove(CyclicItem cyclicItem) {
        if (cyclicItem == null) {
            throw new NullPointerException();
        }

        if (length == 0) {
            return false;
        }

        CyclicItem befItem = lastCyclicItem;
        CyclicItem currItem = firstCyclicItem;
        CyclicItem nextItem = firstCyclicItem.nextItem();
        for (int i = 0; i < length; i++) {
            if (currItem.equals(cyclicItem)) {
                if (length > 2) {
                    befItem.setNextItem(currItem.nextItem());
                    length--;
                    return true;
                } else if (length == 2) {
                    currItem.setNextItem(null);
                    befItem.setNextItem(nextItem);
                    firstCyclicItem = nextItem;
                    length--;
                    return true;
                } else {
                    firstCyclicItem = null;
                    length--;
                    return true;
                }
            }
            befItem = currItem;
            currItem = nextItem;
            nextItem = nextItem.nextItem();
        }
        return false;
    }

    @Override
    public int size() {
        return length;
    }

    private boolean matchCheck(final CyclicItem item) {
        int n = length;
        CyclicItem currentItem = firstCyclicItem;
        while (n != 0) {
            boolean cont = currentItem.equals(item);
            if (cont) {
                return true;
            }
            currentItem = currentItem.nextItem();
            n--;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CyclicCollectionImpl{" +
                "firstCyclicItem=" + firstCyclicItem +
                ", lastCyclicItem=" + lastCyclicItem +
                ", length=" + length +
                '}';
    }
}
