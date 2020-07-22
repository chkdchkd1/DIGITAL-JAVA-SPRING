package kr.green.spring.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;


	public class UploadFileUtils {
		
		public static String uploadFile(String uploadPath, String originalName, byte[] 	
				fileData)throws Exception{
			// 파일을 업로드하는 메소드
			UUID uid = UUID.randomUUID();
			// 파일 덮어쓰기를 막기위한 고유번호 
			String savedName = uid.toString() +"_" + originalName;
			String savedPath = calcPath(uploadPath);
			//c:\User\Administeratordesktop\새폴더\2020\07\ uuid_test.jpg
			File target = new File(uploadPath + savedPath, savedName);
			//New File을 통해 이름을 가진 빈 파일이 형성된다 . 
			//실제 업로드할 파일 
			FileCopyUtils.copy(fileData, target);
			//파일 복사 
			
			//폴도 경로를 \가 아닌 /로 바꾸는 코드
			String uploadFileName = makeIcon(uploadPath, savedPath, savedName);
			return uploadFileName;
		}
		
		private static String calcPath(String uploadPath) {
			//업로드한 파일을 저장할 경로를 계산하는 메소드
			// 날짜를 생성
			Calendar cal = Calendar.getInstance();
			// 년도 경로를 설정 : file.separator (파일경로구분자 = \) \2020s
			String yearPath = File.separator+cal.get(Calendar.YEAR);
			// 년도와 월을 합친 경로를 생성 : \2020\07 
			String monthPath = yearPath + File.separator 
	            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
			// 년도와 월 일을 합친 일 경로를 생성 : \2020\07\22 
			String datePath = monthPath + File.separator 
	            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
			makeDir(uploadPath, yearPath, monthPath, datePath);
			// 경로에 맞게 폴더 생성 
			return datePath;
	 
		}
		private static void makeDir(String uploadPath, String... paths) {
				//폴더를 생성하는 메소드
			if(new File(uploadPath+paths[paths.length-1]).exists())
				return;
			for(String path : paths) {
				File dirPath = new File(uploadPath + path);
				if( !dirPath.exists())
					dirPath.mkdir();
				//이경로르를깆고 (폴더르 만드능..) 
			}
		}
		private static String makeIcon(String uploadPath, String path, String fileName)
	        	throws Exception{
			String iconName = uploadPath + path + File.separator + fileName;
			return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
			
		}
	}
	

