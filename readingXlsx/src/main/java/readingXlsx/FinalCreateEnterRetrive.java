package readingXlsx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.Scanner;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.poi.EncryptedDocumentException;

class FinalCreateEnterRetrive{
	

	//static String excelFilePath = "StoreDetails.xls";
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Scanner scan=new Scanner(System.in);
		String name;
		System.out.println("Enter the file name");
		name=scan.nextLine();
		FileOutputStream excelFile = new FileOutputStream("D:\\eclipse-workspace\\readingXlsx\\" + name + ".xls");
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook1.createSheet("Employee Details");
		int rownum=0;
		//rownum = ((XSSFSheet) sheet1).getLastRowNum();

			Scanner input = new Scanner(System.in);
			Map<Integer, Object[]> data = new HashMap<Integer, Object[]>();
			while(true) {
			System.out.println("Enter Employee Details");
			System.out.println("Enter Employee ID" + "," + "Enter Employee NAME" + "," + "Enter Employee POSITION" + ","
					+ "Enter Employee SALARY");
			
			 
			data.put(rownum, new Object[] { input.nextInt(), input.next(), input.next(), input.next() });
			System.out.println("do you want to add more data");
			System.out.println("1). yes");
			System.out.println("2). no");
			int n=input.nextInt();
			rownum++;
			if(n!=1)
				break;
	
	}
			Set<Integer> keyset = data.keySet();

			for (Integer key : keyset) {
				Row row = ((XSSFSheet) sheet1).createRow(rownum++);
				Object[] objArr = data.get(key);
				int cellnum = 0;
				for (Object obj : objArr) {
					Cell cell = row.createCell(++cellnum);
					if (obj instanceof String)
						cell.setCellValue((String) obj);
					else if (obj instanceof Integer)
						cell.setCellValue((Integer) obj);
				}
			}

			FileOutputStream outputStream = new FileOutputStream(name + ".xls");
			workbook1.write(outputStream);
			// workbook1.close();
			outputStream.close();
			ReadingXlsxFile.main(args);
		
	}
}
