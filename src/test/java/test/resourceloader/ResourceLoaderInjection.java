package test.resourceloader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ResourceLoaderInjection {

	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		ClientBean bean = context.getBean(ClientBean.class);
		bean.doSomething();
	}

	@Configuration
	public static class Config {

		@Bean
		public ClientBean clientBean() {
			return new ClientBean();
		}

	}

}