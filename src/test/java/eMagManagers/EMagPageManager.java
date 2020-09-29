package eMagManagers;

import pageObjectsEMag.eMagPages.LoginToEmag;
import pageObjectsEMag.eMagPages.SearchInEmag;

public class EMagPageManager {

    //singleton instantiation of EMag page classes

    private LoginToEmag loginToEmag;
    private SearchInEmag searchInEmag;

    public LoginToEmag  loginToEmag(){
        if (loginToEmag==null){
            loginToEmag=new LoginToEmag();
            return loginToEmag;
        }return loginToEmag;
    }

    public SearchInEmag searchInEmag(){
        if (searchInEmag == null){
            searchInEmag = new SearchInEmag();
           return searchInEmag;
        }return searchInEmag;
    }

}
