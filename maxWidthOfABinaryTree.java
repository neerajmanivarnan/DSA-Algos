class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> q =  new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            
            int size = q.size();
            TreeNode current = q.offer();

            
        }
    }
}
