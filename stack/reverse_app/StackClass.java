

import java.util.EmptyStackException;

public class StackClass {
    private Object[] a;
    private int top;
    private int max;
    
    public StackClass(){
        this(10);
    }
    public StackClass(int max){
        this.a = new Object[max];
        this.max = max;
        this.top = -1;
    }

    protected boolean grow(){
        int max1 = max + (max/2);
        Object[] a1 = new Object[max1];
        for(int i=0; i<= top; i++) 
            a1[i] = a[i];
        a = a1;
        return true;
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public boolean isFull(){
        return(top==max-1);
    }

    public void push(Object data){
        if(this.isFull()) this.grow();
        a[++top]= data;
    }

    public Object pop() throws EmptyStackException{
        if(this.isEmpty()) throw new EmptyStackException();
        Object x = a[top];
        top--;
        return x;
    }

    public Object peek(){
        if(this.isEmpty()) throw new EmptyStackException();
        return a[top];
    }
    public void clear(){
        this.top = -1;
    }
}

