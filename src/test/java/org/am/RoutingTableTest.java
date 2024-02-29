package org.am;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoutingTableTest {

    @Test
    void route() {
        RoutingTable routingTable = new RoutingTable();
        routingTable.withRoute("a.com", "result.com");
        assertEquals("result.com", routingTable.route("a.com"));
        routingTable.withRoute("a.com/abc", "result.com");
        assertEquals("result.com", routingTable.route("a.com/abc"));
        routingTable.withRoute("a.com/abc*", "result1.com");
        assertNull(routingTable.route("a.com/abcd"));
        routingTable.withRoute("a.com/abc/*", "result.com");
        assertEquals("result.com", routingTable.route("a.com/abc/dfasdf"));
        assertEquals("result.com", routingTable.route("a.com/abc/"));
        routingTable.withRoute("http://a.com/abc/", "result.com");
        assertEquals("result.com", routingTable.route("http://a.com/abc/"));
        routingTable.withRoute("http://a.com/abc/*/bcf", "result.com");
        assertEquals("result.com", routingTable.route("http://a.com/abc/sadfasdf/bcf"));
        routingTable.withRoute("http://a.com/abc/cdf/bcf", "result1.com");
        assertEquals("result1.com", routingTable.route("http://a.com/abc/cdf/bcf"));


    }
}