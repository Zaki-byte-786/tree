import java.util.*;
public class boundaryTraversalOfBinaryTree {
    static void leftBoundary(Node node,ArrayList<Integer> arrayList){
        Node currentNode = node.left;
        while (currentNode != null){
            if (currentNode.left != null || currentNode.right != null)arrayList.add(currentNode.data);
            if (currentNode.left != null)currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }
    }
    static void rightBoundary(Node node,ArrayList<Integer> arrayList){
        Node currentNode = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (currentNode != null){
            if (currentNode.left != null || currentNode.right != null)temp.add(currentNode.data);
            if (currentNode.right != null)currentNode = currentNode.right;
            else currentNode = currentNode.left;
        }
        for (int i = temp.size() - 1; i >= 0 ; i--) {
            arrayList.add(temp.get(i));
        }
    }
    static void leafNodeBoundary(Node node,ArrayList<Integer> arraylist){
        if (node.left == null && node.right == null){
            arraylist.add(node.data);
            return;
        }
        if (node.left != null) leafNodeBoundary(node.left,arraylist);
        if (node.right != null) leafNodeBoundary(node.right,arraylist);
    }
    static ArrayList<Integer> method(Node node){
        ArrayList<Integer> al = new ArrayList<>();
        if(node.left != null || node.right != null)al.add(node.data);
        leftBoundary(node,al);
        leafNodeBoundary(node,al);
        rightBoundary(node,al);
        return al;
    }
    public static void main(String[] args) {

    }
}
