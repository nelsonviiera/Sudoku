package Model;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author yudi
 */
public class JTextFieldOnlyNumbers extends JTextField {
        private int maxCharacters = 1, line, column;
    
    public JTextFieldOnlyNumbers() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKeyTyped(evt);}});
    }
  
    private void jTextFieldKeyTyped(KeyEvent evt) {
        String characters="123456789";
        if(!characters.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
        if((getText().length() >= getMaxCharacters()) && (getMaxCharacters() != -1)){
            evt.consume();
            setText(getText().substring(0,getMaxCharacters()));
        }
    }

    public int getMaxCharacters() {
        return maxCharacters;
    }
    
    public void setMaxCharacters(int maxCharacters) {
        this.maxCharacters = maxCharacters;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
