// Complete the levelSum method
//ASSIGNMENT TASK MUST SUBMIT
public class Task6 {

    //===================================TASK#6===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer levelSum( BTNode root ){

        int sum = sumCalc(root, 0, 0);
        return sum;

    }

    private static Integer sumCalc(BTNode root, int lvl, int sum){

        if(root == null){
            return sum;
        }
        if(lvl % 2 == 0){
            sum -= (Integer) root.elem;
        }
        else{
            sum += (Integer) root.elem;
        }
        sum = sumCalc(root.left, lvl+1, sum);
        sum = sumCalc(root.right, lvl+1, sum);
        return sum;

    }
    //============================================================================

}
