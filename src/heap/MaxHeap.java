package heap;

/**
 * A heap in java is a complete binary tree which is further categorized into 2 parts :
 * 1. Maxheap : The root element will always  be larger than its children.
 * 2. Minheap : The root element will always be smaller than its children.
 * **/

/*
* class to have heap functions inside
* */
public class MaxHeap {
    /*
    * array to store elements of maxheap
    * */
    private int[] heapArr;
    private int maxSize;
    private int size;

    /*
    * constructor to initialise array maxSize and size of heap
    * also setting the positive infinity at 0th position of array
    * */
    public MaxHeap(int maxSize){
        this.maxSize=maxSize;
        heapArr=new int[maxSize+1];
        size=0;
        heapArr[0]=Integer.MAX_VALUE;
    }

    /*
    * function to find parent of an element via its position
    * */
    private int parent(int pos){
        return pos/2;
    }

    /*
    * function to find left child of an element
    * */
    private int leftChild(int pos){
        return 2*pos;
    }

    /*
    * function to find right child of an element
    * */
    private int rightChild(int pos){
        return (2*pos)+1;
    }

    /*
    * to check whether a node is leaf node or not
    * */
    private boolean isLeaf(int pos){
        if(pos>=size/2 && pos<size)
            return true;
        else
            return false;
    }

    /*
    * max-heapify will fix the violated property by performing a check, if left child or right child of an element is
    * greater than its parent it will swap it with root.
    * */
    private void heapify(int pos){
        /*
        * should check if the given position is leaf node or not if it is then return from recursion
        * else check if right child is greater than swap it with pos and start a recursion otherwise swap it
        * with left child and start a recursion to check further down the tree.
        * */
        if(isLeaf(pos)){
            return;
        }
        else if(heapArr[pos] < heapArr[leftChild(pos)] ||
                heapArr[pos] < heapArr[rightChild(pos)]){

            if(heapArr[leftChild(pos)] < heapArr[rightChild(pos)]){
                swap(pos,rightChild(pos));
                heapify(rightChild(pos));
            }
            else if(heapArr[leftChild(pos)] > heapArr[rightChild(pos)]){
                swap(pos,leftChild(pos));
                heapify(leftChild(pos));
            }
        }
    }

    /*
    * function to swap elements via their positions
    * */
    private void swap(int pos1,int pos2){
        int temp=heapArr[pos1];
        heapArr[pos1]=heapArr[pos2];
        heapArr[pos2]=temp;
    }

    /*
    * function to insert an element in heap
    * */
    public void insert(int data){
        heapArr[++size]=data;

        /*
        * checking the heap property
        * if my current element is greater than its parent it should swap them and will continue checking the parents
        * until every parent is checked once.
        * */
        int current=size;
        while(heapArr[current]>heapArr[parent(current)]){
            swap(current,parent(current));
            current=parent(current);
        }
    }

    /*
    * deletes the max element of heap and will check the heap property
    * */
    public void pop(){
        /*
        * replacing the first element with last element
        * */
        heapArr[1]=heapArr[size--];
        heapify(1);
    }

    /*
    * function to get the largest element from heap.
    * */
    public int getMax(){
        return heapArr[1];
    }

    /*
    * default display to print all elements of maxheap
    * */
    public void display(){
        System.out.println("Maxheap : ");
        for(int i=1;i<size+1;i++){
            System.out.println(heapArr[i]);
        }
    }

    /*
    * function to do heap sort,
    * this function will return maximum element from heap and then remove it from heap
    * */
    public int[] heapSort(){
        int[] arr=new int[size];
        int size=this.size;

        for(int i=0;i<size;i++){
            arr[i]=getMax();
            pop();
        }

        return arr;
    }
}
