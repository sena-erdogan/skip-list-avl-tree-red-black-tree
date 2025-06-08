public class RedBlackTree<E extends Comparable<E>>
        extends BinarySearchTreeWithRotate<E> {
    /**
     * Nested class to represent a Red‐Black node.
     */
    private static class RedBlackNode<E> extends Node<E> {
        // Additional data members
        /**
         * Color indicator. True if red, false if black.
         */
        private boolean isRed;

        // Constructor

        /**
         * Create a RedBlackNode with the default color of red
         * and the given data field.
         *
         * @param item The data field
         */
        public RedBlackNode(E item) {
            super(item);
            isRed = true;
        }
        // Methods

        /**
         * Return a string representation of this object.
         * The color (red or black) is appended to the node's contents.
         *
         * @return String representation of this object
         */
        @Override
        public String toString() {
            if (isRed) {
                return "Red : " + super.toString();
            } else {
                return "Black: " + super.toString();
            }
        }
    }

    public boolean add(E item) {
        if (root == null) {
            root = new RedBlackNode<>(item);
            ((RedBlackNode<E>) root).isRed = false;
            // root is black.
            return true;
        } else {
            root = add((RedBlackNode<E>) root, item);
            ((RedBlackNode<E>) root).isRed = false;
            // root is always black.
            return addReturn;
        }
    }

    private boolean moveBlackDown(RedBlackNode<E> localRoot){
        if(localRoot.right.isRed && localRoot.left.isRed){
            localRoot.isRed = true;
            localRoot.right.isRed = false;
            localRoot.left.isRed = false;

            return true;
        }
        return false;
    }

    private Node<E> add(RedBlackNode<E> localRoot, E item) {
        if (item.compareTo(localRoot.data) == 0) {
            // item already in the tree.
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item < localRoot.data.
            if (localRoot.left == null) {
                // Create new left child.
                localRoot.left = new RedBlackNode<>(item);
                addReturn = true;
                return localRoot;
            } else { // Need to search.
                // Check for two red children, swap colors if found.
                moveBlackDown(localRoot);
                // Recursively add on the left.
                localRoot.left = add((RedBlackNode<E>) localRoot.left, item);
                // See whether the left child is now red
                if (((RedBlackNode<E>) localRoot.left).isRed) {
                    if (localRoot.left.left != null && ((RedBlackNode<E>)
                            localRoot.left.left).isRed) {
                        // Left‐left grandchild is also red.
                        if (localRoot.left.left != null && ((RedBlackNode<E>)
                                localRoot.left.left).isRed) {
                            // Left‐left grandchild is also red.
                            // Single rotation is necessary.
                            ((RedBlackNode<E>) localRoot.left).isRed = false;
                            localRoot.isRed = true;
                            return rotateRight(localRoot);
                        }else if (localRoot.left.right != null && ((RedBlackNode<E>)
                                    localRoot.left.right).isRed) {
                                // Left‐right grandchild is also red.
                                // Double rotation is necessary.
                                localRoot.left = rotateLeft(localRoot.left);
                                ((RedBlackNode<E>) localRoot.left).isRed = false;
                                localRoot.isRed = true;
                                return rotateRight(localRoot);
                            }
                        }
                    }
                }
            }
            return null;
        }
    }