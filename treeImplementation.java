class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}
public class treeImplementation {
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

        }
    }


