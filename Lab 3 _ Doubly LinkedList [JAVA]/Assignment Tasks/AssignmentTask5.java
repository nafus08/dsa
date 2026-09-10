public class AssignmentTask5 {

    //SUBMIT ONLY THIS METHOD
    public static void sumOddAppend(Node dh) {
        
        Node n = dh.next;
        Node before = dh;
        Node after = n.next;
        int num = 0;
        int sum = 0;
        while(after != dh){
            num = (int) n.elem;
            if(num % 2 != 0){
                sum += num;
                n.next = null;
                before.next = null;
                before.next = after;
                if(after.next != null){
                n = after;
                after = after.next;
                }
                else{
                    n.next = dh;
                }
            }
            else{
                before = before.next;
                n = n.next;
                after = after.next;
            }
        }
        Node newNode = new Node(sum);
        n.next = null;
        n.next = newNode;
        newNode.next = dh;

    }

    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] values = {11, 22, 33, 44, 55, 66};
        Node head = LinkedListHelpers.createDummyHeadedSinglyCircularLL(values, true);

        System.out.println("Given Linked List:");
        LinkedListHelpers.printDummyHeadedSinglyCircularLL(head);
        System.out.println("\nExpected Output:");
        Object[] expected = {22, 44, 66, 99};
        Node expectedHead = LinkedListHelpers.createDummyHeadedSinglyCircularLL(expected, true);
        LinkedListHelpers.printDummyHeadedSinglyCircularLL(expectedHead);
        
        //Running the Sum Odd Append
        sumOddAppend(head);
        //Printing after Sum Odd Append
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedSinglyCircularLL(head);
    }
}
