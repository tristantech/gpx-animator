package app.gpx_animator.core.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceUnitTest {

    @Test
    void testMeters() {
        assertEquals(0.1, DistanceUnit.METERS.convertDistance(0.1), 0.05);
        assertEquals(5.3, DistanceUnit.METERS.convertDistance(5.3), 0.05);
        assertEquals(9.9, DistanceUnit.METERS.convertDistance(9.9), 0.05);
        assertEquals(123.4, DistanceUnit.METERS.convertDistance(123.4), 0.05);
    }

    @Test
    void testFeet() {
        assertEquals(0.33, DistanceUnit.FEET.convertDistance(0.1), 0.05);
        assertEquals(17.3885, DistanceUnit.FEET.convertDistance(5.3), 0.05);
        assertEquals(32.4803, DistanceUnit.FEET.convertDistance(9.9), 0.05);
        assertEquals(404.85564, DistanceUnit.FEET.convertDistance(123.4), 0.05);
    }

    @Test
    void testKilometers() {
        assertEquals(0.1234, DistanceUnit.KILOMETERS.convertDistance(123.4), 0.0005);
        assertEquals(0.500, DistanceUnit.KILOMETERS.convertDistance(500), 0.0005);
        assertEquals(1.999, DistanceUnit.KILOMETERS.convertDistance(1999), 0.0005);
        assertEquals(12.34567, DistanceUnit.KILOMETERS.convertDistance(12345.67), 0.0005);
    }

    @Test
    void testMiles() {
        assertEquals(0.076677205, DistanceUnit.MILES.convertDistance(123.4), 0.0005);
        assertEquals(0.310686, DistanceUnit.MILES.convertDistance(500), 0.0005);
        assertEquals(1.242121, DistanceUnit.MILES.convertDistance(1999), 0.0005);
        assertEquals(7.6712436869, DistanceUnit.MILES.convertDistance(12345.67), 0.0005);
    }
}
