import java.util.ArrayList;

public class POI {

    public POI(String title, ArrayList<double[]> coords){
        this.title = title;
        this.coordinates = coords;
    }
    private String title;


    private ArrayList<double[]> coordinates;

    //uses function intoMeter (Building) for whole list
    public ArrayList<double[]> newList(ArrayList<double[]> coordinatesRoom, ArrayList<double[]> coordinatesBuilding) {
        double[] zero = Convert.findZero(coordinatesBuilding);
        ArrayList<double[]> newCoords = new ArrayList<double[]>();
        for (int j = 0; j < coordinatesRoom.size(); j++) {
            newCoords.add(j, Convert.intoMeter(coordinatesRoom.get(j), zero));

        }
        return newCoords;
    }
    public boolean isBeacon(String name) {
        if(this.title == name) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<double[]> getCoordinates() {
        return coordinates;
    }
}
