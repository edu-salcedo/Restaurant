package com.pollo.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileImgService {
	
	private String fileImg="img//";
	
	public String SaveImg(MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			byte[] bytes=file.getBytes();
			Path path = Paths.get(fileImg,file.getOriginalFilename());
	        Files.write(path, bytes);
	        
	        return file.getOriginalFilename();
		}
		return "default.jpg";
	}
	
	public void deleteImg(String name) {
		String path ="img//";
		File files = new File (path+name);	
		files.delete();
		}

}
