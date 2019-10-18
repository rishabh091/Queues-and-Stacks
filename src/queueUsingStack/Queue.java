package queueUsingStack;

import java.util.Iterator;
import java.util.Stack;

/*
* Queue Class will have all the functions that will add services to queue and this queue will be created using
* stack from java.util.stack
* */
public class Queue {
    /*
    * stack to use
    * */
    private Stack<Integer> stack=new Stack<>();

    /*
    * will add elements in queue
    * */
    public void append(int data){
        stack.push(data);
    }

    /*
    * will display the stack
    * */
    public void display(){
        Iterator<Integer> iterator=stack.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /*
    * deleting an element from front as it is done is queue
    * */
    public void shift(){
        /*
        * array to store all the elements of stack
        * ALSO you can use another stack to store elements
        * */
        Stack<Integer> stack=new Stack<>();
        /*
        * Values of old stack will copied to new one
        * */
        while(!this.stack.isEmpty()){
            stack.push(this.stack.pop());
        }
        /*
        * will delete first element
        * */
        stack.pop();
        /*
        * now copy the new stack back to original stack
        * */
        while (!stack.isEmpty()){
            this.stack.push(stack.pop());
        }
    }
}
