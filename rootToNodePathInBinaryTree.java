import java.util.ArrayList;

public class rootToNodePathInBinaryTree {
    static boolean helper(Node root,int x,ArrayList<Integer> list){
        if (root == null)return false;
        list.add(root.data);
        if (root.data == x)return true;
        if (helper(root.left,x,list))return true;
        if (helper(root.right,x,list))return true;
        list.remove(list.size() - 1);
        return false;
    }
    static ArrayList<Integer> function(Node root,int x){
        ArrayList<Integer> list = new ArrayList<>();
        helper(root,x,list);
        return list;
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
        System.out.println(function(root,4));
        System.out.println(function(root,5));

    }
}
