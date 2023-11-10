import java.util.Arrays;
import java.util.Random;

public class GeoLocation {
    Random random = new Random();

    double lat_Rand = (double) random.nextInt(-90000000, 90000001) / 1000000;
    double lon_Rand = (double) random.nextInt(-90000000, 90000001) / 1000000;
    double lan_Plus_Rand = random.nextDouble(-.1, .1);
    double lon_Plus_Rand = random.nextDouble(-.1, .1);
    private static int numLocations = 0;
    private static double distance;
    private final double[] location = new double[2];


    public GeoLocation() {
        this.location[0] = this.lat_Rand;
        this.location[1] = this.lon_Rand;
        numLocations++;
    }

    public GeoLocation(double lat1, double lon1) {
        this.location[0] = lat1;
        this.location[1] = lon1;
        numLocations++;
    }

    GeoLocation(GeoLocation copy) {
        location[0] = Math.round((copy.location[0] + lan_Plus_Rand) * 1000000) / 1000000.0;
        location[1] = Math.round((copy.location[1] + lon_Plus_Rand) * 1000000) / 1000000.0;
        numLocations++;
    }

    public static int getNumLocations() {
        return numLocations;
    }

    public static String distance(GeoLocation vilnius, GeoLocation kaunas) {
        double lat1 = vilnius.location[0];
        double lon1 = vilnius.location[1];
        double lat2 = kaunas.location[0];
        double lon2 = kaunas.location[1];
        HaversineDistance(lat1, lon1, lat2, lon2);
        return String.valueOf(distance);
    }

    private static void HaversineDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        double latDistance = toRad(lat2 - lat1);
        double lonDistance = toRad(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(toRad(lat1)) * Math.cos(toRad(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        distance = Math.round((R * c) * 10) / 10.0;
    }

    private static double toRad(double value) {
        return value * Math.PI / 180;
    }

    public void print() {
        System.out.println(Arrays.toString(location));
    }
}

