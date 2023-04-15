package adt;

public interface AVLTreeInterface<T extends Comparable<T>>{
    public boolean isEmpty();

    /* Make the tree logically empty */
    public void makeEmpty();

    public void insert(T data) throws AVLTree.DuplicateElementException;

    public void remove(T data);

    public boolean contains(T data);

    public AVLTree.List<T> inOrderTraversal();
}
