package com.bit2016.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.UserVo;
import com.bit2016.mysite.exception.GalleryUploadException;

@Service
public class BlogService {

	private static final String SAVE_PATH = "/upload";

	@Autowired
	private BlogDao blogDao;

	public void restore(BlogVo blogVo, MultipartFile multipartFile, UserVo userVo){
		String saveFileName = "";
		
		if(multipartFile.isEmpty() == true){
			return;
		}
		
		try {
			String orgFileName = multipartFile.getOriginalFilename();
			String fileExtName = orgFileName.substring(
					orgFileName.lastIndexOf('.') + 1, orgFileName.length());
			saveFileName = generateSaveFileName(fileExtName);
				writeFile(multipartFile, saveFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// DB에 저장
			System.out.println(saveFileName);
			blogVo.setNo(userVo.getNo());
			blogVo.setLogo(saveFileName);
			System.out.println(blogVo);
			blogDao.update(blogVo);
			System.out.println("updateblogVo");
			

	}

	private void writeFile(MultipartFile multipartFile, String saveFileName)
			throws IOException {
		byte[] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/"
				+ saveFileName);
		fos.write(fileData);
		System.out.println("파일저장");
		fos.close();
	}

	private String generateSaveFileName(String extName) {
		String fileName = "";
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += ("." + extName);
		System.out.println("이름변경");
		return fileName;
	}
	
	public BlogVo getBlogNo(Long no){
		return blogDao.getNo(no);
	}

}
