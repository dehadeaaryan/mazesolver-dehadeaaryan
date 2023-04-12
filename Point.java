//=================================================
// Aaryan Dehade
// Which project is this? Mazesolver - project 1
// Due Date - September 13, 2022
//
// What is this file/module used for?
//      This file is for the Point class and creates the 
//      basic building blocks of the maze.
//=================================================
import java.io.*;

class Point{

    // data members
    int x;
    int y;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // member functions

    // default constructor
    Point(){
        x = 0;
        y = 0;
    } 

    // overloaded constructor
    Point(int x_val, int y_val) {
        x = x_val;
        y = y_val;
    }

    // copy constructor
    Point(Point other){
        x = other.x;
        y = other.y;
    }

    // getX method
    public int getX() {
        return x;
    }

    // getY method
    public int getY() {
        return y;
    }

    // setX method
    public void setX(int x_val) {
        this.x = x_val;
    }

    // setY method
    public void setY(int y_val) {
        this.y = y_val;
    }

    // isEqual method
    public boolean isEqual(Point other) {
        if (this.x == other.getX() && this.y == other.getY()) return true;
        return false;
    }

    // read method
    public static Point read() throws IOException {
        
        // Read each coordinate
        int x = Integer.parseInt("" + (char)br.read()); br.read();
        int y = Integer.parseInt("" + (char)br.read());

        // return the point created by the two coordinates
        return new Point(x, y);
    }

    // print method
    public void print() {
        System.out.printf("(%d, %d)\n", this.x, this.y);
    }

}