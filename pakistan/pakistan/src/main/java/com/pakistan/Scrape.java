package com.pakistan;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Scrape implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
       new Demo().start();
    }
}
