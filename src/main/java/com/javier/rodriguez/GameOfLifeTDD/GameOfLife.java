package com.javier.rodriguez.GameOfLifeTDD;

public class GameOfLife {

	private static final int OVERPOPULATION_THRESHOLD = 3;
	private static final int UNDERPOPULATION_THRESHOLD = 2;

	public boolean getNextStatus(boolean status, int neighbors)
	{
		if (neighbors<UNDERPOPULATION_THRESHOLD) return false;
		if  (neighbors>OVERPOPULATION_THRESHOLD) return false;
		return true;
	}
	
	public int[][]  initalizeWorld ( int width, int height)
	{
		return new int[height][width];
	}
	
}
