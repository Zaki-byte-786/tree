public class symmetricBinaryTree {
  static boolean helper(Node l,Node r){
        if (l == null && r == null)return true;
        if (l == null || r == null)return false;
        if((l.data == r.data) && helper(l.left,r.right) && helper(l.right,r.left))return true;
        return false;
    }
    static boolean function(Node root){
        return helper(root.left,root.right);
    }
    public static void main(String[] args) {

    }
}
