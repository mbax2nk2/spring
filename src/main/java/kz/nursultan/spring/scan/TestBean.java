package kz.nursultan.spring.scan;

import kz.nursultan.spring.TestInterfaceV2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;


@Scope(scopeName = SCOPE_PROTOTYPE)
public class TestBean implements InitializingBean, DisposableBean, TestInterfaceV2 {

    @Override public void afterPropertiesSet() throws Exception {
        System.out.println("TestBean::AfterPropertiesSet called");
    }

    @Override public void destroy() throws Exception {
        System.out.println("TestBean::destroy called");
    }
}
