class Node{
    int data;
    Node next;
    Node prevs;

    Node(int data){
        this.data = data;
        this.next= null;
        this.prevs = null;
    }
}

public class DoublyLinkedListCustom {
    Node head;
    

    public void append(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = newNode;
        newNode.prevs = current;
    }
    public int size(){
        if(head==null) return 0;
        if(head.next==null) return 1;
        Node current = head;
        int count = 0;
        while(current!=null){
           current= current.next;
           count++;
        }
        return count;
    }
    public String get(int data){
        Node current = head;
        int position = 0;
        while(current!=null ){
            position++;
            current = current.next;
         if(current.data==data)
         {
            return data+" found at location"+position;
         }
        }
        return data+" not found in this linked list";
    }
    public void delete(int key){
        if(head==null) return;
        if(head.data==key){
            head = head.next;
            if(head!=null)
            head.prevs = null;
            return;
        } 
       Node current = head;
       while(current!=null && current.data!=key){
           current=current.next;
       }
       if(current==null)return;
       if(current.next!=null)
       {
         current.next.prevs = current.prevs;

       }
       if(current.prevs!=null){
        current.prevs.next = current.next;
       }
    }
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        // System.out.println("null");
    }
    public static void main(String[] args) {
        DoublyLinkedListCustom list = new DoublyLinkedListCustom();
        list.append(23);
        list.append(34);
        list.append(56);
        System.out.println("before delete");
        list.printList();
        list.delete(34);
        System.out.println("after delete");
        list.printList();
        System.out.println("size");
        int size = list.size();
        System.out.println("Size of linked list is"+size);
        String ans = list.get(56);
        System.out.println(ans);
    }
}
