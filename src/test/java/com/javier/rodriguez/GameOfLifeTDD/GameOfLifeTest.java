package com.javier.rodriguez.GameOfLifeTDD;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
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
	@Test
	public void itShouldLiveIfThreeNeighbors()
	{
		GameOfLife gameOfLife = new GameOfLife();
		boolean result = gameOfLife.getNextStatus(false,3);
		assertTrue(result);
	}
	
	@Test
	public void itShoudlInitializeAnEmptyWorld()
	{
		GameOfLife gameOfLife= new GameOfLife();
		int[][] expectedWorld = {{0,0},{0,0},{0,0}};
		
		int[][] initalizedWorld = gameOfLife.initalizeWorld(2,3);
		
		assertArrayEquals(expectedWorld, initalizedWorld);
	
		
	}
	
	@Test
	public void itShouldGetCountCellAliveNeighbours()
	{
		int[][] world = {{0,0,0,0},{0,1,0,0},{0,1,0,1},{0,0,0,0}};
		GameOfLife gameOfLife = new GameOfLife();
		gameOfLife.setWorld(world);
		int result = gameOfLife.countAliveNeighbours(1,1);
		assertEquals(3, result);
	}
	
}

