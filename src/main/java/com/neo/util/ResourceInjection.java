package com.neo.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

//@Service
//@Configurable
public class ResourceInjection {
	@Autowired
	ResourceLoader resourceLoader;

	InputStream io = null;

	public Resource loadDynamicResource() {
		return resourceLoader.getResource("classpath:log4j.properties");
	}

	public void configLog() {
		try {
			io = loadDynamicResource().getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PropertyConfigurator.configure(io);
	}

	public void doSomething() {
		Resource resource = loadDynamicResource();
		File file;
		String s = "";
		try {
			file = resource.getFile();
			s = new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(s);
	}
}
