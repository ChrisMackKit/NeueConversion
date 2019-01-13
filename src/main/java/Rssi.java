public class Rssi {
    private String beaconName;

    private int rssi;

    public Rssi(int rssi, String name){
        this.beaconName = name;
        this.rssi = rssi;
    }
    public int getRssi() {
        return this.rssi;
    }
    public String getBeaconName(){
        return this.beaconName;
    }
}
