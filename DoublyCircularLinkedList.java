
// By Mayank Kumar Sharma.
// in circular doubly Linked list there is no concept for assign null.
// last node points the first node. to make the circular 


import java.util.Scanner;
//creating the node structure.

class Node{
    int data ;
    Node prev;
    Node next;
        // creating the constructor to assign the default value of the node.
        Node(){
            this.prev = null;
            this.next = null;
        }
}


class DoublyCircularLinkedList{
    public static void main(String args []){
        System.out.println("Welcome to the world of Linked list Data Structure.\n");
        
        
        // first of all we have to create the head node 
        Node head = new Node();
        // head node created successfully.
        
        
        // now we have to call the function to create node.
        
        createCircularDoublyLinkedList(head);
        printCDLL(head);
        reversePrintCDLL(head);
        
    // insert a node at beginning 
        //  insertAtBeninning(head);
        //  printCDLL(head);
        //  reversePrintCDLL(head);
        
         
    // insert a node at End 
        // insertAtEnd(head);
        // printCDLL(head);
        // reversePrintCDLL(head);
        
        
        
    // delete a node at Beginning ..
        // deleteAtBeginning(head);
        // printCDLL(head);
        // reversePrintCDLL(head);
        
        
        
    // delete a node from end.
        deleteAtEnd(head);
        printCDLL(head);
        reversePrintCDLL(head);
        
        
        
    } // main method ended here
    

    
    // function to create nodes..
    static void createCircularDoublyLinkedList(Node head){
        
        // create scanner obj 
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no of nodes.");
        
        int n = s.nextInt();
        
        // create temp node for reference 
        Node temp = head;
        
        // check if size is greater than zero or not 
        if(n<=0){
            System.out.println("Node can't be created.");
            return;
        }
        
        // runs the for loop to create n no of nodes,
        for(int i =1; i<=n; i++){
            
            // create new node.
            Node newnode = new Node();
            System.out.println("Enter data for new node "+i);
            newnode.data = s.nextInt();
            
            temp.next = newnode;
            newnode.prev = temp;
            temp = newnode;
        }
        
        head.prev = temp;     // assigning head.prev = last node address
        head.next.prev=temp;  // assign the first node prev = last node;
        temp.next = head.next; // assigning last node.next = first node address
        
        
    } 
    
    //-----------------------------------------------------------------------------
    
    
    // traverse circular doubly linkedlist.
    
    static void printCDLL(Node head){
        Node pointer = head.next;
        System.out.println();
        System.out.print("head<===> ");
        do{ 
            if(head.next ==null) return; // to avoid NullPointerException
            System.out.print(pointer.data+" <===> ");
            pointer=pointer.next;
        }while(pointer!=head.next);
    }
    //-----------------------------------------------------------------------------
    
    
    
    
    
    // reverse traverse of circular doubly linked list.
    /* logic 
    we will create a pointer which will print the pointer data 
    and pointer will update with pointer.prev
    and repeat the steps till we reach the first node;
    
    */
    
    static void reversePrintCDLL(Node head){
        
        Node pointer = head.prev;
        System.out.println();
        System.out.print("head<===> ");
        do{
            if(head.next==null) return;
            System.out.print(pointer.data+" <===> ");
            pointer=pointer.prev;
        }
        while(pointer!=head.prev);
        
        
    }
//-----------------------------------------------------------------------------
    
    
    
    
    // function to insert a node at beginning in the circular doubly linked list
    
    static void insertAtBeninning(Node head){
        Scanner s = new Scanner (System.in);
        
        Node newnode = new Node();
        System.out.println("\nEnter data for new node.");
        newnode.data = s.nextInt();
        // node ready to use.
        
        
        // check either any any node is present or not.
        
        if(head.next == null){
            head.next = newnode;
            newnode.prev = newnode;
            head.prev = newnode;
            
            // make it circular
            head.prev = newnode;
            newnode.next = head.next;
            
            System.out.println("Node added successfully.");
        }
        else{

            
            newnode.next = head.next; // assigned newnode.next = first node address 
            newnode.prev = head.prev; // assigned newnode.prev = last node address
            
           
            newnode.prev.next = newnode; // point last node.next = first node(new node);
            newnode.next.prev = newnode; // point first node(now its second node) to new node;
            
            
            head.next = newnode;  // update head.next to point newnode as first node.
            
            
        }
        
    }
    
//-----------------------------------------------------------------------------


    // function to insert a node at End of the circular doubly linked list
    
    static void insertAtEnd(Node head){
        
        Scanner s = new Scanner(System.in);
        
        Node newnode = new Node();
        System.out.println("\nEnter data for new node.");
        newnode.data = s.nextInt(); // data assigned successfully.
        
        // first check either node is present or not.
        
        if(head.next == null){
             head.next = newnode;
            newnode.prev = newnode;
            head.prev = newnode;
            
            // make it circular
            head.prev = newnode;
            newnode.next = head.next;
            
            System.out.println("Node added successfully.");
            
        }
        else{
            newnode.next = head.next; // assigned newnode.next = first node address 
            newnode.prev = head.prev; // assigned newnode.prev = last node address
            
           
            newnode.prev.next = newnode; // point last node.next = first node(new node);
            newnode.next.prev = newnode; // point first node(now its second node) to new node;
            
            // simply we add the node as first position then update the head.prev to point as last
            
            head.prev = newnode;  // update head.prev to point newnode as last node.
            
        }
        
        
        
    }
    
//-----------------------------------------------------------------------------

    // function to delete a node at beginning in the circular doubly linked list
    
    static void deleteAtBeginning(Node head){
        
        // first check either any node is present or not??
        
        if(head.next == null){
            
            System.out.println("\nThere is no node present to delete.");
            return;
        }
        else{
          head.next = head.next.next;  // point the head.next to 2nd node.
          head.prev.next = head.prev.next.next;  // point lastnode.next = 2nd node;
          
          head.next.prev = head.prev;     // now 2nd node becames the first node.
                                          // so it will point the last node.
          
          System.out.println("\nFirst node deleted Successfully.");
        }
        
        
    }

//-----------------------------------------------------------------------------


    //function to delete a node at End in the circular doubly linked list
    
    static void deleteAtEnd(Node head){
        
        // first check either any node is present or not.
        
        if(head.next == null){
            
            System.out.println("\nThere is no node present to delete.");
            return;
        }
        else{
            head.prev.prev.next = head.next;
            head.prev = head.prev.prev;
            
            head.next.prev = head.prev;
            
            System.out.println("\nLast node deleted successfully.");
        }
        
        
        
    }
    
//-----------------------------------------------------------------------------
    
    
}




