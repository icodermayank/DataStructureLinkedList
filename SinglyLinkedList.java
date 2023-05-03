/**             Linked List Data Structure using java
 *              -------------------------------------
 *               Written By :- Maynak Kumar (CSE) 
 *              Lok Nayank Jai Prakash Institue of Technology Chapra.

Linked list :- 
        1).   Linked list is a linear data Structure that includes a series of connected nodes
        2).   Linked list stored in **Heap Memory** randomly
        3).   Linked list allocate Memory dynamically
        4).   Linked node can be added and deleted dynamically means it has dynamic size 
        5).   Linked List reduce the wastage of memory..
        6).   Linked List has no need of contigious memory allocation
        7).   we can implement both --Queue-- and  --Stack-- using linked list

Dis-Advantage of Linked List:
        (*). Occupy more memory to store address...
        (*). Traversal is difficult.
        (*). Reverse Traversal is impossible in singly linkedList.
            
Note :   [___My code My rule____]

        Head --> node1 --> node2 --> node3 --> null

        $ All the index of nodes starts from 1;
        $ Head and Temp both is only pointer.
        $ both doesn,t contains any data, so don't confuse..
        $ head and temp contains only address.


**/

import java.util.Scanner;

// node Structure
class Node{
    int data; 
    Node next;
}



class SinglyLinkedList{
    public static void main(String [] args ){
    System.out.println("welcome to the linked List data Structure..");
    
    Scanner  s= new Scanner(System.in);
    
    System.out.println("How many nodes do you want to create...");
    int n = s.nextInt();
    
    Node head = new Node();
    head.next=null;
    Node temp = head;
    
    
    // all these driver code is here..
    
    // create node..
    createNode(head, n);
    
   // to print linked list;
   printLinkedList(head);
   
   // deletinon of node in linked list.
   
    deleteFirstNode(head);
    printLinkedList(head);
    
    deleteLastNode(head);
    printLinkedList(head);
    

    deleteNode(head);
    printLinkedList(head);
    
    
    
    
    // node adding in linked list..

    addNodeEnd(head);
    printLinkedList(head);
       
    addNodeFirst(head);
    printLinkedList(head);
    
    
    addNode(head);
    printLinkedList(head);
       
       
       
        
    }// main method closed..
    
    
    
    // method to create a linked list
    
    static void createNode(Node head, int n){
        Scanner sc  = new Scanner(System.in);
        Node temp = head;
        for(int i =1; i<=n; i++){
            Node newnode = new Node();
            newnode.next = null;
            System.out.println("Enter the data for new node "+i);
            newnode.data = sc.nextInt();
            temp.next = newnode;
            temp = newnode;
        }
        System.out.println(n+ " nodes added successfully in your linked list..");
        
    }
    //--------------------------------------------------------------------------------------
    
    
    // funtion to print the linked list..
    
    static void printLinkedList(Node head){
        System.out.println("Your node elements are...");
        Node pointer = head.next;
        System.out.print("Head -> ");
        
        
        while(pointer!=null){
           System.out.print(pointer.data+" -> ");
            pointer=pointer.next;
        }
        System.out.print("null");
    }
    //--------------------------------------------------------------------------------------
    
    
    
    // function for deletion of last node from linked list... 
    
     static void deleteLastNode(Node head){
        
        if (head.next == null)
            System.out.println("Sorry No node present..");
 
       else if (head.next.next == null) {
            head.next = null;
            System.out.println("Last node deleted sucessfully..");
       }
        else{
        Node temp = head.next;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        System.out.println("\nlast node deleted sucessfully..");
        }
    }
    //-----------------------------------------------------------
    
    
    
    // function for deletion of first node from the linked list.
    
    static void deleteFirstNode(Node head){
        if(head.next == null){
            System.out.println("\nThere is no node presented...");
            return;
        }
        else if(head.next.next==null){
            head.next = null;
            System.out.println("\nFirst node deleted sucessfully..");
        }
        else {
            head.next = head.next.next;
            System.out.println("\nFirst node deleted sucessfully..");
        }
    }
    //--------------------------------------------------------------------------------------
    
    
    
