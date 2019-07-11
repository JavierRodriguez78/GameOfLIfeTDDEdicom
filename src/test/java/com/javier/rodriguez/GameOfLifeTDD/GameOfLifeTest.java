package com.javier.rodriguez.GameOfLifeTDD;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
/**
 * Unit test for simple App.
 */

@RunWith(DataProviderRunner.class)
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
	
	
	@DataProvider
	public static Object[][] dataNumberProviderForWorld(){
		return new Object[][] {
			{0,0,1},
			{0,1,1},
			{0,2,1},
			{0,3,0},
			{1,0,2},
			{1,1,1},
			{1,2,3},
			{1,3,1},
			{3,0,1},
			{3,1,1},
			{3,2,2},
			{3,3,1}
		};
	}
	@Test
	@UseDataProvider("dataNumberProviderForWorld")
	public void itShouldGetCountCellAliveNeighbours(final int x, final int y,final int expected)
	{
		int[][] world = {{0,0,0,0},{0,1,0,0},{0,1,0,1},{0,0,0,0}};
		GameOfLife gameOfLife = new GameOfLife();
		gameOfLife.setWorld(world);
		int result = gameOfLife.countAliveNeighbours(x,y);
		assertEquals(expected, result);
//		[0,0,0,0]
//		[0,1,0,0]
//		[0,1,0,1]
//		[0,0,0,0]

	}
	
}

