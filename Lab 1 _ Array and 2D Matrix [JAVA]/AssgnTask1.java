//Assignment Task 01: Container with Most Water
class AssgnTask1{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static void mostWater( Integer[] height ){

        int maxHeight1 = 0;
        int maxHeight2 = 0;
        int idx1 = 0;
        int idx2 = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i] > maxHeight1){
                maxHeight1 = height[i];
                idx1 = i;
            }
        }
        for(int i = 0; i < height.length; i++){
            if(height[i] != maxHeight1){
                if(height[i] > maxHeight2){
                    maxHeight2 = height[i];
                    idx2 = i;
                }
            }
        }
        int length = idx2 - idx1;
        int breadth = 0;
        if(maxHeight2 > maxHeight1){
            breadth = maxHeight1;
        }
        else{
            breadth = maxHeight2;
        }
        System.out.println(length*breadth);

    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println("Given Array: ");
        Arr.print(array);
        System.out.println("\nExpected Output:");
        System.out.print("49");
	System.out.print("\nYour Output:\n");
        mostWater( array );

    }
}
