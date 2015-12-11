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
    
    public boolean checkSudoku(int[][] matrixSudoku, int line, int column, int number) {
        boolean check3x3;
        
        if(!checkLine(matrixSudoku, line, column, number))
            return false;
            
        if(!checkColumn(matrixSudoku,line, column, number))
            return false;

        if(line < 3) {
            if(column < 3)
                check3x3 = checkMatrix3x3(matrixSudoku,line, column, 0, 0, number);
            else if (column >=3 && column < 6)
                check3x3 = checkMatrix3x3(matrixSudoku,line, column, 0, 3, number);
            else
                check3x3 = checkMatrix3x3(matrixSudoku, line, column, 0, 6, number);
        } else if (line >=3 && line < 6) {
            if(column < 3)
                check3x3 = checkMatrix3x3(matrixSudoku, line, column, 3, 0, number);
            else if (column >=3 && column < 6)
                check3x3 = checkMatrix3x3(matrixSudoku, line, column, 3, 3, number);
            else
                check3x3 = checkMatrix3x3(matrixSudoku, line, column, 3, 6, number);
        } else {
            if(column < 3)
                check3x3 = checkMatrix3x3(matrixSudoku, line, column, 6, 0, number);
            else if (column >=3 && column < 6)
                check3x3 = checkMatrix3x3(matrixSudoku, line, column, 6, 3, number);
            else
                check3x3 = checkMatrix3x3(matrixSudoku, line, column, 6, 6, number);
        }
        if(!check3x3)
            return false;
        return true;
    }
    
    private boolean checkLine(int matrixSudoku[][], int line, int column, int number) {
        for(scrollColumn = 0; scrollColumn < 9; scrollColumn++) {
            if(scrollColumn == column)
                scrollColumn++;
            if(scrollColumn < 9) {
                
                if(matrixSudoku[line][scrollColumn] == number)
                    return false;
            }
        }
        return true;
    }
    
    private boolean checkColumn(int matrixSudoku[][], int line, int column, int number) {
        for(scrollLine = 0; scrollLine < 9; scrollLine++) {
            if(scrollLine == line)
                scrollLine++;
            if(scrollLine < 9) {
                if(matrixSudoku[scrollLine][column] == number)
                    //matrixSudoku[line][column].setForeground(Color.red);
                    return false;
            }
        }
        return true;
    }
    
    private boolean checkMatrix3x3(int matrixSudoku[][], int line, int column, int lineMatrix3x3, int columnMatrix3x3, int number) {
        for(scrollLine = lineMatrix3x3; scrollLine < lineMatrix3x3 + 3; scrollLine++) {
            for(scrollColumn = columnMatrix3x3; scrollColumn < columnMatrix3x3 + 3; scrollColumn++) {
                if(scrollLine == line && scrollColumn == column)
                    scrollColumn++;
                if(scrollColumn < columnMatrix3x3 + 3) {
                    if(matrixSudoku[scrollLine][scrollColumn] == number)
                        return false;
                }
            }
        }
        return true;
    }
    
}
