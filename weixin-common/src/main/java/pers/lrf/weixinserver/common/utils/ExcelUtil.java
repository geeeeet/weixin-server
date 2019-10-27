package pers.lrf.weixinserver.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * EXCEL工具
 *
 * @author Administrator
 */
public class ExcelUtil {
    public final static Log log = LogFactory.getLog(ExcelUtil.class);

    /**
     * 获取文件名称
     *
     * @param file
     * @return
     */
    public static String getName(MultipartFile file) {
        return file == null ? "" : file.getOriginalFilename();
    }

    /**
     * 判断文件名格式是否符合
     *
     * @param fileName 完整的文件名
     * @param format   格式:xls,xlsx
     * @return
     */
    public static boolean isFormat(String fileName, String format) {
        if (fileName == null || format == null) {
            return false;
        }
        return Pattern.matches(".+\\." + format.trim().toLowerCase() + "(x)?", fileName.toLowerCase());
    }

    /**
     * 获取模板文件
     *
     * @param tempFileName
     * @return
     */
    public static File getTempFile(HttpServletRequest request, String tempFileName) {
        String path = request.getSession().getServletContext().getRealPath("/");
        return new File(path + "/WEB-INF/assets/excelTmpl/" + tempFileName);
    }

    /**
     * 复制文件
     *
     * @param source
     * @param request
     * @param fileName
     * @return
     */
    public static File copyTempFile(File source, HttpServletRequest request, String fileName) {
        String path = request.getSession().getServletContext().getRealPath("/");
        File d = new File(path + "/WEB-INF/assets/excelTmpl/" + fileName);
        if (d.exists() && d.isFile()) {
            System.out.println(d.delete());
        }
        try {
            java.nio.file.Files.copy(source.toPath(), d.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * 获取exel
     *
     * @param startRow 开始读取行
     * @param maxCols  最大读取列数
     * @return
     */
    public static List<List<String>> parseExcel(InputStream stream, int startRow, int maxRow, int maxCols) {
        List<List<String>> rowList = new ArrayList<List<String>>();
        Workbook wb = null;
        try {
            wb = new XSSFWorkbook(stream);
            Sheet sheet1 = wb.getSheetAt(0);
            Row row;
            Cell cell;
            int rowSize = maxCols;
            int a = startRow < 1 ? 0 : startRow - 1;
            int rowNum = sheet1.getPhysicalNumberOfRows();
            rowNum = maxRow <= 0 || maxRow > rowNum ? rowNum : maxRow + a;
            for (int rowIndex = a; rowIndex < rowNum; rowIndex++) {
                row = sheet1.getRow(rowIndex);
                if (maxCols <= 0) {
                    int tempRowSize = row.getLastCellNum();
                    // 总是最大列数
                    if (tempRowSize > rowSize) {
                        rowSize = tempRowSize;
                    }
                }
                List<String> rusultList = new ArrayList<String>();
                // 循环对列取值
                for (int col = 0; col < rowSize; col++) {
                    cell = row.getCell(col);
                    if (cell == null) {
                        rusultList.add("");
                        continue;
                    }
                    // 获得对应单元格中的格式化数据
                    rusultList.add(getFormatValue(cell));
                }
                rowList.add(rusultList);
            }
            stream.close();
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                stream.close();
                wb.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
        return rowList;
    }

    /**
     * 写入EXCEL
     *
     * @param file
     * @param data
     * @param startRow
     */
    public static void writeExcel(File file, List<List<String>> data, int startRow) {
        Workbook wb = null;
        OutputStream out = null;
        try {
            wb = new XSSFWorkbook(new FileInputStream(file));
            Sheet sheet1 = wb.getSheetAt(0);
            Row row;
            Cell cell;
            startRow = startRow > 0 ? startRow - 1 : startRow;
            // OutputStream out  =  new FileOutputStream(file);
            // wb.write(out);
            for (int rowIndex = 0; rowIndex < data.size(); rowIndex++) {
                row = sheet1.getRow(rowIndex + startRow);
                if (row == null) row = sheet1.createRow(rowIndex + startRow);
                List<String> colList = data.get(rowIndex);
                for (int col = 0; col < colList.size(); col++) {
                    cell = row.getCell(col);
                    if (cell == null) cell = row.createCell(col);
                    cell.setCellValue(colList.get(col));
                }
            }
            out = new FileOutputStream(file);
            wb.write(out);
            wb.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                wb.close();
                out.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

    /**
     * 获取exel
     *
     * @param startRow 开始读取行
     * @param maxCols  最大读取列数
     * @return
     */
    public static List<List<String>> parseExcel(String filePath, int startRow, int maxRow, int maxCols) {
        try {
            return parseExcel(new FileInputStream(filePath), startRow, maxRow, maxCols);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<List<String>>();
    }

    /**
     * 获取exel
     *
     * @param startRow 开始读取行
     * @param maxCols  最大读取列数
     * @return
     */
    public static List<List<String>> parseExcel(MultipartFile file, int startRow, int maxRow, int maxCols) {
        try {
            return parseExcel(file.getInputStream(), startRow, maxRow, maxCols);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<List<String>>();
    }

    /**
     * 获取exel
     *
     * @param startRow 开始读取行
     * @param maxCols  最大读取列数
     * @return
     */
    public static List<List<String>> parseExcel(File file, int startRow, int maxRow, int maxCols) {
        try {
            return parseExcel(new FileInputStream(file), startRow, maxRow, maxCols);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<List<String>>();
    }

    /**
     * 获取EXCEL标题
     *
     * @param file
     * @param startRow
     * @param maxCols
     * @return
     */
    public static List<String> excelTitle(File file, int startRow, int maxCols) {
        try {
            List<List<String>> f = parseExcel(new FileInputStream(file), startRow, 0, maxCols);
            if (f != null && f.size() > 0) {
                return f.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<String>();
    }

    /**
     * 返回2003对应单元格的格式化数据
     *
     * @param cell 单元格
     * @return
     */
    public static String getFormatValue(Cell cell) {
        // 暂存单元格内容
        String value = "";
        try {
            // 匹配单元格内容
            switch (cell.getCellTypeEnum()) {
                // 数据格式类型
                case NUMERIC:// 判断是否是日期类型
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        if (date != null) {
                            value = new SimpleDateFormat("yyyy-MM-dd").format(date);
                        } else {
                            try {
                                value = cell.getStringCellValue();
                                if (value != null) {
                                    value = new SimpleDateFormat("yyyy-MM-dd").format(value);
                                }
                            } catch (Exception e) {
                            }
                        }
                    } else {
                        value = new DecimalFormat("0").format(cell.getNumericCellValue());
//					value=cell.getNumericCellValue()+"";
                    }
                    break;
                case STRING:// 字符串类型
                    value = cell.getStringCellValue();
                    break;
                case FORMULA:// 公式生成类型
                    try {
                        value = cell.getStringCellValue();
                    } catch (Exception e) {
                        value = cell.getNumericCellValue() + "";
                    }
                    break;
                case BOOLEAN:// 布尔型
                    value = cell.getBooleanCellValue() + "";
                    break;
                case BLANK:// 空白
                    break;
                case ERROR:// 错误格式
                    break;
                default:
                    value = cell.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value == null ? "" : value.trim();
    }

    public static String isHead(List<List<String>> lists, String[] titles) {
        if (CollectionUtils.isEmpty(lists) || lists.size() <= 1) {
            return "空文件或只有标题的文件！";
        }
        if (lists.get(0).size() != titles.length) {
            return "导入文件标题格式不正确！";
        }
        List<String> list = lists.get(0); // 标题行
        for (int i = 0; i < titles.length; i++) {
            String title = list.get(i);
            if (StringUtils.isEmpty(title) || !title.equals(titles[i])) {
                return "导入文件标题格式不正确！";
            }
        }
        return null;
    }

    /**
     * 从文件中获取字节数组
     *
     * @param file
     * @return
     */
    public static byte[] readInputStream(File file) {
        InputStream in = null;
        ByteArrayOutputStream bos = null;
        try {
            if (file == null) return new byte[0];
            byte[] buffer = new byte[1024];
            int len = 0;
            bos = new ByteArrayOutputStream();
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) > 0) {
                bos.write(buffer, 0, len);
            }
            bos.close();
            in.close();
            return bos.toByteArray();
        } catch (IOException e) {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ee) {
            }
            e.printStackTrace();
            return new byte[0];
        }
    }
}