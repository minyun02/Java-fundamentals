import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 * 자바에서 엑셀로 쓰고 읽기
 * jakarta.apache.org 에서 POI를 다운받는다.
 * poi-5.0.0.jar, commons-math3-3.6.1.jar를
 * build path 설정 - project에서 오른쪽 클릭 - build path선택
 */
public class WriteExcel {

	public WriteExcel() {
		//엑셀로 쓰기
		
		//1. workbook 객체 생성
		HSSFWorkbook workBook = new HSSFWorkbook();
		
		//2.sheet객체 생성
		HSSFSheet sheet1 = workBook.createSheet("회원목록");
		HSSFSheet sheet2 = workBook.createSheet();
		
		//3.row객체 생성
		HSSFRow row1 = sheet1.createRow(0);
		
		//4.cell객체 생성
		HSSFCell cell1 = row1.createCell(0);
		
		//5.value 세팅
		cell1.setCellValue("번호");
		
		row1.createCell(1).setCellValue("이름");
		row1.createCell(2).setCellValue("연락처");
		row1.createCell(3).setCellValue("이메일");
		
		//////////////////////////////////////////////
		
		String data[][] = {
				{"1", "홍길동", "010-1234-5678", "aaaa@nate.com"},
				{"2", "김길동", "010-2222-3333", "qwer@nate.com"},
				{"3", "고길동", "010-3333-4444", "zxcv@nate.com"},
				{"4", "윤길동", "010-5555-6666", "fads@nate.com"},
				{"5", "최길동", "010-7777-8888", "rewq@nate.com"},
		};
		
		for(int r=0; r<data.length; r++) {//1,2,3,4,5
			HSSFRow cRow = sheet1.createRow(r+1);
			for(int c=0; c<data[r].length; c++) {//0,1,2,3
				if(c==0) {
					//번호를 숫자로 변경하여 저장
					cRow.createCell(c).setCellValue(Integer.parseInt(data[r][c]));
				}else {
					cRow.createCell(c).setCellValue(data[r][c]);
					
					// 데이터들은 결과적으로 워크북에 담긴다.
				}
			}
		}
		//
		File f = new File("D://io/member.xls");
		
		//File로 쓰기 -> FileWriter(문자단위)와 FileOutputStream(바이트단위) 중 엑셀에는 바이트 단위로 들어가는게 더 맞다.
		try {
			FileOutputStream fos = new FileOutputStream(f);
			workBook.write(fos);
			workBook.close();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		System.out.println("엑셀로 쓰기 완료");
	}

	public static void main(String[] args) {
		new WriteExcel();

	}

}
