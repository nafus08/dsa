//Assignment Task 03: Matrix Compression
class AssgnTask3{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static Integer[][] compressMatrix( Integer[][] matrix ){

        int row = matrix.length;
        int col = matrix[0].length;
        int compressedRow = row / 2;
        int compressedCol = col / 2;
        Integer [][] compressedMatrix = new Integer [compressedRow][compressedCol];
        int elementSum = 0;
        for(int i = 0; i < row; i += 2){
            for(int j = 0; j < col; j += 2){
                elementSum = matrix[i][j] + matrix[i][j+1] + matrix [i+1][j] + matrix[i+1][j+1];
                compressedMatrix[i/2][j/2] = elementSum;
            }
        }
        return compressedMatrix;
        
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
            { 1 , 2 , 3 , 4 },
            { 5 , 6 , 7 , 8 },
            { 1 , 3 , 5 , 2 },
            {-2 , 0 , 6 ,-3 }
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        
        System.out.println("\nExpected Output:");
        System.out.print("| 14 | 22 |\n| 2  | 10 |\n");
        
        System.out.print("\nYour Output:\n");
        Integer[][] returnedArray = compressMatrix( matrix );
        Arr.print2D( returnedArray );
    }
}