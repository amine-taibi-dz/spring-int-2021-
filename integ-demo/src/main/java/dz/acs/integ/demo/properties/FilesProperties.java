package dz.acs.integ.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ConfigurationProperties("integ.files")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FilesProperties {
	private String in;
	private String out;
	private String ext;
	private Long maxLen;

}
