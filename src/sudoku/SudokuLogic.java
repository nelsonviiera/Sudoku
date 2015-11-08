package sudoku;

import java.util.Random;

public class SudokuLogic {

    public static void generateRandomNumber(JTextFieldOnlyNumbers[][] matrixSudoku) {
        Random rand = new Random();
        int n = 3;
        final int[][] sudokuAux = new int[n*n][n*n];
        int x = rand.nextInt(1000);
        
        for(int i = 0; i < n; i++, x++)
            for(int j = 0; j < n; j++, x+=n)
                for(int k = 0; k < n*n; k++, x++)
                    sudokuAux[n*i+j][k] = (x % (n*n)) + 1;
        
        changeLine(sudokuAux, 0, 2);
        changeLine(sudokuAux, 3, 5);
        changeLine(sudokuAux, 6, 8);
        
        changeColumn(sudokuAux, 0, 2);
        changeColumn(sudokuAux, 3, 5);
        changeColumn(sudokuAux, 6, 8);

        changeBlock3x9(sudokuAux, 0, 3);
        changeBlock3x9(sudokuAux, 0, 6);

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                matrixSudoku[i][j].setText(String.valueOf(sudokuAux[i][j]));
            }
        }
    }
    
    public static void checkLine(JTextFieldOnlyNumbers[][] matrixSudoku, int line) {
        
    }
    
    public static void checkColumn(JTextFieldOnlyNumbers[][] matrixSudoku, int column) {
        
    }
    
    public static void checkSudoku(JTextFieldOnlyNumbers[][] matrixSudoku) {
        
    }
    
    public static void removeSomeNumbers(JTextFieldOnlyNumbers[][] matrixSudoku){
        Random rand = new Random();
        int numbersInMatrix = rand.nextInt(7)+39;
        int numbersIn3x3 = rand.nextInt(6);
        int i, j;
    }
    
    private static void changeLine(int[][] sudoku, int line1, int line2) {
        int aux;
        for(int i = 0; i < 9; i++) {
            aux = sudoku[line1][i];
            sudoku[line1][i] = sudoku[line2][i];
            sudoku[line2][i] = aux;
        }
    }
    
    private static void changeColumn(int[][] sudoku, int column1, int column2) {
        int aux;
        for(int i = 0; i < 9; i++) {
            aux = sudoku[i][column1];
            sudoku[i][column1] = sudoku[i][column2];
            sudoku[i][column2] = aux;
        }
    }
    
    private static void changeBlock3x9(int[][] sudoku, int line1, int line2) {
        int aux;
        int column2 = 0;
        for(int i = line1; i < line1 + 3; i++) {
            for(int j = 0; j < 9; j++) {
                aux = sudoku[i][j];
                sudoku[i][j] = sudoku[line2][column2];
                sudoku[line2][column2++] = aux;
                if(column2 == 9) {
                    line2++;
                    column2 = 0;
                }
            }
        }
    }
}
