package com.trainscode.service;


/**
 * @author
 */
public interface GraphService {

    /**
     * get distance from certain route
     * @param routes
     * @return
     */
    String getDistanceByRoute(String routes);


    /**
     * number of trips starting at source ending at destination with max stop limit
     * @param source
     * @param destination
     * @param limitStop
     * @param tmpStop
     * @return
     */
    int getNumberOfTripsWithMaxStops(String source,String destination, int limitStop,int tmpStop);

    /**
     * number of trips starting at source ending at destination with exact stop limit
     * @param source
     * @param destination
     * @param limitStop
     * @param tmpStop
     * @return
     */
    int getNumberOfTripsWithExactStops(String source, String destination, int limitStop,int tmpStop);

    /**
     * get length of the shortest route from source to destination
     * @param source
     * @param destination
     * @return
     */
    int getLengthOfShortestRoute(String source,String destination);

    /**
     * get number of different routes from source to destination
     * @param source
     * @param destination
     * @return
     */
    int getNumberOfDifferentRouteWithDistanceLimit(String source,String destination);
}
