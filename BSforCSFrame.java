package bsforcs;

import java.awt.*;
import java.awt.image.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.io.*;

public class BSforCSFrame extends JFrame
{
	// CONSTANTS
	// VARIABLES
	private JPanel boardContentPane;
	private JPanel controlPanel;
	private JLayeredPane boardPanel;
	private JLabel mapLabel;
	private JLabel token1 = new JLabel("TESTING");
	private JLabel token2 = new JLabel();
	private JLabel token3 = new JLabel();
	private Rectangle frameDimensions;
	
	public BSforCSFrame()
	{
		// Name of the window
		super("CECS BS Challenge Game");
		// Set frame to fullscreen
		super.setExtendedState(JFrame.MAXIMIZED_BOTH);
		super.setMinimumSize(new Dimension(1600, 900));
		// Get Dimensions for frame (should return whatever the computer's full
		// screen dimensions are
		frameDimensions = super.getBounds();
		
		//boardContentPane = super.getboardContentPane();
		//boardContentPane.setLayout(new BorderLayout());
		
		// Add background image pane to frame
		createMainPanel();
		
	}
	
	// METHOD - UTILITY method for loading images
	public BufferedImage loadImage(String imageURL)
	{
		BufferedImage image = null;
		// Set background image to CSULB map
		try
		{
			// load image from file
			image = ImageIO.read(new File(imageURL));
		}
		catch(IOException e)
		{
			System.out.println("Image not found!?");
		}
		
		return image;
	}
	
	// METHOD - Creates panel to contain the UI elements to control the game
	private void createControlPanel()
	{
		// New panel to contain game controls
		controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder(new EtchedBorder(), "Game Controls"));
	}
	
	// METHOD - Creates panel to contain the CSULB map game board
	private void createBoardPanel()
	{
		// New panel to contain CSULB map board
		boardPanel = new JLayeredPane();
		boardPanel.setPreferredSize(new Dimension(1670, 2000));
		//LayoutManager overlay = new OverlayLayout(boardPanel);
		//boardPanel.setLayout(overlay);
		// Load image into JLabel
		mapLabel = new JLabel(new ImageIcon(loadImage("images/BSforCSMap.png")));
		//mapLabel.setIcon(new ImageIcon(loadImage("images/BSforCSMap.png")));
		mapLabel.setOpaque(true);
		mapLabel.setBounds(0, 0, 1670, 2000);
		boardPanel.add(mapLabel, JLayeredPane.DEFAULT_LAYER);
		// Allows for scroll within the panel
		JScrollPane scrollPane = new JScrollPane(boardPanel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 0, frameDimensions.width, frameDimensions.height);
		
		//Make new panel to add scrollPane into
		boardContentPane = new JPanel(null);
		boardContentPane.setPreferredSize(new Dimension(1670, 2000));
		boardContentPane.add(scrollPane);
	}
	
	// METHOD - Creates main wrapper panel to hold all other panels
	private void createMainPanel()
	{
		// Create new JPanel to contain components of the JFrame
		JPanel mainPanel = new JPanel();
		// Set JPanel layout to BorderLayout
		mainPanel.setLayout(new BorderLayout());
		
		// METHOD CALLS - Creates panels for each button section
		createBoardPanel();
		createControlPanel();
		
		// Add board and game controls to main panel
		mainPanel.add(boardContentPane);
		mainPanel.add(controlPanel, BorderLayout.SOUTH);
		
		// Add panel to the JFrame
		add(mainPanel);		
	}
	
	public JLabel createToken(JLabel newToken)
	{
		JLabel token = newToken;
		token.setFont(token.getFont().deriveFont(Font.BOLD, 30));
		token.setBackground(null);
		token.setOpaque(true);
		token.setBounds(1000, 1500, 130, 80);
		
		return token;
	}
	
	public void setTokens(JLabel p1token, JLabel p2token, JLabel p3token)
	{
		token1 = createToken(p1token);
		token2 = createToken(p2token);
		token2.setBounds(1000, 1425, 130, 80);
		token3 = createToken(p3token);
		token3.setBounds(1000, 1350, 130, 80);
		
		boardPanel.add(token1, JLayeredPane.PALETTE_LAYER);
		boardPanel.add(token2, JLayeredPane.PALETTE_LAYER);
		boardPanel.add(token3, JLayeredPane.PALETTE_LAYER);
	}
	
	// METHOD - Moves token on the map. playerNum = which player's token to move, x and y = coordinates to move to
	public void moveToken(int playerNum, int x, int y)
	{
		if (playerNum == 1)
		{
			token1.setBounds(x, y, 130, 80);
		}
		else if (playerNum == 2)
		{
			token2.setBounds(x - 75, y - 75, 130, 80);
		}
		else if (playerNum == 3)
		{
			token3.setBounds(x - 150, y - 150, 130, 80);
		}
		repaint();
	}

	public int getFrameHeight()
	{
		return frameDimensions.height;
	}
	
	public int getFrameWidth()
	{
		return frameDimensions.height;
	}
}