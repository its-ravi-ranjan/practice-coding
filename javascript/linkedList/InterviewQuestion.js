
 // Definition for singly-linked list.
  class ListNode {
    constructor(data){
        this.val=data
        this.next=null
        this.bottom=null
    }
 }

 class InterviewQuestion {
  // Q1. There is a singly-linked list head and we want to delete a node node in it.
  // You are given the node to be deleted node. You will not be given access to the first node of head.
  // All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
  // Input: head = [4,5,1,9], node = 5
  // Output: [4,1,9]
  // Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
  //Solution
   deleteNode(node) {
      node.val = node.next.val;
      node.next=node.next.next;
  }
   // Q2. You are given two non-empty linked lists representing two non-negative integers. 
    // The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    // You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    // Input: l1 = [2,4,3], l2 = [5,6,4]
    // Output: [7,0,8]
    // Explanation: 342 + 465 = 807.
    addTwoNumbers(l1, l2) {
        let newList = new ListNode(0)
        let dummy= newList
        let carry=0
        while(l1!=null||l2!=null){
            let val1= l1?.val?l1.val:0
            let val2=l2?.val?l2.val:0
            let sum = val1+val2+carry
            let newItem = new ListNode(sum%10)
            carry=Math.floor(sum/10)
            if(l1)
            l1=l1.next
            if(l2)
            l2=l2.next
            dummy.next = newItem
            dummy=dummy.next
        }
        if(carry)
        {
            let lastitem = new ListNode(carry)
            dummy.next=lastitem
        }
        return newList.next
    };
     // Q3. Given the head of a linked list, remove the nth node from the end of the list and return its head.
    // Input: head = [1,2,3,4,5], n = 2
    // Output: [1,2,3,5]
    removeNthNodeFromEnd(head,n){
        let newHead = new ListNode(0)
        let dummy = newHead
        dummy.next = head
        let fast = dummy
        let slow= dummy
        for(let i=0;i<=n;i++){
            fast=fast.next
        }
        while(fast!=null){
            slow=slow.next
            fast=fast.next
        }
        slow.next=slow.next.next
        return newHead.next
    }
      // Q4. You are given the heads of two sorted linked lists list1 and list2.
    // Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    // Return the head of the merged linked list.
    //Input: list1 = [1,2,4], list2 = [1,3,4]
    // Output: [1,1,2,3,4,4]
    mergeTwoList(list1,list2){
        let newList = new ListNode(0)
        let dummy = newList
        while(list1 &&list2){
            if(list1.val<list2.val){
                dummy.next=list1
                list1=list1.next
            }else{
                dummy.next=list2
                list2=list2.next
            }
            dummy=dummy.next
        }
        dummy.next=list1?list1:list2
        return newList.next
    }
     // Q5. Given the head of a singly linked list, return the middle node of the linked list.
    // If there are two middle nodes, return the second middle node.
    // Input: head = [1,2,3,4,5,6]
    // Output: [4,5,6]
    // Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
    findMiddleNode(head){
        let fast = head
    let slow= head
    while(fast?.next!=null){
        slow=slow.next
        fast=fast.next.next
    }
    return slow
    }
  // Q6. Given the head of a singly linked list, reverse the list, and return the reversed list.
    // Input: head = [1,2,3,4,5]
    // Output: [5,4,3,2,1]
    reverseList(head){
    let currentNode = head
    let newHead=null
    while(currentNode!=null){
        let newItem = currentNode.next
        currentNode.next=newHead
        newHead=currentNode
        currentNode=newItem
    }
    return newHead
  }
  //Q7. Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
  // For example, the following two linked lists begin to intersect at node c1:
    // pA: a1 → a2 → c1 → c2 → c3 → null → b1 → b2 → b3 → c1 ← Match
 // pB: b1 → b2 → b3 → c1 → c2 → c3 → null → a1 → a2 → c1 ← Match
  getInteresctionNode(headA,headB){
    let lA=headA
    let lB=headB
    while(lA!=lB){
        lA=(lA==null)?headB:lA.next
        lB=(lB==null)?headA:lB.next
    }
    return lA
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
    hasCycle(head){
        if(head==null || head.next==null)return false
        let fast = head.next
        let slow = head
        while(fast!=slow){
            if(fast ==null||fast.next==null)return false
            fast = fast.next.next
            slow=slow.next
        }
        return true
    }
   //Q9. Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
    // k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is 
    // not a multiple of k then left-out nodes, in the end, should remain as it is.
    // Input: head = [1,2,3,4,5], k = 2
    // Output: [2,1,4,3,5]
    reverseKGroup(head,k){
    let count = 0
    let current = head
    while(current!=null && count<k){
        current=current.next
        count++
    }
    if(count==k){
        let prev=null
        let i=0
        current=head
        while(i<k){
            let dummy = current.next
            current.next=prev
            prev= current
            current=dummy
            i++
        }
        head.next=reverseKGroup(current,k)
        return prev
    }
    return head
 }
// Q10. Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
    // Input: head = [1,2,2,1]
    // Output: true
  isPalindrome(head) {
    let fast = head
    let slow = head
    while(fast!=null && fast.next!=null){
        fast=fast.next.next
        slow=slow.next
    }
    let reversedList = reverse(slow)
    let current = head
    while(reversedList!=null){
        if(current.val!=reversedList.val)return false
        reversedList=reversedList.next
        current=current.next
    }
    return true
};
 reverse(node){
    let rev=null
    let current = node
    while(current!=null)
    {
        let next = current.next
        current.next=rev
        rev=current
        current=next
    }
    return rev
}
// Q11. Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
    //There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally,
    // pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
    //Do not modify the linked list.

 detectCycle (head) {
    let slow = head
    let fast = head
    while(fast!=null && fast.next!=null){
        fast=fast.next.next
        slow=slow.next
        if(fast==slow){
            let current = head
            while(current!=slow)
            {
                current=current.next
                slow=slow.next
            }
            return current
        }
    }
    return null
};
   // Q12. Given a linked list containing ‘N’ head nodes where every node in the linked list contains two pointers:
    // Next’ points to the next node in the list
   // Child’ pointer to a linked list where the current node is the head
    // Each of these child linked lists is in sorted order and connected by a 
    // 'child' pointer. Your task is to flatten this linked list such that all nodes appear in a single layer or level in a 'sorted order'.
     flatten(root) {
        if(root==null || root.next==null)return root
        root.next= flatten(root.next)
        root = mergeList(root,root.next)
       return root
    }
     mergeList(l1,l2){
      let newHead = new ListNode(0)
      let dummy = newHead
      while(l1!=null && l2!=null){
         if(l1.data<l2.data){
           dummy.bottom= l1
           l1=l1.bottom
           dummy=dummy.bottom
           
         }else{
          dummy.bottom=l2
           l2=l2.bottom
           dummy=dummy.bottom
         }
      }
      dummy.bottom= l1!=null?l1:l2
      return newHead.bottom
    }
    //Q13. Given the head of a linked list, rotate the list to the right by k places.
    // Input: head = [1,2,3,4,5], k = 2
    // Output: [4,5,1,2,3]
    rotateRight (head, k) {
        if(head==null||head.next==null||k==0)return head;
        let length=1;
        let current = head;
        while(current.next!=null){
            current=current.next;
            length++;
        }
        console.log(length);
        current.next=head;
        k = k%length;
        let distance = length-k;
        for(let i=0;i<distance;i++){
            current=current.next;
        }
        let newHead = current.next;
        current.next=null;
        return newHead;
    };
    // Q14 You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 // The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
 // For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 // Input: head = [1,3,4,7,1,2,6]
 // Output: [1,3,4,1,2,6]
    deleteMiddle(head) {
        if(head==null || head.next==null)return null
        let fast = head
        let slow = head
        let prev = null
        while(fast!=null && fast.next!=null){
            prev = slow
            slow=slow.next
            fast=fast.next.next
        }
        prev.next= slow.next!=null?slow.next:null
        return head
    };
   // Q15 Given the head of a linked list, return the list after sorting it in ascending order.
  // Input: head = [4,2,1,3]
  // Output: [1,2,3,4]
  // here wer are using merge sort
    sortList(head) {
        if(head==null || head.next==null)return head
        let mid = getMid(head);
        let midNext = mid.next;
        mid.next= null
        let firstHalf = sortList(head)
        let secondHalf = sortList(midNext)
        return merge(firstHalf,secondHalf)
    };
    getMid(head)
    {
        if(head==null||head.next==null)return head
        let slow = head
        let fast=head
        let prev = null
        while(fast!=null && fast.next!=null){
            prev=slow
            slow=slow.next
            fast=fast.next.next
        }
        console.log(prev.val)
        return prev
    }
    merge(l1,l2){
        let newHead = new ListNode(0)
        let dummy = newHead
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                dummy.next = l1
                dummy=dummy.next
                l1=l1.next
            }else{
                dummy.next=l2
                dummy=dummy.next
                l2=l2.next
            }
        }
        dummy.next= l1?l1:l2
        return newHead.next
    }
    // Q16.Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
// The first node is considered odd, and the second node is even, and so on.
// Note that the relative order inside both the even and odd groups should remain as it was in the input.
// You must solve the problem in O(1) extra space complexity and O(n) time complexity.

    oddEvenList(head) {
        if(head==null||head.next==null)return head;
        let odd = head;
        let even = head.next
        let evenHead = even;
        while(even!=null && even.next!=null){
            odd.next=even.next
            odd = odd.next
            even.next=odd.next
            even = even.next
        }
        odd.next=evenHead
        return head;
    };
   // Q17 Given the head of a doubly linked list with its values sorted in non-decreasing order. Remove all duplicate occurrences of any value in the list so that only distinct values are present in the list.
// Input: head -> 1 <-> 1 <-> 3 <-> 3 <-> 4 <-> 5
// Output: head -> 1 <-> 3 <-> 4 <-> 5
    removeDuplicates(head) {
        if(head==null || head.next==null)return head
        let current = head.next
        let prev = head
        while(current!=null){
            if(prev.val!=current.val){
                prev.next=current
                current.prev= prev
                prev=prev.next
            }
            current=current.next
        }
        return head
    }
}
