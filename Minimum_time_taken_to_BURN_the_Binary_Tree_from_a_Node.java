import java.util.*;
public class Minimum_time_taken_to_BURN_the_Binary_Tree_from_a_Node {
    static Node nodeFind(Node root,int target){
        if (root == null || root.data == target)return root;
       Node left = nodeFind(root.left,target);
        Node right = nodeFind(root.right,target);
        return left == null ? right : left;
    }
   static HashMap<Node,Node> map = new HashMap<>();
    static void childParentHashmap(Node root){
        if (root == null)return;
        if (root.left != null)map.put(root.left,root);
        if (root.right != null)map.put(root.right,root);
        childParentHashmap(root.left);
        childParentHashmap(root.right);
    }
    public static int minTime(Node root, int x){
        childParentHashmap(root);
        Node target = nodeFind(root,x);
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        int time = 0;
        if (root == null)return time;
        q.add(target);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                if (temp.left != null && !set.contains(temp.left))q.add(temp.left);
                if (temp.right != null && !set.contains(temp.right))q.add(temp.right);
                if (map.containsKey(temp) && !set.contains(map.get(temp)))q.add(map.get(temp));
                set.add(temp);
            }
            time++;
        }
        return time - 1;
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
        Node f = new Node(7);
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        Node g = new Node(8);
        Node h = new Node(9);
        Node i = new Node(10);
        Node j = new Node(11);
        Node k = new Node(12);
        Node l = new Node(13);
        Node m = new Node(14);
        Node n = new Node(15);
        c.left = g;
        c.right = h;
        d.left = i;
        d.right = j;
        e.left = k;
        e.right = l;
        f.left = m;
        f.right = n;
    }
}
