//Assignment Task (must Submit)
// Complete the rangeSum method
public class Task4 {

    //===================================TASK#4======================
    // This method takes only three parameters
    // first one is the root of the given tree
    // second one the low range and third one is high range
    // You can use extra helper private static methods as per need
    public static Integer rangeSum( BSTNode root, Integer low, Integer high ){
        
        int sum = 0;
        return rangeSum_helper(root, low, high, sum);

    }

    private static Integer rangeSum_helper(BSTNode root, Integer low, Integer high, int sum){
        
        if(root == null){
            return sum;
        }
        if((int) root.elem >= low && (int) root.elem <= high){
            sum += (int) root.elem;
        }
        if((int) root.elem >= low){
            sum += rangeSum_helper(root.left, low, high, 0);
        }
        if((int) root.elem <= high){
            sum += rangeSum_helper(root.right, low, high, 0);
        }
        return sum;
        
    }
    //===============================================================


}
