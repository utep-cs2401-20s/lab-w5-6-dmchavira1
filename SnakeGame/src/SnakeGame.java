public class SnakeGame {
    //attributes
    private boolean[][] game;
    private int[] headPosition = new int[2];
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //constructors
    public SnakeGame() {
        game = new boolean[1][1];
    }

    public SnakeGame(boolean[][] A, int x, int y) {
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[i].length; k++) {
                game[i][k] = A[i][k];
            }
        }
        headPosition[0] = x;
        headPosition[1] = y;

    }

    //methods
    public int[] findTailExhaustive() {
        resetCounters();
        int[] tail = new int[3];
        int length = 0;

        for (int i = 0; i < game.length; i++) {
            for (int k = 0; k < game[i].length; k++) {
                exhaustiveChecks++;
                if (game[i][k]) {
                    length++;
                    if (headPosition[0] != i && headPosition[1] != k && neighbors(i, k) == 1) {
                        tail[0] = i;
                        tail[1] = k;
                        tail[3] = length;
                        return tail;
                    }
                }
            }
        }

        return tail;
    }

    //It will find the tail of the snake by conducting a search starting at the head location and recursively following the snake's body
    //return 3 items: the x and y position of the tail in the grid, and the length of the snake on the board
    public int[] findTailRecursive() {
        resetCounters();
        int[] tail = new int[3];


        return tail;
    }

    /*
        neighbors method:
        computes the number of 'true' neighbors the corresponding cell in the board has
    */

    public int neighbors(int r, int c) {
        int count = 0;
        if ((c + 1 < game.length) && (game[r][c + 1])) {
            count++;
        }
        if (r + 1 < game.length && game[r + 1][c]) {
            count++;
        }
        if (c - 1 >= 0 && c > 0 && game[r][c - 1]) {
            count++;
        }
        if (r - 1 >= 0 && game[r - 1][c]) {
            count++;
        }
        if (r - 1 >= 0 && c + 1 < game.length && game[r - 1][c + 1]) {
            count++;
        }
        if (r + 1 < game.length && c + 1 < game.length && game[r + 1][c + 1]) {
            count++;
        }
        if (r + 1 < game.length && c - 1 >= 0 && game[r + 1][c - 1]) {
            count++;
        }
        if (r - 1 >= 0 && c - 1 >= 0 && game[r - 1][c - 1]) {
            count++;
        }
        return count;
    }

    public int [] findTailRecursion(int [] currentPosition, int [] previousPosition){

    }
    private void resetCounters(){
        recursiveChecks = 0;
        exhaustiveChecks = 0;

    }
    private static int getRecursiveChecks(){

    }
    private static int getExhaustiveChecks(){

    }
}
