package mobi.xdsp.tracking.dto.enums;

public enum VideoProtocolsE {




    VAST("VAST1", 1),  VAST2("VAST2", 2),  VAST3("VAST3", 3),
    VAST1W("VAST1W", 4),  VAST2W("VAST2W", 5),  VAST3W("VAST3W", 6),
    VAST4("VAST4", 7),  VAST4W("VAST4W", 8),  DAAST1("DAAST1", 9),  DAAST1W("DAAST1W", 10);
    public String name;
    public int code;

    private VideoProtocolsE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
