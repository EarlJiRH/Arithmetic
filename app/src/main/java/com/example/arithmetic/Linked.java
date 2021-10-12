package com.example.arithmetic;

/**
 * ================================================
 * 类名：com.example.arithmetic
 * 时间：2021/10/11 13:47
 * 描述：链表操作的算法示例
 * 修改人：
 * 修改时间：
 * 修改备注：
 * ================================================
 *
 * @author Admin
 */
public class Linked {


    /**
     * @author Admin
     * @date 2021/10/11 13:54
     * https://leetcode-cn.com/problems/reverse-linked-list/
     * 206. 反转链表
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */
    public static ListNode reverseList(ListNode head) {
        //主体思路:注意单链表尾部指向null(next->null)
        //需要添加一个中间变量 last 节点

        ListNode last = null;
        //改每条边 所以需要访问链表
        while (head != null) {
            ListNode nextHead = head.getNext();
            //改一条边
            head.setNext(last);
            //last,head 向后移动一位
            last = head;
            head = nextHead;
        }
        return last;
    }


    /**
     * @author Admin
     * @date 2021/10/11 15:11
     * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
     * 25. K个一组翻转链表
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。
     * <p>
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        //创建保护点 防止null.getNext()情况下抛出异常
        ListNode protect = new ListNode(0, head);
        //last=上一组结尾
        ListNode last = protect;
        //分组(找到每一组的开始、结尾)，按组遍历
        while (head != null) {
            //1.反转一组
            //2.
            ListNode endNode = getEndNode(head, k);
            if (endNode == null) {
                break;
            }

            //下一组的head
            ListNode nextGroupHead = endNode.getNext();
            //处理head到end之间的k-1条边的反转
            reverseList(head, endNode);
            //上一组跟本组的新开始(旧end)建立联系
            last.setNext(endNode);
            //本组的新结尾(head)跟下一组建立联系
            head.setNext(nextGroupHead);

            //分组遍历
            last = head;
            head = nextGroupHead;
        }

        return protect.getNext();
    }

    /**
     * @author Admin
     * @date 2021/10/11 15:39
     * 获取k个跨步 单向链表上的最后一个节点
     */
    private static ListNode getEndNode(ListNode head, int k) {
        while (head != null) {
            k--;
            if (k == 0) {
                break;
            }
            head = head.getNext();
        }
        return head;
    }

    /**
     * @author Admin
     * @date 2021/10/11 15:20
     * 处理组内的单向链表翻转
     */
    private static void reverseList(ListNode head, ListNode end) {
        if (head == end) {
            return;
        }
        ListNode last = head;
        head = head.getNext();
        //改每条边 所以需要访问链表
        while (head != end) {
            ListNode nextHead = head.getNext();
            //改一条边
            head.setNext(last);
            //last,head 向后移动一位
            last = head;
            head = nextHead;
        }
        end.setNext(last);
    }


    /**
     * @author Admin
     * @date 2021/10/11 15:38
     * https://leetcode-cn.com/problems/linked-list-cycle/
     * 141. 环形链表
     * 给定一个链表，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。
     * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     *
     * 进阶：
     * 你能用 O(1)（即，常量）内存解决此问题吗？
     */

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.getNext();
        while (slow != fast) {
            if (fast == null || fast.getNext() == null) {
                return false;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return true;
    }
}


