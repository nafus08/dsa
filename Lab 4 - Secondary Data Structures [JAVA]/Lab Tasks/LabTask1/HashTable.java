/*You will have to complete the FruitNode Contrustor first
 then within this class you only have to complete two methods
 hashFunction() and insert()
 the rest of the metods are already written
 DO NOT TOUCH any other methods or codes*/
public class HashTable {

    //ht[] :: is the HashTable array that stores the FruitNode objects
    private FruitNode[] ht;

    //Constructor that initializes the HashTable array
	//DO NOT change this Constructor
    public HashTable(int size){
        this.ht = new FruitNode[size];
    }
    
    //This method basically prints the HashTable
    //DO NOT change this method
    public void show(){
        for(int i=0; i<ht.length; i++){
            System.out.print( i+" " );
            FruitNode n = ht[i];
            while (n!=null){
                System.out.print("('"+n.fruit[0]+"', "+n.fruit[1]+") --> ");
                n = n.next;
            }
            System.out.println();
        }
    }

    //you need to COMPLETE this method
    private int hashFunction( String key ){
        
        int sum = 0;
        int len = key.length();

        for (int i = 0; i < len; i++) {
            if ((len % 2 == 0 && i % 2 == 0) || (len % 2 != 0 && i % 2 != 0)) {
                sum += key.charAt(i);
            }
        }

        return sum % ht.length;

    }

    //you need to COMPLETE this method
    //The insert() method will create a FruitNode using name(Key) & price(value)
	//then inserts it in the proper hashed index
    //If collision occurs resolve using the steps explained in the question
    public void insert(String key, Integer value){
        
        int index = hashFunction(key);
        FruitNode head = ht[index];

        // Check if key exists, update if found
        FruitNode current = head;
        while (current != null) {
            if (((String) current.fruit[0]).equals(key)) {
                current.fruit[1] = value;
                return;
            }
            current = current.next;
        }

        // Insert in descending order by value
        FruitNode newNode = new FruitNode(key, value);
        if (head == null || value > (Integer) head.fruit[1]) {
            newNode.next = head;
            ht[index] = newNode;
        } else {
            FruitNode prev = null;
            current = head;
            while (current != null && (Integer) current.fruit[1] >= value) {
                prev = current;
                current = current.next;
            }
            prev.next = newNode;
            newNode.next = current;

    }

}
}