import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class zigZagTraversalOfBinaryTree {
    static List<List<Integer>> method(Node root){
        List<List<Integer>> ll = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        boolean leftToRight = true;
        if (root == null)return ll;
        q.add(root);
        while (!q.isEmpty()){
            int level = q.size();
            List<Integer> l = new LinkedList<>();
            for (int i = 0; i < level; i++) {
            Node currentNode = q.remove();
            if (leftToRight) l.add(currentNode.data);
            else l.add(0,currentNode.data);
            if (currentNode.left != null)q.add(currentNode.left);
            if (currentNode.right != null)q.add(currentNode.right);

            }
leftToRight = !leftToRight;
            ll.add(l);
        }
        return ll;
     }
    public static void main(String[] args) {

    }
}
