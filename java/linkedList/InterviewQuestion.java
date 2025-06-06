
 // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode child;
      ListNode prev;
      ListNode(int x) { val = x;child=null;prev=null; }
   }
 
public class InterviewQuestion {
    // Q1. There is a singly-linked list head and we want to delete a node node in it.
    // You are given the node to be deleted node. You will not be given access to the first node of head.
    // All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
    // Input: head = [4,5,1,9], node = 5
    // Output: [4,1,9]
    // Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
    //Solution
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;
    }
    // Q2. You are given two non-empty linked lists representing two non-negative integers. 
    // The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    // You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    // Input: l1 = [2,4,3], l2 = [5,6,4]
    // Output: [7,0,8]
    // Explanation: 342 + 465 = 807.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode dummy= newList;
        int carry=0;
        while(l1!=null || l2!=null){
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1+val2+carry;
            if(l1!=null)
            l1=l1.next;
            if(l2!=null)
            l2=l2.next;
            ListNode newItem = new ListNode(sum%10);
            carry = sum/10;
            dummy.next=newItem;
            dummy=dummy.next;
        }
        if(carry!=0)
        {
            ListNode newItem = new ListNode(carry);
            dummy.next=newItem; 
        }
        return newList.next;
    }
    // Q3. Given the head of a linked list, remove the nth node from the end of the list and return its head.
    // Input: head = [1,2,3,4,5], n = 2
    // Output: [1,2,3,5]
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i =0;i<=n;i++){
            fast=fast.next;
        }
        
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
    // Q4. You are given the heads of two sorted linked lists list1 and list2.
    // Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    // Return the head of the merged linked list.
    //Input: list1 = [1,2,4], list2 = [1,3,4]
    // Output: [1,1,2,3,4,4]
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode(-1);
        ListNode temp = newList;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        temp.next= list1!=null?list1:list2;
        return newList.next;
    }
    // Q5. Given the head of a singly linked list, return the middle node of the linked list.
    // If there are two middle nodes, return the second middle node.
    // Input: head = [1,2,3,4,5,6]
    // Output: [4,5,6]
    // Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    // Q6. Given the head of a singly linked list, reverse the list, and return the reversed list.
    // Input: head = [1,2,3,4,5]
    // Output: [5,4,3,2,1]
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode next = null;
        while(current!=null){
            ListNode nextNode = current.next;
            current.next = next;
            next= current;
            current = nextNode;
        }
        return next;
    }
 //Q7. Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
  // For example, the following two linked lists begin to intersect at node c1:
  // pA: a1 → a2 → c1 → c2 → c3 → null → b1 → b2 → b3 → c1 ← Match
 // pB: b1 → b2 → b3 → c1 → c2 → c3 → null → a1 → a2 → c1 ← Match
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA= headA;
        ListNode pB=headB;
        while(pA!=pB){
            pA=(pA==null)?headB:pA.next;
            pB=(pB==null)?headA:pB.next;
        }
        return pA;
    }
    //Q8.Given head, the head of a linked list, determine if the linked list has a cycle in it.
    //There is a cycle in a linked list if there is some node in the list that can be reached again 
    // by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
    // Return true if there is a cycle in the linked list. Otherwise, return false.
    // Input: head = [3,2,0,-4], pos = 1
    // Output: true
    // Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
    // To detect a cycle in a linked list, the most optimal and 
    // commonly used approach is Floyd’s Cycle Detection Algorithm, also known as the Tortoise and Hare algorithm.
    // Approach: Floyd’s Cycle Detection Algorithm
    // Idea:
    // Use two pointers:
    // slow moves 1 step at a time.
    // fast moves 2 steps at a time.
    // If there’s a cycle, they will eventually meet.
    // If fast reaches the end (null), no cycle exists.
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)return false;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=slow){
             if(head==null || head.next==null)return false;
            fast=fast.next.next;
            slow=slow.next;
        }
      return true;
    }
    //Q9. Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
    // k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is 
    // not a multiple of k then left-out nodes, in the end, should remain as it is.
    // Input: head = [1,2,3,4,5], k = 2
    // Output: [2,1,4,3,5]
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while(current!=null && length<k){
            length++;
            current=current.next;
        }
        if(length==k){
           int temp=0;
           ListNode prev= null;
           current=head;
            while(temp<k){
                ListNode dummy = current.next;
                current.next = prev;
                prev = current;
                current = dummy;
                temp++;
            }
           head.next= reverseKGroup(current,k);
           return prev;
        }
        return head;


    }
    // Q10. Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
    // Input: head = [1,2,2,1]
    // Output: true
    public boolean isPalindrome(ListNode head) {
        ListNode slow= head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null
        ){
           fast=fast.next.next;
           slow=slow.next;
        }
        ListNode reversedList = reverse(slow);
        
        ListNode current = head;
        while(reversedList!=null){
            if(current.val!=reversedList.val)return false;
            current=current.next;
            reversedList=reversedList.next;
        }
       return true;
    }
    public ListNode reverse(ListNode node){
       ListNode prev=null;
       ListNode currNode = node;
       while(currNode!=null){
        ListNode next = currNode.next;
        currNode.next= prev;
        prev=currNode;
        currNode=next;
       }
       return prev;
    }
    // Q11. Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
    //There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally,
    // pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
    //Do not modify the linked list.
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
             fast = fast.next.next;
            slow = slow.next;
            
            if(fast==slow){
                ListNode current =head;
                while(current!=slow){
                    current=current.next;
                    slow=slow.next;
                }
                return current;
            }
            
           
            
        }
        return null;

    }
    // Q12. Given a linked list containing ‘N’ head nodes where every node in the linked list contains two pointers:
    // Next’ points to the next node in the list
   // Child’ pointer to a linked list where the current node is the head
    // Each of these child linked lists is in sorted order and connected by a 
    // 'child' pointer. Your task is to flatten this linked list such that all nodes appear in a single layer or level in a 'sorted order'.
    
 static ListNode flatten(ListNode root) {
    if(root==null || root.next==null)return root;
    ListNode head = root;

     head.next = flatten(head.next);
     head= mergeList(head,head.next);
   
   return head;
   
 }
