public class checkIfTwoTreesAreIdenticalOrNot {
    public boolean isSameTree(Node p, Node q) {
        if(p == null || q == null)return p == q;
        boolean selfWork = (p.data == q.data);
        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);
        return selfWork && left && right;
    }
    public static void main(String[] args) {

    }
}
