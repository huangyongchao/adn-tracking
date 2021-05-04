package mobi.xdsp.tracking.dto.enums;

public enum OfferApplyActionsEnum {

    OpenWishlist("Activate by Pub Wishlist", 1),
    OpenTopoffer("Activate by Pub Top Offer", 2),
    OpenPlatformTopoffer("Activate by Platform Top Offer", 9),
    OpenPush("Activate by Platform Push", 3),
    OpenAdvPush("Activate by Adv Push", 7),
    OpenConfirmed("Activate by Pub Confirmed", 4),
    OpenWhitelist("Activate by Adv Whitelist", 5),
    OpenTestRun("Activate by Pub Try Run", 6),
    OpenApprove("Activate by AM Approve", 7),
    OpenPubApply("Activate by Pub Apply", 8),

    StopBlock("Pause by Adv Block", 21),
    StopConfirmed("Pause by Adv Deducted", 22),
    StopHighRisk("Pause by High Risk", 23),
    StopBudget("Pause by Budget Not Enough", 24),
    StopCap("Pause by Cap Not Enough", 25),
    StopCancel("Pause by AM Cancel", 26),
    StopAdjust("Pause by Adjust Blacklist", 27),
    StopCR("Pause by CR Lower", 28),
    StopCRhigh("Pause by CR Higher", 31),
    StopP360("Pause by  P360", 29),
    StopPA("Pause by  PA", 30),
    StopKPI("Pause by  Not meet KPIs", 31);


    private String name;
    private int code;

    private OfferApplyActionsEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static int action2Status(int action) {
        if (action <= 20) {
            return OfferApplyStatusEnum.APPROVED.getCode();
        } else if (action <= 40) {
            return OfferApplyStatusEnum.DECLINED.getCode();
        } else {
            return OfferApplyStatusEnum.PENDING.getCode();
        }

    }

    public static void toJson(){

       String actionCode = "const actionCodeMap = new Map();";
       for(OfferApplyActionsEnum e :OfferApplyActionsEnum.values()){
           actionCode+= "actionCodeMap.set('" + e.code + "', '" + e.name + "');";
       }

        String actionCodeL = "const actionCode = [";
        for(OfferApplyActionsEnum e :OfferApplyActionsEnum.values()){
            actionCodeL+= " {value: '" + e.code + "', label: '" + e.name + "'},";
        }
        actionCodeL=actionCodeL+"{value:'-1',label:'No action'}] ";

        System.out.println(actionCode);
        System.out.println(actionCodeL);

    }

    public static void main(String[] args) {
        toJson();
    }
}
