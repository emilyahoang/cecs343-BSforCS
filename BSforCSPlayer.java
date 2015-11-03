package bsforcs;

import javax.swing.*;

public class BSforCSPlayer 
{
	private String name;
	private JLabel token;
	
	public BSforCSPlayer(String playerName)
	{
		name = playerName;
		token = new JLabel(name);
	}
	
	public String getName()
	{
		return name;
	}
	
	public JLabel getToken()
	{
		return token;
	}
}
