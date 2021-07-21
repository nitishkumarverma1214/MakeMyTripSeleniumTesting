package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static Row row = null;
	public static Cell cell = null;
	public static FileInputStream fis = null;
	static String excelFilepath = "src//test//resources//excelfile.xlsx";
	private static Logger logger = (Logger) LogManager.getLogger(ExcelUtils.class);

	/********** write the date into excel file **********/
	public static void writeIntoExcel(List<String> list1, List<String> list2, String SheetName) throws IOException {

		File file = new File(System.getProperty("user.dir") + "\\ExcelData\\MakeMyTripWrite.xlsx");
		FileInputStream inputstream = new FileInputStream(file);
		Workbook workbook = null;
		workbook = new XSSFWorkbook(inputstream);
		Sheet datasheet = workbook.getSheet(SheetName);
		Row row;

		for (int i = 0; i < list1.size(); i++) {
			row = datasheet.createRow(i);
			row.createCell(0).setCellValue(list1.get(i));
			if (!(list2.size() == 0))
				row.createCell(1).setCellValue(list2.get(i));
		}

		inputstream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.close();
	}

	/********** read the date from excel file **********/
	public static List<String> readExcel(String sheetname) {
		// System.out.println("initializing read Excel");
		logger.info("initializing read Excel");

		try {
			FileInputStream readFile = new FileInputStream(
					System.getProperty("user.dir") + "\\ExcelData\\makeMyTrip.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(readFile);

			// System.out.println("workbook * * * "+workbook);

			XSSFSheet sheet = workbook.getSheet(sheetname);
			// System.out.println("sheet * * *"+sheet);
			Row row;

			Cell cell;
			Iterator<Row> rowItr = sheet.iterator();
			row = rowItr.next();
			// rowItr.next();
			List<String> details = new ArrayList();
			while (rowItr.hasNext()) {
				row = rowItr.next();

				Iterator<Cell> cellItr = row.cellIterator();
				while (cellItr.hasNext()) {
					cell = cellItr.next();
					DataFormatter formatter = new DataFormatter();
					String text = formatter.formatCellValue(cell);
					details.add(text);
//					logger.info(text);
					// System.out.println(text);
				}
				break;
			}
			return details;
		} catch (Exception e) {
			return null;

		}
	}

}
