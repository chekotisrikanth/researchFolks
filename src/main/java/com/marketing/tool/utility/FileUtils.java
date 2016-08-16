package com.marketing.tool.utility;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
    /** 
     * Description     
     * @author Anilkumar Ravula
     * Date Aug 15, 2015
	 *
	 * 
	 */
  
@Service
public class FileUtils {
	
	private static final Map<String, String> fileExtensionMap;
	
	@Value("${storagepath:D:/uploads}")
	private String rootFolder;

	
	
	public String getRootFolder() {
		return rootFolder;
	}

	public void setRootFolder(String rootFolder) {
		this.rootFolder = rootFolder;
	}

	static {
	    fileExtensionMap = new HashMap<String, String>();
	    // MS Office
	    fileExtensionMap.put("doc", "application/msword");
	    fileExtensionMap.put("dot", "application/msword");
	    fileExtensionMap.put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
	    fileExtensionMap.put("dotx", "application/vnd.openxmlformats-officedocument.wordprocessingml.template");
	    fileExtensionMap.put("docm", "application/vnd.ms-word.document.macroEnabled.12");
	    fileExtensionMap.put("dotm", "application/vnd.ms-word.template.macroEnabled.12");
	    fileExtensionMap.put("xls", "application/vnd.ms-excel");
	    fileExtensionMap.put("xlt", "application/vnd.ms-excel");
	    fileExtensionMap.put("xla", "application/vnd.ms-excel");
	    fileExtensionMap.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	    fileExtensionMap.put("xltx", "application/vnd.openxmlformats-officedocument.spreadsheetml.template");
	    fileExtensionMap.put("xlsm", "application/vnd.ms-excel.sheet.macroEnabled.12");
	    fileExtensionMap.put("xltm", "application/vnd.ms-excel.template.macroEnabled.12");
	    fileExtensionMap.put("xlam", "application/vnd.ms-excel.addin.macroEnabled.12");
	    fileExtensionMap.put("xlsb", "application/vnd.ms-excel.sheet.binary.macroEnabled.12");
	    fileExtensionMap.put("ppt", "application/vnd.ms-powerpoint");
	    fileExtensionMap.put("pot", "application/vnd.ms-powerpoint");
	    fileExtensionMap.put("pps", "application/vnd.ms-powerpoint");
	    fileExtensionMap.put("ppa", "application/vnd.ms-powerpoint");
	    fileExtensionMap.put("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
	    fileExtensionMap.put("potx", "application/vnd.openxmlformats-officedocument.presentationml.template");
	    fileExtensionMap.put("ppsx", "application/vnd.openxmlformats-officedocument.presentationml.slideshow");
	    fileExtensionMap.put("ppam", "application/vnd.ms-powerpoint.addin.macroEnabled.12");
	    fileExtensionMap.put("pptm", "application/vnd.ms-powerpoint.presentation.macroEnabled.12");
	    fileExtensionMap.put("potm", "application/vnd.ms-powerpoint.presentation.macroEnabled.12");
	    fileExtensionMap.put("ppsm", "application/vnd.ms-powerpoint.slideshow.macroEnabled.12");
	    // Open Office
	    fileExtensionMap.put("odt", "application/vnd.oasis.opendocument.text");
	    fileExtensionMap.put("ott", "application/vnd.oasis.opendocument.text-template");
	    fileExtensionMap.put("oth", "application/vnd.oasis.opendocument.text-web");
	    fileExtensionMap.put("odm", "application/vnd.oasis.opendocument.text-master");
	    fileExtensionMap.put("odg", "application/vnd.oasis.opendocument.graphics");
	    fileExtensionMap.put("otg", "application/vnd.oasis.opendocument.graphics-template");
	    fileExtensionMap.put("odp", "application/vnd.oasis.opendocument.presentation");
	    fileExtensionMap.put("otp", "application/vnd.oasis.opendocument.presentation-template");
	    fileExtensionMap.put("ods", "application/vnd.oasis.opendocument.spreadsheet");
	    fileExtensionMap.put("ots", "application/vnd.oasis.opendocument.spreadsheet-template");
	    fileExtensionMap.put("odc", "application/vnd.oasis.opendocument.chart");
	    fileExtensionMap.put("odf", "application/vnd.oasis.opendocument.formula");
	    fileExtensionMap.put("odb", "application/vnd.oasis.opendocument.database");
	    fileExtensionMap.put("odi", "application/vnd.oasis.opendocument.image");
	    fileExtensionMap.put("oxt", "application/vnd.openofficeorg.extension");
	    // Other
	    fileExtensionMap.put("txt", "text/plain");
	    fileExtensionMap.put("rtf", "application/rtf");
	    fileExtensionMap.put("pdf", "application/pdf");
	}
	

	private  static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);
	
