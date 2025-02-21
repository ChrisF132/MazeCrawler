public class Main {
    public static void main(String[] args) {
        char[][] charArray = new char[7][20];
        Maze maze = new Maze();

        maze.fillMaze(charArray);





        for(int i = 0; i < charArray.length; i++) {
            for(int j = 0; j < charArray[i].length; j++) {
                System.out.print(charArray[i][j]);
            }
            System.out.println();
        }


    }
}
