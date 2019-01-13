import java.util.ArrayList;

public class Position {


    public double[] coordinates;

    private ArrayList<POI> beaconList;

    public Position(ArrayList<POI> bl){
        this.beaconList = bl;

        coordinates = new double[]{0.0, 0.0};
    }
    public void setPosition(double[] coords) {
        this.coordinates = coords;
    }

    /*
     * Takes List of rssi's orders them into classes 1 to 3 (based on the Beacon signal classes) and based on those
     * Beacons it finds the middle between the beacons in the same class.
     */

    public double[] ownPosition(ArrayList<Rssi> rssi) {
        ArrayList<Rssi> class1 = beaconClass1(rssi);
        ArrayList<Rssi> class2 = beaconClass2(rssi);
        ArrayList<Rssi> class3 = beaconClass3(rssi);
        double[] ownPosition = new double[]{0, 0};
        if (class1.size() != 0) {
            ownPosition = positionBetweenBeacon(class1);
        } else if (class2.size() != 0) {
            ownPosition = positionBetweenBeacon(class2);
        } else if (class3.size() != 0) {
            ownPosition = positionBetweenBeacon(class3);
        }
        return ownPosition;
    }

    //Beacon who are max. 1 Meter away (rssi: 1-40). List is null if no beacon was found in that rssi range
    public ArrayList<Rssi> beaconClass1(ArrayList<Rssi> rssis) {
        ArrayList<Rssi> beaconClass1 = new ArrayList<Rssi>();
        for (int i = 0; i < rssis.size(); i++) {
            if ((rssis.get(i).getRssi()) < 40) {
                beaconClass1.add(rssis.get(i));
            }
        }
        return beaconClass1;
    }

    //Beacon who are max. 1-4 Meter away (rssi: 40-70). List is null if no beacon was found in that rssi range
    public ArrayList<Rssi> beaconClass2(ArrayList<Rssi> rssis) {
        ArrayList<Rssi> beaconClass2 = new ArrayList<Rssi>();
        for (int i = 0; i < rssis.size(); i++) {
            if (40 <= (rssis.get(i).getRssi()) && (rssis.get(i).getRssi()) < 70) {
                beaconClass2.add(rssis.get(i));
            }
        }
        return beaconClass2;
    }

    //Beacon who are max. 4+ Meter away (rssi: 70+). List is null if no beacon was found in that rssi range
    public ArrayList<Rssi> beaconClass3(ArrayList<Rssi> rssis) {
        ArrayList<Rssi> beaconClass3 = new ArrayList<Rssi>();
        for (int i = 0; i < rssis.size(); i++) {
            if (70 <= (rssis.get(i).getRssi())) {
                beaconClass3.add(rssis.get(i));
            }
        }
        return beaconClass3;
    }


    /*
     *Takes a rssi, searches the Beacon List for the Beacon with the same name and returns the coordinates
     */

    public double[] getBeaconCoordinates(Rssi beacon) {
        for (int i = 0; i < beaconList.size(); i++) {
            if(beaconList.get(i).isBeacon(beacon.getBeaconName())) {
                return beaconList.get(i).getCoordinates().get(0);
            }
        }
        // double[] x = {0, 0};
        // Coordinates zero = new Coordinates(x);
        return null;
    }

    //Takes rssi List and finds Beaconlocations and finds the middle of those Beacons. It returns Coordinates od middle
    public double[] positionBetweenBeacon(ArrayList<Rssi> rssiList) {
        double[] ownPosition = new double[]{0, 0};
        int timesBeaconWasNotFound = 0;
        for(int j = 0; j < rssiList.size(); j++) {
            ownPosition[0] = (ownPosition[0] + getBeaconCoordinates(rssiList.get(j))[0]);
            ownPosition[1] = (ownPosition[1] + getBeaconCoordinates(rssiList.get(j))[1]);

            //If getBeaconCoordinates return null it was not found so we devide by one less
            if(getBeaconCoordinates(rssiList.get(j)) == null) {
                timesBeaconWasNotFound++;
            }
        }
        ownPosition[0] = (ownPosition[0] / ( rssiList.size() - timesBeaconWasNotFound));
        ownPosition[1] = (ownPosition[1] / ( rssiList.size() - timesBeaconWasNotFound));
        return ownPosition;
    }
}
