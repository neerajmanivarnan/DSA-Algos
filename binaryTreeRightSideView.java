class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q =  new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){

            int currentLevelSize = q.size();

            for(int i=0;i<currentLevelSize;i++){
                TreeNode currentNode = q.poll();
                if(i == currentLevelSize-1) result.add(currentNode.val);
                if(currentNode.left != null) q.offer(currentNode.left);
                if(currentNode.right != null) q.offer(currentNode.right);
            }

        }

        return result;
    }
}
