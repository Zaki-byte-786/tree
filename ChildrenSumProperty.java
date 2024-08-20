public class ChildrenSumProperty {
    static void method(Node root){
        int child = 0;
        if(root == null || (root.left == null && root.right == null))return;
        if(root.left != null)child += root.left.data;
        if(root.right != null)child += root.right.data;
        if(child < root.data){
            if(root.left != null)root.left.data = root.data;
            if(root.right != null)root.right.data = root.data;
        }
        method(root.left);
        method(root.right);
        child = 0;
        if(root.left != null)child += root.left.data;
        if(root.right != null)child += root.right.data;
        root.data = child;
    }
    public static void main(String[] args) {

    }
}
