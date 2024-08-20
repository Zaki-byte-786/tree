public class balancedTree extends treeImplementation{
    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        boolean leftSubTree = isBalanced(root.left);
        boolean rightSubTree = isBalanced(root.right);
        if(!leftSubTree  || !rightSubTree)return false;
        return true;   // TC->O(N^2),SC ->O(N) due to stack
    }


    static int heightoptimal(Node root){
        if(root == null)return 0;
        int leftHeight = heightoptimal(root.left);
        int rightHeight = heightoptimal(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1)return -1;
        if(leftHeight == -1 || rightHeight == -1)return -1;
        return 1 + Math.max(leftHeight,rightHeight);
    }
    public boolean optimal(Node root) {
        return heightoptimal(root) != -1;
    }          // TC->O(N),SC ->O(N) due to stack
    public static void main(String[] args) {

    }

}
