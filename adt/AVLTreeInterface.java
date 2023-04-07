package adt;

public interface AVLTreeInterface<T extends Comparable<T>> {
    // Remove a node with data value from the AVL Tree
    public void remove(T data);

    void reset();

    // Check if the AVL Tree contains a node with data value
    public boolean contains(T data);

    // Get the height of the AVL Tree
    public int height();

    // Vote for a candidate
    public void voteFor(T candidate);

    public int getVotes(T candidate);

    AVLTree.List<T> getRanking();

    // Get the size of the AVL Tree
    public int size();

    // Print the AVL Tree in order traversal
    public void print();

    void clearVotes();

    void add(T data);

    T getWinner();
}

