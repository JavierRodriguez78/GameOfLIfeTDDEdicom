package com.javier.rodriguez.GameOfLifeTDD;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 * Unit test for simple App.
 */


public class GameOfLifeTest 
{
	@Test
	public void isAliveCell()
	{
		Cell cell = new Cell(true);
		
		assertTrue(cell.isAlive());
		
	}
	
	
}

