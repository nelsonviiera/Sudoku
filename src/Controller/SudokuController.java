package Controller;

import Model.MatrixSudoku;
import Model.Validator;
import View.SudokuFrame;
import static java.lang.System.exit;

/**
 *
 * @author yudi
 */
public class SudokuController{

    private MatrixSudoku matrixSudoku;
    
    public SudokuController() {
        matrixSudoku = MatrixSudoku.getMatrixSudoku();
    }
    
    public boolean isValidate(MatrixSudoku matrixSudoku, int line, int column, int number) {
        boolean validadeNumber;
        Validator valid = new Validator();
        validadeNumber = valid.checkSudoku(matrixSudoku.getMatrix(), line, column, number);
        
        if(validadeNumber == true){
            matrixSudoku.insertNumber(number, line, column);
            return true;
        } else {
            return false;
        }
    }

    public void setObserver(SudokuFrame observer) {
        matrixSudoku.addObserver(observer);
    }
}
