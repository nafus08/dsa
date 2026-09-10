//Lab Task 03: Decryption Process
class LabTask3{

    //Complete this method so that it gives the Expected Output
    public static Integer[] decryptMatrix( Integer[][] matrix ){

        Integer [] sumOfArr = new Integer [matrix[0].length];
        Integer [] ansArr = new Integer [sumOfArr.length - 1];
        Integer col = matrix[0].length;
        Integer row = matrix.length;
        for(int i = 0; i < col; i++){
            int sum = 0;
            for(int j = 0; j < row; j++){
                sum += matrix[j][i];
            }
            sumOfArr[i] = sum;
        }
        for(int i = 0; i < ansArr.length; i++){
            ansArr[i] = sumOfArr[i+1] - sumOfArr[i];
        }
        return ansArr;

    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
            {1,3,1},
            {6,4,2},
            {5,1,7},
            {9,3,3},
            {8,5,4}
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        System.out.println("\nExpected Output:\n[ -13 1 ]");
        Integer[] returned_val_1 = decryptMatrix( matrix );
        System.out.print("\nYour Output:\n");
        Arr.print(returned_val_1);

    }
}