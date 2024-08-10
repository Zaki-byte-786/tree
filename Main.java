import java.security.KeyPair;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends treeImplementation{
   static class nodeWithFrequency{
        Node node;
        int frequency;
        nodeWithFrequency(Node node,int frequency){
            this.node = node;
            this.frequency = frequency;
        }
    }
    List<Integer> postorderTraversal(Node node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        Node current = node;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    result.add(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        result.add(temp.data);
                    }
                } else {
                    current = temp;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] array = new int[2][3];
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            l1.add(i);
        }
        List<List<Integer>> ll = new ArrayList<>();

        List<Integer> l2 = new ArrayList<>();
        for (int i = 3; i < 6; i++) {
            l2.add(i);
        }
        List<Integer> l3 = new ArrayList<>();
        for (int i = 6; i < 9; i++) {
            l3.add(i);
        }
       ll.add(l1);
        ll.add(l2);
        ll.add(l3);
//        System.out.println(ll);
        Stack<Node> q = new Stack<>();
        q.push(null);
        q.push(null);
        System.out.println(q.size());
//        q.remove();
        int x = 2;
        Stack<KeyPair> stack = new Stack<>();
        Stack<nodeWithFrequency> st = new Stack<>();
        Node root = new Node(1);
        nodeWithFrequency o1 = new nodeWithFrequency(root,1);
        st.push(o1);
        nodeWithFrequency o2 = new nodeWithFrequency(root,2);
        st.push(o2);
        System.out.println(st.size());
        System.out.println(o1.frequency);
    }
}