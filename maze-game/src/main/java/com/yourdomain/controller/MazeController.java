package com.yourdomain.controller;

import com.yourdomain.model.Maze;
import com.yourdomain.model.Cell;
import com.yourdomain.service.MazeGenerator;
import com.yourdomain.service.PathFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maze")
public class MazeController {

    @Autowired
    private MazeGenerator mazeGenerator;

    @Autowired
    private PathFinder pathFinder;

    @GetMapping("/generate")
    public Maze generateMaze(@RequestParam int width, @RequestParam int height) {
        return mazeGenerator.generateMaze(width, height);
    }

    @PostMapping("/solve")
    public List<Cell> solveMaze(@RequestBody Maze maze) {
        Cell start = maze.getCell(0, 0);
        Cell end = maze.getCell(maze.getHeight() - 1, maze.getWidth() - 1);
        return pathFinder.findShortestPath(maze, start, end);
    }
}