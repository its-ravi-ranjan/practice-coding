
// LinkedList custom
public class Node{
    int data;
    Node next;
 
    Node(int data){
         this.data = data;
         this.next = null;
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
