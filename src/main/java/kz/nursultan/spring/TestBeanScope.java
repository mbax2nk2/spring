package kz.nursultan.spring;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static org.springframework.web.context.WebApplicationContext.SCOPE_APPLICATION;


@Scope(scopeName = SCOPE_APPLICATION)
public class TestBeanScope implements TestInterfaceV2{

    @PostConstruct
    public void init(){
        System.out.println("TestBeanScope::init called");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("TestBeanScope::destroy called");
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(4));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
