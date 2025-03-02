public class Main {
    public static void main(String[] args) {

        Maze maze = new Maze("maze.txt");

        System.out.println("Pre-solve: ");
        maze.printMaze();
        maze.solveMaze(maze.startRow, maze.startCol);
        System.out.println("Post-solve: ");
        maze.printMaze();
    }
}
