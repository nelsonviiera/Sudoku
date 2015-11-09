package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private int scrollLine, scrollColumn;

    public SudokuFrame() {
        this.newGameJButton = new JButton("Novo Jogo");
        this.matrixSudoku = new JTextFieldOnlyNumbers[9][9];
        this.p1JPanel = new JPanel();
        this.p2JPanel = new JPanel();
        this.mainFrame = new JFrame("Sudoku");
    }
    
    private void init() {
        for(scrollLine = 0; scrollLine < 9; scrollLine++){
            for(scrollColumn = 0; scrollColumn < 9; scrollColumn++){
                final JTextFieldOnlyNumbers matrixCell = new JTextFieldOnlyNumbers();
		matrixSudoku[scrollLine][scrollColumn] = new JTextFieldOnlyNumbers();
                matrixCell.setFont(new Font("sansserif", Font.BOLD, 40));
                matrixCell.setForeground(Color.BLACK);
                matrixCell.setHorizontalAlignment(JTextFieldOnlyNumbers.CENTER);
                matrixCell.setLine(scrollLine);
                matrixCell.setColumn(scrollColumn);
                
                matrixCell.addFocusListener(new FocusListener(){
                    @Override
                    public void focusGained(FocusEvent e) {
                        paintLineColumnMatrix(matrixSudoku, matrixCell.getLine(), matrixCell.getColumn());
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        clearPaintLineColumnMatrix(matrixSudoku, matrixCell.getLine(), matrixCell.getColumn());
                    }
                });
                
                matrixCell.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent event) {
                        if(event.getKeyCode() == KeyEvent.VK_ENTER) {
                            SudokuLogic.checkSudoku(matrixSudoku, matrixCell.getLine(), matrixCell.getColumn());
                            
                        }
                        if(event.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                            matrixCell.setForeground(Color.black);
                    }
                });
                
                matrixSudoku[scrollLine][scrollColumn] = matrixCell;
		p1JPanel.add(matrixSudoku[scrollLine][scrollColumn]);
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
                int op = JOptionPane.showConfirmDialog(null, "Deseja iniciar um novo jogo?", "", JOptionPane.YES_NO_OPTION);
                if (op == JOptionPane.YES_OPTION) {
                    p1JPanel.removeAll();
                    init();
                    Game();
                }
            }
        });
    }
    
    private void paintLineColumnMatrix(JTextFieldOnlyNumbers[][] matrixSudoku, int line, int column) {
        for(scrollLine = 0; scrollLine < 9; scrollLine++)
            matrixSudoku[scrollLine][column].setBackground(Color.LIGHT_GRAY);
        for(scrollColumn = 0; scrollColumn < 9; scrollColumn++)
            matrixSudoku[line][scrollColumn].setBackground(Color.LIGHT_GRAY);
        
        if(line < 3) {
            if(column < 3)
                paintMatrix(matrixSudoku, 0, 0);
            else if(column >= 3 && column < 6)
                paintMatrix(matrixSudoku, 0, 3);
            else
                paintMatrix(matrixSudoku, 0, 6);
        } else if(line >= 3 && line < 6) {
            if(column < 3)
                paintMatrix(matrixSudoku, 3, 0);
            else if(column >= 3 && column < 6)
                paintMatrix(matrixSudoku, 3, 3);
            else
                paintMatrix(matrixSudoku, 3, 6);
        } else {
            if(column < 3)
                paintMatrix(matrixSudoku, 6, 0);
            else if(column >= 3 && column < 6)
                paintMatrix(matrixSudoku, 6, 3);
            else
                paintMatrix(matrixSudoku, 6, 6);
        }
    }
    
    private void clearPaintLineColumnMatrix(JTextFieldOnlyNumbers[][] matrixSudoku, int line, int column) {
        for(scrollLine = 0; scrollLine < 9; scrollLine++)
            matrixSudoku[scrollLine][column].setBackground(Color.WHITE);        
        for(scrollColumn = 0; scrollColumn < 9; scrollColumn++)
            matrixSudoku[line][scrollColumn].setBackground(Color.WHITE);
        
        if(line < 3) {
            if(column < 3)
                clearPaintMatrix(matrixSudoku, 0, 0);
            else if(column >= 3 && column < 6)
                clearPaintMatrix(matrixSudoku, 0, 3);
            else
                clearPaintMatrix(matrixSudoku, 0, 6);
        } else if(line >= 3 && line < 6) {
            if(column < 3)
                clearPaintMatrix(matrixSudoku, 3, 0);
            else if(column >= 3 && column < 6)
                clearPaintMatrix(matrixSudoku, 3, 3);
            else
                clearPaintMatrix(matrixSudoku, 3, 6);
        } else {
            if(column < 3)
                clearPaintMatrix(matrixSudoku, 6, 0);
            else if(column >= 3 && column < 6)
                clearPaintMatrix(matrixSudoku, 6, 3);
            else
                clearPaintMatrix(matrixSudoku, 6, 6);
        }
    }
    
    private void paintMatrix(JTextFieldOnlyNumbers[][] matrixSudoku, int line, int column) {
        for(scrollLine = line; scrollLine < (line + 3); scrollLine++) {
            for(scrollColumn = column; scrollColumn < (column + 3); scrollColumn++) {
                matrixSudoku[scrollLine][scrollColumn].setBackground(Color.LIGHT_GRAY);
            }
        }
    }
    
    private void clearPaintMatrix(JTextFieldOnlyNumbers[][] matrixSudoku, int line, int column) {
        for(scrollLine = line; scrollLine < (line + 3); scrollLine++) {
            for(scrollColumn = column; scrollColumn < (column + 3); scrollColumn++) {
                matrixSudoku[scrollLine][scrollColumn].setBackground(Color.WHITE);
            }
        }
    }
    
    private void Game() {
        SudokuLogic.generateRandomNumber(matrixSudoku);
        SudokuLogic.removeSomeNumbers(matrixSudoku);
    }
    
    public static void main(String[] args) {
        SudokuFrame sudoku = new SudokuFrame();
        sudoku.init();
        sudoku.Game();
    }

}