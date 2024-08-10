import java.util.*;

public class levelorderTraversal {
    static List<List<Integer>> method(Node node){
        List<List<Integer>> ll = new ArrayList<>();
        if (node == null)return ll;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()){
            int level = q.size();
            List<Integer> l = new LinkedList<>();
            for (int i = 0; i < level; i++) {
                Node currentNode = q.remove();
                if (currentNode.left != null)q.add(currentNode.left);
                if (currentNode.right != null)q.add(currentNode.right);
                l.add(currentNode.data);
            }
            ll.add(l);
        }
        return ll;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        a.left = c;
        a.right = d;
        b.right = e;
        System.out.println(method(root));
    }
}
