package ru.netology.geo;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    protected String ip;
    protected Location testLocation;
    protected Location geoServiceLocation;


    protected void compare(Location testLocation, Location geoServiceLocation) {
        assertEquals(testLocation.getCity(), geoServiceLocation.getCity());
        assertEquals(testLocation.getCountry(), geoServiceLocation.getCountry());
        assertEquals(testLocation.getStreet(), geoServiceLocation.getStreet());
        assertEquals(testLocation.getBuiling(), geoServiceLocation.getBuiling());
    }

    @Test
    void byIpLocalhost() {

        ip = "127.0.0.1";
        GeoServiceImpl geoService = new GeoServiceImpl();
        geoServiceLocation = geoService.byIp(ip);
        testLocation = new Location(null, null, null, 0);
        compare(testLocation, geoServiceLocation);
    }

    @Test
    void byIpRussia() {

        ip = "172.0.0.1";
        GeoServiceImpl geoService = new GeoServiceImpl();
        geoServiceLocation = geoService.byIp(ip);
        testLocation = new Location("Moscow", Country.RUSSIA, null, 0);
        compare(testLocation, geoServiceLocation);
    }

    @Test
    void byIpUSA() {

        ip = "96.0.0.1";
        GeoServiceImpl geoService = new GeoServiceImpl();
        geoServiceLocation = geoService.byIp(ip);
        testLocation = new Location("New York", Country.USA, null, 0);
        compare(testLocation, geoServiceLocation);
    }

}