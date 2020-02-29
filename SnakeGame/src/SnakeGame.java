public class SnakeGame {
    //attributes
    private boolean[][] game;
    private int[] headPosition = new int[2];
    private static int exhaustiveChecks;
    private static int recursiveChecks;
    //constructors
    //constructor that makes a empty 1x1 board
    public SnakeGame() {
        game = new boolean[1][1];
    }
    // i had jessie olivas help me with this part.this constructor take a 2D array that is boolean and the position of x and y of the snakes head
    public SnakeGame(boolean[][] A, int x, int y) {
        headPosition= new int[2];
        game = new boolean[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[i].length; k++) {
                game[i][k] = A[i][k];
            }
        }
        headPosition[0] = x;
        headPosition[1] = y;
    }
    //methods
    //this method should return where x and y are in the board
    public int[] findTailExhaustive() {
        resetCounters();
        int[] t = new int[3];
        int snakeLength = 0;
        // used a for loop to check  where the snake is at or
        // which position the snake is.
        for (int i = 0; i < game.length; i++) {
            for (int k = 0; k < game[i].length; k++) {
                exhaustiveChecks++;
                if (game[i][k]) {
                    snakeLength++;
                    if (neighbors(i, k) == 1 && headPosition[0] != i || headPosition[1] != k) {
                        t[0] = i;
                        t[1] = k;
                    }
                }
            }
        }
        t[2] = snakeLength;
        return t;
    }
    public int[] findTailRecursive() {
        //used encapsulation to return the x and y position and its length.
        resetCounters();
        int[] t = findTailRecursive(headPosition, headPosition);
        int[] snakeTail = new int[3];
        snakeTail[0] = t[0];
        snakeTail[1] = t[1];
        snakeTail[2] = length();
        return snakeTail;
    }
//allows the snake to move up, down, left, right.
    public int neighbors(int r, int c) {
        int count = 0;
        //right
        if (c + 1 != game.length && game[r][c + 1]) {
            count++;
        }
        //left
        if (c - 1 > 0 && game[r][c - 1]) {
            count++;
        }
        //bottom
        if (r + 1 !=game.length && game[r + 1][c]) {
            count++;
        }
        //top
        if (r - 1 > 0 && game[r - 1][c]) {
            count++;
        }
        return count;
    }
    public int length(){
        int count = 0;
        for (boolean[] booleans : game) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    count++;
                }
            }
        }
        return count;
    }
    private int [] findTailRecursive(int [] currentPosition, int [] previousPosition){
        int[] afterPosition = new int[2];
        afterPosition[0] = currentPosition[0];
        afterPosition[1] = currentPosition[1];
        //diana valles and jessie olivas had helped me with this part.
        if((afterPosition[0] == headPosition[0] && afterPosition[1] != headPosition[1])||(afterPosition[0] != headPosition[0] && afterPosition[1] == headPosition[1])|| ((afterPosition[0] != headPosition[0] && afterPosition[1] != headPosition[1]) && neighbors(afterPosition[0],afterPosition[1]) == 1)){
            if(neighbors(afterPosition[0],afterPosition[1]) == 1) {
                recursiveChecks++;
                return currentPosition;
            }
        }
        if((currentPosition[0] + 1 < game.length) && (currentPosition[0] + 1 != previousPosition[0]) && (game[currentPosition[0] + 1][currentPosition[1]])){
                    afterPosition[0] = currentPosition[0] + 1;
                    afterPosition[1] = currentPosition[1];
                    recursiveChecks++;
                    return findTailRecursive(previousPosition, currentPosition);
                }
        if((currentPosition[0] - 1 >= 0) && (currentPosition[0] - 1 != previousPosition[0]) && (game[currentPosition[0] - 1][currentPosition[1]])) {
                    afterPosition [0] = currentPosition[0] - 1;
                    afterPosition [1] = currentPosition[1];
                    recursiveChecks++;
                    return findTailRecursive(afterPosition, currentPosition);
                }
        if((currentPosition[1] + 1 < game.length) && (currentPosition[1] + 1 != previousPosition[1])&& (game[currentPosition[0]][currentPosition[1] + 1])){
                    afterPosition[0] = currentPosition[0];
                    afterPosition[1] = currentPosition[1] + 1;
                    recursiveChecks++;
                    return findTailRecursive(afterPosition, currentPosition);
                }
        if((currentPosition[1] - 1 >= 0) && (currentPosition[1] - 1 != previousPosition[1]) && (game[currentPosition[0]][currentPosition[1] - 1])){
                    afterPosition[0] = currentPosition[0];
                    afterPosition[1] = currentPosition[1] - 1;
                    recursiveChecks++;
                    return findTailRecursive(afterPosition, currentPosition);
                }
        return new int[]{currentPosition[0], currentPosition[1], 1};
        }
        private void resetCounters(){
        recursiveChecks = 0;
        exhaustiveChecks = 0;

    }
    private static int getRecursiveChecks(){
        return recursiveChecks;

    }
    private static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }
}
