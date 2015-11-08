
package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author Emerson Yudi Nakashima   1451600
 * @author Nelson Vieira da Silva   1514628
 */
public class SudokuFrame{

    private JButton newGameJButton;
    private JTextFieldOnlyNumbers[][] matrixSudoku;
    private JPanel p1JPanel;
    private JPanel p2JPanel;
    private JFrame mainFrame;

    public SudokuFrame() {
        this.newGameJButton = new JButton("Novo Jogo");
        this.matrixSudoku = new JTextFieldOnlyNumbers[9][9];
        this.p1JPanel = new JPanel();
        this.p2JPanel = new JPanel();
        this.mainFrame = new JFrame("Sudoku");
    }
    
    private void Init() {
        int i, j;
        for(i = 0;i<+9;i++){
            for(j = 0; j<+9; j++){
		matrixSudoku[i][j] = new JTextFieldOnlyNumbers();
                matrixSudoku[i][j].setFont(new Font("sansserif", Font.BOLD, 40));
                matrixSudoku[i][j].setForeground(Color.BLACK);
                matrixSudoku[i][j].setHorizontalAlignment(JTextFieldOnlyNumbers.CENTER);
                matrixSudoku[i][j].setLine(i);
                matrixSudoku[i][j].setColumn(j);
		p1JPanel.add(matrixSudoku[i][j]);
                if (i < 3) {
                    if(j < 3)
                        matrixSudoku[i][j].setBackground(Color.DARK_GRAY);
                    else if (j >= 3 && j < 6)
                        matrixSudoku[i][j].setBackground(Color.GRAY);
                    else
                        matrixSudoku[i][j].setBackground(Color.LIGHT_GRAY);
                } else if (i >=3 && i < 6) {
                    if(j < 3)
                        matrixSudoku[i][j].setBackground(Color.GREEN);
                    else if (j >= 3 && j < 6)
                        matrixSudoku[i][j].setBackground(Color.MAGENTA);
                    else
                        matrixSudoku[i][j].setBackground(Color.ORANGE);
                } else {
                    if(j < 3)
                        matrixSudoku[i][j].setBackground(Color.RED);
                    else if (j >= 3 && j < 6)
                        matrixSudoku[i][j].setBackground(Color.YELLOW);
                    
                }
            }
	}
        
        p1JPanel.setLayout(new GridLayout(9,9,1,1));
	p1JPanel.setSize(540, 600);
		
	p2JPanel.setLayout(new GridLayout(1,2,200,10));
	p2JPanel.add(newGameJButton);
	p2JPanel.setBorder(new LineBorder(new Color(238,238,238),20));
        
        mainFrame.setLayout(new BorderLayout(0,0));
	mainFrame.add(p1JPanel, BorderLayout.CENTER);
	mainFrame.add(p2JPanel, BorderLayout.SOUTH);
	mainFrame.setSize(580, 640);
	mainFrame.setLocationRelativeTo(null);
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainFrame.setResizable(false);
	mainFrame.setVisible(true);
        
        newGameJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int op = JOptionPane.showConfirmDialog(null, "Deseja iniciar um novo jogo ?", "", JOptionPane.YES_NO_OPTION);
                if (op == JOptionPane.YES_OPTION)
                    SudokuLogic.generateRandomNumber(matrixSudoku);
            }
        });
    }
    
    private void Game() {
        SudokuLogic.generateRandomNumber(matrixSudoku);
        SudokuLogic.removeSomeNumbers(matrixSudoku);
    }
    
    public static void main(String[] args) {
        SudokuFrame sudoku = new SudokuFrame();
        sudoku.Init();
        sudoku.Game();
    }

}
