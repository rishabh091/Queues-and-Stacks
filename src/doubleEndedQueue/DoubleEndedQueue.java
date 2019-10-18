package doubleEndedQueue;

import java.util.Iterator;
import java.util.Stack;

/*
* this class will have all the functions of double ended queue.
*
* A double ended queue is a queue that enables user to add and delete data from front and back side of queue
* basically when 2 queues are joined together forms a double ended queue.
* */
public class DoubleEndedQueue {
    /*
    * using stack to store data
    * */
    private Stack<Integer> queueStackFront=new Stack<>();
    private Stack<Integer> queueStackBack=new Stack<>();

    /*
    * function to append data at front
    * */
    public void addToFront(int data){
        queueStackFront.push(data);
    }

    /*
    function to append data at back
    */
    public void addToBack(int data){
        queueStackBack.push(data);
    }

    /*
    * function to display queue as a whole
    * */
    public void display(){
        System.out.println("Queue : ");
        Iterator<Integer> frontQueueIterator=queueStackFront.iterator();
        Iterator<Integer> backQueueIterator=queueStackBack.iterator();

        while(frontQueueIterator.hasNext()){
            System.out.println(frontQueueIterator.next());
        }
        while(backQueueIterator.hasNext()){
            System.out.println(backQueueIterator.next());
        }
    }

    /*
    * function to remove element from front of the queue
    * */
    public void shift(){
        queueStackFront=deleteElement(queueStackFront);
    }

    /*
    * function made to delete element and will reduce repeatability for shift() and pop()
    * */
    private Stack<Integer> deleteElement(Stack<Integer> stack){
        Stack<Integer> temp=new Stack<>();

        while(!stack.isEmpty()){
            temp.push(stack.pop());
        }

        /*
         * this will delete the first element
         * */
        temp.pop();

        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }

        return stack;
    }

    /*
    * function to remove the element from the back queue
    * */
    public void pop(){
        /*
        * recalling deleteElement() because removing element from queue is same
        * */
        queueStackBack=deleteElement(queueStackBack);
    }
}
