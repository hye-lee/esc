package com.pro.esc.shop;


import java.io.File;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;


public class UploadFileUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);

	public static String uploadFile(String uploadPath, int proCateSeq, String org_filename, byte[] fileData) throws Exception {
	
		UUID uuid = UUID.randomUUID();
		String str_filename = uuid.toString() + "_" + org_filename;
		System.out.println("str_filename: "+str_filename);
		String savedPath = calcPath(uploadPath, proCateSeq);
		
		//저장할 파일준비
		File target = new File(uploadPath + savedPath, str_filename);

		FileCopyUtils.copy(fileData, target);
	
		String uploadedFileName = null;
		uploadedFileName = makeName(uploadPath, savedPath, str_filename);
		
		//uploadedFileName는 썸네일명으로 화면에 전달된다.
		return uploadedFileName;
	}//
	
	//폴더 생성 함수
	@SuppressWarnings("unused")
	private static String calcPath(String uploadPath, int proCateSeq) {

		makeDir(uploadPath, proCateSeq);

		return "/"+proCateSeq;
	}
	
	//폴더 생성 함수
	private static void makeDir(String uploadPath, int proCateSeq) {
		
		String allPath=uploadPath+"/"+proCateSeq;
		System.out.println(allPath);
		if(new File(allPath).exists()) {
			return;
		}
		
		File dirPath = new File(allPath);
		if(!dirPath.exists()) {
				dirPath.mkdir();
		}//if
			
		
	}//makeDir
	
	private static String makeName(String uploadPath, String path, String fileName) throws Exception{
		String makeName = uploadPath + path + File.separator + fileName;
		return makeName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	/*//썸네일 이미지 생성
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
		
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 200);
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);

		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	*/
	
}