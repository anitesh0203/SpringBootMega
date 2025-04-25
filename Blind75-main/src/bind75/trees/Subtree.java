package bind75.trees;

import java.util.List;

public class Subtree {


    public boolean test(TreeNode root, TreeNode subroot) {
        if(root.val != subroot.val) {
            return  false;
        }
        test(root.left, subroot.left);
        test(root.right, subroot.right);

        return true;
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        TreeNode ans = null;
        findNode(root, subRoot, ans);
        if(ans == null) {
            return false;
        } else {
            return test(ans, subRoot);
        }
    }

    private void findNode(TreeNode root, TreeNode subRoot, TreeNode ans) {
        if(root == null) {
            return;
        }
        if(root.val == subRoot.val) {
            ans = root;
        }
        findNode(root.left, subRoot, ans);
        findNode(root.right, subRoot,ans);
    }
}
