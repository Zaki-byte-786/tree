import java.util.*;

public class Print_all_the_Nodes_at_a_distanceofKinBinaryTree {
    static HashMap<Node,Node> map = new HashMap<>();
    static void childParentMap(Node root){
        if (root == null)return;
        if (root.left != null)map.put(root.left,root);
        if (root.right != null)map.put(root.right,root);
        childParentMap(root.left);
        childParentMap(root.right);
    }
    public static List<Integer> distanceK(Node root, Node target, int k) {
        List<Integer> list = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> set =new HashSet<>();
        childParentMap(root);
        q.add(target);
        while (k > 0 ){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                if (temp.left != null && !set.contains(temp.left)){
                    q.add(temp.left);
                }
                if (temp.right != null && !set.contains(temp.right)){
                    q.add(temp.right);
                }
                if (map.containsKey(temp)){
                    Node papa = map.get(temp);
                    if (!set.contains(papa)){
                        q.add(papa);
                    }
                }
                set.add(temp);
            }
            k--;
        }
        int size = q.size();
        for (int i = 0; i < size; i++) {
            list.add(q.poll().data);
        }
        return list;
    }
    public static void main(String[] args) {

    }
}
