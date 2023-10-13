package lab03.Ex1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;
public class JGalo extends JFrame implements ActionListener {
	private static final long serialVersionUID = -3780928537820216588L; // ignore this
	private JPanel jPanel = null; // the panel
	private JToggleButton bt[]; // the buttons
	JGaloInterface jogo ;  // the game to be played

	public JGalo(JGaloInterface myGreatGame) {
		super("Jogo da Galinha"); // title of the window
		jogo = myGreatGame;	 // the game to be played
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close the window
		setSize(300,300); // size of the window
        setLocation(100,100); // position of the window
        jPanel = new JPanel(); // create a panel
		jPanel.setLayout(new GridLayout(3,3)); // 3x3 grid layout
		bt = new JToggleButton[9];
		for (int i=0; i<9; i++) {  // 9 buttons in the grid layout 
			bt[i] = new JToggleButton();
			bt[i].setFont(new Font("Tahoma", Font.BOLD, 50));
			bt[i].setForeground(Color.BLUE);
			bt[i].addActionListener(this);
			jPanel.add(bt[i]);				
		}
		  
		this.setContentPane(jPanel); // add the panel to the window
		setVisible(true); // show the window
	}

	public void actionPerformed(ActionEvent e) { // when a button is pressed
		if (e.getSource().getClass().getSimpleName().equals("JToggleButton")){ // if it is a JToggleButton
			((JToggleButton)e.getSource()).setText(String.valueOf(jogo.getActualPlayer())); // set the text of the button
			((JToggleButton)e.getSource()).setEnabled(false); // disable the button
		}
		for (int i=0; i<9; i++) // find the button pressed
			if (e.getSource()==bt[i]) { // if it is the button i
				jogo.setJogada(i/3+1,i%3+1); // set the jogada
			}

		if (jogo.isFinished()){ // if the game is finished
			char result = jogo.checkResult(); // check the result
			if (result == ' ') // if the result is ' ' it is a draw
				JOptionPane.showMessageDialog(getContentPane(), "Empate!");
			else // otherwise it is a win
				JOptionPane.showMessageDialog(getContentPane(), "Venceu o jogador " + result);
			System.exit(0);
		}
	}

	public static void main(String args[]) { // the main method
		if(args.length == 0){
			new JGalo(new Galo());
		} else {
			new JGalo(new Galo(args));
		}
	}
} 
