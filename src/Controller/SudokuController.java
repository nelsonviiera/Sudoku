package Controller;

import Model.JTextFieldOnlyNumbers;
import java.awt.Color;

/**
 *
 * @author yudi
 */
public class SudokuController {
    
    public boolean isValidate(JTextFieldOnlyNumbers[][] matrixSudoku, int line, int column, int amountNumbersSudoku) {
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
            for(int scrollLine = 0; scrollLine < 9; scrollLine++){
                for(int scrollColumn = 0; scrollColumn < 9; scrollColumn++){
                    if(matrixSudoku[scrollLine][scrollColumn].getText().equals("") || matrixSudoku[scrollLine][scrollColumn].getForeground().equals(Color.red))
                        return false;
                }
            }
            return true;
        }
        return false;
    }
    
    private void checkLine(JTextFieldOnlyNumbers[][] matrixSudoku, int line, int column) {
        for(int scrollColumn = 0; scrollColumn < 9; scrollColumn++) {
            if(scrollColumn == column)
                scrollColumn++;
            if(scrollColumn < 9) {
                if(matrixSudoku[line][scrollColumn].getText().equals(matrixSudoku[line][column].getText()))
                    matrixSudoku[line][column].setForeground(Color.red);
            }
        }
    }
    
    private void checkColumn(JTextFieldOnlyNumbers[][] matrixSudoku, int line, int column) {
        for(int scrollLine = 0; scrollLine < 9; scrollLine++) {
            if(scrollLine == line)
                scrollLine++;
            if(scrollLine < 9) {
                if(matrixSudoku[scrollLine][column].getText().equals(matrixSudoku[line][column].getText()))
                    matrixSudoku[line][column].setForeground(Color.red);
            }
        }
    }
    
    private void checkMatrix3x3(JTextFieldOnlyNumbers[][] matrixSudoku, int line, int column, int lineMatrix3x3, int columnMatrix3x3) {
        for(int scrollLine = lineMatrix3x3; scrollLine < lineMatrix3x3 + 3; scrollLine++) {
            for(int scrollColumn = columnMatrix3x3; scrollColumn < columnMatrix3x3 + 3; scrollColumn++) {
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
