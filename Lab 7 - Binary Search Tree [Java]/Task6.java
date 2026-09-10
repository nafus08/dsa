//Assignment Task (must Submit)
// Complete the isBST method
public class Task6 {

    //===================================TASK#6======================
    // This method takes only one parameter
    // it is root of the given tree
    // You can use extra helper private static methods as per need
    public static Boolean isBST( BSTNode root ){
        Boolean bool = true;
        if(root == null){
            return null;
        }
        if(root.right == null && root.left == null){
            return null;
        }
        else if((int) root.left.elem < (int) root.elem){
            isBST(root.left);
        }
        else if((int) root.right.elem > (int) root.elem){
            isBST(root.right);
        }
        else{
            bool = false;
        }
        return bool;

    }
    //===============================================================


}
