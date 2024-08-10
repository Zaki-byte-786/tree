import java.util.*;
class Node1{
    int data;
    Node1 left;
    Node1 right;
    Node1(int data){
        this.data = data;
    }
}
public class treeTraversal {
    static void preOrderTraversal(Node1 node){
        if (node == null)return;
        System.out.print(node.data+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    static List<Integer> preOrderTraversalIterative(Node1 node){
        Stack<Node1> st = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if (node == null)return list;
        st.push(node);
        while (!st.isEmpty()){
            Node1 currentNode = st.pop();
            if (currentNode.right != null)st.push(currentNode.right);
            if (currentNode.left != null)st.push(currentNode.left);
            list.add(currentNode.data);
        }
        return list;
    }
    static void preOrderTraversalWithBothChildPrint(Node1 node){
        if (node == null)return;
        System.out.print(node.data+" -> ");
        if (node.left != null) System.out.print(node.left.data+",");
        else System.out.print(null+",");
        if (node.right != null) System.out.println(node.right.data);
        else System.out.println(null+"");
        preOrderTraversalWithBothChildPrint(node.left);
        preOrderTraversalWithBothChildPrint(node.right);
    }
    static void inOrderTraversal(Node1 node){
        if (node == null)return;
        inOrderTraversal(node.left);
        System.out.print(node.data+" ");
        inOrderTraversal(node.right);
    }
    static List<Integer> inOrderTraversalIterative(Node1 root){
        List<Integer> list = new LinkedList<>();
        Stack<Node1> st = new Stack<>();
        Node1 node = root;
        while (true){
            if (node != null){
                st.push(node);
                node = node.left;
            }
            else {
                if (st.isEmpty())break;
                node = st.pop();
                list.add(node.data);
                node = node.right;
            }
        }
        return list;
    }
    static void inOrderTraversalWithBothChildPrint(Node1 node){
        if (node == null)return;
        inOrderTraversalWithBothChildPrint(node.left);
        System.out.print(node.data+" -> ");
        if (node.left != null) System.out.print(node.left.data+",");
        else System.out.print(null+",");
        if (node.right != null) System.out.println(node.right.data);
        else System.out.println(null+"");
        inOrderTraversalWithBothChildPrint(node.right);
    }
    static void postOrderTraversal(Node1 node){
        if (node == null)return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data+" ");
    }
    static List<Integer> postOrderTraversalIterative(Node1 root){
        Stack<Node1> stack1 = new Stack<>();
        Stack<Node1> stack2 = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if (root == null)return list;
        stack1.push(root);
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
            if (stack2.peek().left != null)stack1.push(stack2.peek().left);
            if (stack2.peek().right != null)stack1.push(stack2.peek().right);
        }
        while (!stack2.isEmpty()){
            list.add(stack2.pop().data);
        }
        return list;
    }
    static void postOrderTraversalWithBothChildPrint(Node1 node){
        if (node == null)return;
        postOrderTraversalWithBothChildPrint(node.left);
        postOrderTraversalWithBothChildPrint(node.right);
        System.out.print(node.data+" -> ");
        if (node.left != null) System.out.print(node.left.data+",");
        else System.out.print(null+",");
        if (node.right != null) System.out.println(node.right.data);
        else System.out.println(null+"");
    }
    static void pre_In_Post_OrderTraverse(int n){
        if (n == 0)return;
        System.out.println("Pre "+n); // pre
        pre_In_Post_OrderTraverse(n - 1);
        System.out.println("In "+n);  // in
        pre_In_Post_OrderTraverse(n - 1);
        System.out.println("Post "+n); // post
    }
    public static void main(String[] args) {
        Node1 root = new Node1(1);
        Node1 a = new Node1(2);
        Node1 b = new Node1(3);
        root.left = a;
        root.right = b;
        Node1 c = new Node1(4);
        Node1 d = new Node1(5);
        a.left = c;
        a.right = d;
        Node1 g = new Node1(6);
        d.left = g;
        Node1 e = new Node1(7);
        Node1 f = new Node1(8);
        b.left = e;
        b.right = f;
        Node1 h = new Node1(9);
        Node1 i = new Node1(10);
        f.left = h;
        f.right = i;


//        Node1 root = new Node1(1); // root
//        root.left = new Node1(2); // a
//        root.left.left = new Node1(4); // c
//        root.left.right = new Node1(5); // d
//        root.left.right.left = new Node1(6); // g
//        root.right = new Node1(3);// b
//        root.right.left = new Node1(7); // e
//        root.right.right = new Node1(8); // f
//        root.right.right.left = new Node1(9); // h
//        root.right.right.right = new Node1(10); // i
//        preOrderTraversal(root);
//        System.out.println();
//        System.out.println(preOrderTraversalIterative(root));
//        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        System.out.println(inOrderTraversalIterative(root));
//        System.out.println();
//        postOrderTraversal(root);
//        System.out.println();
//        preOrderTraversalWithBothChildPrint(root);
//        System.out.println();
//        inOrderTraversalWithBothChildPrint(root);
//        System.out.println();
//        postOrderTraversalWithBothChildPrint(root);
//        pre_In_Post_OrderTraverse(3);



    }
}
