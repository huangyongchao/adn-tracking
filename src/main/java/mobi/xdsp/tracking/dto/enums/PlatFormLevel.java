package mobi.xdsp.tracking.dto.enums;


public enum PlatFormLevel {
    /**
     *
     */
    One("1",1), Two("2",2), Three("3",3), Four("4",4), Five("5",5);

    public String key;
    public int value;

    private PlatFormLevel(String key, int value) {
        this.key = key;
        this.value = value;
    }


}
