package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

/**
 *
 * @author yudi
 */
public class MatrixSudoku extends Observable {
    
    private int matrix[][] = new int [9][9];
    private static MatrixSudoku instance;
    private int countNumbers;
    private boolean isFinish = false;
    
    private MatrixSudoku() {
        
    }
    
    public static MatrixSudoku getMatrixSudoku() {
        if(instance == null){
            instance = new MatrixSudoku();
        }
        return instance;
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
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
        
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
        int amountNumbersSudoku = 0;
        Random rand = new Random();
        int numbersIn3x3 = rand.nextInt(8);
        ArrayList<Integer> vAux = new ArrayList<>();
        int i, j, k;
        
        ArrayList<Integer> characters = new ArrayList<>();
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
                k = matrix[i][j];
                if(!vAux.contains(k))
                    matrix[i][j] = 0;
                else {
                    
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
                k = matrix[i][j];
                if(!vAux.contains(k))
                    matrix[i][j] = 0;
                else {
                    
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
                k = matrix[i][j];
                if(!vAux.contains(k))
                    matrix[i][j] = 0;
                else {
                    
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
                k = matrix[i][j];
                if(!vAux.contains(k))
                    matrix[i][j] = 0;
                else {
                    
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
                k = matrix[i][j];
                if(!vAux.contains(k))
                    matrix[i][j] = 0;
                else {
                    
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
                k = matrix[i][j];
                if(!vAux.contains(k))
                    matrix[i][j] = 0;
                else {
                    
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
                k = matrix[i][j];
                if(!vAux.contains(k))
                    matrix[i][j] = 0;
                else {
                    
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
                k = matrix[i][j];
                if(!vAux.contains(k))
                    matrix[i][j] = 0;
                else {
                    
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
                k = matrix[i][j];
                if(!vAux.contains(k))
                    matrix[i][j] = 0;
                else {
                    
                    amountNumbersSudoku++;
                }
            }
        }
        setCountNumbers(amountNumbersSudoku);
    }
    
    public void insertNumber(int number, int line, int column) {
        //TRATAR ERRO
        this.matrix[line][column] = number;
        System.out.println("Números no Sudoku: " + getCountNumbers());
        setChanged();
        notifyObservers();
    }
    
    public void removeNumber(int number, int line, int column) {
        //TRATAR ERRO
        this.matrix[line][column] = 0;
        setChanged();
        notifyObservers();
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    public int getCountNumbers() {
        return countNumbers;
    }

    public void setCountNumbers(int countNumbers) {
        this.countNumbers = countNumbers;
    }

    public boolean isIsFinish() {
        return isFinish;
    }

    public void setIsFinish(boolean isFinish) {
        this.isFinish = isFinish;
    }

   
}
