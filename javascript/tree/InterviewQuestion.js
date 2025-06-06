 function TreeNode(val, left, right) {
         this.val = (val===undefined ? 0 : val)
         this.left = (left===undefined ? null : left)
         this.right = (right===undefined ? null : right)
     }
    // Q1 Given the root of a binary tree, return the inorder traversal of its nodes' values.
    // Input: root = [1,null,2,3]
    // Output: [1,3,2]  
    // DFS using
var inorderTraversal = function(root) {
    let result = []
    dfs(root,result)
    return result
};
var dfs = function(root,result){
    if(!root)return
    dfs(root.left,result)
    result.push(root.val)
    dfs(root.right,result)
}
// inorder using iterretive >> time complexity o(n) and time complexity o(n)
// DFS using
var inorderTraversalItteretive = function(root){
    let result = []
    let stack = []
    let current = root
    while(current!=null || stack.length>0){
        while(current!=null){
            stack.push(current)
            current=current.left
        }
        current = stack.pop()
        result.push(current.val)
        current=current.right
    }
}
// Q2. Given the root of a binary tree, return the preorder traversal of its nodes' values.
// Input: root = [1,null,2,3]
// Output: [1,2,3]
// DFS
var preorderTraversal = function(root) {
    let result = []
    dfsPre(root,result)
    return result
};
var dfsPre = function(root,result){
    if(root==null)return
    result.push(root.val)
    dfsPre(root.left,result)
    dfsPre(root.right,result)
}
// preorder itteretive
// DFS
var preorderTraversalIterretive = function(root){
    if(!root) return []
    let result=[]
    let stack = [root]
    while(stack!=null){
       const node =stack.pop()
       result.push(node.val)
       if(node.right)stack.push(node.right)
       if(node.left)stack.push(node.left)
    }
    return result
}
  // Q3. Given the root of a binary tree, return the postorder traversal of its nodes' values.
    // Input: root = [1,null,2,3]
    // Output: [3,2,1]
    // DFS
var postorderTraversal = function(root) {
    let result=[]
    dfsPost(root,result)
    return result
};
var dfsPost = function(root,result){
    if(root==null)return
    dfsPost(root.left,result)
    dfsPost(root.right,result)
    result.push(root.val)
}
// using itteretive and DFS
var postorderTraversalItteretive = function(root){
    if(!root)return []
    let stack1= [root]
    let stack2=[]
    let result = []
    while(stack1!=null){
        const node = stack1.pop()
        stack2.push(node)

        if(node.right)stack1.push(node.right)
        if(node.left)stack2.push(node.left)
    }
   while(stack2.length>0){
    result.push(stack2.pop())
   }
   return result
    
}
// BFS or level order traversal
var levelOrderTraversal = function(root){
    let result = []
    if(!root) return result
    let queue = [root]
    while(queue.length){
        let node = queue.shift()
        result.push(node)
        if(node.left)queue.push(node.left)
        if(node.right)queue.push(node.right)
    }
return result
}
// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
    // Input: root = [3,9,20,null,null,15,7]
    // Output: [[3],[9,20],[15,7]]
    var levelOrder = function(root){
        let result = []
        if(!root)return result
        let queue = [root]
        while(queue.length){
            let size = queue.length
            let levelItem = []
            for(let i=0;i<size;i++){
                let node = queue.shift()
                levelItem.push(node.val)
                if(node.left)queue.push(node.left)
                if(node.right)queue.push(node.right)

            }
            result.push(levelItem)
        }
      return result
    }
     // Given the root of a binary tree, return its maximum depth.
    // A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    // Input: root = [3,9,20,null,null,15,7]
    // Output: 3
    var maxDepth = function(root){
        let depth = 0
        let queue = [root];
        while(queue.length){
            let size = queue.length
            for(let i=0;i<size;i++){
                let node = queue.shift()
                if(node.left)queue.push(node.left)
                if(node.right)queue.push(node.right)
            }
           depth++
        }
        return depth
    }
    // Given the root of a binary tree, return the length of the diameter of the tree.
    // The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
    // The length of a path between two nodes is represented by the number of edges between them.
    // Input: root = [1,2,3,4,5]
    // Output: 3
    // Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
    var diameterOfBinaryTree= function(root){
        let diameter = 0
        var depth = function(node){
            if(!root)return 0
            let left = depth(node.left)
            let right = depth(node.right)
            diameter = Math.max(diameter,left+right)
            return 1+Math.max(left,right)
        }
        return diameter
    }
