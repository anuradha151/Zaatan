package com.pakistan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {
    void start(){

        FirefoxDriver firefoxDriver = new Driver().getFirefoxDriver();
        firefoxDriver.get("https://cryptototem.com/ico-list/");
        WebElement body = firefoxDriver.findElement(By.tagName("body"));
        System.out.println(body.getText());

    }
}
