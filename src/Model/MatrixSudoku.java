package Model;

import java.util.Random;

/**
 *
 * @author yudi
 */
public class MatrixSudoku {
    
    private final int matrix[][] = new int[][] { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} };;

    public MatrixSudoku() {
        
    }
    
    public void generateRandomNumber(int matrixSudoku[][]) {
        Random rand = new Random();
        int n = 3;
        int x = rand.nextInt(1000);
        
        for(int i = 0; i < n; i++, x++)
            for(int j = 0; j < n; j++, x+=n)
                for(int k = 0; k < n*n; k++, x++)
                    matrixSudoku[n*i+j][k] = (x % (n*n)) + 1;
        
        changeLine(matrixSudoku, 0, 2);
        changeLine(matrixSudoku, 3, 5);
        changeLine(matrixSudoku, 6, 8);
        
        changeColumn(matrixSudoku, 0, 2);
        changeColumn(matrixSudoku, 3, 5);
        changeColumn(matrixSudoku, 6, 8);

        changeBlock3x9(matrixSudoku, 0, 3);
        changeBlock3x9(matrixSudoku, 0, 6);
    }
    
    private void changeLine(int matrixSudoku[][], int line1, int line2) {
        int aux;
        for(int i = 0; i < 9; i++) {
            aux = matrixSudoku[line1][i];
            matrixSudoku[line1][i] = matrixSudoku[line2][i];
            matrixSudoku[line2][i] = aux;
        }
    }
    
    private void changeColumn(int matrixSudoku[][], int column1, int column2) {
        int aux;
        for(int i = 0; i < 9; i++) {
            aux = matrixSudoku[i][column1];
            matrixSudoku[i][column1] = matrixSudoku[i][column2];
            matrixSudoku[i][column2] = aux;
        }
    }
    
    private void changeBlock3x9(int matrixSudoku[][], int line1, int line2) {
        int aux;
        int column2 = 0;
        for(int i = line1; i < line1 + 3; i++) {
            for(int j = 0; j < 9; j++) {
                aux = matrixSudoku[i][j];
                matrixSudoku[i][j] = matrixSudoku[line2][column2];
                matrixSudoku[line2][column2++] = aux;
                if(column2 == 9) {
                    line2++;
                    column2 = 0;
                }
            }
        }
    }
    
    public void removeSomeNumbers(int matrixSudoku[][]){
        System.out.println("Veririficar se há uma forma mais simples para remover");
    }
}
