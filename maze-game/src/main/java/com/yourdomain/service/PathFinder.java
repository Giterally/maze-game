package com.yourdomain.service;

import com.yourdomain.model.Maze;
import com.yourdomain.model.Cell;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.List;

public class PathFinder {
    public List<Cell> findShortestPath(Maze maze, Cell start, Cell end) {
        Graph<Cell, DefaultEdge> graph = buildGraph(maze);
        DijkstraShortestPath<Cell, DefaultEdge> dijkstraAlg = new DijkstraShortestPath<>(graph);
        return dijkstraAlg.getPath(start, end).getVertexList();
    }

    private Graph<Cell, DefaultEdge> buildGraph(Maze maze) {
        Graph<Cell, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        
        // Add vertices
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                graph.addVertex(maze.getCell(i, j));
            }
        }

        // Add edges
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                Cell cell = maze.getCell(i, j);
                if (!cell.hasNorthWall() && i > 0) graph.addEdge(cell, maze.getCell(i-1, j));
                if (!cell.hasSouthWall() && i < maze.getHeight()-1) graph.addEdge(cell, maze.getCell(i+1, j));
                if (!cell.hasEastWall() && j < maze.getWidth()-1) graph.addEdge(cell, maze.getCell(i, j+1));
                if (!cell.hasWestWall() && j > 0) graph.addEdge(cell, maze.getCell(i, j-1));
            }
        }

        return graph;
    }
}