static ListNode mergeList (ListNode l1,ListNode l2){
   ListNode head = new ListNode(0);
   ListNode dummy = head;
  while(l1!=null && l2!=null)
  {
    if(l1.val<l2.val){
       dummy.child=l1;
      l1=l1.child;
      
      dummy=dummy.child;
    }else{
    dummy.child=l2;
      l2=l2.child;
      
      dummy=dummy.child;
    }
  }
 dummy.child = l1!=null?l1:l2;
 return head.child;
}
  //Q13. Given the head of a linked list, rotate the list to the right by k places.
    // Input: head = [1,2,3,4,5], k = 2
    // Output: [4,5,1,2,3]

public ListNode rotateRight(ListNode head, int k) {
    if(head==null||head.next==null||k==0)return head;
     int length=1;
ListNode current = head;
while(current.next!=null){
    current=current.next;
    length++;
}
current.next=head;
k = k%length;
int distance = length-k;
for(int i=0;i<distance;i++){
    current=current.next;
}
ListNode newHead = current.next;
current.next=null;
return newHead;
}

 // Q14 You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 // The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
 // For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 // Input: head = [1,3,4,7,1,2,6]
 // Output: [1,3,4,1,2,6]

public ListNode deleteMiddle(ListNode head) {
    if(head==null|| head.next==null)return null;
    ListNode prev= null;
    ListNode fast = head;
    ListNode slow= head;
    while(fast!=null && fast.next!=null){
        prev= slow;
        slow=slow.next;
        fast=fast.next.next;
    }
    prev.next = slow.next!=null?slow.next: null;
    return head;
}
// Q15. Given the head of a singly linked list, find the length of the loop in the linked list if it exists. 
// Return the length of the loop if it exists; otherwise, return 0.
// A loop exists in a linked list if some node in the list can be reached again by continuously following the next pointer.
//  Internally, pos is used to denote the index (0-based) of the node from where the loop starts.
// Note that pos is not passed as a parameter.
public int findLengthOfLoop(ListNode head) {
    ListNode fast=head;
    ListNode slow= head;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        
        if(slow==fast){
            int count = 1;
            ListNode current = slow.next;
            while(current!=slow){
                current=current.next;
                count++
            }
            return count;
        }
        
    }
    return 0;

 }
 //Q16Given the head of a doubly linked list and an integer target. Delete all nodes in the linked list with the value target and return the head of the modified linked list.
 //Input: head -> 1 <-> 2 <-> 3 <-> 1 <-> 4, target = 1
