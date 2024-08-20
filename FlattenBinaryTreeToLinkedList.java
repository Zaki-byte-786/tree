import java.util.LinkedList;
import java.util.List;

class TreeNode{
    TreeNode node;
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }
}

public class FlattenBinaryTreeToLinkedList {
//    static List<Integer> list = new LinkedList<>();
//    static void preOrder(TreeNode root){
//        if (root == null)return;
//        preOrder(root.left);
//        list.add(root.val);
//        preOrder(root.right);
//    }
static void flatten(TreeNode root){
    TreeNode curr = root;
    while (curr != null){
        if (curr.left == null) curr = curr.right;
        else {
            TreeNode currLeft = curr.left;
            while (currLeft.right != null) currLeft = currLeft.right;
            currLeft.right = curr.right;
            curr.right = curr.left;
            curr.left = null;
            curr = curr.right;
        }
    }
}
    public static void main(String[] args) {
TreeNode root = new TreeNode(1);
TreeNode a = new TreeNode(2);
TreeNode b = new TreeNode(7);
root.left = a;
root.right = b;
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(5);
        a.left = c;
        a.right = d;
        TreeNode e = new TreeNode(8);
        b.right = e;
        TreeNode f = new TreeNode(4);
        c.right = f;
        TreeNode g = new TreeNode(6);
d.right = g;
//preOrder(root);
//        System.out.println(list);


    }
}
