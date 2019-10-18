package heap;

/**
 * A heap in java is a complete binary tree which is further categorized into 2 parts :
 * 1. Maxheap : The root element will always  be larger than its children.
 * 2. Minheap : The root element will always be smaller than its children.
 * **/

/*
 * class to have heap functions inside
 * */
public class MinHeap {

    private int maxSize;
    private int size;
    private int[] minHeap;

    /*
    * will get size and initialise the heap array
    * */
    public MinHeap(int size){
        maxSize=size;
        this.size=0;
        minHeap=new int[maxSize+1];
        minHeap[1]=Integer.MIN_VALUE;
    }

    /*
    * function to get parent of any element through its index
    * */
    private int parent(int pos){
        return pos/2;
    }

    /*
    * function to get left child of an element through its index
    * */
    private int leftChild(int pos){
        return 2*pos;
    }

    /*
    * function to get right child of an element through its index
    * */
    private int rightChild(int pos){
        return (2*pos)+1;
    }

    /*
    * function to swap elements by the index
    * */
    private void swap(int pos,int pos1){
        int temp=minHeap[pos];
        minHeap[pos]=minHeap[pos1];
        minHeap[pos1]=temp;
    }

    /*
    * function to check whether the node is leaf node or not
    * */
    public boolean isLeaf(int pos){
        if(pos >= size/2 && pos < size)
            return true;
        else
            return false;
    }

    /*
    * heapify function to fix the violated property of min heap, it will check if left child or right child of element
    * is smaller than them then it will replace that element with smallest of left child or right child
    * */
    private void heapify(int pos){
        if(isLeaf(pos)){
            return;
        }
        else if(minHeap[pos] > minHeap[leftChild(pos)] ||
                minHeap[pos] > minHeap[rightChild(pos)]){

            if(minHeap[leftChild(pos)] < minHeap[rightChild(pos)]){
                swap(pos,leftChild(pos));
                heapify(leftChild(pos));
            }
            else if(minHeap[leftChild(pos)] > minHeap[rightChild(pos)]){
                swap(pos,rightChild(pos));
                heapify(rightChild(pos));
            }
        }
    }


    /*
    * function to insert a new element in heap
    * */
    public void insert(int data){
        minHeap[++size]=data;
        /*
        * check whether or not min heap property if still valid, if not valid then it should swap the newly add element
        * with the parent
        * */
        int current=size;
        while (minHeap[current] < minHeap[parent(current)]){
            swap(current,parent(current));
            current=parent(current);
        }
    }

    /*
    * function to delete the root of min heap and check and fix the heap property
    * */
    public void pop(){
        minHeap[1]=minHeap[size--];
        heapify(1);
    }

    /*
    * function to get the minimum element in min heap
    * */
    public int getMin(){
        return minHeap[1];
    }

    /*
    * function to display the heap array
    * */
    public void display(){
        System.out.println("Min heap : ");
        for(int i=1;i<size+1;i++){
            System.out.println(minHeap[i]);
        }
    }
}
