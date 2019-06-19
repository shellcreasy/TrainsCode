package com.trainscode.service.impl;

import com.trainscode.service.GraphService;

import java.util.*;

/**
 * @author shell
 */
public class GraphServiceImpl implements GraphService {

    private Map<String, Integer> DirectedGraph;

    private int trips = 0;

    public GraphServiceImpl(String graphString) {
        Map<String, Integer> routeMap = new HashMap<>(16);
        if (graphString != null && !graphString.equals("")) {
            String[] route = graphString.split(",");
            for (int i = 0; i < route.length; i++) {
                routeMap.put(route[i].substring(0, 2), Integer.valueOf(route[i].substring(2, 3)));
            }
        }
        if (routeMap.size() > 0) {
            this.DirectedGraph = routeMap;
        }
    }

    @Override
    public String getDistanceByRoute(String routes) {
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

        Set<String> graphEdges = DirectedGraph.keySet();
        int distance = 0;
        for(int i =0;i<edges.size();i++){
            if(!graphEdges.contains(edges.get(i))){
                return "NO SUCH ROUTE";
            }
            if(graphEdges.contains(edges.get(i))){
                distance = distance + DirectedGraph.get(edges.get(i));
            }
        }

        return Integer.toString(distance);
    }

    @Override
    public int getNumberOfTripsWithMaxStops(String source, String destination, int limitStop,int tmpStop) {
        Iterator<String> iterator = DirectedGraph.keySet().iterator();
        int stop;
       while (iterator.hasNext()){
           String edge = iterator.next();
           if(edge.startsWith(source) && !edge.endsWith(destination)){
               stop = tmpStop + 1;
               getNumberOfTripsWithMaxStops(edge.substring(1,2),destination,limitStop,stop);
           }
           if(edge.startsWith(source) && edge.endsWith(destination)){
               stop = tmpStop + 1;
               if(stop <= limitStop){
                   trips = trips + 1;
               }
           }
       }
        return trips;
    }

    /**
     * number of trips starting at source ending at destination with exact stop limit
     *
     * @param source
     * @param destination
     * @param limitStop
     * @param tmpStop
     * @return
     */
    @Override
    public int getNumberOfTripsWithExactStops(String source, String destination, int limitStop, int tmpStop) {
        Iterator<String> iterator = DirectedGraph.keySet().iterator();
        int stop;
        while (iterator.hasNext()){
            String edge = iterator.next();
            if(edge.startsWith(source) && !edge.endsWith(destination)){
                stop = tmpStop + 1;
                getNumberOfTripsWithExactStops(edge.substring(1,2),destination,limitStop,stop);
            }
            if(edge.startsWith(source) && edge.endsWith(destination)){
                stop = tmpStop + 1;
                if(stop == limitStop){
                    trips = trips + 1;
                }
            }
        }
        return trips;
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
