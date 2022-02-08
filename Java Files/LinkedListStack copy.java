public class LinkedListStack
{
      // head of the list 
  
    /* Linked list Node*/
    static class Node { 
        int data; 
        Node next; 
 
        Node(int d) 
        {
            this.data = d;
            this.next = null; 
        } 
        
    } 
       
    Node top;
  
    
    LinkedListStack()
    {
        this.top = null; 
    }
    
    
    public void push(int data)
    {
        Node temp = new Node(data); 
       
        //temp.next is null
        temp.next = top; 
        
        top = temp;
        
    }
    
    public boolean isEmpty()
    {
        return top == null; 
    }
    
    public int pop()
    {
        Node curr = top;
        if (!isEmpty())
        {
             
            this.top = this.top.next; 
            
        }
        
        return curr.data; 
        
    }
    
    public int peek()
    {
        if (this.top == null)
        {
            System.out.println("The stack is empty");
        }
        System.out.println(this.top.data); 
        return this.top.data;
    }
    public void display()
    {

        while (top != null)
        {
            System.out.println(top.data);
            top = top.next; 
           
        }
    }
    
    
    
    public static void main(String[] args)
    {
        LinkedListStack list = new LinkedListStack(); 
        
        list.push(34); 
        list.push(20); 
        list.push(2); 
        list.push(8); 
        
        list.pop();
        
        
        
        list.display(); 
    }
}
