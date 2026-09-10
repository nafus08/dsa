// Complete the subtractSummation method
//ASSIGNMENT TASK MUST SUBMIT
public class Task5 {

    //===================================TASK#5===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer subtractSummation( BTNode root ){
        
        Integer sum = 0;
        sum = leftSum(root.left, 0) - rightSum(root.right, 0);
        return sum;
        
    }

    private static Integer leftSum(BTNode root, Integer sum){

        if(root == null){
            return 0;
        }
        sum = (Integer) root.elem + leftSum(root.left, sum) + rightSum(root.right, sum);
        return sum;

    }

    private static Integer rightSum(BTNode root, Integer sum){

        if(root == null){
            return 0;
        }
        sum = (Integer) root.elem + rightSum(root.left, sum) + rightSum(root.right, sum);
        return sum;

    }
    //============================================================================

}