	@Autowired
	private ResourceLoader resourceLoader; 
	
	
	public String saveFile(MultipartFile reportImage,String fileName,String parenFolderPath) throws IOException {
		//BufferedOutputStream stream = null;
		//byte[] bytes =null;
		
		 try {
			 String extn = reportImage.getOriginalFilename().split("\\.")[1];
			 
			 //Resource resource = resourceLoader.getResource("classpath:/"+parenFolderPath+"/"+imageName);
			 
			 File file = new File(rootFolder+"/"+parenFolderPath+"/"+fileName+"."+extn);
			 
			 if(!file.getParentFile().exists()) {
				 file.getParentFile().mkdirs();
			 }
			 if(file.exists()) {
				    long time= Calendar.getInstance().getTimeInMillis();
				    fileName= String.valueOf(fileName+"_"+time+"."+extn);
				    file = new File(rootFolder+"/"+parenFolderPath+"/"+fileName);
			 }
        	 reportImage.transferTo(file);
        	 
			 //file.renameTo(file.)
			 
			 //File file = resourceLoader.getResource("../"+parenFolderPath+"/"+imageName).getFile();
			 //File file = new File(this.getClass().getResource("/"+parenFolderPath+"/"+imageName).toURI());
			 //file.createNewFile();
			 //reportImage.transferTo(file);

			 //reportImage.transferTo(dest);
			 //parenFolderPath = resourceLoader.getResource("resources/"+parenFolderPath).toString();
             //bytes = reportImage.getBytes();
             
             //File file = checkAndReturnFiles(StringUtil.buildString(imageName,ext),parenFolderPath);
             /*stream =
                     new BufferedOutputStream(new FileOutputStream(file));
             stream.write(bytes);*/
             LOGGER.info("You successfully uploaded"); 
             return fileName;
         } catch (Exception fnpe) {
        	 LOGGER.error("fail saving failed for the {}  the message {}", fileName , fnpe.getCause());
        	 throw new RuntimeException(fnpe);
		} finally {
			/*if(stream != null) {
				stream.close();
			}*/
			
			//bytes = null;
         }
		
	}
	
	public String saveFile(MultipartFile reportImage,String parenFolderPath) throws IOException { 
		return saveFile(reportImage,null,parenFolderPath);
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
	
	public static File getStream(String fileName,String directory) {
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
	/*public static void  saveImage(String image,String imageName,String parenFolderPath) throws IOException {
		// Note preferred way of declaring an array variable
		 image = image.substring(image.indexOf(",")+1);
		byte[] data = Base64.decodeBase64(image);
		try (OutputStream stream = new FileOutputStream(checkAndReturnFiles(StringUtil.buildString(imageName,".jpg"), parenFolderPath))) {
		    stream.write(data);
		} catch (IOException e) {
			 LOGGER.error("fail saving failed for the {} employeeID the message {}  longMessage {} ", imageName , e.getCause(),e.getStackTrace());
        	 throw e;
		}
	
	}*/
	
	public static ByteArrayOutputStream getByteArrayOutputStream(String fileName) throws IOException {

		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {

			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();

			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}

		} catch (IOException e) {
			throw e;
		}  finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}

	public static Map<String, String> getFileextensionmap() {
		return fileExtensionMap;
	}
	
	
	
}
