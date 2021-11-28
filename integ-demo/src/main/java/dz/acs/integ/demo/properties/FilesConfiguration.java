package dz.acs.integ.demo.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableConfigurationProperties(FilesProperties.class)
@RequiredArgsConstructor
public class FilesConfiguration {
	private final FilesProperties filesProperties;
	
	
	@Bean
	public FilesProperties filesProperties() {
		return filesProperties;
	}

}
