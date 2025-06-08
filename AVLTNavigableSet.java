import java.util.Iterator;

public class AVLTNavigableSet<E extends Comparable<E>> implements NavigableSet<E>{
    private AVLTree<E> avlTree;
    public AVLTNavigableSet(){
        avlTree = new AVLTree<E>();
    }
    public boolean insert(E item){
        return avlTree.add(item);
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
        return avlTree.iterator();
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
