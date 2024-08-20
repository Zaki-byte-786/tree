public class maximumPathSum extends treeImplementation{
    static int maximumSum = Integer.MIN_VALUE;
    static int helper(Node root){
        if(root == null)return 0;
        int leftSum = Math.max(helper(root.left),0);
        int rightSum = Math.max(helper(root.right),0);
        int currentSum = root.data + leftSum + rightSum;
        maximumSum = Math.max(maximumSum,currentSum);
        return root.data + Math.max(leftSum,rightSum);
    }
    public static int maxPathSum(Node root) {
       helper(root);
        return maximumSum;
    }
    public static void main(String[] args) {
        Node root = new Node(15);
        Node a = new Node(10);
        Node b = new Node(20);
        root.left = a;
        root.right = b;
        Node c = new Node(-30);
        Node d = new Node(-15);
        b.left = c;
        b.right = d;
        System.out.println(maxPathSum(root));
    }
}
