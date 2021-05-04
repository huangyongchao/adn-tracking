package mobi.xdsp.tracking.dto.enums;


public enum SubidGenerateTypeE {
    /**
     *
     */
    GridMobi("jinglemobi"), GridMobiBJ("gridmobibj"), GridMobiHK("gridmobihk"), StartMobi("startmobi"), GoWadogo("gowadogo");

    public String key;

    private SubidGenerateTypeE(String key) {
        this.key = key;
    }

}
