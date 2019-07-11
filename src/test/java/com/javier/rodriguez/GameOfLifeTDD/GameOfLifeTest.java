package com.javier.rodriguez.GameOfLifeTDD;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
	@Test
	public void isDeadCell()
	{
		Cell cell = new Cell(false);
		
		assertFalse(cell.isAlive());
		
	}
	
	@Test
	public void itShouldDeadIfLessThanTwooNeighbors()
	{
		GameOfLife gameOfLife = new GameOfLife();
		boolean result = gameOfLife.getNextStatus(true,1);
		assertFalse(result);
	}
	
	@Test
	public void itShouldDeadIfTwooOrThreeNeighbors()
	{
		GameOfLife gameOfLife = new GameOfLife();
		boolean result = gameOfLife.getNextStatus(true,2);
		assertTrue(result);
	}
	
	@Test
	public void itShouldDeadIfMoreThanThreeNeighbors()
	{
		GameOfLife gameOfLife = new GameOfLife();
		boolean result = gameOfLife.getNextStatus(true,4);
		assertFalse(result);
	}
	
	
}

