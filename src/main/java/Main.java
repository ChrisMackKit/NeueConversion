import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        double[] coords = new double[]{8.4193448, 49.01443214};
        double[] coords1 = new double[]{8.419341124, 49.01438917};
        double[] coords2 = new double[]{8.419336527, 49.01433545};
        double[] coords3 = new double[]{8.419332839, 49.01429235};
        double[] coords4 = new double[]{8.419329163, 49.01424939};
        double[] coords5 = new double[]{8.419326413, 49.01421733};

        ArrayList<double[]> geoJson = new ArrayList<double[]>();
        ArrayList<double[]> newCoord;
        Convert test = new Convert();
        geoJson.add(coords);
        geoJson.add(coords1);
        geoJson.add(coords2);
        geoJson.add(coords3);
        geoJson.add(coords4);
        geoJson.add(coords5);
        for (int j = 0; j < geoJson.size(); j++) {
            System.out.println(geoJson.get(j)[0] + ", " + geoJson.get(j)[1]);
        }
        newCoord = test.newList(geoJson);
        for (int i = 0; i < newCoord.size(); i++) {
            System.out.println(newCoord.get(i)[0] + ", " + newCoord.get(i)[1]);
        }
    }
       /* double[] c1 = {2.0, 2.0};
        double[] c2 = {8.0, 2.0};
        double[] c3 = {4.0, 5.0};
        double[] c4 = {3.0, 9.0};
        double[] c5 = {9.0, 9.0};

        Coordinates a1 = new Coordinates(c1);
        Coordinates a2 = new Coordinates(c2);
        Coordinates a3 = new Coordinates(c3);
        Coordinates a4 = new Coordinates(c4);
        Coordinates a5 = new Coordinates(c5);
        ArrayList<Coordinates> b1 = new ArrayList<Coordinates>();
        ArrayList<Coordinates> b2 = new ArrayList<Coordinates>();
        ArrayList<Coordinates> b3 = new ArrayList<Coordinates>();
        ArrayList<Coordinates> b4 = new ArrayList<Coordinates>();
        ArrayList<Coordinates> b5 = new ArrayList<Coordinates>();
        b1.add(a1);
        b2.add(a2);
        b3.add(a3);
        b4.add(a4);
        b5.add(a5);
        Rssi rssi1 = new Rssi(70, "1");
        Rssi rssi2 = new Rssi(76, "2");
        Rssi rssi3 = new Rssi(70, "3");
        Rssi rssi4 = new Rssi(78, "4");
        Rssi rssi5 = new Rssi(89, "5");
        POI beacon1 = new POI("1", b1);
        POI beacon2 = new POI("2", b2);
        POI beacon3 = new POI("3", b3);
        POI beacon4 = new POI("4", b4);
        POI beacon5 = new POI("5", b5);
        ArrayList<Rssi> rssi = new ArrayList<Rssi>();
        rssi.add(rssi1);
        rssi.add(rssi2);
        rssi.add(rssi3);
        rssi.add(rssi4);
        rssi.add(rssi5);
        ArrayList<POI> beaconList = new ArrayList<POI>();
        beaconList.add(beacon1);
        beaconList.add(beacon2);
        beaconList.add(beacon3);
        beaconList.add(beacon4);
        beaconList.add(beacon5);
        Position position = new Position(beaconList);
        position.setPosition(position.ownPosition(rssi));
        System.out.println("Position: " + position.coordinates.getX() + ", " + position.coordinates.getY());

    }*/
    }
