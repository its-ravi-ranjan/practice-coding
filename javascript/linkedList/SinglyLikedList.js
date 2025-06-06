// linked list is linear data strucutre which consist of nodes . Here each nodes contains data and pointer to next node


class Node {
    constructor(data){
        this.data = data
        this.next= null
    }

}

class SinglyLinkedList{
    constructor(){
        this.head=null
    }

    add(data){
        let newNode = new Node(data)
       if(this.head==null){
          this.head = newNode
          return
       }
       let currentHead = this.head
       while(currentHead.next!=null){
        currentHead=currentHead.next
       }
       currentHead.next = newNode
    }
       //Optimal Approach: Tortoise and Hare (Fast & Slow Pointers)
    //This technique finds the second middle node in one pass (O(n) time, O(1) space).
    //🐢 Slow Pointer moves one step at a time
    // 🐇 Fast Pointer moves two steps at a time
    // When the fast pointer reaches the end, the slow pointer is at the middle.
    findMiddleNode(){
        let slow= this.head
        let fast = this.head
        while(fast && fast.next){
            slow= slow.next
            fast=fast.next.next
        }
        this.head=slow
    }
    //To merge two sorted singly linked lists into one sorted linked list, the optimal approach is to use two pointers to traverse both lists and compare nodes one by one.
    //
    mergeTwoSortedLL(list1,list2){
        let newList = new Node(-1)
        let temp = newList
        while(list1 && list2){
          if(list1.data<list2.data){
            temp.next = list1
            list1=list1.next
          }else{
            temp.next=list2
            list2=list2.next
          }
          temp=temp.next
        }
        temp.next = list1!=null?list1:list2
        return newList.next
    }
    removeNthNodeFromEnd(n){
        let slow = this.head
        let fast = this.head
        for(let i=0;i<=n;i++){
            fast=fast.next
        }
        while(fast!=null){
            fast= fast.next
            slow=slow.next
        }
        slow.next=slow.next.next
    }
    delete(key){
       if(this.head==null)return 
       if(this.head.data==key){
        this.head= this.head.next
        return
       }
       let currentHead = this.head
       while(currentHead.next!=null && currentHead.next.data!=key){
        currentHead = currentHead.next
       }
       if(currentHead.next!=null){
        currentHead.next= currentHead.next.next
       }
    }
    printList(){
        let currentHead = this.head
        while(currentHead!=null){
            console.log(currentHead.data+">")
            currentHead=currentHead.next
        }
    }
}

let list = new SinglyLinkedList()
list.add(45)
list.add(34)
list.add(23)
list.add(78)
list.add(98)
list.printList()
// list.findMiddleNode()
list.removeNthNodeFromEnd(2)
list.printList()