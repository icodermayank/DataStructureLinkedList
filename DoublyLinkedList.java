// doubly linked list..

import java.util.Scanner;

class Node{
    int data; 
    Node prev;
    Node next;
    // create constructor to initillize the default value of the prev and next
    Node (){
        this.prev = null;
        this.next = null;
    }
}
// structure of node has been created..

// it here main class is created and driver method will be run into the main method..

class DoublyLinkedList{
    public static void main(String args [] ){
        System.out.println("Welcome to the Doubly Linked List Datastructure...");
      
        
      
        
        // first of we have to create the node head so that any method can use it directly..
        
        Node head = new Node();
        // head created successfully..
        
        
        
        // calling the function to create the linked list.
        createDll(head);
        // print the Dll
        printDll(head);
        
        // reverse printing the dll;
        reversePrintDll(head);
        
        
        // deleting the last node from the Dll
      //  deleteLastNode(head);
      //  printDll(head);
      //  reversePrintDll(head);
      
      
      
    // deleting the first node from the Dll
    //   deleteFirstNode(head);
    //   printDll(head);
    //   reversePrintDll(head);


// delete a node from anywhere from Dll
    //   deleteNode(head);
    //   printDll(head);
    //   reversePrintDll(head);



// add a node at last of the linked list..
        // addNodeLast(head);
        // printDll(head);
        // reversePrintDll(head);
    


// function to add a node at first of the Doubly linked list..

        // addNodeFirst(head);
        // printDll(head);
        // reversePrintDll(head);


// function to add a node at any valid position in the Doubly linked list..

     addNode( head);
     printDll(head);
     reversePrintDll(head);


        
    } // main method ended here...
    
    
    
    
    
    //--------------------------------------------------------------------------------------------------------
    
    
    // here i am going to create the funtion to create the doubly linked list.

    static void createDll(Node head){
        Scanner s = new Scanner(System.in);
        
        System.out.println("How many nodes do you want to ");
        int size = s.nextInt();
        
        
        // check if size is greater than 0 or not 
        
        if(size<=0){
            System.out.println("Node can't be create..");
            return ;
            
        }
        
        Node temp = head;
        for(int i =1; i<=size; i++){
            Node newnode = new Node();
            System.out.println("Enter data for the new node "+ i);
            newnode.data = s.nextInt();
            
            temp.next = newnode;
            newnode.prev = temp;
            temp=newnode;
            
        }
        System.out.println(size+" Nodes created successfully..");
    }
    
//-------------------------------------------------------------------------------------------
    
    
    
    
    // method for traversing or printing linkedlist..
    
    static void printDll(Node head){
        Node pointer = head.next;
        System.out.println();
        System.out.print("Head===> ");
        while(pointer!=null){
            System.out.print(pointer.data+" <===> ");
            pointer=pointer.next;
        }
        System.out.print("Null");
        System.out.println();
    }
    
//-----------------------------------------------------------------------------------------   
    
    
    
    // method to reverse printing of Dll.
    
    static void reversePrintDll(Node head){
        Node pointer = head.next;
        
        if(pointer==null){
            System.out.print("Null===> Head\n");
            return;
        }
        
        
        while(pointer.next!=null){
            pointer=pointer.next;
        }
        
        System.out.print("Null===> ");
        
        while(pointer.prev!=null){
            System.out.print(pointer.data+" <===> ");
            pointer=pointer.prev;
        }
        
        System.out.print("Head");
        System.out.println();
    }
//-----------------------------------------------------------------------------------------



//funtion to delete a node from last;

    static void deleteLastNode(Node head){
        // we have to create a pointer to reach to the last node..
        
        if(head.next == null){
            System.out.println("No node present...");
            return ;
        }
        if(head.next.next==null){
            // it means only one node present in the list..
            // so we will directly assign the head.next == null
            head.next =null;
            System.out.println("Last node deleted successfully..");
            return;
            
        }
        
        // if both condition became false then we 
        
        Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        System.out.println("Last node deleted Successfully");
        
        
    }
    //-----------------------------------------------------------------------------------------
    

    
    // function to delete first node of the Dll..
    
