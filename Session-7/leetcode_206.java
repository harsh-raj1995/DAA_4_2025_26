/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        List<Integer> l = new ArrayList<>();
        int n=0;
        ListNode temp= head;
        while(temp!=null){
            l.add(temp.val);
            n++;
            temp=temp.next;
        }
        temp=head;
        for(int i=n-1;i>-1;i--){
            temp.val=l.get(i);
            temp=temp.next;
        }
        return head;
    }
}