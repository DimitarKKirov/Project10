package masterManager;

import eMagManagers.EMagPageManager;
import pageObjects.BardBG.BardBG;
import pageObjects.Excite.PageManagerExcite;

public class MasterPageManager {

    //the Master Manager can instantiate every other Manager and itself in singleton way
    //by doing this the user can use every Page Class and its methods

    private static MasterPageManager masterManager = new MasterPageManager();
    private EMagPageManager eMagPageManager;
    private PageManagerExcite pageManagerExcite;
    private BardBG bardBG;

    public static MasterPageManager getMasterManager() {
        return masterManager;
    }

    public EMagPageManager eMagPageManager() {
        if (eMagPageManager == null) {
            eMagPageManager = new EMagPageManager();
            return eMagPageManager;
        }
        return eMagPageManager;
    }

    public PageManagerExcite pageManagerExcite() {
        if (pageManagerExcite == null) {
            pageManagerExcite = new PageManagerExcite();
            return pageManagerExcite;
        }
        return pageManagerExcite;
    }

    public BardBG bardBG() {
        if (bardBG == null) {
            bardBG = new BardBG();
            return bardBG;
        }
        return bardBG;
    }
}
