import javax.swing.tree.TreeNode;
import java.util.Stack;

//https://leetcode.com/problems/symmetric-tree/description/
public class task3 {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            TreeNode q = stack.pop();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null) return false;

            if (p.val != q.val) return false;

            stack.push(p.left);
            stack.push(q.right);

            stack.push(p.right);
            stack.push(q.left);
        }
        return true;
    }
}