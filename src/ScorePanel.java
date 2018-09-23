import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ScorePanel extends JPanel implements Cloneable{
    private static final long serialVersionUID = 1L;
    private JButton p1,v1;
    private JPanel logoPanel;
  

    public ScorePanel() {
	super(new BorderLayout());
	setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	logoPanel = new JPanel();
	addButtons();
	addValidate();
	this.add(BorderLayout.CENTER, logoPanel);
	this.setBackground(new Color(0xD62D26));
	
//	addPicture();
    }

    public void addButtons() {
	p1 = new JButton("Play Turn");
	
	this.add(BorderLayout.NORTH, p1);
	
	p1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		Scrabble.s.setTurn(Scrabble.TRAY2);
	    }
	});

    }
    
    public void addValidate() {
    	v1 = new JButton("validate");
    	
    	this.add(BorderLayout.SOUTH, v1);
    	
    	v1.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	JOptionPane.showMessageDialog(null, "Valid word!");
    	    }
    	});
    }
    

    public void setButton(boolean _turn) {
	p1.setVisible(_turn);
    }
}
