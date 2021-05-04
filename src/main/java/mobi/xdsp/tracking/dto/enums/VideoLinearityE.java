package mobi.xdsp.tracking.dto.enums;

public enum VideoLinearityE {


    LINEAR("Linear", 1), NONLINEAR("NonLinear", 2);
    public String name;
    public int code;

    private VideoLinearityE(String name, int code) {
        this.name = name;
        this.code = code;
    }


}
