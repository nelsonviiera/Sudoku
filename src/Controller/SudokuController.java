package Controller;

import Model.MatrixSudoku;
import Model.Validator;
import View.SudokuFrame;

/**
 *
 * @author yudi
 */
public class SudokuController implements Runnable{

    private MatrixSudoku matrixSudoku;
    private Validator validator;
    public Thread t;
    
    public SudokuController() {
        matrixSudoku = MatrixSudoku.getMatrixSudoku();
        validator = new Validator();
    }
    
    public boolean isValidate(int line, int column, int number) {
        boolean validadeNumber;
        Validator valid = new Validator();
        validadeNumber = valid.checkSudoku(matrixSudoku.getMatrix(), line, column, number);
        
        if(validadeNumber == true){
            matrixSudoku.setCountNumbers(matrixSudoku.getCountNumbers() + 1);
            matrixSudoku.insertNumber(number, line, column);
            return true;
        } else {
            return false;
        }
    }

    public void setObserver(SudokuFrame observer) {
        matrixSudoku.addObserver(observer);
    }
    
    @Override
    public void run(){
        System.out.println("ASUIHAUI " + matrixSudoku.getCountNumbers());
        if(matrixSudoku.getCountNumbers() >= 81){
            System.out.println("entrei");
            while(matrixSudoku.isIsFinish())
                matrixSudoku.setIsFinish(validator.checkSudoku());
            System.out.println("Parabéeeeens!");
        }

    }
}
    