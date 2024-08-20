import java.security.KeyPair;
import java.util.*;

//import java.util.*;
//class Tuple{
//    Node node;
//    int vertical;
//    int level;
//    Tuple(Node node,int vertical,int level){
//        this.node = node;
//        this.vertical = vertical;
//        this.level = level;
//    }
//}
//static List<List<Integer>> verticalTraverse(Node root){
////    TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
////
////}


public class Main extends treeImplementation{
    public List<Integer> preOrderTraversal(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.left == null) {
                // Add the current node's value to the list (Pre-order step)
                list.add(currentNode.data);
                currentNode = currentNode.right;
            } else {
                Node currentNodeLeftChild = currentNode.left;
                while (currentNodeLeftChild.right != null && currentNodeLeftChild.right != currentNode) {
                    currentNodeLeftChild = currentNodeLeftChild.right;
                }

                if (currentNodeLeftChild.right == null) {
                    // Add the current node's value to the list before threading (Pre-order step)
                    list.add(currentNode.data);
                    currentNodeLeftChild.right = currentNode; // Create the thread
                    currentNode = currentNode.left;
                } else {
                    currentNodeLeftChild.right = null; // Remove the thread
                    currentNode = currentNode.right;
                }
            }
        }

        return list;
    }
//    static void changeTree(Node root){
//        if (root == null || (root.left == null && root.right == null))return;
//        int child = 0;
//        if (root.left != null )child += root.left.data;
//        if (root.right != null)child += root.right.data;
//        if (child >= root.data)root.data = child;
//        else {
//            if (root.left != null)root.left.data = root.data;
//            if (root.right != null)root.right.data = root.data;
//        }
//        changeTree(root.left);
//        changeTree(root.right);
//        int total = 0;
//        if (root.left != null) total += root.left.data;
//        if (root.right != null) total += root.right.data;
//        if (root.left != null || root.right != null)root.data = total;
//    }
//    static int height(Node root){
//        if (root == null)return 0;
////        if (root == null || (root.left == null && root.right == null))return 0;
//        return 1 + Math.max(height(root.left),height(root.right));
//    }
//   static class nodeWithFrequency{
//        Node node;
//        int frequency;
//        nodeWithFrequency(Node node,int frequency){
//            this.node = node;
//            this.frequency = frequency;
//        }
//    }
//    List<Integer> postorderTraversal(Node node) {
//        List<Integer> result = new ArrayList<>();
//        if (node == null) {
//            return result;
//        }
//        Stack<Node> stack = new Stack<>();
//        Node current = node;
//
//        while (current != null || !stack.isEmpty()) {
//            if (current != null) {
//                stack.push(current);
//                current = current.left;
//            } else {
//                Node temp = stack.peek().right;
//                if (temp == null) {
//                    temp = stack.pop();
//                    result.add(temp.data);
//                    while (!stack.isEmpty() && temp == stack.peek().right) {
//                        temp = stack.pop();
//                        result.add(temp.data);
//                    }
//                } else {
//                    current = temp;
//                }
//            }
//        }
//        return result;
//    }
//   static TreeMap<Integer,List<Integer>> tmap = new TreeMap<>();
//    static void function(Node root,int dist){
//        if (root == null)return;
//        List<Integer> list = tmap.getOrDefault(dist,new LinkedList<>());
//        list.add(root.data);
//        tmap.put(dist,list);
//        function(root.left,dist - 1);
//        function(root.right,dist + 1);
//    }
//       static HashMap<Node,Node> map = new HashMap<>();
//    static void childParentMap(Node root){
//        if (root == null)return;
//        if (root.left != null)map.put(root.left,root);
//        if (root.right != null)map.put(root.right,root);
//        childParentMap(root.left);
//        childParentMap(root.right);
//    }
//    public static List<Integer> distanceK(Node root, Node target, int k) {
//        List<Integer> list = new LinkedList<>();
//        Queue<Node> q = new LinkedList<>();
//        HashSet<Node> set =new HashSet<>();
//        childParentMap(root);
//        q.add(target);
//        while (k > 0 ){
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                Node temp = q.poll();
//                if (temp.left != null && !set.contains(temp.left)){
//                    q.add(temp.left);
//                }
//                if (temp.right != null && !set.contains(temp.right)){
//                    q.add(temp.right);
//                }
//                if (map.containsKey(temp)){
//                    Node papa = map.get(temp);
//                    if (!set.contains(papa)){
//                        q.add(papa);
//                    }
//                }
//                set.add(temp);
//            }
//           k--;
//        }
//        int size = q.size();
//        for (int i = 0; i < size; i++) {
//            list.add(q.poll().data);
//        }
//        return list;
//    }
//    static int leftHeight(Node root){
//        int count = 0;
//        while (root != null){
//            count++;
//            root = root.left;
//        }
//        return count;
//    }
//    static int rightHeight(Node root){
//        int count = 0;
//        while (root != null){
//            count++;
//            root = root.right;
//        }
//        return count;
//    }
//    static int numberOfNodes(Node root){
//        if (root == null)return 0;
//        int left = leftHeight(root);
//        int right = rightHeight(root);
//        if (left == right)return (2 << (left-1)) - 1;
//        return 1 + numberOfNodes(root.left) + numberOfNodes(root.right);
//    }
//    static Node mainFunction(int[] inOrder,int[] postOrder){
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < inOrder.length; i++) {
//            map.put(inOrder[i],i);
//        }
//        Node root = helper(inOrder,0,inOrder.length - 1,postOrder,0,postOrder.length - 1,map);
//        return root;
//    }
//    static Node helper(int[] inOrder,int inStart,int inEnd,int[] postOrder,int postStart,int postEnd,HashMap<Integer,Integer> map){
//        if (inStart > inEnd || postStart > postEnd)return null;
//        Node root = new Node(postOrder[postEnd]);
//        int inRoot = map.get(root.data);
//        int leftArraySize = inRoot - inStart;
//        root.left = helper(inOrder,inStart,inRoot - 1,postOrder,postStart ,postStart + leftArraySize - 1,map);
//        root.right = helper(inOrder,inRoot + 1,inEnd,postOrder,postStart + leftArraySize,postEnd - 1,map);
//        return root;
//    }
    static StringBuilder treeToStringBuilder(Node root){
        Queue<Node> q = new LinkedList<>();
        StringBuilder st = new StringBuilder();
        if (root == null)return st;
        q.add(root);
       while (!q.isEmpty()){
           int size = q.size();
           for (int i = 0; i < size; i++) {
           Node currentNode = q.poll();
               if (currentNode == null)st.append("null,");
               else {
                   q.add(currentNode.left);
                   q.add(currentNode.right);
                   st.append(currentNode.data+",");
               }
           }
       }
       st.deleteCharAt(st.length() - 1);
       return st;
    }
    public static void main(String[] args) {
//        int[][] array = new int[2][3];
//        List<Integer> l1 = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            l1.add(i);
//        }
//        List<List<Integer>> ll = new ArrayList<>();
//
//        List<Integer> l2 = new ArrayList<>();
//        for (int i = 3; i < 6; i++) {
//            l2.add(i);
//        }
//        List<Integer> l3 = new ArrayList<>();
//        for (int i = 6; i < 9; i++) {
//            l3.add(i);
//        }
//       ll.add(l1);
//        ll.add(l2);
//        ll.add(l3);
////        System.out.println(ll);
//        Stack<Node> q = new Stack<>();
//        q.push(null);
//        q.push(null);
//        System.out.println(q.size());
////        q.remove();
//        int x = 2;
//        Stack<KeyPair> stack = new Stack<>();
//        Stack<nodeWithFrequency> st = new Stack<>();
//        Node root = new Node(1);
//        nodeWithFrequency o1 = new nodeWithFrequency(root,1);
//        st.push(o1);
//        nodeWithFrequency o2 = new nodeWithFrequency(root,2);
//        st.push(o2);
//        System.out.println(st.size());
//        System.out.println(o1.frequency);
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        Node g = new Node(8);
        Node h = new Node(9);
        Node i = new Node(10);
        Node j = new Node(11);
        Node k = new Node(12);
        Node l = new Node(13);
        Node m = new Node(14);
        Node n = new Node(15);
        c.left = g;
        c.right = h;
        d.left = i;
        d.right = j;
        e.left = k;
        e.right = l;
        f.left = m;
        f.right = n;
//        System.out.println(height(root.left) - height(root.right));
//        List<Integer> l = new LinkedList<>();
//        System.out.println(l);
//       l.add(0,5);
//        l.add(0,6);
//        l.add(0,1);
//        l.sort(Comparator.naturalOrder());
//        System.out.println(l);
//        l.sort(Comparator.reverseOrder());
//        System.out.println(l);

//        for (int i = l.size() - 1; i >= 0; i--) {
//            System.out.print(l.get(i)+" ");
//        }
//        ArrayList<Integer> al = new ArrayList<>();
//        al.add(1);
//        al.add(2);
//        al.add(3);
//        if(!(root.left == null && root.right == null)){
//            System.out.println("root is not leaf node");
//        }
//        else System.out.println("root is a leaf node");

//        void changeTree(BinaryTreeNode < int > * root) {
//            // Write your code here.
//            if(root==NULL || (root->left == NULL && root->right == NULL))
//                return;
//            int child=0;
//
//            if(root->left)
//                child+=root->left->data;
//            if(root->right)
//                child+=root->right->data;
//
//            //we make sure that while going down the child has no shortage
//            if(child < root->data)
//            {
//                if(root->left)
//                {
//                    root->left->data=root->data;
//                }
//                if(root->right)
//                {
//                    root->right->data=root->data;
//                }
//            }
//
//            changeTree(root->left);
//            changeTree(root->right);
//
//            //while going back up
//            int tot=0;
//            if(root->left)
//                tot+=root->left->data;
//            if(root->right)
//                tot+=root->right->data;
//            root->data=tot;
//
//        }
//        function(root,0);
//        System.out.println(tmap);
////        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
////        Queue<Integer> pq = new LinkedList<>();
//        pq.add(4);
//        pq.add(2);
//        pq.add(3);
//        pq.add(5);
//        pq.add(1);
//        pq.add(7);
//            System.out.println(pq.remove());
//            TreeMap<Integer,Integer> map = new TreeMap<>();
//            map.put(3,5);
//            map.put(1,6);
//            map.put(2,7);
//            List<Integer> list = new LinkedList<>();
//            for (int x : map.values()){
//                list.add(x);
//            }
//            System.out.println(list);
//childParentMap(root);
//        System.out.println(map);
//        System.out.println(distanceK(root,b,1));
//        System.out.println(leftHeight(root));
//        System.out.println(numberOfNodes(root));
//        System.out.println(treeToStringBuilder(root));
//        StringBuilder st = new StringBuilder();
//        System.out.println(st.append("a"));
//        System.out.println(st.append(1+","+"a"));
//        System.out.println(1+",");
//        st.deleteCharAt(3);
//        System.out.println(st);
       String s = "a,b,c,d,e,z";
      String []array =  s.split(",");
        for (int o = 0; o < array.length; o++) {
            System.out.print(array[o]);
        }
        System.out.println();
        String x = array[1];
        System.out.println(x);
        System.out.println(array[4]);
        System.out.println(array[5].equals("z"));
List<Integer> list = new LinkedList<>();
    }
}