package com.pakistan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Test {

    FirefoxDriver firefoxDriver = null;

    public void start_scrape() throws InterruptedException, IOException {
        firefoxDriver = new Driver().getFirefoxDriver();
        scrape_link("https://www.realtor.com/apartments/32003");
    }

    private void scrape_link(String url) throws InterruptedException, IOException {
        FileWriter fileWriter = new FileWriter("C:/Users/Hash/Desktop/text.csv");
        int ii=0;
        do{
            firefoxDriver.get(url);
            String body = firefoxDriver.findElementByTagName("body").getText();
            System.out.println(body);
            System.err.println("next Page url "+ ++ii +" | "+url);
            WebElement aTag = firefoxDriver.findElementByClassName("pagn-next").findElement(By.tagName("a"));
            String nextPageUrl = aTag.getAttribute("href");



            WebElement elementById = firefoxDriver.findElementById("e1-10");
            List<WebElement> li = elementById.findElements(By.tagName("li"));
            int i=0;
            for (WebElement data:li){
                try {

                    WebElement lvtitle = data.findElement(By.className("lvtitle"));
                    String attribute = lvtitle.findElement(By.tagName("a")).getAttribute("href");
                    i++;
                    System.out.println(i+ " | "+ attribute);
                    fileWriter.write(attribute+"\n");
                    fileWriter.flush();
                }catch (Exception e){}
            }
            url=nextPageUrl;

        }while (true);
    }
}

