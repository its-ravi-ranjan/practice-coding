
import java.lang.reflect.Array;


// LinkedList custom
// linked list is linear data strucutre which consist of nodes . Here each nodes contains data and pointer to next node
// how it different from array;// LinkedList custom
// linked list is linear data strucutre which consist of nodes . Here each nodes contains data and pointer to next node
// how it different from array;
// example of linked list :
// Previous and next page in a web browser
// Music Player

public class Node{
    int data;
    Node next;
 
    Node(int data){
         this.data = data;
         this.next = null;
    }
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
 }

public class SinglyLinkedListCustom {
    Node head;

    public void append(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next!=null){
            current= current.next;
        }
        current.next = newNode;
        
    }
    public void delete(int key) {
        if(head==null)return;

        if(head.data==key)
        {
            head= head.next;
            return;
        }
        Node current = head;
        while(current.next!=null && current.next.data!=key){
            current=current.next;
        }
        if(current.next!=null){
            current.next= current.next.next;
        }

    }
 public void printList(){
    Node current = head;
    while(current.next!=null)
    {
        System.out.print(current.data+"-->");
        current = current.next;
    }
    System.out.println(current.data);
 }
    public static void main(String[] args) {
       SinglyLinkedListCustom list = new SinglyLinkedListCustom();
       list.append(12);
       list.append(24);
       list.append(34);
       list.append(45);
       list.printList();
       list.delete(34);
       list.printList();
    }
}
