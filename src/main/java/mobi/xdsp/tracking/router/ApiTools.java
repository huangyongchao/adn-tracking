package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.dto.enums.PBStateE;
import mobi.xdsp.tracking.entity.Activate;

public class ApiTools {

    public static void packageCnt(Activate activate) {
        if (activate.getStatus() == null) {
            activate.setStatus(PBStateE.VALID.code);
            activate.setActivecnt(1);
            activate.setDeductcnt(0);
        }else if(PBStateE.VALID.code == activate.getStatus()){
            activate.setInactivecnt(0);
            activate.setActivecnt(1);
            activate.setDeductcnt(0);
        }else if(PBStateE.INVALID.code == activate.getStatus()){
            activate.setInactivecnt(1);
            activate.setActivecnt(0);
            activate.setDeductcnt(0);
        }else if(PBStateE.REJECT.code == activate.getStatus()){
            activate.setInactivecnt(1);
            activate.setActivecnt(0);
            activate.setDeductcnt(0);
        }else if(PBStateE.DEDUCT.code == activate.getStatus()){
            activate.setInactivecnt(0);
            activate.setActivecnt(0);
            activate.setDeductcnt(1);
        }else{
            activate.setStatus(PBStateE.INVALID.code);
            activate.setInactivecnt(1);
            activate.setActivecnt(0);
            activate.setDeductcnt(0);
        }
    }
}
