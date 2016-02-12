/*
===========================================================================================
||	Project:			Risk Game														||
||	Module:				COMP20050														||
||	Author(s):			Rory Buckley, Francis Lawlor									||
||	Contact:			Rory.Buckley.89@gmail.com										||
||	Contact 2:			14745991@ucdconnect.ie											||
||	Description:		Output class using JFrame										||
||	Version:			0.1																||
||																						||
===========================================================================================
 */

package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Output extends JFrame {
	
	public Output() {
		this.setTitle("Risk");
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		final int FRAME_WIDTH = (int) (screensize.getWidth() * 0.75);
		final int FRAME_HEIGHT = (int) (screensize.getHeight() * 0.75);
		
	
		//create panels
		this.game_info_panel= new JPanel();
		this.input_panel = new JPanel();
		this.map_panel = new MapPanel(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		
		//create labels to identify each panel
		JLabel game_info = new JLabel("Game Information", SwingConstants.CENTER);
		JLabel input = new JLabel("User input");
		
		//create text field to be added to user input panel.
		this.tf = new JTextField();
		tf.setPreferredSize(new Dimension(400,24));
		
		//add the labels to the panels
		game_info_panel.add(game_info);
		input_panel.add(input);
		
		//add text field to user input panel.
		input_panel.add(tf);
		
		//create a new panel which consists of panels "game_info_panel" and "input_panel" on top of one another
		JSplitPane bottom_panels = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
		        true, game_info_panel, input_panel);
		        
		//create a new panel which consists of "bottom_panels" beneath "map_panel"
		JSplitPane full_gui= new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
		            true, map_panel, bottom_panels);
		
		//set dimensions for panels
		map_panel.setPreferredSize(new Dimension(
				FRAME_WIDTH, FRAME_HEIGHT));
		game_info.setPreferredSize(new Dimension(
				FRAME_WIDTH, 100));
		
		//prevent panels from being resizeable
		bottom_panels.setEnabled(false);
		game_info_panel.setEnabled(false);
		full_gui.setEnabled(false);
	 	
	 	//add gui to jframe
		this.getContentPane().add(full_gui);
		
		//set what happens when "X" is clicked in right top corner.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		//ensures window can't be resized and dimensions aren't ruined.
		this.setResizable(false);
		//make gui visible
		this.setVisible(true);
 
	}
	
	public JTextField getTextField(){
		return this.tf;
	}
	
	public void addTextOutput(String text){
		
		
	}
	
	public void setArmies(PlayerComponent pl, String country, int inf, int cav, int art){
		
	}
	
	public void setPlayers(String name, int color){
		
	}
	
	/*public void setGameMechanics(GameMechanics game){
	this.game = game;
	}*/
	
	private JTextField tf;
	private JPanel input_panel;
	private JPanel game_info_panel;
	private MapPanel map_panel;
	//private GameMechanics game;
	private static final long serialVersionUID = 1L;
}

/*public static void main(String[] args){
	GameMechanics game = new GameMechanics(new Output());
	/*Output o = new Output();
	game.setFrame(o);
}*/




/*
public class GameMechanics {
	public GameMechanics(){
		
	}
	public GameMechanics(Output o){
		this.frame = o;
	}
	
	public void setFrame(Output o){
		this.frame = o;
	}
	
	String blah = frame.getText(tf);
	
	private Output frame;
}*/
