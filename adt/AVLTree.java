package adt;

//test fo jk
public class AVLTree<T extends Comparable<T>> implements AVLTreeInterface<T> {
    private Node root;

    private class Node {
        String key;
        int count;
        Node left;
        Node right;
        int height;
        Node parent;

        public Node(String key) {
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

    public AVLTree() {
        root = null;
    }

    private int height(Node n) {
        if (n == null) {
            return 0;
        }
        return n.height;
    }

    private int balance(Node n) {
        if (n == null) {
            return 0;
        }
        return height(n.left) - height(n.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    public void add(String ID) {
        root = add(root, ID);
    }

    private Node add(Node n, String ID) {
        if (n == null) {
            return new Node(ID);
        }
        if (ID.compareTo(n.key) < 0) {
            n.left = add(n.left, ID);
        } else if (ID.compareTo(n.key) > 0) {
            n.right = add(n.right, ID);
        } else {
            System.out.println("Voter already exists in the system");
            return n;
        }

        n.height = 1 + Math.max(height(n.left), height(n.right));

        int balance = balance(n);

        if (balance > 1 && ID.compareTo(n.key) < 0) {
            return rightRotate(n);
        }

        if (balance < -1 && ID.compareTo(n.key) > 0) {
            return leftRotate(n);
        }

        if (balance > 1 && ID.compareTo(n.key) > 0) {
            n.left = leftRotate(n.left);
            return rightRotate(n);
        }

        if (balance < -1 && ID.compareTo(n.key) < 0) {
            n.right = rightRotate(n.right);
            return leftRotate(n);
        }

        return n;
    }

    public void remove(String ID) {
        root = remove(root, ID);
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node remove(Node n, String ID) {
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
                Node temp = null;
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
                Node temp = minValueNode(n.right);
                n.key = temp.key;
                n.right = remove(n.right, temp.key);
            }
        }
        if (n == null) {
            return n;
        }
        n.height = 1 + Math.max(height(n.left), height(n.right));
        int balance = balance(n);
        if (balance > 1 && balance(n.left) >= 0) {
            return rightRotate(n);
        }
        if (balance > 1 && balance(n.left) < 0) {
            n.left = leftRotate(n.left);
            return rightRotate(n);
        }
        if (balance < -1 && balance(n.right) <= 0) {
            return leftRotate(n);
        }
        if (balance < -1 && balance(n.right) > 0) {
            n.right = rightRotate(n.right);
            return leftRotate(n);
        }
        return n;
    }

    private Node search(Node node, String key) {
        if (node == null || node.key == key) {
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            return search(node.left, node.key);
        } else {
            return search(node.right, node.key);
        }
    }

    public void castVote(String voterID, String candidateID) {
        Node voterNode = search(root, voterID);
        Node candidateNode = search(root, candidateID);

        if (voterNode == null) {
            voterNode = add(root, voterID);
        }

        if (candidateNode == null) {
            candidateNode = add(root, candidateID);
        }

        voterNode.count++;
        candidateNode.count++;
        root = rebalance(root);
    }

    public void cancelVote(String voterID, String candidateID) {
        Node voterNode = findNode(voterID);
        Node candidateNode = findNode(candidateID);
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

    private Node rebalance(Node node) {
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.right) < 0) {
                rotateRight(node.right);
            }
            rotateLeft(node);
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.left) > 0) {
                rotateLeft(node.left);
            }
            rotateRight(node);
        }
        return node;
    }

    private int getBalanceFactor(Node node) {
        return getHeight(node.right) - getHeight(node.left);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }

    private Node findNode(String key) {
        Node currentNode = root;

        while (currentNode != null) {
            if (key == currentNode.key) {
                return currentNode;
            } else if (key.compareTo(currentNode.key) < 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        return null;
    }

    public int getVoteCount(String voterID) {
        Node node = findNode(voterID);
        if (node != null) {
            return node.count;
        }
        return 0;
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

    public List<String> getCandidateRanking() {
        List<String> candidateList = new ArrayList<>();
        getCandidateRankingHelper(root, candidateList);
        return candidateList;
    }

    private void getCandidateRankingHelper(Node node, List<String> candidateList) {
        if (node != null) {
            getCandidateRankingHelper(node.right, candidateList);
            candidateList.add(node.key);
            getCandidateRankingHelper(node.left, candidateList);
        }
    }

    public List<String> getVoterList() {
        List<String> voterList = new ArrayList<>();
        getVoterListHelper(root, voterList);
        return voterList;
    }

    private void getVoterListHelper(Node node, List<String> voterList) {
        if (node != null) {
            getVoterListHelper(node.left, voterList);
            voterList.add(node.key);
            getVoterListHelper(node.right, voterList);
        }
    }

    public boolean checkDuplicate(String ID) {
        Node node = findNode(ID);
        return node != null && node.key.equals(ID);
    }


}
