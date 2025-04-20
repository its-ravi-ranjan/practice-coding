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
list.printList()
list.delete(34)
list.printList()