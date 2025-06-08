import java.util.Iterator;

public class SLNavigableSet<E extends Comparable<E>> implements NavigableSet<E>{
    private SkipList<E> skipList;
    public SLNavigableSet(){
        skipList = new SkipList<E>();
    }
    public void insert(E item){
        skipList.add(item);
    }
    public Iterator<E> descendingIterator(){
        throw new UnsupportedOperationException();
    }
    public E ceiling(E e){
        throw new UnsupportedOperationException();
    }
    public NavigableSet<E> descendingSet(){
        throw new UnsupportedOperationException();
    }
    public E first(){
        throw new UnsupportedOperationException();
    }
    public E floor(E e){
        throw new UnsupportedOperationException();
    }
    public NavigableSet<E> headset(E toEl, boolean incl){
        throw new UnsupportedOperationException();
    }
    public E higher(E e){
        throw new UnsupportedOperationException();
    }
    public Iterator<E> iterator(){
        throw new UnsupportedOperationException();
    }
    public E last(){
        throw new UnsupportedOperationException();
    }
    public E lower(E e){
        throw new UnsupportedOperationException();
    }
    public E pollFirst(){
        throw new UnsupportedOperationException();
    }
    public E pollLast(){
        throw new UnsupportedOperationException();
    }
    public NavigableSet<E> subSet(E fromEl, boolean fromIncl, E toEl, boolean toIncl){
        throw new UnsupportedOperationException();
    }
    public NavigableSet<E> tailSet(E fromEl, boolean incl){
        throw new UnsupportedOperationException();
    }
}
