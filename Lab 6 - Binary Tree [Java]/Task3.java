//LAB TASK NO NEED TO SUBMIT
// Complete the sumTree method
public class Task3 {

        //===================================TASK#3===================================
        // This method takes only 1 parameter which is root of the given tree
        // This method returns an Integer
        // At times you may need to typeCast root.elem to Integer
        // You can use extra helper private static methods as per need
        public static Integer sumTree( BTNode root ){
            
            return sumTree_helper(root, 0, 0);

        }

        public static Integer sumTree_helper(BTNode root, Integer lvl, Integer sum){
            
            
            if(root == null){
                return sum;
            }
            if(lvl == 0){
                sum = (Integer) root.elem;
            }
            else{
                sum += (Integer) root.elem % lvl;
            }
            
            sum = sumTree_helper(root.left, lvl+1, sum);
            sum = sumTree_helper(root.right, lvl+1, sum);
            
            return sum;

        }
        //============================================================================

}
