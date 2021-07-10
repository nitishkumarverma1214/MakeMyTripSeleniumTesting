package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static Row row = null;
	public static Cell cell = null;
	public static FileInputStream fis = null;
	static String excelFilepath = "src//test//resources//excelfile.xlsx";

	/********** Reading data from the excel file **********/

	 
}
