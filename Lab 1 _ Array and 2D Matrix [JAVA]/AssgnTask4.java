//Assignment Task 04: Game Arena
class AssgnTask4{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static void playGame( Integer[][] arena ){

        int row = arena.length;
        int col = arena[0].length;
        int point = 0;
        int checkRow = 0;
        int checkCol = 0;
        Integer [] rowDirection = {-1, 1, 0, 0};
        Integer [] colDirection = {0, 0, -1, 1};

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if((arena[i][j] != null) && (arena[i][j] % 50 == 0) && (arena[i][j] > 0) ){
                    for(int k = 0; k < 4; k++){
                        checkRow = rowDirection[k] + i;
                        checkCol = colDirection[k] + j;
                        if((checkRow >= 0) && (checkRow < row) && (checkCol >= 0) && (checkCol < col)){
                            if ((arena[checkRow][checkCol] != null) && (arena[checkRow][checkCol] == 2)){
                                point += 2;
                            }
                        }
                    }
                }
            }
        }
        System.out.print("Points gained: " + point + ". ");
        if(point >= 10){
            System.out.println("Your team has survived the game.");
        }
        else{
            System.out.println("Your team is out");
        }

    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] arena = {
            {0,2,2,0},
            {50,1,2,0},
            {2,2,2,0},
            {1,100,2,0}
        };
        System.out.println("Given Arena: ");
        Arr.print2D(arena);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 6. Your team is out.\n");
        
        System.out.print("\nYour Output:\n");
        playGame( arena );

        System.out.print("\n======================\n");

        Integer[][] arena1 = {
            {0,2,2,0,2},
            {1,50,2,1,100},
            {2,2,2,0,2},
            {0,200,2,0,0}
        };
        System.out.println("\nGiven Arena: ");
        Arr.print2D(arena1);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 14. Your team has survived the game.\n");
        
        System.out.print("\nYour Output:\n");
        playGame( arena1 );
    }
}