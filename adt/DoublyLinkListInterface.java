package adt;

public interface DoublyLinkListInterface <T extends Comparable<T>> {
    public boolean add(T newEntry);
    public boolean remove(T entry);
    public boolean contains(T entry);//Find whether the entry is inside in the list or not?
    public void clear();

    public boolean isEmpty();
    public T getEntry(T entry);
    public T getEntry(int index);// Get Entry based on index of list?

    // dk how to use
    //public DoublyLinkList<T>.Node getTail();
//    public DllNode<T> getTail();
//    public String printAscending();
//    public String printDescending();
//    public Iterator<T> iterator(); //???
}
