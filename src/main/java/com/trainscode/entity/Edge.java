package com.trainscode.entity;

import lombok.Data;

/**
 * @author shell
 */
@Data
public class Edge {
    private Node sourceNode;
    private Node destNode;
    private int weight;

    public Edge(Node sourceNode, Node destNode, int weight) {
        this.sourceNode = sourceNode;
        this.destNode = destNode;
        this.weight = weight;
    }
}
