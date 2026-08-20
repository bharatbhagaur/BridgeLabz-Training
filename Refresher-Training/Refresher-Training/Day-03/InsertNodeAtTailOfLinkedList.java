//InsertNodeAtTailOfLinkedList
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data=data;
        this.next = null;
    }
}
public class InsertNodeAtTailOfLinkedList{

     static Node insertNodeAtTail(Node head ,int data){
        Node newNode =new Node(data);
        if(head==null){
            return newNode;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next = newNode;
        
        return head;
     }
     
     static void printLinkedList(Node head){
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
     }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
        
        Node head = null;
        
        for(int i=0;i<n;i++){
            int data = sc.nextInt();
            head =insertNodeAtTail(head, data);
            
        }
        printLinkedList(head);
    }
}