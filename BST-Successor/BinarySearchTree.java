public class BinarySearchTree<E> {

    private BinaryTreeNode<E> head;

    public BinarySearchTree() {
    }

    public BinaryTreeNode<E> max(BinaryTreeNode<E> node){
        if(node.getRightChild() == null){
        return node;
        }
        return max(node.getRightChild());
    }

    public void inOrder(BinaryTreeNode node){
        BinaryTreeNode left = node.getLeftChild();
        if(left != null){
        inOrder(left);
        }
        System.out.println("Visited: " + node.data);
        BinaryTreeNode right = node.getRightChild();
        if(right != null){
        inOrder(right);
        }
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

<<<<<<< HEAD
    public BinaryTreeNode<E> getSuccessor(BinaryTreeNode<E> node) {
        BinaryTreeNode<E> currentNode = node;
        // if has right subtree, go to leftmost node
        if (currentNode.getRightChild() != null) {
            currentNode = currentNode.getRightChild();
            while (currentNode.getLeftChild() != null) {
                currentNode = currentNode.getLeftChild();
            }
            return currentNode;
        }
        // if no right subtree, iterate until you find the first right ancestor
        BinaryTreeNode<E> previousNode = currentNode;
        currentNode = currentNode.getParent();
        while (currentNode.getParent() != null && currentNode.getLeftChild() != previousNode) {
            previousNode = currentNode;
            currentNode = currentNode.getParent();
        }
        if (currentNode.getParent() != null) {
            return currentNode.getLeftChild();
        }
        // NO successor
        return null;
=======
    public BinaryTreeNode<E> getSuccessor(BinaryTreeNode node) {
        if 
    }

    public BinaryTreeNode<E> min(BinaryTreeNode<E> node){
        if(node.getLeftChild() == null){
        return node;
        }
        return min(node.LeftChild());
    }

    public BinaryTreeNode<E> nthSmallest(BinaryTreeNode<E> node, int n) {
        return nthSmallestHelper(min(node), n);
    }

    public BinaryTreeNode<E> nthSmallestHelper(BinaryTreeNode<E> node, int n) {
        if (n <= 1) {
            return node;
        }
        return nthSmallestHelper(getSuccessor(node), n-1);
>>>>>>> 533233a48e3519f2e7365cd167b6f5650ab298cc
    }

    private class BinaryTreeNode<E> {
        private BinaryTreeNode<E> parent;
        private BinaryTreeNode<E> left;
        private BinaryTreeNode<E> right;
        private E key;
        private Object value;

        BinaryTreeNode(BinaryTreeNode<E> node, E Key, Object value) {
            this.parent = node;
            this.key = key;
            this.value = value;
        }

        public E getData() {
            return null;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public void setRightChild(BinaryTreeNode<E> right) {
            this.right = right;
        }

        public BinaryTreeNode<E> getRightChild() {
            return this.right;
        }

        public void setLeftChild(BinaryTreeNode<E> left) {
            this.left = left;
        }

        public BinaryTreeNode<E> getLeftChild() {
            return this.left;
        }

        public Object getKey() {
            return this.key;
        }

        public BinaryTreeNode<E> getParent() {
            return this.parent;
        }
    }

}