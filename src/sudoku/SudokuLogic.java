package sudoku;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Emerson Yudi Nakashima   1451600
 * @author Nelson Vieira da Silva   1514628
 */
public class SudokuLogic {
    
    private int scrollLine, scrollColumn;
    
    public void generateRandomNumber(JTextFieldOnlyNumbers[][] matrixSudoku) {
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
                System.out.print(matrixSudoku[i][j].getText() + " ");
            }
            System.out.println("");
        }
    }
    
    private void changeLine(int[][] sudoku, int line1, int line2) {
        int aux;
        for(int i = 0; i < 9; i++) {
            aux = sudoku[line1][i];
            sudoku[line1][i] = sudoku[line2][i];
            sudoku[line2][i] = aux;
        }
    }
    
    private void changeColumn(int[][] sudoku, int column1, int column2) {
        int aux;
        for(int i = 0; i < 9; i++) {
            aux = sudoku[i][column1];
            sudoku[i][column1] = sudoku[i][column2];
            sudoku[i][column2] = aux;
        }
    }
    
    private void changeBlock3x9(int[][] sudoku, int line1, int line2) {
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

    public int removeSomeNumbers(JTextFieldOnlyNumbers[][] matrixSudoku){
        int amountNumbersSudoku = 0;
        Random rand = new Random();
        int numbersIn3x3 = rand.nextInt(8);
        ArrayList vAux = new ArrayList();
        int i, j, k;
        
        ArrayList characters = new ArrayList();
        for(i = 1; i <= 9; i++)
            characters.add(i);
        
        for(i = 0; i < numbersIn3x3; i++){
            j = rand.nextInt(characters.size());
            vAux.add(characters.get(j));
            characters.remove(characters.get(j));
            j++;
        }

        for(i = 0; i < 3; i++){
            for(j = 0; j < 3; j++){
                k = Integer.parseInt(matrixSudoku[i][j].getText());
                if(!vAux.contains(k))
                    matrixSudoku[i][j].setText(null);
                else {
                    matrixSudoku[i][j].setEditable(false);
                    amountNumbersSudoku++;
                }
            }
        }

        vAux = new ArrayList();
        for(i = 1; i <= 9; i++)
            characters.add(i);
        numbersIn3x3 = rand.nextInt(8);

        for(i = 0; i < numbersIn3x3; i++){
            j = rand.nextInt(characters.size());
            vAux.add(characters.get(j));
            characters.remove(characters.get(j));
            j++;
        }

        for(i = 0; i < 3; i++){
            for(j = 3; j < 6; j++){
                k = Integer.parseInt(matrixSudoku[i][j].getText());
                if(!vAux.contains(k))
                    matrixSudoku[i][j].setText(null);
                else {
                    matrixSudoku[i][j].setEditable(false);
                    amountNumbersSudoku++;
                }
            }
        }
        
        
        vAux = new ArrayList();
        for(i = 1; i <= 9; i++)
            characters.add(i);
        numbersIn3x3 = rand.nextInt(8);

        for(i = 0; i < numbersIn3x3; i++){
            j = rand.nextInt(characters.size());
            vAux.add(characters.get(j));
            characters.remove(characters.get(j));
            j++;
        }

        for(i = 0; i < 3; i++){
            for(j = 6; j < 9; j++){
                k = Integer.parseInt(matrixSudoku[i][j].getText());
                if(!vAux.contains(k))
                    matrixSudoku[i][j].setText(null);
                else {
                    matrixSudoku[i][j].setEditable(false);
                    amountNumbersSudoku++;
                }
            }
        }
        
        
        vAux = new ArrayList();
        for(i = 1; i <= 9; i++)
            characters.add(i);
        numbersIn3x3 = rand.nextInt(8);

        for(i = 0; i < numbersIn3x3; i++){
            j = rand.nextInt(characters.size());
            vAux.add(characters.get(j));
            characters.remove(characters.get(j));
            j++;
        }

        for(i = 3; i < 6; i++){
            for(j = 0; j < 3; j++){
                k = Integer.parseInt(matrixSudoku[i][j].getText());
                if(!vAux.contains(k))
                    matrixSudoku[i][j].setText(null);
                else {
                    matrixSudoku[i][j].setEditable(false);
                    amountNumbersSudoku++;
                }
            }
        }
        
        
        vAux = new ArrayList();
        for(i = 1; i <= 9; i++)
            characters.add(i);
        numbersIn3x3 = rand.nextInt(8);

        for(i = 0; i < numbersIn3x3; i++){
            j = rand.nextInt(characters.size());
            vAux.add(characters.get(j));
            characters.remove(characters.get(j));
            j++;
        }

        for(i = 3; i < 6; i++){
            for(j = 3; j < 6; j++){
                k = Integer.parseInt(matrixSudoku[i][j].getText());
                if(!vAux.contains(k))
                    matrixSudoku[i][j].setText(null);
                else {
                    matrixSudoku[i][j].setEditable(false);
                    amountNumbersSudoku++;
                }
            }
        }
        
        
        vAux = new ArrayList();
        for(i = 1; i <= 9; i++)
            characters.add(i);
        numbersIn3x3 = rand.nextInt(8);

        for(i = 0; i < numbersIn3x3; i++){
            j = rand.nextInt(characters.size());
            vAux.add(characters.get(j));
            characters.remove(characters.get(j));
            j++;
        }

        for(i = 3; i < 6; i++){
            for(j = 6; j < 9; j++){
                k = Integer.parseInt(matrixSudoku[i][j].getText());
                if(!vAux.contains(k))
                    matrixSudoku[i][j].setText(null);
                else {
                    matrixSudoku[i][j].setEditable(false);
                    amountNumbersSudoku++;
                }
            }
        }
        
        
        vAux = new ArrayList();
        for(i = 1; i <= 9; i++)
            characters.add(i);
        numbersIn3x3 = rand.nextInt(8);

        for(i = 0; i < numbersIn3x3; i++){
            j = rand.nextInt(characters.size());
            vAux.add(characters.get(j));
            characters.remove(characters.get(j));
            j++;
        }

        for(i = 6; i < 9; i++){
            for(j = 0; j < 3; j++){
                k = Integer.parseInt(matrixSudoku[i][j].getText());
                if(!vAux.contains(k))
                    matrixSudoku[i][j].setText(null);
                else {
                    matrixSudoku[i][j].setEditable(false);
                    amountNumbersSudoku++;
                }
            }
        }
        
        
        vAux = new ArrayList();
        for(i = 1; i <= 9; i++)
            characters.add(i);
        numbersIn3x3 = rand.nextInt(8);

        for(i = 0; i < numbersIn3x3; i++){
            j = rand.nextInt(characters.size());
            vAux.add(characters.get(j));
            characters.remove(characters.get(j));
            j++;
        }

        for(i = 6; i < 9; i++){
            for(j = 3; j < 6; j++){
                k = Integer.parseInt(matrixSudoku[i][j].getText());
                if(!vAux.contains(k))
                    matrixSudoku[i][j].setText(null);
                else {
                    matrixSudoku[i][j].setEditable(false);
                    amountNumbersSudoku++;
                }
            }
        }
        
        
        vAux = new ArrayList();
        for(i = 1; i <= 9; i++)
            characters.add(i);
        numbersIn3x3 = rand.nextInt(8);

        for(i = 0; i < numbersIn3x3; i++){
            j = rand.nextInt(characters.size());
            vAux.add(characters.get(j));
            characters.remove(characters.get(j));
            j++;
        }

        for(i = 6; i < 9; i++){
            for(j = 6; j < 9; j++){
                k = Integer.parseInt(matrixSudoku[i][j].getText());
                if(!vAux.contains(k))
                    matrixSudoku[i][j].setText(null);
                else {
                    matrixSudoku[i][j].setEditable(false);
                    amountNumbersSudoku++;
                }
            }
        }
        return amountNumbersSudoku;
    }
    
    public boolean checkSudoku(JTextFieldOnlyNumbers[][] matrixSudoku, int line, int column, int amountNumbersSudoku) {
        checkLine(matrixSudoku, line, column);
        checkColumn(matrixSudoku, line, column);

        if(line < 3) {
            if(column < 3)
                checkMatrix3x3(matrixSudoku, line, column, 0, 0);
            else if (column >=3 && column < 6)
                checkMatrix3x3(matrixSudoku, line, column, 0, 3);
            else
                checkMatrix3x3(matrixSudoku, line, column, 0, 6);
        } else if (line >=3 && line < 6) {
            if(column < 3)
                checkMatrix3x3(matrixSudoku, line, column, 3, 0);
            else if (column >=3 && column < 6)
                checkMatrix3x3(matrixSudoku, line, column, 3, 3);
            else
                checkMatrix3x3(matrixSudoku, line, column, 3, 6);
        } else {
            if(column < 3)
                checkMatrix3x3(matrixSudoku, line, column, 6, 0);
            else if (column >=3 && column < 6)
                checkMatrix3x3(matrixSudoku, line, column, 6, 3);
            else
                checkMatrix3x3(matrixSudoku, line, column, 6, 6);
        }
        
        if(amountNumbersSudoku >= 81) {
            for(scrollLine = 0; scrollLine < 9; scrollLine++){
                for(scrollColumn = 0; scrollColumn < 9; scrollColumn++){
                    if(matrixSudoku[scrollLine][scrollColumn].getText().equals("") || matrixSudoku[scrollLine][scrollColumn].getForeground().equals(Color.red))
                        return false;
                }
            }
            return true;
        }
        return false;
    }
    
    private void checkLine(JTextFieldOnlyNumbers[][] matrixSudoku, int line, int column) {
        for(scrollColumn = 0; scrollColumn < 9; scrollColumn++) {
            if(scrollColumn == column)
                scrollColumn++;
            if(scrollColumn < 9) {
                if(matrixSudoku[line][scrollColumn].getText().equals(matrixSudoku[line][column].getText()))
                    matrixSudoku[line][column].setForeground(Color.red);
            }
        }
    }
    
    private void checkColumn(JTextFieldOnlyNumbers[][] matrixSudoku, int line, int column) {
        for(scrollLine = 0; scrollLine < 9; scrollLine++) {
            if(scrollLine == line)
                scrollLine++;
            if(scrollLine < 9) {
                if(matrixSudoku[scrollLine][column].getText().equals(matrixSudoku[line][column].getText()))
                    matrixSudoku[line][column].setForeground(Color.red);
            }
        }
    }
    
    private void checkMatrix3x3(JTextFieldOnlyNumbers[][] matrixSudoku, int line, int column, int lineMatrix3x3, int columnMatrix3x3) {
        for(scrollLine = lineMatrix3x3; scrollLine < lineMatrix3x3 + 3; scrollLine++) {
            for(scrollColumn = columnMatrix3x3; scrollColumn < columnMatrix3x3 + 3; scrollColumn++) {
                if(scrollLine == line && scrollColumn == column)
                    scrollColumn++;
                if(scrollColumn < columnMatrix3x3 + 3) {
                    if(matrixSudoku[scrollLine][scrollColumn].getText().equals(matrixSudoku[line][column].getText()))
                        matrixSudoku[line][column].setForeground(Color.red);
                }
            }
        }
    }
}