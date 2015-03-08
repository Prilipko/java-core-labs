package collections.iterator.square;

import java.util.Iterator;

public class SquareIterator implements Iterator<Integer> {
    private final int max;
    private int current;

    public SquareIterator(int left, int right) {
        this.max = right;
        this.current = left;
    }

    @Override
    public boolean hasNext() {
        do{
            double sqrt = Math.sqrt(current);
            int sqrtInt = (int) sqrt;
            if(sqrt - sqrtInt == 0){
                return true;
            }
            current++;
        }while(current < max);
        return false;
    }

    @Override
    public Integer next() {
        return current++;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}