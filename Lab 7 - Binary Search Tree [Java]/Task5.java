//Assignment Task (must Submit)
// Complete the sumOfLeaves method
public class Task5 {

    //===================================TASK#5======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need
    public static Integer mirrorSum( BSTNode root ){
        
        int sum = 0;
        return mirrorSum_helper(root.left, root.right, sum);

    }

    private static Integer mirrorSum_helper(BSTNode leftside, BSTNode rightside, int sum){

        if(leftside == null || rightside == null){
            return sum;
        }
        sum += (int) leftside.elem + (int) rightside.elem;
        sum = mirrorSum_helper(leftside.left, rightside.right, sum);
        sum = mirrorSum_helper(leftside.right, rightside.left, sum);
        return sum;

    }
    //===============================================================


}
