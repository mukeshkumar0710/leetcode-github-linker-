// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.nextElement = iterator.hasNext() ? iterator.next() : null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElement;
    }

    @Override
    public Integer next() {
        Integer res = nextElement;
        nextElement = iterator.hasNext() ? iterator.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}