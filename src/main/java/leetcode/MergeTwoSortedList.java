package leetcode;

import java.util.List;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        MergeTwoSortedList sortedList = new MergeTwoSortedList();
        ListNode list1 = new ListNode(1,null); //124
        ListNode list2 = new ListNode(1,null); //134
        list1.next = new ListNode(2,null);
        list1.next.next = new ListNode(4, null);
        list2.next = new ListNode(3, null);
        list2.next.next = new ListNode(4, null);
        ListNode head = sortedList.mergeTwoLists(list1,list2);
        while (head != null) {
            System.out.print(" -> " + head.val);
            head = head.next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(Integer.MAX_VALUE,null);
        ListNode current = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = new ListNode(list1.val, null);
                list1 = list1.next;
            } else {
                head.next = new ListNode(list2.val, null);
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 == null) {
            head.next = list2;
        } else if (list2 == null) {
            head.next = list1;
        }
        return current.next;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
