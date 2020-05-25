/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;



/**
 *
 * @author RAVEN
 */
public class BST<T extends Comparable<T>>{
    private BSTNode root;
    private boolean found;
    public static final int INORDER = 1;
    public static final int PREORDER = 2;
    public static final int POSTORDER = 3;
    private int order = 0; //to save order state
    private Queue<T> Q;
    private int traverse;
    
    public BST(){
        root = null;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public int getSize(){
        return getSize(root);
    }
    
    public int getSize(BSTNode a){
        if(a == null){
            return 0;
        }else{
            return 1 + getSize(a.getLeft()) + getSize(a.getRight());
        }
    }
    
    public boolean contains(T a){
        return contains(root, a);
    }
    
    public boolean contains(BSTNode<T> node, T a){
        if(node == null){
            return false;
        }else if(a.compareTo(node.getData()) > 0){
            return contains(node.getRight(), a);
        }else if(a.compareTo(node.getData()) < 0){
            return contains(node.getLeft(), a);
        }else{
            return true;
        }
    }
    
    public T getElement(T a){
        return (T) getElement(root, a);
    }
    
    public T getElement(BSTNode<T> node, T a){
        if(node == null){
            return null;
        }else if(a.compareTo(node.getData()) > 0){
            return (T)getElement(node.getRight(), a);
        }else if(a.compareTo(node.getData()) < 0){
            return (T)getElement(node.getLeft(), a);
        }else{
            return node.getData();
        }
    }
    
    public void addNode(T a){
        root = addNode(root, a);
    }
    
    public BSTNode<T> addNode(BSTNode<T> node, T a){
        if(node == null){
            node = new BSTNode<T>(a, null, null);
        }else if(a.compareTo(node.getData()) <= 0 ){
            node.setLeft(addNode(node.getLeft(), a));
        }else{
            node.setRight(addNode(node.getRight(), a));
        }
        return node;
        
    }
    
    public boolean remove(T t){
        root = remove(root, t);
        return found;
    }
    
    public BSTNode<T> remove(BSTNode<T> node, T t){
        if(node == null){
            found = false;
        }else if(t.compareTo(node.getData()) > 0){ 
            node.setRight(remove(node.getRight(), t)); 
        }else if(t.compareTo(node.getData()) < 0){
            node.setLeft(remove(node.getLeft(), t));
        }else{
            node = removeNode(node);
            found = true;
        }
        return node; //nothing happens, so my tree remains the same
    }
    
    public BSTNode<T> removeNode(BSTNode<T> a){
        if(a.getLeft() == null && a.getRight() == null){
            return null; 
        }
        else if(a.getLeft() == null ){
            return(a.getRight());
        }else if(a.getRight() == null){
            return a.getLeft();
        }else{
            T t = (T) getPredecessor(a.getLeft());
            a.setData(t); 
            a.setLeft(remove(a.getLeft(),t));
            return a;
        }
    }
    
    public T getPredecessor(BSTNode<T> a){
        while(a.getRight() != null){
            a = a.getRight();
        }
        return a.getData();
    }
    
    public void showTree(){
        Q.showQueue();
    }
    
    public void setOrder(int a){
        traverse = a;
        Q = new Queue<>();
        switch(traverse){
            case 0:
                order = 0;
                break;
            case INORDER:
                inOrder(root);
                order = INORDER;
                break;
            case PREORDER:
                preOrder(root);
                order = PREORDER;
                break;
            case POSTORDER:
                postOrder(root);
                order = PREORDER;
                break;
        }
    }
    
    public void inOrder(BSTNode<T> a){
        if(a != null){
            inOrder(a.getLeft());
            Q.enqueue(a.getData());
            inOrder(a.getRight());
        }
    }
    
    public void postOrder(BSTNode<T> a){
        if(a != null){
            postOrder(a.getLeft());
            postOrder(a.getRight());
            Q.enqueue(a.getData());
        }
    }
    
    public void preOrder(BSTNode<T> a){
        if(a != null){
            Q.enqueue(a.getData());
            preOrder(a.getLeft());
            preOrder(a.getRight());
        }
    }
    
    public void balance(){
        int size = this.getSize();
        setOrder(INORDER); 
        T[] data = (T[]) (new Comparable[size]);
        for(int i =0; i < size; i++){
            data[i] = Q.dequeue();
        }
        root = null; 
        insertBalanceTree(data,0, size-1);
    }
    
    public void insertBalanceTree(T[] t, int low, int high){
        if(low == high){
            this.addNode(t[low]);
        }else if(low +1 == high){ 
            this.addNode(t[low]);
            this.addNode(t[high]);
        }else{
            int mid = (low+high)/2;
            this.addNode(t[mid]);
            insertBalanceTree(t, low, mid-1);
            insertBalanceTree(t, mid+1, high);
        }
    }
    
    public void freqCounter(){
        System.out.println("Word Frequency Generator Program");
        setOrder(BST.INORDER);
        int count = 1;
        T temp2 = (T) root.getData();
        while(!Q.isEmpty()){
            T temp = Q.dequeue();
            if(!Q.isEmpty()){
                temp2 = temp;
                if(temp.compareTo(Q.peek()) == 0) {
                    count++;
                }
                else {
                    System.out.printf("%04d %s -->\n", count, temp);
                    count = 1;
                }
            }else{
                if(temp.compareTo(temp2) == 0){
                    System.out.printf("%04d %s -->\n", count++, temp);
                }else{
                    count = 1;
                    System.out.printf("%04d %s -->\n", count, temp);
                }
            }
        }
    }
    
}
