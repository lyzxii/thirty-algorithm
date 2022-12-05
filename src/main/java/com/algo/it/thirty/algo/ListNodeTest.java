package com.algo.it.thirty.algo;

import com.algo.it.thirty.base.ListNode;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月11日
 * @since: 1.0.0
 */
public class ListNodeTest {
    public static void main(String[] args) {

    }

    /**
     * $$反转链表$$
     *
     *
     *
     *
     * */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    public ListNode add(ListNode l1, ListNode l2, int bit) {
        if (l1 == null && l2 == null && bit == 0) {
            return null;
        }
        int val = bit;
        if (l1 != null) {
            val += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            val += l2.val;
            l2 = l2.next;
        }
        ListNode node = new ListNode(val % 10);
        node.next = add(l1, l2, val / 10);
        return node;
    }

    /**
     * $$ 合并2个有序链表 $$
     *
     * */
    public ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
        if(l1 ==null){
            return l2;
        }

        if(l2 ==null){
            return l1;
        }

        if(l1.val < l2.val){
            l1.next = mergeTwoLists01(l1.next, l2);
            return l1;
        }else{
            l2.next =mergeTwoLists01(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(-1);
        ListNode pre = listNode;
        if(l1 != null && l2!= null ){
            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;

            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 ==null? l2:l1;
        return listNode.next;
    }





    public ListNode mergeTwoLists22(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}


