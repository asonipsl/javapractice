package dp.tree;

public class MaxPathSum {


    static class Res {
        public int res = Integer.MIN_VALUE;
    }
    static  class Node {
        int data;
        dp.tree.BinaryTreeDiameter.Node left,right;

        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {
        dp.tree.BinaryTreeDiameter.Node root = new dp.tree.BinaryTreeDiameter.Node(10);
        root.left = new dp.tree.BinaryTreeDiameter.Node(2);
        root.right = new dp.tree.BinaryTreeDiameter.Node(10);
        root.left.left = new dp.tree.BinaryTreeDiameter.Node(20);
        root.left.right = new dp.tree.BinaryTreeDiameter.Node(1);
        root.right.left = new dp.tree.BinaryTreeDiameter.Node(-25);
        root.right.left.left = new dp.tree.BinaryTreeDiameter.Node(3);
        root.right.left.right = new dp.tree.BinaryTreeDiameter.Node(4);
/*
                    (10)
                 |      |
               (2)      (10)
             |     |        |
           (20)   (1)      (-25)
                         |     |
                        (3)   (4)
*/
        dp.tree.BinaryTreeDiameter.Res result = new dp.tree.BinaryTreeDiameter.Res();
        result.res = Integer.MIN_VALUE;
        solve(root,result);
        System.out.println("Diameter Of Tree = " + result.res);
    }

    private static int solve(dp.tree.BinaryTreeDiameter.Node root, dp.tree.BinaryTreeDiameter.Res result) {
        if (root == null) {
            return 0;
        }

        int rootVal = root.data;
        int leftSum = solve(root.left,result);
        int rightSum = solve(root.right,result);

        int rootSum = Math.max(leftSum,rightSum) + rootVal;

        int maxRootSum = Math.max(rootSum, (leftSum+rightSum+rootVal));

        result.res = Math.max(result.res,maxRootSum);

        return rootSum;
    }
}

