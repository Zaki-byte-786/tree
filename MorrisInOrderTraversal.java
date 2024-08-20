import java.util.*;
public class MorrisInOrderTraversal {
    // the code will distort the giving tree
    public List<Integer> inorderTraversal(Node root) {
        List<Integer> list = new LinkedList<>();
        if(root == null)return list;
        Node currentNode = root;
        while(currentNode != null){
            if(currentNode.left == null){
                list.add(currentNode.data);
                currentNode = currentNode.right;
            }
            else{
                Node temp = currentNode;
                Node currentNodeLeftChild = currentNode.left;
                while(currentNodeLeftChild.right != null){
                    currentNodeLeftChild = currentNodeLeftChild.right;
                }
                currentNodeLeftChild.right = currentNode;
                currentNode = currentNode.left;
                temp.left = null;
            }
        }
        return list;
    }
// the code will preserve the given tree
    public List<Integer> inorder2Traversal(Node root) {
        List<Integer> list = new LinkedList<>();
        if(root == null)return list;
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                list.add(curr.data);
                curr = curr.right;
            }
            else{
                Node currLeft = curr.left;
                while(currLeft.right != null && currLeft.right != curr){
                    currLeft = currLeft.right;
                }
                if(currLeft.right == null){
                    currLeft.right = curr;
                    curr = curr.left;
                }
                else{
                    list.add(curr.data);
                    currLeft.right = null;
                    curr = curr.right;
                }
            }


        }
        return list;
    }
    public static void main(String[] args) {

    }
}
