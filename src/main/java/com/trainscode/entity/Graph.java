package com.trainscode.entity;

import lombok.Data;

import java.util.List;

/**
 * @author shell
 */
@Data
public class Graph {
    private List<Edge> edges;

    public Graph(List<Edge> edges) {
        this.edges = edges;
    }
}
