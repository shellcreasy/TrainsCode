package com.trainscode.service.impl;

import com.trainscode.entity.Edge;
import com.trainscode.entity.Graph;
import com.trainscode.entity.Node;
import com.trainscode.service.GraphService;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class GraphServiceImplTest {

    @Test
    public void testGetPathLengthByNodes() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Edge edge1 = new Edge(nodeA,nodeB,5);
        Edge edge2 = new Edge(nodeB,nodeC,4);
        Edge edge3 = new Edge(nodeC,nodeD,8);
        Edge edge4 = new Edge(nodeD,nodeC,8);
        Edge edge5 = new Edge(nodeD,nodeE,6);
        Edge edge6 = new Edge(nodeA,nodeD,5);
        Edge edge7 = new Edge(nodeC,nodeE,2);
        Edge edge8 = new Edge(nodeE,nodeB,3);
        Edge edge9 = new Edge(nodeA,nodeE,7);
        List<Edge> edges = new ArrayList<Edge>();
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        edges.add(edge6);
        edges.add(edge7);
        edges.add(edge8);
        edges.add(edge9);
        Graph graph = new Graph(edges);
        GraphService graphService = new GraphServiceImpl();
        int  pathLenght = graphService.getPathLengthByNodes(graph,nodeA,nodeB);
        Assert.assertEquals(5 ,pathLenght);
    }
}