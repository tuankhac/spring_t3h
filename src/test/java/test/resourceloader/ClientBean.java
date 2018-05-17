package test.resourceloader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ClientBean {
	@Autowired
	private ResourceLoader resourceLoader;

	public void doSomething() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:log4j.properties");
		File file = resource.getFile();
		String s = new String(Files.readAllBytes(file.toPath()));
		System.out.println(s);
	}
}
