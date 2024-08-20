import java.util.LinkedList;
import java.util.List;

public class MorrisPreOrderTraversal {
    public List<Integer> preorder2Traversal(Node root) {
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
                    list.add(curr.data);
                    currLeft.right = curr;
                    curr = curr.left;
                }
                else{
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
