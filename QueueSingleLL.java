import java.util.*;  // importing this so we can throw some exceptions

public class QueueSingleLL<Item> implements Queue<Item>{

  //Member variable in your LL
  Node first; //points at first node
  Node last; //points at last node
  int n; //size of LL

  //Inner class definition of Node
  class Node {
    //Node member variables
    Item info;
    Node next; //pointer to next node


    //Node constructor: lets us create values and pointers
    Node(Item info, Node next) {
      this.info = info;
      this.next = next;
    }
  }

  //CONSTRUCTOR for QueueLL class: set variables to null or 0
  public QueueSingleLL() {
    this.first = null;
    this.last = null;
    this.n = 0;
  }

  //METHODS: from queue interface


  //ENQUEUE: add something to end of queue
  public void enqueue (Item item){
    Node newlast = new Node(item, null); //create new node for incoming Item

    //if list is empty, first will point at the new Node
    if (last == null){
      first = newlast;
    }
    //if list is not empty, point the old last node pointer to the newlast
    else {
      last.next = newlast;
    }

    //in all cases, last pointer points to the new node
    last = newlast;
    n++; //increase list size by 1

  }


  //DEQUEUE: remove front of queue
  public Item dequeue(){
    // If the queue is empty, just throw an exception.
    if (size() == 0) {
      throw new NoSuchElementException("Empty queue");
    }
    Item toReturn = first.info; //returning info in the front of the queue
    first = first.next; //move first pointer to second in queue

    //if there was no second node, last would be pointing at the node just deleted
    if (first == null) {
      last = null;
    }

    n--; //decrease list size by 1
    return toReturn; //return dequeue info
  }



  //SIZE: return queue size
  public int size(){
    return n;
  }

  //ISEMPTY: return boolean if queue is empty or not
  public boolean isEmpty(){
    return (n==0);
  }

  //FINDITEM: traverse list to find Item
  public boolean findItem(Item item) {
    //use for-loop to traverse through nodes
    for (Node x = first; x != null; x = x.next) {
      if (x.info.equals(item)) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {

    //create linked list
    QueueSingleLL<String> myqueue = new QueueSingleLL<String>();

    //Test enqueue: add items to LL
    myqueue.enqueue("California");
    myqueue.enqueue("Connecticut");
    myqueue.enqueue("Massachussetts");

    //Test findItem: look for California
    if (myqueue.findItem("California")){
      System.out.println("Found California in your queue!");
    }

    //Test deuque: remove items in queue and print as you dequeue
    while (!myqueue.isEmpty()){
      System.out.format("%s\n",myqueue.dequeue());
    }

  }



}
