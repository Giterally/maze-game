package com.yourdomain.model;

public class Cell {
    private int row;
    private int col;
    private boolean visited;
    private boolean northWall;
    private boolean southWall;
    private boolean eastWall;
    private boolean westWall;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.visited = false;
        this.northWall = true;
        this.southWall = true;
        this.eastWall = true;
        this.westWall = true;
    }

    // Getters and setters
    // ...
}