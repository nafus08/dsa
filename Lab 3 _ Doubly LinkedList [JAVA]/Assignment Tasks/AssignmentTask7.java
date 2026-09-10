public class AssignmentTask7 {

    //SUBMIT ONLY THIS METHOD
 
    public static void rangeMove(DNode dh, int start, int end) {
        DNode n = dh.next;
        DNode last = dh.prev;
        DNode referLast = dh.prev;
        while (n != dh) {
            if (n == referLast.next) {
                break;
            }
            DNode after = n.next;
            DNode before = n.prev;
            int num = (int) n.elem;
            for (int i = start; i <= end; i++) {
                if (num == i) {
                    before.next = n.next;
                    after.prev = n.prev;
                    n.prev = last;
                    n.next = dh;
                    last.next = n;
                    dh.prev = n;
                    last = n;
                    break;
                }
            }
            n = after;
        }
    }
    
    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] values = {5, 3, 7, 1, 9, 6, 2, 4};
        DNode dh = LinkedListHelpers.createDummyHeadedDoublyLL(values, true);

        System.out.println("Given Linked List:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);

        System.out.println("\nExpected Output:");
        Object[] expected = {3, 1, 9, 2, 4, 5, 7, 6};
        DNode expectedHead = LinkedListHelpers.createDummyHeadedDoublyLL(expected, true);
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(expectedHead);
        
        //Running the Range Move with [5,7] range 
        rangeMove(dh, 5, 7);
        //Printing after Range Move
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);
    }
}
