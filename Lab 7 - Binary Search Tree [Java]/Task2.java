//Before starting to work on this design the Tree in the Tester code 
// Complete the sumOfLeaves method
public class Task2 {

    //===================================TASK#2===================================
    // This method takes only 2 parameters
    // 1st one is root
    // 2nd one is an Integer
    // You'll need to find the path from the root to a node containing the Integer
    // return the path as a String
    public static String findPath( BSTNode root, Integer key ){
        String str = "";
        if(root == null){
            return "No Path Found";
        }
        if(key == root.elem){
            return "" + key;
        }
        if(key < root.elem){
            str = findPath(root.left, key);
            if(str == "No Path Found"){
                return str;
            }
            else{
                str = (Integer) root.elem +" "+ findPath(root.left, key);
            }
        }
        if(key > root.elem){
            str = findPath(root.right, key);
            if(str == "No Path Found"){
                return str;
            }
            else{
                str = (Integer) root.elem +" "+ findPath(root.right, key);
            }
        }
        return str;
    }
    //============================================================================

}
