package com.javier.rodriguez.GameOfLifeTDD;

public class GameOfLife {

	public boolean getNextStatus(boolean status, int neighbors)
	{
		if (neighbors<2) return false;
		if  (neighbors>3) return false;
		return true;
	}
	
}
