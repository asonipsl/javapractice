package dp.tree;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

public class BinaryTreeDiameter {

    static class Res {
        public int res = Integer.MIN_VALUE;
    }
    static  class Node {
        int data;
        Node left,right;

        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }

        public int getData() {
            return this.data;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.left = new Node(-25);
        root.right.left.left = new Node(3);
        root.right.left.right = new Node(4);
/*
                        (10)
                     |      |
                   (2)      (10)
                 |     |        |
               (20)   (1)      (-25)
                             |     |
                            (3)   (4)
 */
        Res result = new Res();
        result.res = Integer.MIN_VALUE;
        solve(root,result);
        System.out.println("Diameter Of Tree = " + result.res);
    }

    private static int solve(Node root, Res result) {
        if (root == null) {
            return 0;
        }

        int rootCount = 1;
        int leftSum = solve(root.left,result);
        int rightSum = solve(root.right,result);

        int rootSum = Math.max(leftSum,rightSum) + rootCount;

        int maxRootSum = Math.max(rootSum, (leftSum+rightSum+rootCount));

        result.res = Math.max(result.res,maxRootSum);

        return rootSum;
    }
}
