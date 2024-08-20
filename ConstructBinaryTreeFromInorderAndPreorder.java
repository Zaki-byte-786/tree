import java.util.HashMap;
public class ConstructBinaryTreeFromInorderAndPreorder {
static Node helper(int[] inOrder,int inStart,int inEnd,int[] preOrder,int preStart,int preEnd,HashMap<Integer,Integer> map){
    if (inStart > inEnd || preStart > preEnd)return null;
    Node root = new Node(preOrder[preStart]);
    int inRoot = map.get(root.data);
    int leftArraySize = inRoot - inStart;
    root.left = helper(inOrder,inStart,inRoot - 1,preOrder,preStart + 1,preStart + leftArraySize,map);
    root.right = helper(inOrder,inRoot + 1,inEnd,preOrder,preStart + leftArraySize + 1,preEnd,map);
    return root;
}
    static Node mainFunction(int[] inOrder,int[] preOrder){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i],i);
        }
        Node root = helper(inOrder,0,inOrder.length - 1,preOrder,0,preOrder.length - 1,map);
        return root;
    }
    public static void main(String[] args) {

    }
}
