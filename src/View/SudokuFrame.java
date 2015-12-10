package View;

import Controller.SudokuController;
import Model.JTextFieldOnlyNumbers;
import Model.MatrixSudoku;
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
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author yudi
 */
public class SudokuFrame implements Observer {
    private MatrixSudoku matrixSudoku;
    private JTextFieldOnlyNumbers[][] matrixSudokuFrame;
    private JPanel p1JPanel;
    private JPanel p2JPanel;
    private JFrame mainFrame;
    private JButton newGameJButton;
//    private SudokuLogic sudokuLogic;
//    private Player player;
//    private boolean finish;
    private SudokuController sudokuController;

    public SudokuFrame() {
        this.matrixSudoku = MatrixSudoku.getMatrixSudoku();
        this.newGameJButton = new JButton("Novo Jogo");
        this.matrixSudokuFrame = new JTextFieldOnlyNumbers[9][9];
        this.p1JPanel = new JPanel();
        this.p2JPanel = new JPanel();
        this.mainFrame = new JFrame("Sudoku");
//        this.sudokuLogic = new SudokuLogic();
//        this.player = new Player();
//        player.setNome("Yudi");
//        setFinish(false);
//        setAmountNumbersSudoku(0);
    }
    
    private void init() {
        p1JPanel.removeAll();
        p2JPanel.removeAll();
        for(int scrollLine = 0; scrollLine < 9; scrollLine++){
            for(int scrollColumn = 0; scrollColumn < 9; scrollColumn++){
                final JTextFieldOnlyNumbers matrixCell = new JTextFieldOnlyNumbers();
		matrixSudokuFrame[scrollLine][scrollColumn] = new JTextFieldOnlyNumbers();
                matrixCell.setFont(new Font("sansserif", Font.BOLD, 40));
                matrixCell.setForeground(Color.BLACK);
                matrixCell.setHorizontalAlignment(JTextFieldOnlyNumbers.CENTER);
                matrixCell.setLine(scrollLine);
                matrixCell.setColumn(scrollColumn);
                
                matrixCell.addFocusListener(new FocusListener(){
                    @Override
                    public void focusGained(FocusEvent e) {
                        paintLineColumnMatrix(matrixSudokuFrame, matrixCell.getLine(), matrixCell.getColumn());
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        clearPaintLineColumnMatrix(matrixSudokuFrame, matrixCell.getLine(), matrixCell.getColumn());
                    }
                });
                
                matrixCell.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent event) {
                        if(event.getKeyCode() == KeyEvent.VK_ENTER) {
//                            setFinish(sudokuLogic.checkSudoku(matrixSudokuFrame, matrixCell.getLine(), matrixCell.getColumn(), amountNumbersSudoku));
                        }
                        if(event.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                            matrixCell.setForeground(Color.black);
                        }
//                        if(getAmountNumbersSudoku() >= 81) {
//                            if(isFinish()) {
//                                JOptionPane.showMessageDialog(p1JPanel, "Parabéns " + player.getNome() +", para jogar novamente, clique em OK e Novo Jogo");
//                                p1JPanel.setEnabled(false);
//                                mainFrame.dispose();
//                                init();
//                                game();
//                            }
//                        }
                    }
                });
                
                matrixSudokuFrame[scrollLine][scrollColumn] = matrixCell;
		p1JPanel.add(matrixSudokuFrame[scrollLine][scrollColumn]);
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
                    mainFrame.dispose();
                    init();
                    game();
                }
            }
        });
    }
    
    private void paintLineColumnMatrix(JTextFieldOnlyNumbers[][] matrixSudokuFrame, int line, int column) {
        for(int scrollLine = 0; scrollLine < 9; scrollLine++)
            matrixSudokuFrame[scrollLine][column].setBackground(Color.LIGHT_GRAY);
        for(int scrollColumn = 0; scrollColumn < 9; scrollColumn++)
            matrixSudokuFrame[line][scrollColumn].setBackground(Color.LIGHT_GRAY);
        
        if(line < 3) {
            if(column < 3)
                paintMatrix(matrixSudokuFrame, 0, 0);
            else if(column >= 3 && column < 6)
                paintMatrix(matrixSudokuFrame, 0, 3);
            else
                paintMatrix(matrixSudokuFrame, 0, 6);
        } else if(line >= 3 && line < 6) {
            if(column < 3)
                paintMatrix(matrixSudokuFrame, 3, 0);
            else if(column >= 3 && column < 6)
                paintMatrix(matrixSudokuFrame, 3, 3);
            else
                paintMatrix(matrixSudokuFrame, 3, 6);
        } else {
            if(column < 3)
                paintMatrix(matrixSudokuFrame, 6, 0);
            else if(column >= 3 && column < 6)
                paintMatrix(matrixSudokuFrame, 6, 3);
            else
                paintMatrix(matrixSudokuFrame, 6, 6);
        }
    }
    
    private void clearPaintLineColumnMatrix(JTextFieldOnlyNumbers[][] matrixSudokuFrame, int line, int column) {
        for(int scrollLine = 0; scrollLine < 9; scrollLine++)
            matrixSudokuFrame[scrollLine][column].setBackground(Color.WHITE);        
        for(int scrollColumn = 0; scrollColumn < 9; scrollColumn++)
            matrixSudokuFrame[line][scrollColumn].setBackground(Color.WHITE);
        
        if(line < 3) {
            if(column < 3)
                clearPaintMatrix(matrixSudokuFrame, 0, 0);
            else if(column >= 3 && column < 6)
                clearPaintMatrix(matrixSudokuFrame, 0, 3);
            else
                clearPaintMatrix(matrixSudokuFrame, 0, 6);
        } else if(line >= 3 && line < 6) {
            if(column < 3)
                clearPaintMatrix(matrixSudokuFrame, 3, 0);
            else if(column >= 3 && column < 6)
                clearPaintMatrix(matrixSudokuFrame, 3, 3);
            else
                clearPaintMatrix(matrixSudokuFrame, 3, 6);
        } else {
            if(column < 3)
                clearPaintMatrix(matrixSudokuFrame, 6, 0);
            else if(column >= 3 && column < 6)
                clearPaintMatrix(matrixSudokuFrame, 6, 3);
            else
                clearPaintMatrix(matrixSudokuFrame, 6, 6);
        }
    }
    
    private void paintMatrix(JTextFieldOnlyNumbers[][] matrixSudokuFrame, int line, int column) {
        for(int scrollLine = line; scrollLine < (line + 3); scrollLine++) {
            for(int scrollColumn = column; scrollColumn < (column + 3); scrollColumn++) {
                matrixSudokuFrame[scrollLine][scrollColumn].setBackground(Color.LIGHT_GRAY);
            }
        }
    }
    
    private void clearPaintMatrix(JTextFieldOnlyNumbers[][] matrixSudokuFrame, int line, int column) {
        for(int scrollLine = line; scrollLine < (line + 3); scrollLine++) {
            for(int scrollColumn = column; scrollColumn < (column + 3); scrollColumn++) {
                matrixSudokuFrame[scrollLine][scrollColumn].setBackground(Color.WHITE);
            }
        }
    }
    
    private void game() {
//        sudokuLogic.generateRandomNumber(matrixSudokuFrame);
//        setAmountNumbersSudoku(sudokuLogic.removeSomeNumbers(matrixSudokuFrame));
    }
    
    public static void main(String[] args) {
        SudokuFrame sudoku = new SudokuFrame();
        sudoku.init();
        sudoku.game();
    }

    @Override
    public void update(Observable o, Object arg) {
        
    }
}
