class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        int maxValue = 0;

        for (ListNode list : lists) {
            ListNode current = list;
            while (current != null) {
                if (current.val > maxValue) {
                    maxValue = current.val;
                }
                current = current.next;
            }
        }

        int smallest = 0;

        for(ListNode list : lists){
            ListNode current = list;
            while(current != null){
                if(current.val < smallest){
                    smallest = current.val;
                }
                current = current.next;
            }
        }

        ListNode head = new ListNode(0, new ListNode(0));
        ListNode defaultNode = head.next;
        int match = smallest;
        for(int j = smallest; j <= maxValue; j++) {
            for (ListNode list : lists) {
                ListNode current = list;
                while (current != null) {
                    if (current.val == match) {
                        defaultNode.next = new ListNode(current.val);
                        defaultNode = defaultNode.next;
                    }
                    current = current.next;
                }
            }
            match++;
        }
        return head.next.next;
    }
}
