package DriveManager;

public class driverManagerFactory {

    public static driverManager getManager (String browser, String execution){

        driverManager driverManager = null;

        switch (execution){
            case "local":
                if (browser.equals("firefox")){
                    driverManager = new firefoxDriverManager();
                }else if (browser.equals("chrome")){
                    driverManager = new chromeDriverManager();
                }else {
                    System.out.println("Navegador Incorrecto");
                }

                break;

            case "hub":
//                Se tiene que configurar para ejecutar en hub
                break;
        }

        return driverManager;

    }
}
