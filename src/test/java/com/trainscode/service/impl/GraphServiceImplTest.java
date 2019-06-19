package com.trainscode.service.impl;

import com.trainscode.service.GraphService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.*;

public class GraphServiceImplTest {
    @Test
    public void testBuildGraph() throws Exception {
        String graphString = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
        GraphService graphService = new GraphServiceImpl();
        boolean result = graphService.buildGraph(graphString);
        Assert.assertTrue(result);
    }

    @Test
    public void testGetDistanceByRoute() throws Exception {
        String routeString = "A-E-B-C-D";
        GraphService graphService = new GraphServiceImpl();
        int distance = graphService.getDistanceByRoute(routeString);
        Assert.assertEquals(1,distance);
    }

    @Test
    public void testGetNumberOfTripsWithStopsLimit() throws Exception {
    }

    @Test
    public void testGetLengthOfShortestRoute() throws Exception {
    }

    @Test
    public void testGetNumberOfDifferentRouteWithDistanceLimit() throws Exception {
    }

}