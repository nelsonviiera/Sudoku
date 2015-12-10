/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nelsonjr
 */
public class Validator {
    
    private int scrollLine, scrollColumn;
    
    public boolean checkSudoku(int[][] matrixSudoku, int line, int column, int amountNumbersSudoku) {
        checkLine(matrixSudoku, line, column);
        checkColumn(matrixSudoku,line, column);

        if(line < 3) {
            if(column < 3)
                checkMatrix3x3(matrixSudoku,line, column, 0, 0);
            else if (column >=3 && column < 6)
                checkMatrix3x3(matrixSudoku,line, column, 0, 3);
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
        
        //Errado
        if(amountNumbersSudoku >= 81) {
            for(scrollLine = 0; scrollLine < 9; scrollLine++){
                for(scrollColumn = 0; scrollColumn < 9; scrollColumn++){
                    if(matrixSudoku[scrollLine][scrollColumn] == 0)
                        return false;
                }
            }
            return true;
        }
        return false;
    }
    
    private boolean checkLine(int matrixSudoku[][], int line, int column) {
        for(scrollColumn = 0; scrollColumn < 9; scrollColumn++) {
            if(scrollColumn == column)
                scrollColumn++;
            if(scrollColumn < 9) {
                
                if(matrixSudoku[line][scrollColumn] == matrixSudoku[line][column])
                    return false;
            }
        }
        return true;
    }
    
    private boolean checkColumn(int matrixSudoku[][], int line, int column) {
        for(scrollLine = 0; scrollLine < 9; scrollLine++) {
            if(scrollLine == line)
                scrollLine++;
            if(scrollLine < 9) {
                if(matrixSudoku[scrollLine][column] == matrixSudoku[line][column])
                    //matrixSudoku[line][column].setForeground(Color.red);
                    return false;
            }
        }
        return true;
    }
    
    private boolean checkMatrix3x3(int matrixSudoku[][], int line, int column, int lineMatrix3x3, int columnMatrix3x3) {
        for(scrollLine = lineMatrix3x3; scrollLine < lineMatrix3x3 + 3; scrollLine++) {
            for(scrollColumn = columnMatrix3x3; scrollColumn < columnMatrix3x3 + 3; scrollColumn++) {
                if(scrollLine == line && scrollColumn == column)
                    scrollColumn++;
                if(scrollColumn < columnMatrix3x3 + 3) {
                    if(matrixSudoku[scrollLine][scrollColumn] == matrixSudoku[line][column])
                        return false;
                }
            }
        }
        return true;
    }
    
}
