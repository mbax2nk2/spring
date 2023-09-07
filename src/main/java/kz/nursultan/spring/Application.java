package kz.nursultan.spring;

import kz.nursultan.spring.ignorescan.Example;
import kz.nursultan.spring.scan.TestBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;

@ComponentScan(basePackages = "kz.nursultan.spring", excludeFilters = @ComponentScan.Filter(type= FilterType.REGEX, pattern="kz\\.nursultan\\.spring\\.ignorescan\\..*"))
@SpringBootApplication
public class Application {
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(Application.class, args);
		checkBeansPresence("testBeanMethods", "testBean", "testBeanAnnotation", "testBeanScope", "example");
	}

	@Bean()
	TestBean testBean() {
		return new TestBean();
	}
	@Bean
	TestBeanAnnotation testBeanAnnotation() {
		return new TestBeanAnnotation();
	}
	@Bean
	@Primary
	TestBeanScope testBeanScope() {
		return new TestBeanScope();
	}
	@Bean(name = "testBeanMethods",initMethod = "customInit", destroyMethod = "customDestroy")
	TestBeanMethods testBeanMethods() {
		return new TestBeanMethods();
	}

	private static void checkBeansPresence(String... beans) {
		for (String beanName : beans) {
			System.out.println("Is " + beanName + " in ApplicationContext: " + applicationContext.containsBean(beanName));
		}
	}

}
