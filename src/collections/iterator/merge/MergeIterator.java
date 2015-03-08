package collections.iterator.merge;

import java.util.Iterator;

public class MergeIterator implements Iterator<Integer> {
    private final Iterator<Integer> iter0;
    private Iterator<Integer> iter1;
    Integer head0;
    Integer head1;

    public MergeIterator(Iterator<Integer> iter0, Iterator<Integer> iter1) {
        this.iter0 = iter0;
        this.iter1 = iter1;
    }

    @Override
    public boolean hasNext() {
        if(head0 == null && iter0.hasNext()){
            head0 = iter0.next();
        }
        if( head1 == null && iter1.hasNext()){
            head1 = iter1.next();
        }
        return head0 != null || head1 != null;
    }

    @Override
    public Integer next() {
        int result;
        if(head0 == null){
            result = head1;
            head1 = null;
            return result;
        }
        if(head1 == null){
            result = head0;
            head0 = null;
            return result;
        }
        if(head0.compareTo(head1)>0){
            result = head1;
            head1 = null;
            return result;
        }
        else {
            result = head0;
            head0 = null;
            return result;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}