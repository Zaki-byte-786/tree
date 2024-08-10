import java.util.LinkedList;
import java.util.Queue;

public class sizeOfTree extends treeImplementation{
    static int method(Node node){
        if (node == null)return 0;
      return 1+method(node.left)+method(node.right);
    }
    static int sumOfNodes(Node root){
        if (root == null)return 0;
        return root.data+sumOfNodes(root.left)+sumOfNodes(root.right);
    }
    static int maxNode(Node node){
        if (node == null)return Integer.MIN_VALUE;
        return Math.max(node.data,Math.max(maxNode(node.left),maxNode(node.right)));
    }
    static int minNode(Node node){
        if (node == null)return Integer.MAX_VALUE;
        return Math.min(node.data,Math.min(minNode(node.left),minNode(node.right)));
    }
    static int edgesHeight(Node node){ // when height = number of edges
        if (node == null || (node.left == null && node.right == null))return 0;
        return 1 + Math.max(edgesHeight(node.left),edgesHeight(node.right));
    }
    static int nodesHeight(Node node){ // when height = number of edges
        if (node == null)return 0;
        return 1 + Math.max(nodesHeight(node.left),nodesHeight(node.right));
    }
    static int productOfNode(Node node){
        if (node == null)return 1;
        return node.data * productOfNode(node.left) * productOfNode(node.right);
    }
    static void printNthLevelNode(Node node,int level){
        if (node == null)return;
        if (level == 1){
             System.out.print(node.data+" ");
             return; // O(N) if we don't use return statement for each level the traversal will occur for N nodes
         }
         printNthLevelNode(node.left,level - 1);
         printNthLevelNode(node.right,level - 1);
    }
    static void printNodeLevelByLevel(Node node){
        int level = edgesHeight(node) + 1;
        for (int i = 1; i <= level ; i++) {
            printNthLevelNode(node,i);
            System.out.println();
        }
    }
    static void printNodeLevelByLevelOptimal(Node node){
        if (node == null)return;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (q.size() > 0){
            Node temp = q.peek();
            if (temp.left != null)q.add(temp.left);
            if (temp.right != null)q.add(temp.right);
            System.out.print(q.peek().data + " ");
            q.remove();
        }
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
//        System.out.println(method(root));
//        System.out.println(sumOfNodes(root));
//        System.out.println(maxNode(root));
//        System.out.println(height(root));
//        System.out.println(productOfNode(root));
//        System.out.println(minNode(root));
        printNthLevelNode(root,2);
        System.out.println();
        printNodeLevelByLevel(root);
        printNodeLevelByLevelOptimal(root);
    }
}
