import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
//class pair{
//    Node node;
//    int line;
//    pair(Node node,int line){
//        this.node = node;
//        this.line = line;
//    }
//}
// make class pair here we couldn't do it because it is already present in topViewOfBinaryTree
public class bottomViewOfBinaryTree {
    static ArrayList<Integer> function(Node root){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null)return arrayList;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root,0));
        while (!q.isEmpty()){
            pair element = q.remove();
            Node curreentNode = element.node;
            int vertical = element.line;
            map.put(vertical,curreentNode.data);
            if (curreentNode.left != null)q.add(new pair(curreentNode.left,vertical-1));
            if (curreentNode.right != null)q.add(new pair(curreentNode.right,vertical + 1));
        }
        for (int x : map.values()){
            arrayList.add(x);
        }
        return arrayList;
    }
    public static void main(String[] args) {

    }
}
