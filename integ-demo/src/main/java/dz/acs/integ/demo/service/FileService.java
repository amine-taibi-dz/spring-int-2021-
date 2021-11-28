package dz.acs.integ.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class FileService {
	
	@ServiceActivator(inputChannel = "filtredIn",outputChannel = "file-lines")
	public Message<List<String>> process(Message<File> fileMsg){
		File payload = fileMsg.getPayload();
		System.err.println(payload);
		List<String> lines=List.of();
		String absolutePath = payload.getAbsolutePath();
		Path pathIn = Path.of(absolutePath);
		
		try {
			lines = Files.readAllLines(pathIn);
			
		} catch (IOException e) {
			//FIXME ata error
			e.printStackTrace();
		} 
		Message<List<String>> message = MessageBuilder.withPayload(lines).build();
//		String output = absolutePath.replace("input","output");
//		 output = output.replace(".in", ".out");
//		Path pathOut = Path.of(output);
//		try {
//			Files.move(pathIn, pathOut, StandardCopyOption.REPLACE_EXISTING);	
//		} catch (Exception e) {
//			//FIXME ata error
//			e.printStackTrace();
//		}
		
		return message;
	}

}