import java.util.ArrayList;

public class LCAInBinaryTree {
    static boolean helper(Node root, int x, ArrayList<Node> list){
        if (root == null)return false;
        list.add(root);
        if (root.data == x)return true;
        if (helper(root.left,x,list))return true;
        if (helper(root.right,x,list))return true;
        list.remove(list.size() - 1);
        return false;
    }
    static ArrayList<Node> function(Node root,int x){
        ArrayList<Node> list = new ArrayList<>();
        helper(root,x,list);
        return list;
    }
    static Node brute(Node root,Node p,Node q){
        ArrayList<Node> list1 = function(root,p.data);
        ArrayList<Node> list2 = function(root,q.data);
        int k = 0;
        for ( k = 0; k < Math.min(list1.size(),list2.size()); k++) {
            if (list1.get(k).data != list2.get(k).data)break;
        }
        return list1.get(k - 1);
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
        System.out.println(brute(root,c,d).data);

    }
}
//public static void changeTree(BinaryTreeNode < Integer > root) {
//    // Write your code here.
//    int child = 0;
//    if(root == null || (root.left == null && root.right == null))return;
//    if(root.left != null)child += root.left.data;
//    if(root.right != null)child += root.right.data;
//    if(child < root.data){
//        if(root.left != null)root.left.data = child;
//        if(root.right != null)root.right.data = child;
//    }
//    changeTree(root.left);
//    changeTree(root.right);
//    child = 0;
//    if(root.left != null)child += root.left.data;
//    if(root.right != null)child += root.right.data;
//    root.data = child;
//}