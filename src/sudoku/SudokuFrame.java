package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author Emerson Yudi Nakashima   1451600
 * @author Nelson Vieira da Silva   1514628
 */
public class SudokuFrame{

    static JButton NewGame = new JButton("Novo Jogo");
    static JTextFieldOnlyNumbers[][] matrixSudoku = new JTextFieldOnlyNumbers[9][9];
    static JPanel p1 = new JPanel();
    static JPanel p2 = new JPanel();
    static JFrame MainFrame = new JFrame("Sudoku");
    
    private static void Init() {
        int i, j;
        for(i = 0;i<+9;i++){
            for(j = 0; j<+9; j++){
		matrixSudoku[i][j] = new JTextFieldOnlyNumbers();
                matrixSudoku[i][j].setFont(new Font("sansserif", Font.BOLD, 40));
                matrixSudoku[i][j].setForeground(Color.BLACK);
                matrixSudoku[i][j].setHorizontalAlignment(JTextFieldOnlyNumbers.CENTER);
		p1.add(matrixSudoku[i][j]);
                if (i < 3) {
                    if(j < 3) {
                        matrixSudoku[i][j].setBackground(Color.DARK_GRAY);
                    } else if (j >= 3 && j < 6) {
                        matrixSudoku[i][j].setBackground(Color.GRAY);
                    } else
                        matrixSudoku[i][j].setBackground(Color.LIGHT_GRAY);
                } else if (i >=3 && i < 6) {
                    if(j < 3) {
                        matrixSudoku[i][j].setBackground(Color.GREEN);
                    } else if (j >= 3 && j < 6) {
                        matrixSudoku[i][j].setBackground(Color.MAGENTA);
                    } else
                        matrixSudoku[i][j].setBackground(Color.ORANGE);
                } else {
                    if(j < 3) {
                        matrixSudoku[i][j].setBackground(Color.RED);
                    } else if (j >= 3 && j < 6) {
                        matrixSudoku[i][j].setBackground(Color.YELLOW);
                    }
                }
            }
	}
        
        p1.setLayout(new GridLayout(9,9,1,1));
	p1.setSize(540, 600);
		
	p2.setLayout(new GridLayout(1,2,200,10));
	p2.add(NewGame);
	p2.setBorder(new LineBorder(new Color(238,238,238),20));
        
        MainFrame.setLayout(new BorderLayout(0,0));
	MainFrame.add(p1,BorderLayout.CENTER);
	MainFrame.add(p2,BorderLayout.SOUTH);
	MainFrame.setSize(580, 640);
	MainFrame.setLocationRelativeTo(null);
	MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	MainFrame.setResizable(false);
	MainFrame.setVisible(true);
    }
    
    private static void Game() {
        SudokuLogic.generateRandomNumber(matrixSudoku);
        SudokuLogic.removeSomeNumbers(matrixSudoku);
    }
    
    public static void main(String[] args) {
        Init();
        Game();
    }

}
