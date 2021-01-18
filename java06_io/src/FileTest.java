import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//window 기준...
public class FileTest {

	public FileTest() {
		// File 객체 생성 : 1.드라이브명+"://", 2.폴더명, 3.파일명 이 필요하고 반드시 절대주소(드라이브 위치 포함)여야한다!
		// 				없는 폴더, 파일도 파일객체 생성가능
		File f1 = new File("d://javaIO");
		
		File f2 = new File("d://ioSample/demo.sql");
		
		File f3 = new File(f1, "test.txt");
		
		//생성을 위해 필요한 메소드들..
		//	exist() : 폴더, 파일이 존재하는지 확인 > return boolean (true: 있다, false: 없다)
		//	mkdir:한 개의 폴더 만들때, mkdirs: 상위폴더까지 생성이 필요할때, 여러개
		//	createNewFile >>> 예외처리 해줘야함
		
		// 폴더생성
		if(!f1.exists()) { // 폴더가 없다면?
			if(f1.mkdirs()) {
				System.out.println("폴더가 생성되었습니다");
			}else {
				System.out.println("폴더가 생성되지않았습니다");
			}
		}
		System.out.println("폴더가 이미 존재합니다");
		
		// 파일생성
		if(!f3.exists()) {
			try {
				if(f3.createNewFile()) {
					System.out.println("파일이 생성되었습니다");
				}else {
					System.out.println("파일이 생성되지않았습니다");
				}
			} catch (IOException e) {
				System.out.println("파일생성 에러발생 !!! > "+e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("파일이 이미 존재합니다");
		
		// 마지막 수정일 불러오기	:lastModified() > return long : 마지막 수정날짜를 밀리초로 구해준다 1970.1.1.0.0.0.0 1초마다 1000씩 증가
		long lastModifiedDate = f2.lastModified();
		System.out.println(lastModifiedDate +"= 마지막 수정 날짜");
		//밀리초를 날짜로 변환 : setTimeInMillis(long millis) > return void
		Calendar now = Calendar.getInstance(); //오늘날짜
		now.setTimeInMillis(lastModifiedDate); //밀리초를 Calendar에 세팅
		// 2021-01-06 오후 03:10
		SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-DD a hh:mm");
		String lastDateStr = format1.format(now.getTime());
		System.out.println("마지막 수정 날짜 = "+lastDateStr);
		
		//boolean	canExecute()
		//boolean	isDirectory()
		System.out.println("canExecute ? "+f2.canExecute());
		System.out.println("canRead ? "+f2.canRead());
		System.out.println("canWrite ? "+f2.canWrite());
		System.out.println("isFile ? "+f2.isFile());
		System.out.println("isDirectory ? "+f2.isDirectory());
		System.out.println("= = = = = = = = = = = = = = = = = = = = =");
		
		//특정드라이브 또는 특정 폴더의 폴더목록, 파일목록을 구한다 : File[]	< listFiles(), cf. String[]	< list()
		File f4 = new File("C://");
		File file[] = f4.listFiles();
			// f.getPath(); : 드라이브명과 경로를 구해줌 (파일이 있으면 파일명까지)
			// f.getName(); : 파일명
			// f.getAbsoluteName(); : 드라이브명, 경로, 파일명
			// f.getParent(); : 드라이브명, 경로까지
			// boolean	isHidden() : 숨긴 폴더/파일
		for( File f : file) {
			if(f.isDirectory()) {
				// f.getPath(); : 드라이브명과 경로를 구해줌 (파일이 있으면 파일명까지)
				// f.getName(); : 파일명
				// f.getAbsoluteName(); : 드라이브명, 경로, 파일명
				// f.getParent(); : 드라이브명, 경로까지
				// boolean	isHidden()
				if(f.isHidden()) {
					System.out.println("\t\t"+"[숨긴폴더] "+f.getPath());
				}else {
					System.out.println("[폴더] "+f.getPath());
				}
			}else if(f.isFile()) {
				if(f.isHidden()) {
					System.out.println("\t\t"+"[숨긴파일] "+f.getName());
				}else {
					System.out.println("[파일] "+f.getName());
				}
			}
				
		}
		System.out.println("= = = = = = = = = = = = = = = = = = = = =");
		
		//현재 컴퓨터의 드라이브 목록 구하기
		//static File[]	< listRoots()
		File drive[] = File.listRoots();
		for(File dr : drive) {
			System.out.println("드라이브 목록 : "+dr.getPath());
		}
		
		//파일크기(byte): 올림출력, 메가바이트로 넘어가면 M
		long size = f2.length();
		System.out.println("file size = "+size);
		
		//파일지우기 boolean	< delete()
		f3.delete();
		System.out.println("파일이 삭제됨..."+f3.exists());
		
	}

	public static void main(String[] args) {
		new FileTest();

	}

}
