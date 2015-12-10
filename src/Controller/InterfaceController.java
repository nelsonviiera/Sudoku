/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.JTextFieldOnlyNumbers;

/**
 *
 * @author yudi
 */
public interface InterfaceController {
    
    public boolean isValidate(int matrixSudoku[][], int line, int column, int amountNumbersSudoku);
}
