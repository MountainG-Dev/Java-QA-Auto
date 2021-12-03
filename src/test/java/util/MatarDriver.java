package util;

import java.io.IOException;

public class MatarDriver {
    public static void main(String[] args) throws IOException {
//        Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        //	Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe /T");
        System.out.println("Driver eliminados");
    }
}
