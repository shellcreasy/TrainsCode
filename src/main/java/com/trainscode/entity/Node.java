package com.trainscode.entity;

import lombok.Data;
import java.util.List;

/**
 * @author shell
 */
@Data
public class Node {
    private String nodeName;
    private List<Node> adjNodes;
    public Node(String nodeName){
        this.nodeName = nodeName;
    }
}
