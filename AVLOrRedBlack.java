public class AVLOrRedBlack<E extends Comparable<E>> {
    public AVLOrRedBlack(){
        //INTENTIONALLY LEFT EMPTY
    }

    /**Uses two helper methods. One to check if a tree is an AVLTree
     * and one to check if it is a RedBlackTree
     * @param tree
     * @return 1 if the tree is a RedBlackTree, 2 if it is an AVLTree, 0 is neither
     */
    public int AVLorRedBlack(BinarySearchTree<E> tree){
        if(!tree.isRed()){
            if(isRedBlack(tree.root, 0))    return 1;
        }
        if(isAVL(tree)) return 2;
        else    return 0;
    }

    private boolean isRedBlack(BinaryTree.Node<E> localRoot, int count){
        if(localRoot == null)   return false;
        if(count%2 == 0){
            if(localRoot.isRed) return false;
            else    return isRedBlack(localRoot.left,count+1) && isRedBlack(localRoot.right, count+1);
        }
        else{
            if(!localRoot.isRed) return false;
            else    return isRedBlack(localRoot.left,count+1) && isRedBlack(localRoot.right, count+1);
        }
    }
    private boolean isAVL(BinarySearchTree<E> tree){
        return (maxNodes(tree.root) > numberOfNodes(tree.root)) && (minNodes(heightOfTree(tree.root)) < numberOfNodes(tree.root)) && (minHeight(tree.root) < heightOfTree(tree.root)) && (maxHeight(numberOfNodes(tree.root)) > heightOfTree(tree.root));
    }
    /** Natural Log of 2 */
    static final double LOG2 = Math.log(2.0);
    private int maxNodes(BinaryTree.Node<E> localRoot){
        return (int)(Math.pow(2,heightOfTree(localRoot)+1))-1;
    }
    private int minNodes(int count){
        if(count == 0)  return 1;
        else if(count == 1) return 2;
        return minNodes(count-1) + minNodes(count-2) + 1;
    }
    private int minHeight(BinaryTree.Node<E> localRoot){
        return (int)Math.floor((Math.log(numberOfNodes(localRoot) / LOG2)));
    }
    private int maxHeight(int count){
        if(count == 0)  return 1;
        else if(count == 1) return 2;
        return maxHeight(count-1) + maxHeight(count-2) + 1;
    }
    private int numberOfNodes(BinaryTree.Node<E> localRoot){
        if(localRoot == null) return 0;
        return numberOfNodes(localRoot.left) + numberOfNodes(localRoot.right);
    }
    private int heightOfTree(BinaryTree.Node<E> localRoot){
        if(localRoot == null)   return 0;
        return 1 + Math.max(heightOfTree(localRoot.right),heightOfTree(localRoot.left));
    }
}
