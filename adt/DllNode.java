package adt;

import Entity.Voter;

public class DllNode<T extends Comparable<T>> implements DoublyLinkListInterface<T>{

    // DllNode<T> = generic class that represents node in DoublyLinkList
    private DllNode<T> prev; // data type stored in node is T; T can be Voter entity
    private DllNode<T> next;
    private Voter data;
    private int size = 0;

    public DllNode(){
        this.data = null;
        this.prev = null;
        this.next = null;
    }

    public DllNode(Voter data){
        this.data = data;
        this.prev = null;
        this.next = null;
        this.size++;
    }

    @Override
    public boolean add(T newEntry){
        if (newEntry == null){                  // check if newEntry is null
            return false;                       // if empty, false indicates
        }

        // add voter object to the end of list
        Voter newVoter = (Voter) newEntry;
        DllNode<T> n = new DllNode<>(newVoter); // create new node(n)
        if (isEmpty()){                         // check if the list is empty
            next = n;
            prev = n;
        }else{
            DllNode currentNode = next;             // create a current pointer points to head?
            while(currentNode.next != null){        // point the pointer to next node if current.next not null
                currentNode = currentNode.next;     // points to next node
            }
            currentNode.next = n;
            n.prev = currentNode;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean remove(T entry){
        if (entry == null || isEmpty()) {       // return null if the entry is null or the list is empty
            return false;
        }

        Voter targetVoter = (Voter) entry;
        DllNode<T> currentNode = next;              // create a pointer


        // remove targeted voter object
        while (currentNode != null) {                               // while pointer not null
            if (currentNode.data.compareTo(targetVoter) == 0) {     // if the currentNode data = targeted node data
                if (currentNode.equals(prev)) {                     // check if current node is the firstNode in list(current and prev(null) same object)
                    prev = currentNode.next;                        // remove the node at beginning
                    currentNode.next.prev = null;
                    currentNode.next = null;
                } else if (currentNode.equals(next)) {              // check if current node is last node in list
                    next = currentNode.prev;
                    currentNode.prev.next = null;
                    currentNode.prev = null;
                } else {
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                }
                this.size--;
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }


    @Override       //search if the entry is inside in the list
    public boolean contains(T entry)
    {
        if (entry == null || isEmpty()) {
            return false;
        }

        Voter targetVoter = (Voter) entry;
        DllNode<T> currentNode = next;

        while (currentNode != null) {
            if (currentNode.data.compareTo(targetVoter) == 0) {return true;}
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public int size(){
        return size;
    }
    @Override       // clear the whole list
    public void clear(){
        next = null;
        prev = null;
        this.size = 0;
    }

    @Override       // check if the list is empty
    public boolean isEmpty(){
        return this.size == 0;
    };

    @Override
    public T getEntry(T entry){     // get the entry in the list
        if (entry == null || isEmpty()) {
            return null;
        }

        Voter targetVoter = (Voter) entry;

        DllNode<T> currentNode = next;

        while (currentNode != null) {
            if (currentNode.data.equals(targetVoter)) {
                return (T) currentNode.data;
            }

            currentNode = currentNode.next;
        }

        return null;
    }


    public T getEntry(int index){// Get Entry based on index of list?
        if (index < 1 || index > this.size || isEmpty()) {
            return null;
        }

        DllNode<T> currentNode = next;
        int currentIndex = 1;

        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        return (T) currentNode.data;
    }

    // dk how to use
//    public DoublyLinkList<T>.Node getTail();
//    public String printAscending();
//    public String printDescending();


    //    public DllNode<T> getTail() {
//        DllNode<T> current = next;
//        while (current.next != null) {
//            current = current.next;
//        }
//        return current;
//    }
}
