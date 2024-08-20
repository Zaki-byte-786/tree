import java.util.*;
public class right_And_LeftViewOfBinaryTree {
    static List<Integer> rightView(Node root){
        List<Integer> list = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        boolean flag = true;
        q.add(root);
        if (root == null)return list;
        while (!q.isEmpty()){
            int elementAtEachLevel = q.size();
            for (int i = 0; i < elementAtEachLevel; i++) {
            Node temp = q.remove();
            if (temp.right != null)q.add(temp.right);
            if (temp.left != null)q.add(temp.left);
            if (flag){
                list.add(temp.data);
                flag = false;
            }
            }
flag = true;
        }
        return list;
    }

// rightView using Recursion

    List<Integer> list = new LinkedList<>();
    void helper(Node root,int level){
        if(root == null)return;
        if(level == list.size())list.add(root.data);
        helper(root.right,level + 1);
        helper(root.left,level + 1);
    }
    public List<Integer> rightSideView(Node root) {
        helper(root,0);
        return list;
    }


    static List<Integer> leftView(Node root){
        List<Integer> list = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        boolean flag = true;
        q.add(root);
        if (root == null)return list;
        while (!q.isEmpty()){
            int elementAtEachLevel = q.size();
            for (int i = 0; i < elementAtEachLevel; i++) {
                Node temp = q.remove();
                if (temp.left != null)q.add(temp.left);
                if (temp.right != null)q.add(temp.right);
                if (flag){
                    list.add(temp.data);
                    flag = false;
                }
            }
            flag = true;
        }
        return list;
    }

    // rightView using Recursion

    List<Integer> list2 = new LinkedList<>();
    void helper2(Node root,int level){
        if(root == null)return;
        if(level == list2.size())list2.add(root.data);
        helper2(root.left,level + 1);
        helper2(root.right,level + 1);
    }
    public List<Integer> leftSideView(Node root) {
        helper(root,0);
        return list;
    }
    public static void main(String[] args) {

    }
}
