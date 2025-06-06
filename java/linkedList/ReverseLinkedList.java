


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
    //using iteration
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
    //using recusrive
    public Node recursivehelper(Node node){
       if(node==null || node.next==null)return node;
       Node newHead = recursivehelper(node.next);
       Node next = node.next;
       next.next = node;
       node.next=null;
       return newHead;
    }
    public void reverseRecursive(){
        head = recursivehelper(head);
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
    //Optimal Approach: Tortoise and Hare (Fast & Slow Pointers)
    //This technique finds the second middle node in one pass (O(n) time, O(1) space).
    //🐢 Slow Pointer moves one step at a time
    // 🐇 Fast Pointer moves two steps at a time
    // When the fast pointer reaches the end, the slow pointer is at the middle.
    public void findMiddleNode(){
        Node fast=head;
        Node slow=head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast=fast.next.next;
        }
        head= slow;
    }
    public void removeNthNodeFromlast(int n){
        Node fast=head;
        Node slow=head;
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }
        if(fast==null) {
            head=slow.next;
            return;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
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
        // list.findMiddleNode();
        list.removeNthNodeFromlast(5);
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
