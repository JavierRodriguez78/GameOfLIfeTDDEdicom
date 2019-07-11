package com.javier.rodriguez.GameOfLifeTDD;

import java.util.Arrays;

public class GameOfLife {

	private static final int OVERPOPULATION_THRESHOLD = 3;
	private static final int UNDERPOPULATION_THRESHOLD = 2;
	
	private int[][] world;
	
	public boolean getNextStatus(boolean status, int neighbors)
	{
		if (neighbors<UNDERPOPULATION_THRESHOLD) return false;
		if  (neighbors>OVERPOPULATION_THRESHOLD) return false;
		if (neighbors==2 && status == false) return false;
		return true;
	}
	
	public int[][]  initalizeWorld ( int width, int height)
	{
		return new int[height][width];
	}
	
	public int[][] getWorld() {
		return world;
	}

	public void setWorld(int[][] world) {
		this.world = world;
	}
	
	public int countAliveNeighbours(int posX, int posY)
	{
		int alive = 0;

		for (int x = posX -1; x <= posX + 1; x++) {
            if (x < 0 || x >= world.length) continue;
            for (int y = posY -1; y <= posY + 1; y++) {
                if (y < 0 || y >= world[x].length) continue;
                if ((x != posX ||  y != posY) && world[x][y] == 1)  alive++;
            }
        }
		return alive;
	}
	
	public void getNextGeneration()
	{
		int[][] out = new int[this.world.length][this.world[0].length];
		
		int width= this.world.length;
		int heigth = this.world[0].length;
		
		for (int x=0; x<width; x++) {
			for (int y=0; y<heigth; y++) {
				
				int neighbours = this.countAliveNeighbours(x, y);
				boolean result = this.getNextStatus(world[x][y]==1?true:false, neighbours);
				out[x][y]=result?1:0;
				System.out.print(out[x][y]);
			}
			System.out.println();
		}
		
		
		this.world=out;
	}
			

}
