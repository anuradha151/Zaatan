package com.pakistan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Ebay {
    FirefoxDriver firefoxDriver=null;

    public Ebay() {
         firefoxDriver = new Driver().getFirefoxDriver();
    }

    void start(){
        int i=0;
        while (true) {
            i++;
            firefoxDriver.get("https://www.ebay.com/b/Laptops-Netbooks/175672/bn_1648276?_pgn="+i);
            getMainLinks();
        }
    }

    private void getMainLinks() {
        WebElement elementByClassName = firefoxDriver.findElementByClassName("b-list__items_nofooter");
        List<WebElement> elements = elementByClassName.findElements(By.className("s-item__link"));
        for(WebElement data:elements){
            System.out.println(data.getAttribute("href"));
            try {
                System.out.println(data.findElement(By.className("s-item__price")).getText());
            }catch (Exception e){}
            System.out.println(data.getText());

        }

    }
}
