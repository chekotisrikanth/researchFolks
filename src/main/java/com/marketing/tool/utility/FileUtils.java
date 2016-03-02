package com.marketing.tool.utility;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.codec.binary.Base64;
import com.marketing.tool.utility.StringUtil;
    /** 
     * Description     
     * @author Anilkumar Ravula
     * Date Aug 15, 2015
	 *
	 * 
	 */
    
public class FileUtils {
	

	private  static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);
	
	public static void saveFiles(MultipartFile reportImage,String imageName,String parenFolderPath) throws IOException {
		BufferedOutputStream stream = null;
		 try {
             byte[] bytes = reportImage.getBytes();
             String ext = "."+reportImage.getOriginalFilename().split("\\.")[1];
             stream =
                     new BufferedOutputStream(new FileOutputStream(checkAndReturnFiles(StringUtil.buildString(imageName,ext), parenFolderPath)));
             stream.write(bytes);
             
             LOGGER.info("You successfully uploaded"); 
         } catch (IOException fnpe) {
        	 LOGGER.error("fail saving failed for the {} employeeID the message {}", imageName , fnpe.getCause());
        	 throw fnpe;
		} finally {
			if(stream != null) {
				stream.close();
			}
			
         }
	}
	
	public static File checkAndReturnFiles(String fileName,String directory) {
		File file = new File(directory);
		LOGGER.info("Utils Path {} ",file.getAbsolutePath());
		if(!file.exists()) {
			boolean flag = file.getParentFile().mkdirs();
			file.mkdirs();
			// if if false log the error
			LOGGER.info("After flag ",flag);
		}
		
			return new File(file, fileName);
		
	}
	public static void  saveImage(String image,String imageName,String parenFolderPath) throws IOException {
		// Note preferred way of declaring an array variable
		 image = image.substring(image.indexOf(",")+1);
		byte[] data = Base64.decodeBase64(image);
		try (OutputStream stream = new FileOutputStream(checkAndReturnFiles(StringUtil.buildString(imageName,".jpg"), parenFolderPath))) {
		    stream.write(data);
		} catch (IOException e) {
			 LOGGER.error("fail saving failed for the {} employeeID the message {}  longMessage {} ", imageName , e.getCause(),e.getStackTrace());
        	 throw e;
		}
	
	}
	
}
