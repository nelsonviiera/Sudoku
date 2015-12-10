package Controller;

import Model.Validator;

/**
 *
 * @author yudi
 */
public class SudokuController implements InterfaceController {
    
    @Override
    public boolean isValidate(int matrixSudoku[][], int line, int column, int amountNumbersSudoku) {
        Validator valid = new Validator();
        valid.checkSudoku(matrixSudoku, line, column, amountNumbersSudoku);
        return true;
    }
}
