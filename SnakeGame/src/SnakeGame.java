public class SnakeGame {
    //attributes
    private boolean [][] game;
    private int [] headPosition = new int [2];
    private static int exhaustiveChecks;
    private static int recursiveChecks;
    //constructors
    public SnakeGame(){
        game = new boolean[1][1];
    }
    public SnakeGame(boolean [][] A, int x, int y){
        for(int i = 0; i < A.length;i++ ){
            for(int j = 0; j < A[i].length;j++){
                game[i][j] = A[i][j];
            }
        }
        headPosition [0] = x;
        headPosition [1] = y;

    }
    //methods
    public int [] findTailExhaustive() {


    }
    public int [] findTailRecursion(){
    }
    public int [] findTailRecursion(int [] currentPosition, int [] previousPosition){

    }
    private void resetCounters(){

    }
    private static int getRecursiveChecks(){

    }
    private static int getExhaustiveChecks(){

    }
}
