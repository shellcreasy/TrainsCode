package com.trainscode.service;

import com.trainscode.entity.Graph;
import com.trainscode.entity.Node;

public interface GraphService {
    int getPathLengthByNodes(Graph graph, Node sourceNode, Node destNode,int pathLenght);
}
