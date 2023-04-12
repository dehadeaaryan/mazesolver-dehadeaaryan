import java.io.IOException;
import java.util.Arrays;

//=================================================
// Aaryan Dehade
// Which project is this? Mazesolver - project 1
// Due Date - September 13, 2022
//
// What is this file/module used for?
//      This file is used as the main program solving file
//      with the recursive findpath function to get to the end 
//      of the maze.
//=================================================
class Maze{

    // data members
    char[][] mazeArr;
    Point start, finish;
    String maze, alphabet;
    int rIndex, index, rows, columns;


    // member functions

    // Check if the point is traversable
    boolean isValid(Point p){
        return (mazeArr[p.y][p.x] == '.');
    }

    // set a character at the location
    void setAt(int x, int y, char z) {
        mazeArr[y][x] = z;
    }
    
    // set the next character in the alphabet
    void markVisited(Point p) {
        setAt(p.x, p.y, alphabet.charAt(index));
    }

    // set back to a "."
    void markNotInPath(Point p) {
        setAt(p.x, p.y, '.');
    }

    // go to next alphabet
    void incrementAlphabetIndex() {
        index = (index + 1) % 26;
    }

    // go to previous alphabet
    void decrementAlphabetIndex() {
        index = (index + 25) % 26;
    }

    // Skip the blank space in the input
    static void skipInputCharacter() throws IOException {
        Point.br.read();
    }

    // read a line from the console
    static String readLine() throws IOException {
        return Point.br.readLine();
    }






    // default constructor
    Maze(){
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        rIndex = 0;
        index = 0;
    }


    // overloaded constructor
    Maze(int r, int c){
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        rIndex = 0;
        index = 0;
    }

    // initialize method
    public void initialize() {
        mazeArr = null;
    }

    // read method
    public void read() throws IOException {

        // read the dimensions of the maze
        int rows = Integer.parseInt("" + (char)Point.br.read()); skipInputCharacter();
        int columns = Integer.parseInt("" + (char)Point.br.read()); skipInputCharacter();

        // read the start and end points
        start = Point.read(); skipInputCharacter();
        finish = Point.read(); skipInputCharacter();

        // create an array according to the dimensions
        mazeArr = new char[rows + 2][columns + 2];

        // Create a string of all characters of the maze
        maze = "";
        for (int i = 0; i < rows; i++) {
            maze = maze + readLine();
        }

        // Loop over the maze array and insert characters from the string and create a boundary
        for (int i = 0; i < rows + 2; i++) {
            for (int j = 0; j < columns + 2; j++) {
                if (i == 0 || i == rows + 1 || j == 0 || j == columns + 1) {
                    // create the boundary
                    mazeArr[i][j] = '*';
                } else {
                    // create the maze
                    mazeArr[i][j] = maze.charAt(rIndex);
                    rIndex++;
                }
            }
        }
    }

    // print method
    public void print() {
        // for all rows
        for (int row = 0; row < mazeArr.length; row++) {
            String line = "";
            // for all columns
            for (int column = 0; column < mazeArr[0].length; column++) {
                // if it is not the first or last row or column
                if (row != 0 && row != mazeArr.length - 1 && column != 0 && column != mazeArr[0].length - 1) {
                    line = line + mazeArr[row][column]; // print each character
                } 
            }
            System.out.println(line); // print each line
        }
    }

    // printall method
    public void printall() {
        for (int i = 0; i < mazeArr.length; i++) System.out.println(Arrays.toString(mazeArr[i])); // loop over the array and print internal arrays
    }

    // findpath method
    boolean findPath(Point p) {

        // If the path is not valid, exit (base case 1)
        if (!isValid(p)) return false;

        // mark as visited and increment the index
        markVisited(p);
        incrementAlphabetIndex();

        // if the current point is the goal, return true (base case 2)
        if (p.isEqual(finish)) return true;

        // try traversing all four directions from the current point
        Point[] points = {new Point(p.x, p.y + 1), new Point(p.x + 1, p.y), new Point(p.x, p.y - 1), new Point(p.x, p.y + 1)};
        for (Point next : points) if (findPath(next)) return true;

        // If path not found, go back to previous character, mark the current point as not in the path and exit
        decrementAlphabetIndex();
        markNotInPath(p);
        return false;
    }
}