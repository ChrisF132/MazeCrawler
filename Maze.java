import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

    //Constants
    char WALL = 'X';
    char CLEAR = ' ';
    char START = 'S';
    char FINISH = 'F';




    public void fillMaze(char[][] characterArray) {
        try {
            String inputLine;
            Scanner scanner = new Scanner(new File("maze.txt"));

            String line = scanner.nextLine();

            String[] columnsRows = line.split(" ");
            scanner.nextLine();

            String[] exitCoords = line.split(" ");
            scanner.nextLine();

            String[] startCoords = line.split(" ");

            int rows = Integer.parseInt(String.valueOf(columnsRows[1]));
            int cols = Integer.parseInt(String.valueOf(columnsRows[0]));




            //Copies the SimpleMaze to the characterArray

            for(int i = 0; i < rows; i++) {

                inputLine = scanner.nextLine();


                for(int j = 0; j < cols; j++) {

                    if(j < inputLine.length()) {

                        characterArray[i][j] = inputLine.charAt(j);

                    }

                    else {

                        characterArray[i][j] = ' ';

                    }

                }

            }

            scanner.close();

        } // end try

        catch (FileNotFoundException e) {

            System.out.println(e);

            System.exit(1); // IO error; exit program

        } // end catch

    }

    public boolean isOpen(char[][] characterArray, int row, int col) {
        return characterArray[row][col] == ' ';
    }

    public void markStart(char[][] characterArray, int row, int col) {
        for(int j = 0; j < col; j++) {
                if(isOpen(characterArray, row-1, j)) {
                    characterArray[row-1][j] = START;
                }
        }
    }

    public void markFinish(char[][] characterArray, int row, int col) {
        for(int j = 0; j < col; j++) {
            if(isOpen(characterArray, 0, j)) {
                characterArray[0][j] = FINISH;
            }
        }
    }


}




