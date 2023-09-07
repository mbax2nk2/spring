package kz.nursultan.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;



public class TestBeanMethods implements TestInterface{

   public void customInit() throws Exception {
        System.out.println("TestBeanMethods::customInit called");
    }

   public void customDestroy() throws Exception {
        System.out.println("TestBeanMethods::customDestroy called");
    }
}
