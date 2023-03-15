public class BinarySearchTree {

    public BinaryTreeNode<E> max(BinaryTreeNode<E> node){
        if(node.getRightChild() == null){
        return node;
        }
        return max(node.getRightChild());
    }

    public E get(BinaryTreeNode<E> startFrom, Comparable key){
        if(startFrom == null){
            return null;
        }

        int cmp = key.compareTo(startFrom.getKey());
        if(cmp == 0){
            return startFrom.getData(); //return the value for this key
        }
        else if(cmp < 0){
            return get(startFrom.getLeftChild(),key);
        }
        else { //cmp > 0
            return get(startFrom.getRightChild(),key);
        }
    }

    public BinaryTreeNode put(BinaryTreeNode node, Comparable key, Object value) {
        if (node == null) {
            return new BinaryTreeNode(null, key, value); //create new node
        }
        int compare = key.compareTo(node.getKey());
        //when a recursive call creates a new child, it is attached to the parent
        if (compare < 0) {
            BinaryTreeNode left = node.getLeftChild();
            BinaryTreeNode returned = put(left, key, value);
            if (left == null) {
                node.setLeftChild(returned);
            }
        }
        else if (compare > 0) {
        BinaryTreeNode right = node.getRightChild();
        BinaryTreeNode returned = put(right, key, value);
        if (right == null) {
        node.setRightChild(returned);
        }
        }
        else {
        node.setValue(value); //set value in existing node
        }
        return node;
        }

    public E getSuccessor(BinaryTreeNode node) {
        return node;
    }

    private class BinaryTreeNode<E> {
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private Comparable key;
        private E value;

        BinaryTreeNode(Comparable Key, E value) {
            this.key = key;
            this.value = value;
        }

    }

}