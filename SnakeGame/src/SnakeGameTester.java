import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SnakeGameTester {
    /* this test is just to see if everything is running up to par and if the code is working.
    and testing one of the images from the read me would allow it to pass.
    TEST STATUS: Passed
    */
    @Test
    public void exhaustiveTest1(){
        boolean[][] game = {
                {false,false,false,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,false,false,false,false}};
        int[] z = {3,2,3};
        SnakeGame t = new SnakeGame(game,1,2);
        assertArrayEquals(z, t.findTailExhaustive());
    }
    /*
    this test was to see what would happen if the game board was smaller and if the snake was diagonal,
     */
    @Test
    public void exhaustiveTest2(){
        boolean[][] game = {
                {false,false,false,},
                {true,true,true,},
                {false,false,false,}};
        int[] z = {1,1,3};
        SnakeGame t = new SnakeGame(game,1,2);
        assertArrayEquals(z, t.findTailExhaustive());
    }
    @Test
    /*
    this test was to see if it can find the tail if it was turning.
     */

    public void exhaustiveTest3(){
        boolean[][] game = {
                {false,false,false,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {false,true,true,false,false},
                {false,false,false,false,false}};
        int[] z = {3,1,4};
        SnakeGame t = new SnakeGame(game,1,2);
        assertArrayEquals(z, t.findTailExhaustive());
    }
    @Test
    /*
    this test was to see if it was able to detect the tail if it was turnt and long
    passed
     */
    public void exhaustiveTest4(){
        boolean[][] game = {
                {false,false,false,false,false},
                {false,false,true,false,false},
                {false,false,true,false,false},
                {true,true,true,false,false},
                {false,false,false,false,false}};
        int[] z = {3,2,5};
        SnakeGame t = new SnakeGame(game,0,1);
        assertArrayEquals(z, t.findTailExhaustive());
    }
    @Test
    /*
    this was to test the tail in a u-shape
     */
    public void exhaustiveTest5(){
        boolean[][] game = {
                {false,false,false,false,false},
                {false,false,false,false,false},
                {false,true,false,true,false},
                {false,true,true,true,false},
                {false,false,false,false,false}};
        int[] z = {3,3,5};
        SnakeGame t = new SnakeGame(game,2,2);
        assertArrayEquals(z, t.findTailExhaustive());
    }
    @Test
    /*
    this test was to see what would happened if it found its tail
     */

    public void recursiveTest1(){
        boolean[][] game = {
                {false,false,false,false,false},
                {false,false,false,false,false},
                {false,false,false,false,false},
                {false,false,false,false,false},
                {true,true,true,true,true}};
        int[] z = {4,1,5};
        SnakeGame t = new SnakeGame(game,4,0);
        assertArrayEquals(z, t.findTailRecursive());
    }
    @Test
    //this test was to see if the method is functioning like its supposed to and see if it work
    public void recursiveTest2(){
        boolean[][] game = {
                {true,false,false,false,false},
                {true,false,false,false,false},
                {true,false,false,false,false},
                {true,false,false,false,false},
                {true,false,false,false,false}};
        int[] z = {1,0,5};
        SnakeGame t = new SnakeGame(game,0,0);
        assertArrayEquals(z, t.findTailRecursive());
    }
    @Test
    // this test was to see if the head is facing towards the head
    public void recursiveTest3(){
        boolean[][] game = {
                {false,false,false,false,false},
                {false,true,true,true,false},
                {false,true,false,true,false},
                {false,false,true,true,false},
                {false,false,true,true,false}};
        int[] z = {4,0,9};
        SnakeGame t = new SnakeGame(game,4,0);
        assertArrayEquals(z, t.findTailRecursive());
    }
    @Test
    // testing if the snake if it was going to be out of bounds
    public void recursiveTest4(){
        boolean[][] game = {
                {true,true,true,true,false},
                {false,false,false,false,false},
                {false,false,false,false,false},
                {false,false,false,false,false},
                {false,false,false,false,false}};
        int[] z = {4,0,4};
        SnakeGame t = new SnakeGame(game,0,0);
        assertArrayEquals(z, t.findTailRecursive());
    }
    @Test
    //this code was to see if the snake would run even if its just new
    public void recursiveTest5(){
        boolean[][] game = {
                {false,false,false,false,false},
                {false,false,false,false,false},
                {false,true,true,true,false},
                {false,false,false,false,false},
                {false,false,false,false,false}};
        int[] z = {2,3,3};
        SnakeGame t = new SnakeGame(game,2,1);
        assertArrayEquals(z, t.findTailRecursive());
    }

    }



