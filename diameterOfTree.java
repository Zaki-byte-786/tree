public class diameterOfTree {
    static int height(Node root){
        if(root == null)return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public int diameterOfBinaryTree(Node root) {
        if(root == null)return 0;
        int rootNode = height(root.left) + height(root.right);
        int leftSubTree = diameterOfBinaryTree(root.left);
        int rightSubTree = diameterOfBinaryTree(root.right);
        return Math.max(rootNode,Math.max(leftSubTree,rightSubTree));
    }


    int diameter = 0;
    int heightOptimal(Node root){
        if(root == null)return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        diameter = Math.max(diameter,leftHeight + rightHeight);
        return 1 + Math.max(leftHeight,rightHeight);
    }
     int diameterOfBinaryTreeOptimal(Node root) {
        heightOptimal(root);
        return diameter;
    }
    public static void main(String[] args) {

    }
}
