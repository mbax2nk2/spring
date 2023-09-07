package kz.nursultan.spring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.TimeUnit;


public class TestBeanAnnotation implements TestInterface {

    @PostConstruct
    public void init(){
        System.out.println("TestBeanAnnotation::init called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("TestBeanAnnotation::destroy called");
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(4));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
