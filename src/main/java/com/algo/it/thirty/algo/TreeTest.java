package com.algo.it.thirty.algo;

import com.algo.it.thirty.base.TreeNode;
import edu.princeton.cs.algs4.LinkedBag;

import javax.xml.stream.events.StartDocument;
import java.util.*;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月11日
 * @since: 1.0.0
 */
public class TreeTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        root.left = four;
        root.right = six;

        four.left = two;
        four.right = one;
        TreeTest treeTest = new TreeTest();
        List<Integer> preList = treeTest.preOrderIteration(root);
        List<Integer> inList = treeTest.inOrderIteration(root);
        List<Integer> postList = treeTest.postOrderIteration(root);
        System.out.println(preList);
        System.out.println(inList);
        System.out.println(postList);

        treeTest.preOrderRecur(root);
        treeTest.inOrderRecur(root);
        treeTest.postOrderRecur(root);

        System.out.println("---");

        List<Integer> cex = cex(root);
        System.out.println(cex);

        List<List<Integer>> lists = cexArr(root);
        System.out.println(lists);

        TreeNode treeNode = transferMirror(root);
        System.out.println(treeNode);

    }


    /**
     * 二叉树前序 根左右
     * 压栈-弹出-保存-有子节点处理子节点右左压栈。继续循环
     */
    public List<Integer> preOrderIteration(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.right != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     * 二叉树中序 左根右
     * 先压入所有左节点，然后开始弹出，弹出后如果存在后节点，压入右节点
     */
    public List<Integer> inOrderIteration(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                //root = node.right;
                stack.push(node.right);
            }
        }
        return result;
    }

    /**
     * 二叉树后序 左右根
     * 从根节点到所有左节点压入，开始弹出，
     * 如果弹出节点有右节点，则操作右节点当作根节点继续压入
     * 如果没有，则保存第一个左节点，然后压出根节点，判断根节点的右节点是否存在，存在则将根节点保存在临时节点，处理右节点,重复上面的
     */
    public List<Integer> postOrderIteration(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //重点：右节点不为空，开始搞右节点
            if (root.right == null || root.right == prev) {
                result.add(root.val);
                prev = root;
                root = null;
            } else {
                //这里会先将根节点放入，后续如果这个节点右节点存在，也不会在处理了
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }

    /*递归遍历*/
    public static void preOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    public static void inOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecur(root.left);
        System.out.print(root.val + " ");
        inOrderRecur(root.right);
    }

    public static void postOrderRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 判断是否是对称的二叉树
     *
     * @param root
     * @return
     */
    public boolean isMirror(TreeNode root) {
        rec(root.left, root.right);
        return flag;
    }

    boolean flag = true;

    public void rec(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            if (!(left == null && right == null)) {
                flag = false;
            }
            return;
        }
        if (left.val != right.val) {
            flag = false;
            return;
        }
        rec(left.left, right.right);
        rec(left.right, right.left);
    }


    public int maxDepth(TreeNode node) {
        int res = 0;
        depth(node, 0);
        return res;
    }

    int res = 0;

    public void depth(TreeNode node, int curDepth) {
        if (node == null) {
            res = Math.max(res, curDepth);
        }
        curDepth++;
        depth(node.left, curDepth);
        depth(node.right, curDepth);
    }

    /**
     * 二叉树的层序遍历
     * offer(E e) 将指定的元素添加到列表的尾部（最后一个元素）。
     * poll() 返回并删除这个列表的第一个元素。
     */
    public static List<Integer> cex(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> link = new LinkedList<>();
        link.add(root);
        while (!link.isEmpty()) {
            TreeNode node = link.poll();
            result.add(node.val);
            if (node.left != null) {
                link.offer(node.left);
            }
            if (node.right != null) {
                link.offer(node.right);
            }
        }
        return result;

    }

    /**
     * 二叉树的层序遍历成数组
     * offer(E e) 将指定的元素添加到列表的尾部（最后一个元素）。
     * poll() 返回并删除这个列表的第一个元素。
     */
    public static List<List<Integer>> cexArr(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> link = new LinkedList<>();
        link.add(root);
        while (!link.isEmpty()) {
            List<Integer> ele = new ArrayList<>();
            int size = link.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = link.poll();
                ele.add(node.val);
                if (node.left != null) {
                    link.offer(node.left);
                }
                if (node.right != null) {
                    link.offer(node.right);
                }
            }
            result.add(ele);
        }
        return result;
    }


    /**
     * 判断一个二叉树是不是另外一个二叉树的子树
     */
    public boolean isSubTree(TreeNode nodeA, TreeNode nodeB) {
        if (nodeA == null || nodeB == null) {
            return false;
        }
        return same(nodeA, nodeB) || isSubTree(nodeA.left, nodeB) || isSubTree(nodeA.right, nodeB);


    }

    public boolean same(TreeNode nodeA, TreeNode nodeB) {
        if (nodeB == null) {
            return true;
        }

        if (nodeA == null) {
            return false;
        }

        if (nodeA.val == nodeB.val) {
            return same(nodeA.left, nodeB.left) && same(nodeA.right, nodeB.right);
        }
        return false;
    }


    /**
     * 输出一个二叉树镜像
     * 层序遍历 + 替换左右节点
     */
    public static TreeNode transferMirror(TreeNode root) {
        TreeNode newRoot = root;
        LinkedList<TreeNode> list = new LinkedList();
        list.add(newRoot);
        while (!list.isEmpty()) {
            TreeNode node = list.poll();
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return newRoot;
    }

    /**
     * 判断二叉树是否是对称的
     */
    public static boolean isSymmetry(TreeNode root) {
        if (root == null) {
            return false;
        }
        return sym(root.left, root.right);
    }

    public static boolean sym(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null && B != null) {
            return false;
        }
        if (A != null && B == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }
        if (A.val == B.val) {
            return sym(A.left, B.right) && sym(A.right, B.left);
        }
        return false;
    }
}
