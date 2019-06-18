package com.trainscode.service.impl;

import com.trainscode.entity.Edge;
import com.trainscode.entity.Graph;
import com.trainscode.entity.Node;
import com.trainscode.service.GraphService;

import java.util.List;

/**
 * @author shell
 */
public class GraphServiceImpl implements GraphService {

    public int getPathLengthByNodes(Graph graph, Node sourceNode, Node destNode,int pathLenght) {
        List<Edge> edges = graph.getEdges();
        for(int i=0;i<edges.size();i++){
            if(edges.get(i).getSourceNode().getNodeName().equals(sourceNode.getNodeName()) &&
                    edges.get(i).getDestNode().getNodeName().equals(destNode.getNodeName())){
                pathLenght = edges.get(i).getWeight();
                return pathLenght;
            }
            if(edges.get(i).getSourceNode().getNodeName().equals(sourceNode.getNodeName()) &&
                    !edges.get(i).getDestNode().getNodeName().equals(destNode.getNodeName())){
                pathLenght = edges.get(i).getWeight() + pathLenght;
                getPathLengthByNodes(graph,edges.get(i).getDestNode(),null,edges.get(i).getWeight());
            }

        }
        return 0;
    }
}
