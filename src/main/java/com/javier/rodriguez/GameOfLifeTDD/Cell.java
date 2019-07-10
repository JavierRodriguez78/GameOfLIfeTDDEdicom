package com.javier.rodriguez.GameOfLifeTDD;

public class Cell {

	private Boolean aLife;

	public Cell(Boolean aLife) {
		super();
		this.aLife = aLife;
	}

	public Boolean isAlive() {
		return aLife;
	}

	public void setaLife(Boolean aLife) {
		this.aLife = aLife;
	}
	
	
	
}
