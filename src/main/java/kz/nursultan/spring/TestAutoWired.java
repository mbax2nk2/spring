package kz.nursultan.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TestAutoWired {
    TestInterface testInterface;
    TestInterfaceV2 testInterfaceV2;


    public TestAutoWired(@Qualifier("testBeanMethods") TestInterface testInterface, TestInterfaceV2 testInterfaceV2) {
        this.testInterface = testInterface;
        this.testInterfaceV2 = testInterfaceV2;
    }
}
