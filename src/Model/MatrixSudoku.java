package Model;

import java.util.Observable;
import java.util.Random;

/**
 *
 * @author yudi
 */
public class MatrixSudoku extends Observable {
    
    private int matrix[][] = new int[][] { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} };;
    private static MatrixSudoku instancia;

    private MatrixSudoku() {
        
    }
    
    public static MatrixSudoku getMatrixSudoku() {
        if(instancia == null)
            instancia = new MatrixSudoku();
        return instancia;
    }
    
    
    public void generateRandomNumber() {
        Random rand = new Random();
        int n = 3;
        int x = rand.nextInt(1000);
        
        for(int i = 0; i < n; i++, x++)
            for(int j = 0; j < n; j++, x+=n)
                for(int k = 0; k < n*n; k++, x++)
                    this.matrix[n*i+j][k] = (x % (n*n)) + 1;
        
        changeLine(0, 2);
        changeLine(3, 5);
        changeLine(6, 8);
        
        changeColumn(0, 2);
        changeColumn(3, 5);
        changeColumn(6, 8);

        changeBlock3x9(0, 3);
        changeBlock3x9(0, 6);
        
        removeSomeNumbers();
        setChanged();
        notifyObservers();
    }
    
    private void changeLine(int line1, int line2) {
        int aux;
        for(int i = 0; i < 9; i++) {
            aux = this.matrix[line1][i];
            this.matrix[line1][i] = this.matrix[line2][i];
            this.matrix[line2][i] = aux;
        }
    }
    
    private void changeColumn(int column1, int column2) {
        int aux;
        for(int i = 0; i < 9; i++) {
            aux = this.matrix[i][column1];
            this.matrix[i][column1] = this.matrix[i][column2];
            this.matrix[i][column2] = aux;
        }
    }
    
    private void changeBlock3x9(int line1, int line2) {
        int aux;
        int column2 = 0;
        for(int i = line1; i < line1 + 3; i++) {
            for(int j = 0; j < 9; j++) {
                aux = this.matrix[i][j];
                this.matrix[i][j] = this.matrix[line2][column2];
                this.matrix[line2][column2++] = aux;
                if(column2 == 9) {
                    line2++;
                    column2 = 0;
                }
            }
        }
    }
    
    public void removeSomeNumbers(){
        System.out.println("Veririficar se há uma forma mais simples para remover");
    }
    
    private void insertNumber(int number, int line, int column) {
        //TRATAR ERRO
        this.matrix[line][column] = number;
        setChanged();
        notifyObservers();
    }
    
    private void removeNumber(int number, int line, int column) {
        //TRATAR ERRO
        this.matrix[line][column] = number;
        setChanged();
        notifyObservers();
    }
}
