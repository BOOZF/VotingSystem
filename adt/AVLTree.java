import static java.lang.Math.max;

public class AVLTree<T extends Comparable<T>> implements AVLTreeInterface<T> {

    private AVLNode root;

    private class AVLNode {
        String key;
        int count;
        AVLNode left;
        AVLNode right;
        int height;
        AVLNode parent;

        public AVLNode(String key) {
            this.key = key;
            this.count = 0;
            this.height = 1;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public interface List<T> {
        public void add(T element);
        public int size();
        public T get(int index);
    }

    public class ArrayList<T> implements List<T> {
        private T[] array;
        private int size;

        public ArrayList() {
            array = (T[]) new Object[10];
            size = 0;
        }

        public void add(T element) {
            if (size == array.length) {
                T[] newArray = (T[]) new Object[array.length * 2];
                for (int i = 0; i < array.length; i++) {
                    newArray[i] = array[i];
                }
                array = newArray;
            }
            array[size] = element;
            size++;
        }

        public int size() {
            return size;
        }

        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            return array[index];
        }
    }

    public AVLTree() {
        root = null;
    }

    @Override
    public boolean contains(String ID) {
        AVLNode node = findNode(root, ID);
        return node != null;
    }

    @Override
    public boolean isEmpty()
    {
        return root == null;
    }

    @Override
    /* Make the tree logically empty */
    public void makeEmpty()
    {
        root = null;
    }

    @Override
    /* Function to insert data */
    public void insertV(String data)
    {
        root = insert(data, root);
    }

    @Override
    /* Function to insert data */
    public void insertC(String data)
    {
        root = insert(data, root);
    }

    @Override
    public void deleteV(String data)
    {
        root = remove(root, data);
    }

    @Override
    public void deleteC(String data)
    {
        root = remove(root, data);
    }
    @Override
    /* Functions to search for an element */
    public boolean search(String val)
    {
        return search(root, val);
    }

    @Override
    public void castVote(String voterID, String candidateID) {
        AVLNode voterNode = searchCastVote(root, voterID);
        AVLNode candidateNode = searchCastVote(root, candidateID);

        if (voterNode == null) {
            voterNode = insert(voterID, root);
        }

        if (candidateNode == null) {
            candidateNode = insert(candidateID, root);
        }

        voterNode.count++;
        candidateNode.count++;
        root = rebalance(root);
    }

    @Override
    public void cancelVote(String voterID, String candidateID) {
        AVLNode voterNode = findNode(root, voterID);
        AVLNode candidateNode = findNode(root, candidateID);
        if (voterNode == null || candidateNode == null) {
            // Voter or candidate does not exist
            return;
        }
        if (voterNode.getCount() == 0 || candidateNode.getCount() == 0) {
            // Cannot cancel vote if there are no votes
            return;
        }
        // Decrement the vote count for both voter and candidate nodes
        voterNode.setCount(voterNode.getCount() - 1);
        candidateNode.setCount(candidateNode.getCount() - 1);
        // Rebalance the AVL tree
        root = rebalance(root);
    }

    @Override
    public int getVoteCount(String candidateID) {
        AVLNode candidateNode = findNode(root, candidateID);
        if (candidateNode == null) {
            return 0; // candidate not found
        } else {
            return candidateNode.count;
        }
    }

    @Override
    public List<String> getList() {
        List<String> voterList = new ArrayList<>();
        getListHelper(root, voterList);
        return voterList;
    }

    @Override
    public boolean checkDuplicate(String ID) {
        AVLNode node = findNode(root, ID);
        return node != null && node.key.equals(ID);
    }

    /* Function to get height of node */
    private int height(AVLNode t )
    {
        return t == null ? -1 : t.height;
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }

    private AVLNode findNode(AVLNode node, String key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return findNode(node.left, key);
        } else {
            return findNode(node.right, key);
        }
    }


    private void getListHelper(AVLNode node, List<String> voterList) {
        if (node != null) {
            getListHelper(node.left, voterList);
            voterList.add(node.key);
            getListHelper(node.right, voterList);
        }
    }

