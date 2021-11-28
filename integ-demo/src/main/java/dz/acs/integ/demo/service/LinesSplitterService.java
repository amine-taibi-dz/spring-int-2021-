package dz.acs.integ.demo.service;

import java.util.List;

import org.springframework.integration.annotation.Splitter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class LinesSplitterService {
 
	@Splitter(inputChannel = "file-lines",outputChannel = "lines")
	public List<String> split(Message<List<String>> msg) {
		System.err.println(msg.getPayload());
		return msg.getPayload();

	}
 
}
