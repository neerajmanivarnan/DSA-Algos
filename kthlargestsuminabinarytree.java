/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {

        if (root == null) return 0;

        PriorityQueue<Long> array = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<TreeNode> q =  new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            long sum = 0;

            for(int i=0;i<size;i++){
                TreeNode current = q.poll();
                sum+= current.val;

                if(current.left != null) q.offer(current.left);
                if(current.right != null) q.offer(current.right);

            }

            array.add(sum);

        }

        long maxVal = 0 ;

        if(k > array.size()) return -1;

        for(int i=0;i<k;i++){
            maxVal = array.poll();
        }

        return maxVal;
        
    }
}
