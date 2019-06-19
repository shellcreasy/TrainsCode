package com.trainscode.service.impl;

import com.trainscode.service.GraphService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GraphServiceImplTest {

    private static String graphString = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";

    @Test
    public void testGetDistanceByRoute() throws Exception {
        String routeString = "A-B-C";
        GraphService graphService = new GraphServiceImpl(graphString);
        String distance = graphService.getDistanceByRoute(routeString);
        Assert.assertEquals("9",distance);
    }

    @Test
    public void testInput2() throws Exception {
        String routeString = "A-D";
        GraphService graphService = new GraphServiceImpl(graphString);
        String distance = graphService.getDistanceByRoute(routeString);
        Assert.assertEquals("5",distance);
    }

    @Test
    public void testInput3() throws Exception {
        String routeString = "A-D-C";
        GraphService graphService = new GraphServiceImpl(graphString);
        String distance = graphService.getDistanceByRoute(routeString);
        Assert.assertEquals("13",distance);
    }

    @Test
    public void testInput4() throws Exception {
        String routeString = "A-E-B-C-D";
        GraphService graphService = new GraphServiceImpl(graphString);
        String distance = graphService.getDistanceByRoute(routeString);
        Assert.assertEquals("22",distance);
    }

    @Test
    public void testInput5() throws Exception {
        String routeString = "A-E-D";
        GraphService graphService = new GraphServiceImpl(graphString);
        String distance = graphService.getDistanceByRoute(routeString);
        Assert.assertEquals("NO SUCH ROUTE",distance);
    }

    @Test
    public void testGetNumberOfTripsWithMaxStops() throws Exception {
        GraphService graphService = new GraphServiceImpl(graphString);
        int trips = graphService.getNumberOfTripsWithMaxStops("C","C",3,0);
        Assert.assertEquals(2,trips);
    }

    @Test
    public void testGetNumberOfTripsWithExactStops() throws Exception {
        GraphService graphService = new GraphServiceImpl(graphString);
        int trips = graphService.getNumberOfTripsWithExactStops("A","C",4,0);
        Assert.assertEquals(3,trips);
    }

    @Test
    public void testGetLengthOfShortestRoute() throws Exception {
    }

    @Test
    public void testGetNumberOfDifferentRouteWithDistanceLimit() throws Exception {
    }

}