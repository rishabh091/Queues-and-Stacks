package queueUsingLinkedList;

import java.util.LinkedList;

/*
* class that have all the functions of queue
* */
public class QueueUsingLinkedList {

    private LinkedList<Integer> linkedList=new LinkedList<>();

    /*
    * function to add elements in queue
    * */
    public void insert(int data){
        linkedList.add(data);
    }

    /*
    * function to delete element from queue
    * */
    public void delete(){
        if(linkedList.size() != 0){
            linkedList.remove(0);
        }
        else{
            System.err.println("Underflow");
        }
    }

    /*
    * function to display queue
    * */
    public void display(){
        System.out.println("Queue : ");

        for(int i=0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i));
        }
    }
}
