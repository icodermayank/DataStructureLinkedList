
import java.util.Scanner;

// creating node structure..
class Node{
    int  data;
    Node next;
    Node(){
        this.next = null;  // constructor to assing the defalut value 
    }
}



class SinglyCircularLinkedList{
    public static void main(String [] args){
        System.out.println("Welcome to the Circular LinkedList Data Structure..");

     // first of all we have to create the head node...
     Node head = new Node();


        // create circular linked list..
        createCircularLinkedList(head);
        printCll(head);


        // insert a node at beginning 
       // insertAtBeginning(head);
      //  printCll(head);


        // insert a node at End
        // insertAtEnd(head);
        // printCll(head);

     // delete a node from beginning.
        // deleteNodeBeginning(head);
        // printCll(head);



     // delete a node from end.
    
        deleteNodeEnd(head);
        printCll(head);


    } // main method ended here..





    // function to create Circular linked list...

    static void createCircularLinkedList(Node head){
        Scanner  s  = new Scanner(System.in);

        System.out.println("How many nodes do you want to create...");
        int n = s.nextInt();
        Node temp = head;
        for(int i =1; i<=n; i++){
            Node newnode = new Node();
            System.out.println("Enter data for new node "+i);
            newnode.data = s.nextInt();

            temp.next = newnode;
            temp = newnode;
        }
        temp.next=head.next; // make linked list circular..


    }
 //---------------------------------------------------------------------------------------------------------------



    // function to print circular linked list...

     static void printCll(Node head){
    
        Node pointer = head.next;

        System.out.print("\nHead--> ");
        if(head.next==null) return;
        do{
            System.out.print(pointer.data+" --> ");
            pointer=pointer.next;
        }
        while(pointer!=head.next);
       System.out.println();

    }
//---------------------------------------------------------------------------------------------------------------


    

    // function to insert a node at beginning in the singly circular linked list..

        static void insertAtBeginning(Node head){

            Scanner s = new Scanner(System.in);
            // create new node..
            Node newnode = new Node();
            System.out.println("\nEnter data for new node.. which is to be inserted..");
            newnode.data = s.nextInt();

            // first check either any node is present or not..

            if(head.next == null){
                head.next = newnode;
                newnode.next = head.next;
                System.out.println("Node Added successfully.");
            }
            else{
                Node temp = head;
                 do{
                    temp = temp.next;
                }
                while(temp.next!=head.next); // we have to reach the last node so that we will update the pointer..

                newnode.next = head.next;


                // assign the last node address to the first node.
                temp.next = newnode;
 
                // update the head pointer so that head will start point to the same node.
                head.next = newnode;

            }


        }
  //---------------------------------------------------------------------------------------------------------------




    // function to insert a node at end in the singly circular linked list..

    static void insertAtEnd(Node head){
        Scanner s = new Scanner(System.in);
        
        // creatin new node to assign the node ..
        Node newnode = new Node();
        System.out.println("\nEnter data for the new node.. which is to be inserted.");
        newnode.data = s.nextInt();
        // data assigned successfully.

        // check either any node is present or not..
        if(head.next == null){  // it means no node is present in linked list

            // assign new node into the head.
            head.next = newnode;
            newnode.next = head.next; // update the pointer..
            return;
        }

        // now we have to reach the last node address so that we will be able to add the node 
        Node temp = head;
        do{
            temp = temp.next;
        }
        while(temp.next!=head.next);

        temp.next = newnode;
        newnode.next = head.next;
    }
  //---------------------------------------------------------------------------------------------------------------




    // function to delete a node at beginning in the singly circular linked list..

    static void deleteNodeBeginning(Node head){
        // check if any node is present or not..
        if(head.next == null){
            System.out.println("There is no node present to delete..");
            return;
        }
        // to delete the last node whe have to traverse till the last node
        // so that we will assign the pointer to the sencond node 

         Node temp = head;
        do{
            temp = temp.next;
        }
        while(temp.next!=head.next);
        // now we are reached at the last node.

        // to delete first node..
        temp.next = temp.next.next;
        head.next = head.next.next; // now head started pointing to the second node..
        System.out.println("First node deleted successfully.");

    } 
  //---------------------------------------------------------------------------------------------------------------



    // function to delete a node at end of the singly circular linked list..

    static void deleteNodeEnd(Node head){
        // first of all we have to check either any node is present or not..
        if (head.next == null){
            System.out.println("There is no node present to delete..");
            return;
        }

        // now we have to traverse till the last node-1;
        
         Node temp = head;
        do{
            temp = temp.next;
        }
        while(temp.next.next!=head.next); // now we reached at the second last node.


        // to delete last node. we will point the second last node to the first node
        temp.next = head.next;
        System.out.println("Last node deleted successfully.");

    }
  //---------------------------------------------------------------------------------------------------------------- 

}