    /* Function to insert data recursively */
    private AVLNode insert(String x, AVLNode t)
    {
        if (t == null)
            t = new AVLNode(x);
        else if (x.compareTo(t.key) < 0)
        {
            t.left = insert( x, t.left );
            if( height( t.left ) - height( t.right ) == 2 )
                if( x.compareTo(t.left.key) < 0 )
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if( x.compareTo(t.key) > 0 )
        {
            t.right = insert( x, t.right );
            if( height( t.right ) - height( t.left ) == 2 )
                if( x.compareTo(t.right.key) > 0)
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
            ;  // Duplicate; do nothing
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }

    private AVLNode remove(AVLNode n, String ID) {
        if (n == null) {
            System.out.println("Voter does not exist in the system");
            return null;
        }

        if (ID.compareTo(n.key) < 0) {
            n.left = remove(n.left, ID);
        } else if (ID.compareTo(n.key) > 0) {
            n.right = remove(n.right, ID);
        } else {
            if (n.left == null || n.right == null) {
                AVLNode temp = null;
                if (temp == n.left) {
                    temp = n.right;
                } else {
                    temp = n.left;
                }

                if (temp == null) {
                    temp = n;
                    n = null;
                } else {
                    n = temp;
                }
            } else {
                AVLNode temp = minValueNode(n.right);
                n.key = temp.key;
                n.right = remove(n.right, temp.key);
            }
        }
        if (n == null) {
            return n;
        }
        n.height = 1 + max(height(n.left), height(n.right));
        int balance = balance(n);
        if (balance > 1 && balance(n.left) >= 0) {
            return rotateWithRightChild(n);
        }
        if (balance > 1 && balance(n.left) < 0) {
            n.left = rotateWithLeftChild(n.left);
            return rotateWithRightChild(n);
        }
        if (balance < -1 && balance(n.right) <= 0) {
            return rotateWithLeftChild(n);
        }
        if (balance < -1 && balance(n.right) > 0) {
            n.right = rotateWithRightChild(n.right);
            return rotateWithLeftChild(n);
        }
        return n;
    }
    /* Rotate binary tree node with left child */
    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode k1)
    {
        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private AVLNode doubleWithLeftChild(AVLNode k3)
    {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */
    private AVLNode doubleWithRightChild(AVLNode k1)
    {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }

    private AVLNode searchCastVote(AVLNode node, String key) {
        if (node == null || node.key == key) {
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            return searchCastVote(node.left, node.key);
        } else {
            return searchCastVote(node.right, node.key);
        }
    }

    private boolean search(AVLNode r, String val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            String rval = r.key;
            if (val.compareTo(rval) < 0)
                r = r.left;
            else if (val.compareTo(rval) > 0)
                r = r.right;
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    private int balance(AVLNode n) {
        if (n == null) {
            return 0;
        }
        return height(n.left) - height(n.right);
    }

    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private AVLNode rebalance(AVLNode node) {
        int balanceFactor = getBalanceFactor(node);

        // Left-heavy?
        if (balanceFactor < -1) {
            if (getBalanceFactor(node.left) <= 0) {    // Case 1
                // Rotate right
                node = rotateWithRightChild(node);
            } else {                                // Case 2
                // Rotate left-right
                node.left = rotateWithLeftChild(node.left);
                node = rotateWithRightChild(node);
            }
        }

        // Right-heavy?
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.right) >= 0) {    // Case 3
                // Rotate left
                node = rotateWithLeftChild(node);
            } else {                                 // Case 4
                // Rotate right-left
                node.right = rotateWithRightChild(node.right);
                node = rotateWithLeftChild(node);
            }
        }

        return node;
    }

    private int getBalanceFactor(AVLNode node) {
        return getHeight(node.right) - getHeight(node.left);
    }

    private int getHeight(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + max(getHeight(node.left), getHeight(node.right));
    }
}
