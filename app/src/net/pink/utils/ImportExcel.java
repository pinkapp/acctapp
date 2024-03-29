package net.pink.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * java读取excel工具类
 * 
 * @author huangdc
 * @version 1.0
 * 
 */
public class ImportExcel
{
	/**
	 * 从excel读取数据java类，从第二行开始读取，指定列号读取
	 * 
	 * @param <T>
	 * @param excelFile
	 *            excel文件（包括路径）
	 * @param sheetName
	 *            sheet名称
	 * @param fetchCellNum
	 *            读取列号，注意列号从0开始
	 * @param clazz
	 *            java类
	 * @param pattern
	 *            日期转换格式
	 * @return
	 */
	public static <T> List<T> importExcel(String excelFile, Class<T> clazz,
			Map<Integer, String> map, String sheetName, int fetchFirstRow,
			String pattern)
	{
		InputStream in = null;
		try
		{
			in = new FileInputStream(excelFile);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return importExcel(in, clazz, map, sheetName, fetchFirstRow, pattern);
	}

	/**
	 * 从excel读取数据java类，从第二行开始读取，指定列号读取，日期类型转换格式yyyy-MM-dd
	 * 
	 * @param <T>
	 * @param excelFile
	 *            excel文件（包括路径）
	 * @param sheetName
	 *            sheet名称
	 * @param fetchCellNum
	 *            读取列号，注意列号从0开始
	 * @param clazz
	 *            java类
	 * @return
	 */
	public static <T> List<T> importExcel(String excelFile, Class<T> clazz,
			Map<Integer, String> map)
	{
		String sheetName = "Sheet1";
		String pattern = "yyyy-MM-dd";
		InputStream in = null;
		try
		{
			in = new FileInputStream(excelFile);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return importExcel(in, clazz, map, sheetName, -1, pattern);
	}

	public static <T> List<T> importExcel(String excelFile, Class<T> clazz,
			Map<Integer, String> map, String sheetName)
	{
		String pattern = "yyyy-MM-dd";
		InputStream in = null;
		try
		{
			in = new FileInputStream(excelFile);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return importExcel(in, clazz, map, sheetName, -1, pattern);
	}

	public static <T> List<T> importExcel(String excelFile, Class<T> clazz,
			Map<Integer, String> map, String sheetName, int fetchFirstRow)
	{
		String pattern = "yyyy-MM-dd";
		InputStream in = null;
		try
		{
			in = new FileInputStream(excelFile);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return importExcel(in, clazz, map, sheetName, fetchFirstRow, pattern);
	}

	/**
	 * 从excel读取数据java类，从第二行开始读取，指定列号读取
	 * 
	 * @param <T>
	 * @param in
	 *            文件流
	 * @param sheetName
	 *            sheet名称
	 * @param fetchFirstRow
	 *            指定行开始读取
	 * @param map
	 *            行与类字段Field对应关系
	 * @param clazz
	 *            java类
	 * @param pattern
	 *            日期转换格式
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> importExcel(InputStream in, Class<T> clazz,
			Map<Integer, String> map, String sheetName, int fetchFirstRow,
			String pattern)
	{

		try
		{
			List<T> dataset = new ArrayList<T>();
			// 声明一个工作薄
			HSSFWorkbook workbook = new HSSFWorkbook(in);
			// 生成一个表格
			HSSFSheet sheet = workbook.getSheet(sheetName);
			int firstRowNum = 0;
			if (fetchFirstRow >= 0)
			{
				firstRowNum = fetchFirstRow;
			} else
			{
				firstRowNum = sheet.getFirstRowNum() + 1;
			}

			int lastRowNum = sheet.getLastRowNum();
			Field[] fields = clazz.getDeclaredFields();
			for (int i = firstRowNum; i <= lastRowNum; i++)
			{
				HSSFRow row = sheet.getRow(i);
				Object obj = clazz.newInstance();
				Set<Integer> set = map.keySet();
				for (Integer integer : set)
				{
					HSSFCell cell = row.getCell(integer);
					if (cell == null)
					{
						continue;
					}
					Field field = findField(fields, map.get(integer));
					if (field == null)
					{
						continue;
					}
					Class<?> type = field.getType();
					Object val = null;
					String value = getCellValue(cell);
					if (String.class.getName().equals(type.getName()))
					{
						val = value;
					} else if (Integer.class.getName().equals(type.getName()))
					{
						Double d = Double.parseDouble(value);
						val = d.intValue();

					} else if (Double.class.getName().equals(type.getName()))
					{
						val = Double.parseDouble(value);
					} else if (Long.class.getName().equals(type.getName()))
					{
						Double d = Double.parseDouble(value);
						val = d.longValue();

					} else if (Short.class.getName().equals(type.getName()))
					{
						Double d = Double.parseDouble(value);
						val = d.shortValue();

					} else if (Float.class.getName().equals(type.getName()))
					{
						Double d = Double.parseDouble(value);
						val = d.floatValue();

					} else if (Boolean.class.getName().equals(type.getName()))
					{
						val = Boolean.parseBoolean(value);
					} else if (Date.class.getName().equals(type.getName()))
					{
						SimpleDateFormat sdf = new SimpleDateFormat(pattern);
						val = sdf.parse(value);
					} else
					{
						System.err.println("不支持的数据类型");
						return null;
					}
					String fieldName = field.getName();
					String setMethodName = "set"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);
					Method setMethod = clazz.getMethod(setMethodName,
							field.getType());
					setMethod.invoke(obj, val);
				}
				dataset.add((T) obj);
			}
			return dataset;
		} catch (SecurityException e)
		{
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
			return null;
		} catch (IOException e)
		{
			e.printStackTrace();
			return null;
		} catch (InstantiationException e)
		{
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
			return null;
		} catch (NoSuchMethodException e)
		{
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
			return null;
		} catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		} finally
		{
			try
			{
				in.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}

	}

	private static Field findField(Field[] fields, String fieldName)
	{
		for (Field field : fields)
		{
			if (field.getName().equals(fieldName))
			{
				return field;
			} else
			{
				continue;
			}
		}
		return null;
	}

	private static String getCellValue(HSSFCell cell)
	{
		int cellType = cell.getCellType();
		switch (cellType)
		{
		case HSSFCell.CELL_TYPE_BLANK:

			return "";
		case HSSFCell.CELL_TYPE_BOOLEAN:

			return cell.getBooleanCellValue() + "";
		case HSSFCell.CELL_TYPE_ERROR:

			return cell.getErrorCellValue() + "";
		case HSSFCell.CELL_TYPE_FORMULA:

			return "";
		case HSSFCell.CELL_TYPE_NUMERIC:

			return cell.getNumericCellValue() + "";
		case HSSFCell.CELL_TYPE_STRING:

			return cell.getStringCellValue();

		default:
			return "";
		}

	}
	// public static void main(String[] args)
	// {
	// Map<Integer, String> map = new HashMap<Integer, String>();
	// map.put(0, "receiver");
	// map.put(1, "money");
	// map.put(2, "assignreason");
	// List<MoneyAssign> bb = ImportExcel.importExcel("c:\\a.xls",
	// MoneyAssign.class, map);
	// for (MoneyAssign moneyAssign : bb)
	// {
	// System.out.println(moneyAssign.getReceiver() + ","
	// + moneyAssign.getMoney() + ","
	// + moneyAssign.getAssignreason());
	// }
	// }

}