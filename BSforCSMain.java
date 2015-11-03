package bsforcs;

import javax.imageio.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.awt.image.*;

public class BSforCSMain 
{
	public static void main(String[] args)
	{
		// Create 3 new players
		BSforCSPlayer player1 = new BSforCSPlayer("Player 1");
		BSforCSPlayer player2 = new BSforCSPlayer("Player 2");
		BSforCSPlayer player3 = new BSforCSPlayer("Player 3");
		
		// Display game board
		BSforCSFrame board = new BSforCSFrame();
		
		// Set tokens to default position
		board.setTokens(player1.getToken(), player2.getToken(), player3.getToken());
		
		
		board.pack();
		// Set frame to exit on close
	    board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		// Sets frame to be visible
		board.setVisible(true);

		
	}		
}
