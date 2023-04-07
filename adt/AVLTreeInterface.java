public interface AVLTreeInterface<T extends Comparable<T>> {

    public boolean contains(String ID);

    public boolean isEmpty();

    /* Make the tree logically empty */ public void makeEmpty();

    /* Function to insert data */ public void insertV(String data);

    /* Function to insert data */ public void insertC(String data);

    public void deleteC(String data);

    public void deleteV(String data);

    /* Functions to search for an element */ public boolean search(String val);

    public void castVote(String voterID, String candidateID);

    public void cancelVote(String voterID, String candidateID);

    public int getVoteCount(String candidateID);

    public AVLTree.List<String> getList();

    public boolean checkDuplicate(String ID);
}
