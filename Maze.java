import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

    //Constants
    char WALL = 'x';
    char CLEAR = ' ';
    char START = 'S';
    char FINISH = 'F';
    char PATH = 'P';
    char VISITED = 'V';

    int startRow, exitRow, startCol, exitCol;

    char[][] characterArray;

    public Maze(String mazeFile) {
        fillMaze(mazeFile);
    }




    public void fillMaze(String mazeFile) {
        try {
            Scanner scanner = new Scanner(new File(mazeFile));

            int cols = scanner.nextInt();
            int rows = scanner.nextInt();

            characterArray = new char[rows][cols];

            exitCol = scanner.nextInt();
            exitRow = scanner.nextInt();

            startCol = scanner.nextInt();
            startRow = scanner.nextInt();



            scanner.nextLine();


            //Copies the SimpleMaze to the characterArray

            for(int i = 0; i < rows; i++) {

                String inputLine = scanner.nextLine();


                for(int j = 0; j < cols; j++) {

                    if(j < inputLine.length()) {

                        characterArray[i][j] = inputLine.charAt(j);

                    }

                    else {
                        characterArray[i][j] = CLEAR;
                    }
                }
            }
            characterArray[startRow][startCol] = START;
            characterArray[exitRow][exitCol] = FINISH;

            scanner.close();

        } // end try

        catch (FileNotFoundException e) {

            System.out.println(e);

            System.exit(1); // IO error; exit program

        } // end catch
    }

    public void printMaze() {
        for(int i = 0; i < characterArray.length; i++) {
            for (int j = 0; j < characterArray[i].length; j++) {
                System.out.print(characterArray[i][j]);
            }
            System.out.println();
        }
    }

    public boolean solveMaze(int startRow, int startCol)
    {
        return goNorth(startRow, startCol);
    }

    public boolean goNorth(int row, int col) {

            if (row == exitRow && col == exitCol) {
                return true;
            }

            if(row -1 < 0 || row - 1 >= characterArray.length || characterArray[row-1][col] == WALL
                    || characterArray[row-1][col] == VISITED || characterArray[row-1][col] == PATH) {
                return false;
            }

            characterArray[row-1][col] = PATH;

        if (goNorth(row - 1, col) || goWest(row - 1, col) || goEast(row - 1, col) || goSouth(row - 1, col)) {
            return true;
        }
        characterArray[row-1][col] = VISITED;
        return false;
        }
    //characterArray[row][col - 1]
    public boolean goWest(int row, int col) {

        if (row == exitRow && col == exitCol) {
            return true;
        }
        if(col -1 < 0 || col - 1 >= characterArray[0].length  || characterArray[row][col-1] == WALL || characterArray[row][col-1] == VISITED || characterArray[row][col-1] == PATH) {
            return false;
        }

        characterArray[row][col-1] = PATH;

        if (goWest(row, col-1) || goEast(row, col-1) || goSouth(row, col-1) || goNorth(row, col-1)) {
            return true;
        }
        characterArray[row][col-1] = VISITED;
        return false;
    }

    //characterArray[row+1][col]
   public boolean goSouth(int row, int col) {

       if (row == exitRow && col == exitCol) {
           return true;
       }
       if(row +1 < 0 || row + 1 >= characterArray.length  || characterArray[row+1][col] == WALL || characterArray[row+1][col] == VISITED || characterArray[row+1][col] == PATH) {
           return false;
       }

       characterArray[row+1][col] = PATH;

       if (goWest(row+1, col) || goEast(row+1, col) || goSouth(row+1, col) || goNorth(row+1, col)) {
           return true;
       }
       characterArray[row+1][col] = VISITED;
       return false;
   }

   //characterArray[row][col + 1]
   public boolean goEast(int row, int col) {
       if (row == exitRow && col == exitCol) {
           return true;
       }
       if(col +1 < 0 || col + 1 >= characterArray[0].length  || characterArray[row][col+1] == WALL || characterArray[row][col+1] == VISITED || characterArray[row][col+1] == PATH) {
           return false;
       }

       characterArray[row][col+1] = PATH;

       if (goWest(row, col+1) || goEast(row, col+1) || goSouth(row, col+1) || goNorth(row, col+1)) {
           return true;
       }
       characterArray[row][col+1] = VISITED;
       return false;
   }
}


