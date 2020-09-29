package paths;

import java.io.File;

public interface DriverSwitchBrowser {

    //file resources.properties for web driver loading
    File chr= new File("src\\test\\java\\resources\\properties\\Chrome.properties");
    File fF=new File("src\\test\\java\\resources\\properties\\FireFox.properties");
    String chrome = chr.getAbsolutePath();
    String fireFox = fF.getAbsolutePath();
}
