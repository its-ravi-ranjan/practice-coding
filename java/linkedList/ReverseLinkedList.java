
class Node{
    int data;
    Node next;
    Node last;

    Node(int data){
        this.data=data;
        this.next=null;
        this.last=null;
    }
}
// using builtin linkedlist
public class ReverseLinkedList {
    Node head;
    public void reverse(){
      Node last = null;
      Node current = head;
      while(current!=null){
         Node next = current.next;
         current.next = last;
         last = current;
         current= next;
      }
      head=last;
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(head==null)
        {
            head= newNode;
            return;
        }
        Node currNode= head;
        while(currNode.next!=null){
            currNode = currNode.next;
        }
        currNode.next = newNode;

    }
    public void printList(){
       Node cuNode = head;
       while(cuNode!=null){
        System.out.print(cuNode.data+"-->");
        cuNode=cuNode.next;
       }
    }
    public static void main(String[] args) {
        // using inbuilt LinkedList
        // LinkedList <Integer> list = new LinkedList<>();
        // list.add(56);
        // list.add(23);
        // list.add(34);
        // list.add(78);
        // list.add(89);
        // System.out.println(list);
        //  LinkedList<Integer> reverseList = new LinkedList<>();
        //  for (int val : list) {
        //      reverseList.addFirst(val);
        //  }
        //  System.out.println(reverseList);

        //using custom linked list
        ReverseLinkedList list= new ReverseLinkedList();
        list.add(34);
        list.add(56);
        list.add(23);
        list.add(89);
        list.add(23);
        System.out.println("original linked list");
        list.printList();
        System.out.println("Reversed linked list");
        list.reverse();
        list.printList();
    }
}

/** 
 * solution which i done on leetcode
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode current = head;
//         ListNode next = null;
//         while(current!=null){
//             ListNode nextNode = current.next;
//             current.next = next;
//             next= current;
//             current = nextNode;
//         }
//         return next;
//     }
// }
