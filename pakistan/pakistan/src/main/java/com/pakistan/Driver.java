package com.pakistan;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.stereotype.Component;

@Component
public class Driver {
    public FirefoxDriver getFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", "./geckodriverLinux.exe");
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);
        return new FirefoxDriver(options);

    }
}
