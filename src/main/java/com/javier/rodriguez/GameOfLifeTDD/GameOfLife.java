package com.javier.rodriguez.GameOfLifeTDD;

public class GameOfLife {

	private static final int OVERPOPULATION_THRESHOLD = 3;
	private static final int UNDERPOPULATION_THRESHOLD = 2;
	
	private int[][] world;
	
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
		
		
//		for(int x=posX-1; x<=posX+1; x++) {
//			
//			 
//			for(int y=posY-1; x>=0  && y<=posY+1; y++) {
//				
//				if(x!=posX && y !=posY  && world[x][y]==1)  alive++; 
//			}
//			
//		}
		
		
//		if(world[posX-1][posY-1]==1) alive++;
//		if(world[posX-1][posY]==1) alive++;
//		if(world[posX-1][posY+1]==1) alive++;
//		
//		if(world[posX][posY-1]==1) alive++;
//		if(world[posX][posY+1]==1) alive++;
//		
//		if(world[posX+1][posY-1]==1) alive++;
//		if(world[posX+1][posY]==1) alive++;
//		if(world[posX+1][posY+1]==1) alive++;
//			
			
		return alive;
	}

}