    // function for deletionn of any node from a linked list..
    
    static void deleteNode(Node head){
        Scanner sc2 = new Scanner (System.in);
        System.out.println("\nEnter the position of node to be deleted.. (starts from 1)");
        int position = sc2.nextInt();
        
        
        if(position <=0){
            System.out.println("head can't be deleted..");
            }

         else if(position == 1){
                head.next = head.next.next;
                System.out.println(position+ " node deleted successfully..");
            }
         else if(position>1){
            Node temp = head.next;
            for(int i =1; temp.next!=null && i<position-1; i++){
                temp = temp.next;
                
            }
            try{
            temp.next=temp.next.next; // this line will generate Exception when user enters
            }                          // the Invalid postion p > present .. 
            catch(Exception e){
                System.out.println("Invalid index, out from the linked list");
            }
        }
    } 
    //---------------------------------------------------------------------------------------
    
    
    //function for adding a node to end of the list.. 
    
    static void addNodeEnd(Node head){
        Node temp = head.next;
        
        Scanner se = new Scanner(System.in);
        
        Node newnode = new Node();
        
        System.out.println("\nEnter data for the last node which is to be added..");
        newnode.data=se.nextInt();
        newnode.next = null;
        
        if(head.next==null){
            head.next = newnode;
        }
        else{ // temp contains the head.next means first node.
             while(true){  // we will traverse till we found temp.next == null means tail.
               
                if(temp.next == null){
                temp.next = newnode;  // after found we will insert and break
                break;
                }
                else
                temp=temp.next;
             }
             
        }
        System.out.println("Last node added successfully..");
        
    }
    //--------------------------------------------------------------------------------------
    
    
    
    // function to add node a node at the first position to the linked list.
    
    static void addNodeFirst(Node head){
        Node newnode = new Node();
        Scanner ss = new Scanner(System.in);
        System.out.println("\nEnter the data for new node.. which is to be added at first.");
        newnode.data = ss.nextInt();
        newnode.next = null;
        
        // node created successfully... above
        
        // to add node.
        
        if(head.next ==null){ // it means no node is present so add them into t
            head.next = newnode;
        }
        // if above condition false.. so there is node present in linked list..
        // so we will assin the first node to the newnode.next;
        // head.next will contains the new node so there is node added 
        
        else{
        Node temp = head.next;
        newnode.next = temp;
        head.next = newnode;
        
        }
        
        
    }
    //--------------------------------------------------------------------------------------
    
    
    
    // function to add node node in any position
    
    static void addNode(Node head){
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter the postion to add node (index starts from 1)..");
        int postion = in.nextInt();
        
        
        if(postion<=0){
            System.out.println("\nPlease enter a valid index..");
            return ;
        }
        
        // create a node to add into the linked list..
        Node newnode = new Node();
        System.out.println("Enter the data for new node at postion "+postion);
        newnode.data = in.nextInt();
        newnode.next = null;
        
        // check if there is no node present..
        
        if(head.next == null){
            head.next = newnode;
            System.out.println("\n new node added to the first postion..");
        }
        
        // if atleast one node present.
        else{
            Node temp = head.next;
            if(postion==1){           // if only one node present 
                newnode.next = temp;
                head.next = newnode;
            }
            
                 // if more than one node present... 
                 
            else{
                try{
                for(int i = 1; i<postion-1; i++){  
                    temp = temp.next;
                    }
                
                newnode.next = temp.next;
                temp.next = newnode;
                System.out.println("\nNew Node added to the "+postion);
                }
                catch(Exception e){
                    System.out.println("\nInvalid index please enter valid postion");
                }
            }
            
            
        } 
        
        
        
    } // addNode method ends here..
    //--------------------------------------------------------------------------------------
    
    
    
    
} // Main class closed..




