package stackUsingQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
* this class will contain all the methods of stacks created via using queue
* */
public class Stack {

    /*
    * Using linked list queue and not using my own queue because that is made of stack and i
    * dont know if that will make any particular difference but i am not risking it.
    * */
    private Queue<Integer> queue=new LinkedList<>();

    /*
    * function to add elements in stack
    * */
    public void push(int data){
        queue.add(data);
    }

    /*
    * function to display data from queue.
    * */
    public void display(){
        Iterator<Integer> queueIterator=queue.iterator();

        while (queueIterator.hasNext()){
            System.out.println(queueIterator.next());
        }
    }

    /*
    * function will remove data from stack
    * */
    public void pop(){
        /*
        * temporary linked list
        * */
        LinkedList<Integer> temp=new LinkedList<>();

        while (!queue.isEmpty()){
            temp.push(queue.remove());
        }

        /*
        * actually deleting the element
        * */
        temp.pop();

        /*
        * copying linked list back to stack
        * */
        for(int i=0;i<temp.size();i++){
            queue.add(temp.get(i));
        }
    }
}
