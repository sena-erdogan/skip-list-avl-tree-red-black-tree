import java.util.Arrays;
import java.util.*;

@SuppressWarnings("unchecked") 
public class SkipList<E extends Comparable<E>>{
    private SLNode<E> head = new SLNode<E>();
    private int maxCap;
    private int maxLevel;
    private int size = 0;
    /** Static class to contain the data and the links */
    static class SLNode<E> {
        SLNode<E>[] links;
        E data;
        SLNode () {
           //INTENTIONALLY EMPTY
        }
        /** Create a node of level m */
        SLNode (int m, E data) {
            links = (SLNode<E>[]) new SLNode[m]; // create links
            this.data = data; // store item
        }
    }
    /** Starter add method
    @param item item to be added
     */
    public void add(E item){
        SLNode<E> newNode = new SLNode<E>(1,item);
        add(newNode);
    }
    /** add method
     @param newNode node containing the item to be added
     */
    private SLNode<E>[] add(SLNode<E> newNode){
        SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
        SLNode<E> current = head;
        for (int i = current.links.length-1; i >= 0; i--) {
            while (current.links[i] != null
                    && current.links[i].data.compareTo(newNode.data) < 0) {
                newNode.links[i] = pred[i].links[i];
                pred[i].links[i] = newNode;
            }
            pred[i] = current;
        }
        size++;
        if (size > maxCap) {
            maxLevel++;
            maxCap = computeMaxCap(maxLevel);
            head.links = Arrays.copyOf(head.links, maxLevel);
            pred = Arrays.copyOf(pred, maxLevel);
            pred[maxLevel - 1] = head;
        }
        return pred;
    }

    private int computeMaxCap(int maxLevel) {
        return (int)Math.pow(2.0, maxLevel) - 1;
    }

    @SuppressWarnings("unchecked")
/** Search for an item in the list
 @param item The item being sought
 @return A SLNode array which references the predecessors
 of the target at each level.
 */
    private SLNode<E>[] search (E target) {
        SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
        SLNode<E> current = head;
        for (int i = current.links.length-1; i >= 0; i--) {
            while (current.links[i] != null
                    && current.links[i].data.compareTo(target) < 0) {
                current = current.links[i];
            }
            pred[i] = current;
        }
        return pred;
    }

    /** Find an object in the skip‐list
     @param target The item being sought
     @return A reference to the object in the skip‐list that matches
     the target. If not found, null is returned.
     */
    public E find(E target) {
        SLNode<E>[] pred = search(target);
        if (pred[0].links[0] != null &&
                pred[0].links[0].data.compareTo(target) == 0) {
            return pred[0].links[0].data;
        } else {
            return null;
        }
    }
    /** Natural Log of 2 */
    static final double LOG2 = Math.log(2.0);
    /** Method to generate a logarithmic distributed integer between
     1 and maxLevel. i.e., 1/2 of the values returned are 1, 1/4
     are 2, 1/8 are 3, etc.
     @return a random logarithmic distributed int between 1 and
     maxLevel
     */
    private int logRandom() {
        Random rand = new Random();
        int r = rand.nextInt(maxCap);
        int k = (int) (Math.log(r + 1) / LOG2);
        if (k > maxLevel - 1) {
            k = maxLevel - 1;
        }
        return maxLevel- k;
    }
}
