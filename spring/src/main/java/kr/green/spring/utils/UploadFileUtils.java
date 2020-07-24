package kr.green.spring.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;


	public class UploadFileUtils {
			// 서버에 파일을 업로드하고 (파일 업로드 시 폴더가 없으면 폴더를 생성) 업로드된 파일명(서버경로제외) 을 알려주는 메서드 
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
		
		// 서버 경로에 업로드 날짜를 기준으로 폴더를 체크하여 날짜경로를 알려주는 메서드 , return 값이 /년도/월/일 이 반환 (폴더가 없으면 생성)
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
		//uploadPath 기준으로 path 폴더가 없으면 만드는 메서드 
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
		// 날짜경로와 파일명을 합친 문자열을 반환 
		// /년도/월/일/uuid_파일명.확장자
		private static String makeIcon(String uploadPath, String path, String fileName)
	        	throws Exception{
			String iconName = uploadPath + path + File.separator + fileName;
			return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
			
		}
	}
	

