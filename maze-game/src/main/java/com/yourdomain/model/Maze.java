package com.yourdomain.model;

public class Maze {
    private int width;
    private int height;
    private Cell[][] cells;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    // Getters and setters
    // ...
}