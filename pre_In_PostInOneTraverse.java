import java.util.*;
public class pre_In_PostInOneTraverse{
   static class Node{
        Node left,right;
        int val;
        Node(int val){
            this.val = val;
        }
    }
    static class nodeWithFrequency{
       Node node;
       int frequency;
       nodeWithFrequency(Node node,int frequency){
           this.node = node;
           this.frequency = frequency;
       }
    }
    static List<Integer> method(Node root){
       Stack<nodeWithFrequency> st = new Stack<>();
       List<Integer> preOrderList = new LinkedList<>();
        List<Integer> inOrderList = new LinkedList<>();
        List<Integer> postOrderList = new LinkedList<>();
        st.push(new nodeWithFrequency(root,1));
        if (root == null)return preOrderList; // any empty list you can return
        while (!st.isEmpty()){
         if(st.peek().frequency == 1){
             preOrderList.add(st.peek().node.val);
             st.peek().frequency++;
             if (st.peek().node.left != null) st.push(new nodeWithFrequency(st.peek().node.left,1));
         }
         else if (st.peek().frequency == 2) {
             inOrderList.add(st.peek().node.val);
             st.peek().frequency++;
             if (st.peek().node.right != null) st.push(new nodeWithFrequency(st.peek().node.right,1));
         }
         else {
             postOrderList.add(st.peek().node.val);
             st.remove(st.peek());
         }
        }
return postOrderList;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);
       Stack<nodeWithFrequency> st = new Stack<>();
       st.push(new nodeWithFrequency(root,1));
       st.push(new nodeWithFrequency(root.left,2));
        st.push(new nodeWithFrequency(root.right,-1));
        System.out.println(st.peek().node.val);
        Node temp = st.peek().node;
        System.out.println(temp.val);
        System.out.println(method(root));
    }
}