//Output: head -> 2 <-> 3 <-> 4
//Explanation: All nodes with the value 1 were removed.
 public ListNode deleteAllOccurrences(ListNode head, int target) {
    if(head==null)return head;
    ListNode current = head;
    while(current!=null){
      if(current.val==target){
          ListNode newNode = current.next;
          if(current.prev!=null)
          current.prev.next = current.next;
          else
          head=current.next;
          if(current.next!=null)
          current.next.prev = current.prev;
          current=newNode;
      }
      current=current.next;
    }
    return head;
  }
  // Q17. Given the head of a linked list, return the list after sorting it in ascending order.
  // Input: head = [4,2,1,3]
  // Output: [1,2,3,4]
    // here wer are using merge sort

  public ListNode sortList(ListNode head) {
    if(head==null || head.next==null)return head;
    ListNode mid = getHalf(head);
    ListNode next = mid.next;
    mid.next= null;
    ListNode firstHalf = sortList(head);
    ListNode secondHalf = sortList(next);
    return merge(firstHalf,secondHalf);
}
public ListNode getHalf(ListNode node){
    ListNode fast = node;
    ListNode slow = node;
    ListNode prev= null;
    while(fast!=null && fast.next!=null){
        prev=slow;
        slow=slow.next;
        fast=fast.next.next;
    }
    return prev;
}
public ListNode merge(ListNode l1,ListNode l2){
    ListNode newList = new ListNode(0);
    ListNode dummy = newList;
    while(l1!=null && l2!=null){
        if(l1.val<l2.val){
            dummy.next = l1;
            dummy=dummy.next;
            l1=l1.next;
        }else{
            dummy.next = l2;
            dummy=dummy.next;
            l2=l2.next;
        }
    }
    dummy.next = l1!=null?l1:l2;
    return newList.next;
}
// Q18 Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
// The first node is considered odd, and the second node is even, and so on.
// Note that the relative order inside both the even and odd groups should remain as it was in the input.
// You must solve the problem in O(1) extra space complexity and O(n) time complexity.
// 1st approach
public ListNode oddEvenList(ListNode head) {
    ListNode odd = new ListNode(0);
    ListNode l1 = odd;
    ListNode even = new ListNode(0);
    ListNode l2 = even;
    int count  = 1;
    while(head!=null)
    {
       if(count%2==0){
        l2.next = head;
        l2=l2.next;
       
       }else{
        l1.next= head;
        l1=l1.next;
        
       }
       count++;
        head=head.next;
    }
      l1.next=even.next;
      l2.next=null;
return odd.next;
}
// 2nd approach
public ListNode oddEvenList2(ListNode head) {
    if(head==null||head.next==null)return head;
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenhead = even;
    while(even!=null && even.next!=null)
    {
      odd.next = even.next;
      odd=odd.next;
      even.next=odd.next;
      even=even.next;
    }
    odd.next= evenhead;
    return head;
    
}
// Q19 Given the head of a doubly linked list with its values sorted in non-decreasing order. Remove all duplicate occurrences of any value in the list so that only distinct values are present in the list.
// Input: head -> 1 <-> 1 <-> 3 <-> 3 <-> 4 <-> 5
// Output: head -> 1 <-> 3 <-> 4 <-> 5
public ListNode removeDuplicates(ListNode head) {
    if(head==null || head.next==null)return head;
    ListNode current = head.next;
    ListNode prev= head;
    while(current!=null){
       if(current.val!=prev.val){
        prev.next = current;
        current.prev = prev;
        prev=prev.next;
        
       }
       current=current.next;
    }
    return head;
}
}
