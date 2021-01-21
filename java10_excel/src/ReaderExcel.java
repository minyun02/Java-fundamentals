import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ReaderExcel {

	public ReaderExcel() {
		try {
			//Excel 파일 읽어오기
			File f = new File("D://io/member.xls");
			FileInputStream fis = new FileInputStream(f);
		
			//파일 읽어오기 순서
			//1. POI객체를 얻어오기
			POIFSFileSystem poi = new POIFSFileSystem(fis);
			//2.workbook 얻어오기
			HSSFWorkbook workbook = new HSSFWorkbook(poi);
			//3.sheet
			//시트수 구하기
			int sheetCount = workbook.getNumberOfSheets();
			System.out.println("시트수 :"+ sheetCount);
			
			//데이터를 읽어올 시트 구하기
			HSSFSheet sheet =  workbook.getSheet("회원목록"); //sheet index를 이용하는 방법 -> workbook.getSheetAt(0);
			
			//행의 수 구하기
			int rowCount = sheet.getPhysicalNumberOfRows(); //6
			
			for(int row=0; row<rowCount; row++) {
				//4.row ->4,5번은 반복문으로 구한다. 먼저 읽어올 행의 수를 구해야한다.
				HSSFRow memRow = sheet.getRow(row);
				
				//현재 행에 몇칸이 있는지 구하기
				int colCount = memRow.getPhysicalNumberOfCells();
				for(int col=0; col<colCount; col++) {
					//5.cell
					HSSFCell cell = memRow.getCell(col);
					//숫자, 문자
					if(row>0 && col==0) {//숫자로 읽기
						int data = (int)cell.getNumericCellValue(); // getNumericCellValue();는 double로 반환받는데 번호가 1.0 이럴 순 없으니 int로 형변환
						System.out.print(data+"\t");
					}else {//문자로 읽기
						String data = cell.getStringCellValue();
						System.out.print(data+"\t");
					}
				}
				System.out.println();
			}
			fis.close();
			poi.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new ReaderExcel();

	}

}
