package com.trainscode.service;

import java.util.Map;

/**
 * @author
 */
public interface GraphService {
    boolean buildGraph(String graphString);
    int getDistanceByRoute(String routes);
    int getNumberOfTripsWithStopsLimit(String source,String destination,int stops);
    int getLengthOfShortestRoute(String source,String destination);
    int getNumberOfDifferentRouteWithDistanceLimit(String source,String destination);
}
