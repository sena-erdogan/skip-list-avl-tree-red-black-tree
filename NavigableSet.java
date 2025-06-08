import java.util.Iterator;

public interface NavigableSet<E>{
    E ceiling(E e);
    Iterator<E> descendingIterator();
    NavigableSet<E> descendingSet();
    E first();
    E floor(E e);
    NavigableSet<E> headset(E toEl, boolean incl);
    E higher(E e);
    Iterator<E> iterator();
    E last();
    E lower(E e);
    E pollFirst();
    E pollLast();
    NavigableSet<E> subSet(E fromEl, boolean fromIncl, E toEl, boolean toIncl);
    NavigableSet<E> tailSet(E fromEl, boolean incl);
}
