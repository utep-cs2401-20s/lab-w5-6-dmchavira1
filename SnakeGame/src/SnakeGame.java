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
        headPosition= new int[2];
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
                        tail[2] = length;
                        return tail;
                    }
                }
            }
        }

        return tail;
    }


    public int[] findTailRecursive() {

        resetCounters();
        int[] tail = new int[3];
        for(int i = 0; i < game.length;i++){
            for(int j = 0; j < game[i].length;j++){

            }

        }


        return tail;
    }



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

    return currentPosition;
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
