import java.io.IOException;

//=================================================
// Aaryan Dehade
// Which project is this? Mazesolver - project 1
// Due Date - September 13, 2022
//
// What is this file/module used for?
//      This file is used to create the required number of
//      instances of the maze class and solve them.
//=================================================

class MazeSolver{
    
    public static void main(String [] args) throws NumberFormatException, IOException{

        // read the number of mazes
        int n = Integer.parseInt("" + (char)Point.br.read()); Point.br.read(); Point.br.readLine();
        
        // For each of the n mazes
        for (int i = 0; i < n; i++) {
            // Create an instance of the maze class
            Maze m = new Maze();
            // Initialize the maze array
            m.initialize();
            // Read input from the console
            m.read();
            // if a path is found, print it else print "NO PATH EXISTS"
            if (m.findPath(m.start)) m.print();
            else System.out.println("NO PATH EXISTS");
            // Account for the empty line after each maze
            if (i != n - 1) Point.br.readLine();
        }
    }
}