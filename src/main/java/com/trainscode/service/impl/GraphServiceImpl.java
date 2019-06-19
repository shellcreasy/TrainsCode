package com.trainscode.service.impl;

import com.trainscode.entity.Edge;
import com.trainscode.entity.Graph;
import com.trainscode.entity.Node;
import com.trainscode.service.GraphService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shell
 */
public class GraphServiceImpl implements GraphService {

    private static Map<String, Integer> DirectedGraph;

    @Override
    public boolean buildGraph(String graphString) {
        Map<String, Integer> routeMap = new HashMap<>(16);
        if (graphString != null && !graphString.equals("")) {
            String[] route = graphString.split(",");
            for (int i = 0; i < route.length; i++) {
                routeMap.put(route[i].substring(0, 2), Integer.valueOf(route[i].substring(2, 3)));
            }
        }
        if (routeMap.size() > 0) {
            this.DirectedGraph = routeMap;
            return true;
        }
        return false;
    }

    @Override
    public int getDistanceByRoute(String routes) {
        List<String> tmpEdges = new ArrayList<>(16);
        if (routes != null || !routes.equals("")) {
            for (int i = 0; i < routes.length(); i = i + 2) {
                if (i + 3 <= routes.length()) {
                    String edge = routes.substring(i, i + 3);
                    tmpEdges.add(edge);
                }
            }
        }

        List<String> edges = new ArrayList<>(16);
        for(int i =0;i<tmpEdges.size();i++){
            String[] edgePoints = tmpEdges.get(i).split("-");
            String edge = edgePoints[0] + edgePoints[1];
            edges.add(edge);
        }

        return 0;
    }

    @Override
    public int getNumberOfTripsWithStopsLimit(String source, String destination, int stops) {
        return 0;
    }

    @Override
    public int getLengthOfShortestRoute(String source, String destination) {
        return 0;
    }

    @Override
    public int getNumberOfDifferentRouteWithDistanceLimit(String source, String destination) {
        return 0;
    }
}
