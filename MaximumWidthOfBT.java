import java.util.LinkedList;
import java.util.Queue;

class Pair{
    Node node;
    int weight;
    Pair(Node node,int weight){
        this.node = node;
        this.weight = weight;
    }
}
public class MaximumWidthOfBT {
    public int widthOfBinaryTree(Node root) {
        if(root == null)return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int first = 0,last = 0;
            for(int i = 0;i < size;i++){
                int idx = q.peek().weight;
                Node node = q.poll().node;
                if(i == 0)first = idx;
                if(i == size - 1)last = idx;
                if(node.left != null)q.add(new Pair(node.left,2 * idx));
                if(node.right != null)q.add(new Pair(node.right,2 * idx + 1));
            }
            ans = Math.max(ans,last - first + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
