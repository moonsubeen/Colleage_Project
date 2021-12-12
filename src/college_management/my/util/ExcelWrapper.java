package college_management.my.util;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFPrintSetup;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import college_management.my.auth.UserAuth;
import college_management.my.db.model.LectureHistory;
import college_management.my.db.model.Student;
import college_management.my.db.model.User;
import college_management.my.service.InfoService;
import college_management.my.service.LectureService;
import college_management.my.service.ProfessorService;
import college_management.my.service.StudentService;
import college_management.my.service.UserService;

public class ExcelWrapper {
	XSSFWorkbook xssfWb = null; 
	XSSFSheet xssfSheet = null; 
	XSSFRow xssfRow = null; 
	XSSFCell xssfCell = null; 
	XSSFPrintSetup prints = null;

	public static void main(String[] args) {
		ExcelWrapper wrapper = new ExcelWrapper();
	}
	
	public ExcelWrapper() {
		
	}
	
	public void init(User user, Student student, List<LectureHistory> lectures, String title) {
		// ...
		try {
			int rowNo = 0; // 행의 갯수 
			xssfWb = new XSSFWorkbook(); //XSSFWorkbook 객체 생성 
			xssfSheet = xssfWb.createSheet("학생 성적정보"); // 워크시트 이름 설정 // 시트 이름 입력 값 받기
			xssfSheet.setMargin(xssfSheet.LeftMargin, 0.24);
			xssfSheet.setMargin(xssfSheet.RightMargin, 0.24);
			
			XSSFFont font = xssfWb.createFont(); 
			font.setFontName(HSSFFont.FONT_ARIAL); // 폰트 스타일 
			font.setFontHeightInPoints((short)20); // 폰트 크기 
			font.setBold(true); // Bold 설정 
			font.setColor(new XSSFColor(Color.decode("#457ba2"))); // 폰트 색 지정 
			
			//테이블 셀 스타일
			CellStyle cellStyle = xssfWb.createCellStyle();
			xssfSheet.setColumnWidth(0, (xssfSheet.getColumnWidth(0))+(short)1024); // 0번째 컬럼 넓이 조절
			xssfSheet.setColumnWidth(1, (xssfSheet.getColumnWidth(1))+(short)2800); // 1번째 컬럼 넓이 조절
			xssfSheet.setColumnWidth(3, (xssfSheet.getColumnWidth(3))+(short)1024); // 3번째 컬럼 넓이 조절
			xssfSheet.setColumnWidth(6, (xssfSheet.getColumnWidth(6))+(short)1500); // 7번째 컬럼 넓이 조절 
			cellStyle.setFont(font); // cellStyle에 font를 적용
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 정렬 
			
			//셀병합 
			xssfSheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 6)); //첫행, 마지막행, 첫열, 마지막열 병합 
			xssfSheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 1)); //첫행, 마지막행, 첫열, 마지막열 병합 
			xssfSheet.addMergedRegion(new CellRangeAddress(3, 3, 3, 4)); //첫행, 마지막행, 첫열, 마지막열 병합 
			xssfSheet.addMergedRegion(new CellRangeAddress(4, 4, 3, 4)); //첫행, 마지막행, 첫열, 마지막열 병합 
			
			// 타이틀 생성
			xssfRow = xssfSheet.createRow(rowNo++); // 행 객체 추가 
			xssfCell = xssfRow.createCell((short) 0); // 추가한 행에 셀 객체 추가 
			xssfCell.setCellStyle(cellStyle); // 셀에 스타일 지정 
			xssfCell.setCellValue("학생성적 통지서"); // 데이터 입력 // 제목 입력 값 받기 
			xssfSheet.createRow(rowNo++); 
			xssfRow = xssfSheet.createRow(rowNo++); // 빈행 추가 
			
			//테이블 스타일 설정 
			CellStyle tableCellStyle = xssfWb.createCellStyle(); 
			nomalcellStyle(tableCellStyle);
			
			CellStyle CellStyle = xssfWb.createCellStyle();
			emphasizestyle(CellStyle);
			
			xssfRow = xssfSheet.createRow(rowNo++); // 이 열 다음 rowNo = 4
			
			crecell(0, CellStyle, "이름"); // 0
			crecell(1, tableCellStyle, user.getName());
			crecell(2, CellStyle, "학번"); // 2
			crecell(3, tableCellStyle, user.getId());
			crecell(4, CellStyle, "");
			crecell(5, CellStyle, "성별"); // 5
			crecell(6, tableCellStyle, user.getSex());
			xssfRow = xssfSheet.createRow(rowNo++); // 5
			
			crecell(0, CellStyle, "이메일"); // 0
			crecell(1, tableCellStyle, user.getEmail());
			crecell(2, CellStyle, "전화번호"); // 2
			crecell(3, tableCellStyle, user.getPhoneNumber());
			crecell(4, CellStyle, "");
			crecell(5, CellStyle, "전공"); // 5
			crecell(6, tableCellStyle, student.getMajor());
			xssfRow = xssfSheet.createRow(rowNo++); // 6
			
			crecell(0, CellStyle, "강의제목"); // 0, 1 병합
			crecell(1, CellStyle, "");
			crecell(2, CellStyle, "년도");
			crecell(3, CellStyle, "학기"); // 2
			crecell(4, CellStyle, "학점"); // 3
			crecell(5, CellStyle, "성적"); // 4
			crecell(6, CellStyle, "등급"); // 5
			xssfRow = xssfSheet.createRow(rowNo++); // 7
			
			for(int i = 0; i < lectures.size(); i++) {
				xssfSheet.addMergedRegion(new CellRangeAddress(i+6, i+6, 0, 1));
				crecell(0, tableCellStyle, lectures.get(i).getLecture().getName());
				crecell(1, tableCellStyle, "");
				crecell(2, tableCellStyle, lectures.get(i).getLecture().getYear() + "년도");
				crecell(3, tableCellStyle, lectures.get(i).getLecture().getSemester() + "학기");
				crecell(4, tableCellStyle, lectures.get(i).getLecture().getPoint() + "학점");
				crecell(5, tableCellStyle, lectures.get(i).getGrade() + "점");
				crecell(6, tableCellStyle, lectures.get(i).getRank());
				xssfRow = xssfSheet.createRow(rowNo++);
			}
			
			prints = xssfSheet.getPrintSetup();
			prints.setPaperSize(XSSFPrintSetup.A4_PAPERSIZE);
			prints.setLandscape(false);
			prints.setScale((short) 100);
			
			xssfWb.setPrintArea(0, 0, 6, 0, rowNo-2);
			
			print(title);
		}catch(Exception e) {
			
		}
	}
	
	public void cellwidth() {
		
	}
	
	public void cellmerge() {
		
	}
	
	public void crefont() {
		
	}
	
	public void nomalcellStyle(CellStyle tableCellStyle) {
		tableCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); // 테두리 위쪽 
		tableCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 테두리 아래쪽 
		tableCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); // 테두리 왼쪽 
		tableCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); // 테두리 오른쪽
		tableCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	}
	
	public void emphasizestyle(CellStyle tableCellStyle) {
		tableCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); // 테두리 위쪽 
		tableCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 테두리 아래쪽 
		tableCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN); // 테두리 왼쪽 
		tableCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN); // 테두리 오른쪽
		tableCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		tableCellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);  
		tableCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	}
	
	public void crecell(int i, CellStyle tableCellStyle, String name) {
		xssfCell = xssfRow.createCell((short) i); 
		xssfCell.setCellStyle(tableCellStyle);
		xssfCell.setCellValue(name); 
	}
	
	public void print(String title) throws Exception {
		// ...
		String localFile = "C:\\Users\\zx040\\eclipse-workspace\\" + title + ".xlsx"; 
		File file = new File(localFile); 
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			xssfWb.write(fos);
			if (fos != null)
				fos.close();
		} catch (Exception e) {
		} 
	}
}
