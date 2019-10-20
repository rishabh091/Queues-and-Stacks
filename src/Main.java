import circularQueueUsingArray.CircularQueueUsingArray;
import doubleEndedQueue.DoubleEndedQueue;
import heap.MaxHeap;
import heap.MinHeap;
import queueUsingLinkedList.QueueUsingLinkedlist;
import stackUsingQueue.Stack;

public class Main {

    /*
    * void main() function to call queue and other data structures
    * */
    public static void main(String[] args) {
        QueueUsingLinkedlist queueUsingLinkedlist=new QueueUsingLinkedlist();
        for(int i=0;i<3;i++){
            queueUsingLinkedlist.insert(i+1);
        }
        queueUsingLinkedlist.display();
        queueUsingLinkedlist.delete();
        queueUsingLinkedlist.delete();
        queueUsingLinkedlist.delete();
        queueUsingLinkedlist.display();
        queueUsingLinkedlist.delete();
    }
}