    static void deleteFirstNode(Node head){
        // check either head node is empty or not..
        if(head.next == null){
            System.out.println("No Node present in DLL..");
        }
        else if(head.next.next == null){
            head.next = null;
            System.out.println("First node deleted Successfully..");

        }
        else {
            head.next = head.next.next;
            head.next.prev = head;
            System.out.println("First node deleted Successfully..");
        }
    }
    //-----------------------------------------------------------------------------------------
    

//function to delete a node from anywhere valid position from Doubly linked list..

    static void deleteNode(Node head){
        Scanner s = new Scanner (System.in);

            // check if node is present or not in linkedlist..
        if(head.next == null){
            System.out.println("No node present..");
            return;
        }

        System.out.println("Enter position to delete node..");
        int position = s.nextInt();


        // check if position is >0

        if(position <=0){
            System.out.println("Head can't be delete..");
            return;
        }

        if(position>=1){
            if(position ==1){
                if(head.next.next == null){
                    head.next=null;
                    System.out.println("Node "+position+"  deleted successfully..");
                }
            }
            else{ // thinked position = 3; and 4 node present.
            Node temp = head;

                for(int i =1; i<position; i++){
                    temp=temp.next;
                }
                temp.next=temp.next.next;
                System.out.println("Node "+position+" deleted successfully..");
                try{
                    temp.next.prev = temp; // if position is last node so it will generate NullPointerException.
                }
                catch(Exception e){
                    // Null PointerException is handled here..  :)
                }
            }
        }
    }
    
    //------------------------------------------------------------------------------------------------------------


// function to add a node in last of the Doubly linked list..

static void addNodeLast(Node head){
    Scanner s = new Scanner (System.in);

    // created new node..
    Node newnode = new Node();
    System.out.println("Enter data for new node..");
    newnode.data = s.nextInt(); // data assigned..

    Node temp = head;
    while(temp.next !=null){
        temp = temp.next;
    }
    temp.next = newnode;
    newnode.prev = temp;
    System.out.println("New node Sucessfully added at last of the linked list..");
    
}

// -----------------------------------------------------------------------------------------------------------



// function to add a new node in first position of the Doubly linked list.

static void addNodeFirst(Node head){
    Scanner s = new Scanner (System.in);
    Node newnode = new Node();
    System.out.println("Enter data for new node..");
    newnode.data = s.nextInt();
    // new node created....

    // check if no node is present..
    if(head.next == null){
        head.next = newnode;
        newnode.prev = head;

        System.out.println("New node add at the first of Dll..");
    }
    else {
        newnode.next = head.next;
        head.next = newnode;
        head.next.prev = head;
        head.next.next.prev = newnode;

        
       // System.out.println("New node added at the first of Dll..");
    }

}

//-----------------------------------------------------------------------------------------------------------------



// function to add node at anywhere valid position in Doulbly linked list...

static void addNode(Node head){

    Scanner s = new Scanner(System.in);

    System.out.println("Enter position to add the new node..");
    int position = s.nextInt();

    // check if position is valid or not??
    if(position<=0){
        System.out.println("Please enter a valid position..");
        return;
    }

    System.out.println("Enter data for the new node...");
    Node newnode = new Node();
    newnode.data = s.nextInt();

    if(position>=1){
       
        // check if any node is present or not...
        if(head.next == null){
            head.next = newnode;
            newnode.prev = head;

            System.out.println("New node added at the first position....");
            return;
        }


       // head <===> node1 <===>__             __<===> node2 <===> node3 <===> null
              //                  |__newnode__|
       int i;
       Node temp = head.next;
       for(i =1; (i<position-1 && temp.next!=null); i++){
            temp = temp.next;
       }
       try{

            newnode.next = temp.next;
            temp.next.prev = newnode; // it may will generate exception for last node which points null
            temp.next = newnode;
            newnode.prev = temp;
       
            System.out.println("New node added sucessfully... at position "+position);
       }

        catch(Exception e){
           // if position is greater than the length of dll so we will add the node at last..

            temp.next = newnode;
            newnode.prev = temp;
            System.out.println("New node added at last position ");
           

        }




    }




} // add node function ended here...
//----------------------------------------------------------------------------------------------------------


}
// Main class ended here..

/*                      Thank You So Much for Watching my Code      [Mayank Kumar]          */

