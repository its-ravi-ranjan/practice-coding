package java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.print.attribute.standard.PresentationDirection;

import com.sun.tools.javac.util.ListBuffer;

public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

public class InterviewQuestion {
    // Q1 Given the root of a binary tree, return the inorder traversal of its nodes' values.
    // Input: root = [1,null,2,3]
    // Output: [1,3,2]
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root,result);
        return result;
    }
    public void dfs(TreeNode root,List result){
        if(root==null)return;
        dfs(root.left,result);
        result.add(root.val);
        dfs(root.right,result);
    }
    // inorder traversal itteretive
    public List<Integer> inorderTraversalIteretive(TreeNode root){
        List<Integer> result =new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current!=null || !stack.isEmpty()){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current=current.right;
        }
      return result;
    }
    // inorder morris traversal
    // Normally, recursive or stack-based traversal uses O(h) memory, where h is the height of the tree.
    // Morris Traversal does it in O(1) space by temporarily changing the tree.
public List<Integer> morrisInorderTraversal (TreeNode root){
    List<Integer> result = new ArrayList<>();
    TreeNode current = root;
    while(current!=null){
       if(current.left==null){
        result.add(current.val);
        current=current.right;
       }else{
       TreeNode precedence = current.left;
       while(precedence.right!=null && precedence.right!=current){
           precedence=precedence.right;
       }
       if(precedence.right==null){
        precedence.right = current;
        current=current.left;
       }else{
        precedence.right = null;
        result.add(current.val);
        current=current.right;
       }
    }
    }
    return result;
}
}    
    // Q2. Given the root of a binary tree, return the preorder traversal of its nodes' values.
    // Input: root = [1,null,2,3]
    // Output: [1,2,3]
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsPre(root,result);
        return result;
    }
    public void dfsPre(TreeNode root,List result){
        if(root==null)return;
        result.add(root.val);
        dfsPre(root.left,result);
        dfsPre(root.right,result);
    }
    // preorder traversal itteretive

    public List<Integer> itteretivePreorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root==null)return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right!=null)stack.push(node.right);
            if(node.left!=null)stack.push(node.left);
        }
      return result;
    }
     // preorder morris traversal
    // Normally, recursive or stack-based traversal uses O(h) memory, where h is the height of the tree.
    // Morris Traversal does it in O(1) space by temporarily changing the tree.
public List<Integer> morrisPreorderTraversal (TreeNode root){
    List<Integer> result = new ArrayList<>();
    TreeNode current = root;
    while(current!=null){
       if(current.left==null){
        result.add(current.val);
        current=current.right;
       }else{
       TreeNode precedence = current.left;
       while(precedence.right!=null && precedence.right!=current){
           precedence=precedence.right;
       }
       if(precedence.right==null){
        precedence.right = current;
        result.add(current.val);
        current=current.left;
       }else{
        precedence.right = null;
        current=current.right;
       }
    }
    }
    return result;
}
    // Q3. Given the root of a binary tree, return the postorder traversal of its nodes' values.
    // Input: root = [1,null,2,3]
    // Output: [3,2,1]

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        bfsPost(root,result);
        return result;
    }
    public void bfsPost(TreeNode root,List result){
        if(root==null)return;
        bfsPost(root.left,result);
        bfsPost(root.right,result);
        result.add(root.val);
    }
    // post order itteretive
    public List<Integer> itteretivePostorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack1= new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.right!=null)stack1.push(node.right);
            if(node.left!=null)stack1.push(node.left);
        }
        while(!stack2.isEmpty()){
            TreeNode node2 = stack2.pop();
            result.add(node2.val);

        }
        return result;
    }
    // BFS or level order traversal(left to right)
    public List<Integer> levelOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            if(node.left!=null)queue.offer(node.left);
            if(node.right!=null)queue.offer(node.right);
        }
        return result;
    }
    // Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
    // Input: root = [3,9,20,null,null,15,7]
    // Output: [[3],[9,20],[15,7]]
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelItem = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode node = queue.poll();
                levelItem.add(node.val);
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
            result.add(levelItem);
        }
        return result;
    }
    // Given the root of a binary tree, return its maximum depth.
    // A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    // Input: root = [3,9,20,null,null,15,7]
    // Output: 3
    public int maxDepth(TreeNode root){
        int depth=0;
        if(root==null)return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
    // Given the root of a binary tree, return the length of the diameter of the tree.
    // The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
    // The length of a path between two nodes is represented by the number of edges between them.
    // Input: root = [1,2,3,4,5]
    // Output: 3
    // Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
    public int diameterOfBinaryTree(TreeNode root){
        int[] diameter = new int[1];
        depth(root,diameter);
        return diameter[0];
    }
    public int depth(TreeNode node, int[] diameter){
        if(node==null)return 0;
        int left = depth(node.left,diameter);
        int right = depth(node.right,diameter);
        diameter[0] = Math.max(diameter[0],left+right);
        return Math.max(left,right);
     }
}
