package circularQueueUsingArray;

/*
* class to contain major functions of a circular queue
* */
public class CircularQueueUsingArray {

    private int[] arr;
    private int size;
    private int front;
    private int back;

    /*
    * constructor to get size of array and initialising the array
    * */
    public CircularQueueUsingArray(int size){
        this.size=size;
        arr=new int[this.size];
        front=-1;
        back=-1;
    }

    /*
    * function to add the elements in queue
    * Case 1 : if the queue is empty then set front and back to 0 and then add element in the back thus incrementing the back
    * Case 2 : if there is no space left in array then print an error of overflow to the user.
    * Case 3 : if my front is not equal to 0 and back is completely full then it should add elements to the front of the array thus
    * shifting the back before the front.
    * Case 4 : this else condition includes the generic addition and circular addition in queue
    * */
    public void insert(int data){
        if(front == -1 && back == -1){
            front=0;
            back=0;
            arr[back]=data;
            back++;
        }
        else if((front == 0 && back == size) || (back == front)){
            System.err.println("Overflow");
        }
        else if(front != 0 && back == size){
            back=0;
            arr[back]=data;
            back++;
        }
        else{
            arr[back]=data;
            back++;
        }
    }

    /*
    * function to display the queue from front to back.
    * Case 1 : if back is less than size means circular property is not implemented yet, then print the queue normally
    * Case 2 : if elements from the front is deleted then print elements from front to size and then print from 0 to back.
    * and if back is again larger than front then it should print normally
    * */
    public void display(){
        System.out.println("Queue : ");

        if(back <= size && front == 0){
            for(int i=front;i<back;i++){
                System.out.println(arr[i]);
            }
        }
        else{
            if(back < front){
                for(int i=0;i<back;i++){
                    System.out.println(arr[i]);
                }
                for(int i=front;i<size;i++){
                    System.out.println(arr[i]);
                }
            }
            else{
                for(int i=front;i<back;i++){
                    System.out.println(arr[i]);
                }
            }
        }
    }

    /*
    * function to delete and element from queue
    * Case 1 : if all the elements of the queue is deleted then restart the queue by setting the front and back equal to -1.
    * Case 2 : if front and back is equal to -1 then throw an error of underflow
    * Case 3 : if back is less than front then move front to starting point again
    * Case 4 : increment front to delete element from the queue
    * */
    public void delete(){
        if((front == back-1) && (front != -1)){
            front=-1;
            back=-1;
        }
        else if(front == -1 && back == -1){
            System.err.println("Underflow");
        }
        else if(front==size-1 && back < front){
            front=0;
        }
        else{
            front++;
        }
    }
}
