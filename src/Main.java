import doubleEndedQueue.DoubleEndedQueue;
import heap.MinHeap;
import stackUsingQueue.Stack;

public class Main {

    /*
    * void main() function to call queue and other data structures
    * */
    public static void main(String[] args) {
        MinHeap minHeap=new MinHeap(10);
        for(int i=10;i>0;i--){
            minHeap.insert(i);
        }

        minHeap.display();

        for(int i=0;i<4;i++){
            minHeap.pop();
        }

        System.out.println("New heap after deletion : ");
        minHeap.display();

    }
}
