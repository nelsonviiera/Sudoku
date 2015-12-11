package View;

import Controller.SudokuController;
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
    private JTextFieldOnlyNumbers[][] matrixSudokuFrame;
    private JPanel p1JPanel;
    private JPanel p2JPanel;
    private JFrame mainFrame;
    private JButton newGameJButton;
    private boolean valid;
    private SudokuController sudokuController;
    private int initialize = 0;

    public SudokuFrame() {
        this.mainFrame = new JFrame("Sudoku"); 
        this.p1JPanel = new JPanel();
        this.p2JPanel = new JPanel();
        this.newGameJButton = new JButton("Novo Jogo");
        this.matrixSudokuFrame = new JTextFieldOnlyNumbers[9][9];
        init();
        sudokuController = new SudokuController();
        sudokuController.setObserver(this);
        MatrixSudoku.getMatrixSudoku().generateRandomNumber();
    }
    
    public void init() {
        this.p1JPanel.removeAll();
        this.p2JPanel.removeAll();
        for(int scrollLine = 0; scrollLine < 9; scrollLine++){
            for(int scrollColumn = 0; scrollColumn < 9; scrollColumn++){
                final JTextFieldOnlyNumbers matrixCell = new JTextFieldOnlyNumbers();
		this.matrixSudokuFrame[scrollLine][scrollColumn] = new JTextFieldOnlyNumbers();
                matrixCell.setFont(new Font("sansserif", Font.BOLD, 40));
                matrixCell.setForeground(Color.BLACK);
                matrixCell.setHorizontalAlignment(JTextFieldOnlyNumbers.CENTER);
                matrixCell.setLine(scrollLine);
                matrixCell.setColumn(scrollColumn);
                
                matrixCell.addFocusListener(new FocusListener(){
                    @Override
                    public void focusGained(FocusEvent e) {
                        paintLineColumnMatrix(matrixCell.getLine(), matrixCell.getColumn());
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        clearPaintLineColumnMatrix(matrixCell.getLine(), matrixCell.getColumn());
                    }
                });
                
                matrixCell.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent event) {
                        if(event.getKeyCode() == KeyEvent.VK_ENTER) {
                            valid = sudokuController.isValidate(matrixCell.getLine(), matrixCell.getColumn(), Integer.parseInt(matrixCell.getText()));
                            if (valid == false){
                                matrixCell.setForeground(Color.red);
                            }
                        }
                        if(event.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                            matrixCell.setForeground(Color.black);
                        }
                    }
                });
                
                this.matrixSudokuFrame[scrollLine][scrollColumn] = matrixCell;
                System.out.println(matrixSudokuFrame[scrollLine][scrollColumn].getText());
		this.p1JPanel.add(this.matrixSudokuFrame[scrollLine][scrollColumn]);
            }
	}
        
        this.p1JPanel.setLayout(new GridLayout(9,9,1,1));
	this.p1JPanel.setSize(540, 600);
		
	this.p2JPanel.setLayout(new GridLayout(1,2,200,10));
	this.p2JPanel.add(this.newGameJButton);
	this.p2JPanel.setBorder(new LineBorder(new Color(238,238,238),20));
        
        this.mainFrame.setLayout(new BorderLayout(0,0));
	this.mainFrame.add(this.p1JPanel, BorderLayout.CENTER);
	this.mainFrame.add(this.p2JPanel, BorderLayout.SOUTH);
	this.mainFrame.setSize(580, 640);
	this.mainFrame.setLocationRelativeTo(null);
	this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.mainFrame.setResizable(false);
	this.mainFrame.setVisible(true);
        
        this.newGameJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int op = JOptionPane.showConfirmDialog(null, "Deseja iniciar um novo jogo?", "", JOptionPane.YES_NO_OPTION);
                if (op == JOptionPane.YES_OPTION) {
                    newGameJButton.removeActionListener(this);
                    mainFrame.dispose();
                    //chamar player
                }
            }
        });
    }
    
    private void paintLineColumnMatrix(int line, int column) {
        for(int scrollLine = 0; scrollLine < 9; scrollLine++)
            this.matrixSudokuFrame[scrollLine][column].setBackground(Color.LIGHT_GRAY);
        for(int scrollColumn = 0; scrollColumn < 9; scrollColumn++)
            this.matrixSudokuFrame[line][scrollColumn].setBackground(Color.LIGHT_GRAY);
        
        if(line < 3) {
            if(column < 3)
                paintMatrix(0, 0);
            else if(column >= 3 && column < 6)
                paintMatrix(0, 3);
            else
                paintMatrix(0, 6);
        } else if(line >= 3 && line < 6) {
            if(column < 3)
                paintMatrix(3, 0);
            else if(column >= 3 && column < 6)
                paintMatrix(3, 3);
            else
                paintMatrix(3, 6);
        } else {
            if(column < 3)
                paintMatrix(6, 0);
            else if(column >= 3 && column < 6)
                paintMatrix(6, 3);
            else
                paintMatrix(6, 6);
        }
    }
    
    private void clearPaintLineColumnMatrix(int line, int column) {
        for(int scrollLine = 0; scrollLine < 9; scrollLine++)
            this.matrixSudokuFrame[scrollLine][column].setBackground(Color.WHITE);        
        for(int scrollColumn = 0; scrollColumn < 9; scrollColumn++)
            this.matrixSudokuFrame[line][scrollColumn].setBackground(Color.WHITE);
        
        if(line < 3) {
            if(column < 3)
                clearPaintMatrix(0, 0);
            else if(column >= 3 && column < 6)
                clearPaintMatrix(0, 3);
            else
                clearPaintMatrix(0, 6);
        } else if(line >= 3 && line < 6) {
            if(column < 3)
                clearPaintMatrix(3, 0);
            else if(column >= 3 && column < 6)
                clearPaintMatrix(3, 3);
            else
                clearPaintMatrix(3, 6);
        } else {
            if(column < 3)
                clearPaintMatrix(6, 0);
            else if(column >= 3 && column < 6)
                clearPaintMatrix(6, 3);
            else
                clearPaintMatrix(6, 6);
        }
    }
    
    private void paintMatrix(int line, int column) {
        for(int scrollLine = line; scrollLine < (line + 3); scrollLine++) {
            for(int scrollColumn = column; scrollColumn < (column + 3); scrollColumn++) {
                this.matrixSudokuFrame[scrollLine][scrollColumn].setBackground(Color.LIGHT_GRAY);
            }
        }
    }
    
    private void clearPaintMatrix(int line, int column) {
        for(int scrollLine = line; scrollLine < (line + 3); scrollLine++) {
            for(int scrollColumn = column; scrollColumn < (column + 3); scrollColumn++) {
                this.matrixSudokuFrame[scrollLine][scrollColumn].setBackground(Color.WHITE);
            }
        }
    }
    
    public static void main(String[] args) {
        new PlayerFrame().setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setMatrix();
    }

    private void setMatrix() {
        int matrix[][] = MatrixSudoku.getMatrixSudoku().getMatrix();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(matrix[i][j] != 0){
                    this.matrixSudokuFrame[i][j].setText(String.valueOf(matrix[i][j]));
                    if(initialize == 0){
                        this.matrixSudokuFrame[i][j].setEditable(false);
                        initialize++;
                    }
                }
            }
        }
    }
}
