package com.xig.competition.d20200111.p5164;

/**
 * [未做完]
 *
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 *
 * 删除完毕后，请你返回最终结果链表的头节点。
 *
 *
 *
 * 你可以返回任何满足题目要求的答案。
 *
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 *
 * 示例 1：
 *
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 *
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * 示例 3：
 *
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 *
 * */
public class Solution {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);

		head.next = new ListNode(2);
		head.next.next = new ListNode(-3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(1);

		new Solution().removeZeroSumSublists(head);

		System.out.printf("");
	}

	public ListNode removeZeroSumSublists(ListNode head) {

		while ((head != null) && (head.val == 0)) {
			head = head.next;
		}

		if (head == null || head.next == null) {
			return head;
		}

		int count = 0;
		ListNode ptr = head;
		ListNode next = head.next;

		while (ptr != null) {
			count = ptr.val + next.val;

			while (next != null && next.next != null && count != 0) {
				next = next.next;
				count += next.val;
			}

			if (count == 0) {
				if (ptr == head) {
					head = next.next;
					ptr = head;
					next = ptr.next;
				} else {
					ptr.val = next.next.val;
					ptr.next = next.next;
					ptr = next.next;
					next = ptr.next;
				}
			}

			if (next == null) {
				ptr = ptr.next;
			}
		}
		return head;
	}

}
