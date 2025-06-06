class Node{
    constructor(data){
        this.data=data
        this.next=null
        this.last = null
    }
}

class DoublyLinkedList{
    constructor(){
        this.head=null
    }

    add(data){
       let newNode = new Node(data)
       if(this.head==null){
        this.head= newNode
        return
       }
       let currentHead = this.head
       while(currentHead.next!=null){
        currentHead=currentHead.next
       }
       currentHead.next=newNode
       newNode.last= currentHead
    }
    reverseIterative(){
        if(this.head==null||this.head.next==null)return this.head;
        let currentHead = this.head
        let last = null;
        while(currentHead!=null){
            let next = currentHead.next;
            currentHead.next=last
            last = currentHead
            currentHead = next
        }
        this.head=last
    }
    recursiveHelper(node){
        if(node==null||node.next==null)return node
        let newHead = this.recursiveHelper(node.next)
        let leftItem = node.next
        leftItem.next=node
        node.next=null
        return newHead
    }
    reverseRecursive(){
        this.head = this.recursiveHelper(this.head)
    }
    //Optimal Approach: Tortoise and Hare (Fast & Slow Pointers)
    //This technique finds the second middle node in one pass (O(n) time, O(1) space).
    //🐢 Slow Pointer moves one step at a time
    // 🐇 Fast Pointer moves two steps at a time
    // When the fast pointer reaches the end, the slow pointer is at the middle.
    findMiddleNode(){
        let slow = this.head;
        let fast = this.head;
        while(fast && fast.next){
            slow = slow.next
            fast= fast.next.next
        }
        this.head = slow
    }
    removeNthNodeFromLast(n){
        let slow = this.head
        let fast = this.head
        for(let i =0;i<=n;i++){
            fast=fast.next
        }
        while(fast!=null){
            fast=fast.next
            slow=slow.next
        }
        slow.next=slow.next.next
    }
    delete(key){
      if(this.head==null)return
      if(this.head.data==key){
        this.head = this.head.next;
        if(this.head!=null)
         this.head.last=null
        return
      }
      let currentHead = this.head
      while(currentHead!=null && currentHead.data!=key){
        currentHead=currentHead.next
      }
      if(currentHead?.next!=null){
        currentHead.next.last = currentHead.last
      }
      if(currentHead?.last!=null)
      {
        currentHead.last.next = currentHead.next
      }

    }

    printList(){
      let currentHead = this.head
      while(currentHead!=null)
      {
        console.log(currentHead.data+" ")
        currentHead =currentHead.next
      }
    }
}

let list = new DoublyLinkedList()
list.add(34)
list.add(56)
list.add(78)
list.add(34)
list.add(67)
// list.printList()
// list.delete(67)
// list.printList()
// list.reverseIterative()
// list.printList()
// list.reverseRecursive()
// list.printList()
// list.findMiddleNode()
list.removeNthNodeFromLast(2)
list.printList()