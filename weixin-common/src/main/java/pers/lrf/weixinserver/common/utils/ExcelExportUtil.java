package pers.lrf.weixinserver.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public class ExcelExportUtil {

    private static Log log = LogFactory.getLog(ExcelExportUtil.class);

    private static String strJoinStr(String a, String b) {
        if ((a == null || "".equals(a.trim())) && (b == null || "".equals(b.trim()))) {
            return "";
        } else {
            return a + " / " + b;
        }
    }

    /**
     * poi导出文件 返回input流，把文件上传传到服务器,先定义好文件
     *
     * @param data      导出数据
     * @param start     开始位置
     * @param modelPath //文件路径
     * @param ls        列数
     * @param session
     * @return
     */
    public static InputStream export(List<List<String>> data, Integer start, String modelPath, int ls, HttpSession session) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();//取得输出
        try {
            String filePath = session.getServletContext().getRealPath(modelPath);//获取文件对象
            SXSSFWorkbook sxssfWorkBook = getSXSSWorkbook(data, start, ls, filePath);
            sxssfWorkBook.write(os);//把数据写到输出流中
            return new ByteArrayInputStream(os.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 导出表格数据：不用先定义好文件
     *
     * @param data       表格数据 可以为null
     * @param titleList  标题数据  标题数据不能为空
     * @param titleStyle 标题样式 可以为null
     * @return
     */
    public static InputStream export(List<List<String>> data, List<String> titleList, XSSFCellStyle titleStyle) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();//取得输出
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            if (titleStyle == null) titleStyle = getTitleStyle(workbook);
            SXSSFWorkbook book = new SXSSFWorkbook(workbook, 1000);
            //写表头数据
            writeTitleDate(book, sheet, titleStyle, titleList);
            //写表格主题数据
            writeCurrentData(book, sheet, getDtoStyle(workbook), 1, data, titleList.size());
            book.write(os);
            return new ByteArrayInputStream(os.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 导出表格数据：不用先定义好文件-----不上传到文件服务器(常用)
     *
     * @param data       表格数据 可以为null
     * @param titleList  标题数据  标题数据不能为空
     * @param titleStyle 标题样式 可以为null
     * @return
     */
    public static void exportStream(List<List<String>> data, List<String> titleList, XSSFCellStyle titleStyle, HttpServletResponse response, String fileName) throws Exception {
        OutputStream out = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("GB2312"), "ISO8859-1") + ".xlsx");
        //response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setContentType("application/vnd.ms-excel;charset=gb2312");
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            if (titleStyle == null) titleStyle = getTitleStyle(workbook);
            SXSSFWorkbook book = new SXSSFWorkbook(workbook, 1000);
            //写表头数据
            writeTitleDate(book, sheet, titleStyle, titleList);
            //写表格主题数据
            writeCurrentData(book, sheet, getDtoStyle(workbook), 1, data, titleList.size());
            book.write(out);
            out.flush();
            out.close();
            log.info("设置浏览器下载成功！");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取封装好数据的SXSSFWorkbook对象
     *
     * @param data
     * @param start
     * @param ls
     * @param filePath
     * @return
     * @throws IOException
     */
    private static SXSSFWorkbook getSXSSWorkbook(List<List<String>> data, Integer start, int ls, String filePath) throws Exception {

        SXSSFWorkbook sxssfWorkBook = null;
        try {
            InputStream fileInput = new FileInputStream(new File(filePath));
            XSSFWorkbook book = new XSSFWorkbook(fileInput);
            sxssfWorkBook = new SXSSFWorkbook(book);
            Sheet sheet = book.getSheet("Sheet1");
            XSSFCellStyle dtoStyle = getDtoStyle(book);
            writeCurrentData(sxssfWorkBook, sheet, dtoStyle, start, data, ls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sxssfWorkBook;
    }


    /**
     * 封装表格数据
     *
     * @param sheet
     * @param style
     * @param rowIndex
     * @param data
     */
    private static void writeCurrentData(SXSSFWorkbook book, Sheet sheet, XSSFCellStyle style, int rowIndex, List<List<String>> data, int ls) {
        try {
            Row row = null;
            Cell cell = null;
            if (data != null && data.size() > 0 && rowIndex >= 0) {
                for (int i = 0; i < data.size(); i++) {
                    List<String> list = data.get(i);
                    row = sheet.createRow(rowIndex + i);//创建写入数据的当前行
                    for (int j = 0; j < list.size(); j++) {
                        cell = row.createCell(j); //创建当前单元格
                        cell.setCellValue(list.get(j));
                        cell.setCellStyle(style);
                    }
                }
                data.clear();
            } else {
                style = (XSSFCellStyle) book.createCellStyle();
                style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 左右居中
                style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER); // 垂直居中
                sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, ls - 1));
                row = sheet.createRow(rowIndex);
                cell = row.createCell(0);
                cell.setCellStyle(style);
                cell.setCellValue("没有相关数据");
                cell.setCellStyle(style);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 表格标题数据
     *
     * @param book
     * @param sheet
     * @param style
     * @param titleData
     */
    private static void writeTitleDate(SXSSFWorkbook book, Sheet sheet, XSSFCellStyle style, List<String> titleData) {
        try {
            Cell cell = null;
            if (titleData != null && titleData.size() > 0) {
                Row row = sheet.createRow(0);
                for (int j = 0; j < titleData.size(); j++) {
                    cell = row.createCell(j); //创建当前单元格
                    cell.setCellValue(titleData.get(j));
                    cell.setCellStyle(style);
                    sheet.setColumnWidth(j, 256 * 15);
                }
            }
            titleData.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取合同计划相关数据背景颜色[第1/2/3/4/5/6/7/8/9/10月颜色]
     *
     * @param state
     * @return
     * @author zhangys
     * @date 2019/5/30 16:28
     */
    private static IndexedColors getCPlanBackGroundColor(Integer state) {
        switch (state) {
            case 1: // 1.灰色
                return IndexedColors.GREY_25_PERCENT;
            case 2: // 2.绿色
                return IndexedColors.LIME;
            case 3: // 3.黄色
                return IndexedColors.GOLD;
            case 4: // 4.红色
                return IndexedColors.RED;
            default:
                return IndexedColors.WHITE;
        }
    }

    /**
     * 获取合同计划相关数据字体颜色[客户质保金过期时间、项目截止时间]
     *
     * @param date
     * @return
     * @author zhangys
     * @date 2019/5/30 16:42
     */
    private static IndexedColors getCPlanFontColor(Date date) {
        if (date == null) return null;
        if (System.currentTimeMillis() > date.getTime()) {
            return IndexedColors.BLUE;
        }
        return null;
    }

    /**
     * @param book
     * @Description 获取表头样式
     * @date 2016-02-02
     * @author zhangys
     */
    public static XSSFCellStyle getTitleStyle(XSSFWorkbook book) {
        // 字体
        XSSFFont titleFont = book.createFont();
        titleFont.setFontName("宋体");
        titleFont.setFontHeightInPoints((short) 9);
        titleFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);

        // 样式
        XSSFCellStyle titleStyle = book.createCellStyle();
        titleStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 左右居中
        titleStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER); // 垂直居中
        titleStyle.setFont(titleFont); // 字体
        titleStyle.setFillForegroundColor(IndexedColors.TAN.index); // 背景颜色
        titleStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND); // 填充类型

        return titleStyle;
    }

    /**
     * @param book
     * @Description 获取汇总及总计行样式
     * @date 2016-02-01
     * @author zhangys
     */
    public static XSSFCellStyle getPoolStyle(XSSFWorkbook book) {
        // 字体
        XSSFFont poolFont = book.createFont();
        poolFont.setFontName("宋体");
        poolFont.setFontHeightInPoints((short) 9);
        poolFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);

        // 样式
        XSSFCellStyle poolStyle = book.createCellStyle();
        poolStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 左右居中
        poolStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER); // 垂直居中
        poolStyle.setFont(poolFont); // 字体
        poolStyle.setBorderTop(XSSFCellStyle.BORDER_THIN); // 上边框
        poolStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN); // 下边框
        poolStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN); // 左边框
        poolStyle.setBorderRight(XSSFCellStyle.BORDER_THIN); // 右边框
        poolStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.index); // 背景颜色
        poolStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND); // 填充类型

        return poolStyle;
    }

    /**
     * @param book
     * @Description 获取基础数据行样式
     * @date 2016-02-01
     * @author zhangys
     */
    public static XSSFCellStyle getDtoStyle(XSSFWorkbook book) {
        // 字体
        XSSFFont dtoFont = book.createFont();
        dtoFont.setFontName("宋体");
        dtoFont.setFontHeightInPoints((short) 9);

        // 样式
        XSSFCellStyle dtoStyle = book.createCellStyle();
        dtoStyle.setFont(dtoFont);                                      // 字体
        dtoStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);              // 左右居中
        dtoStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);   // 垂直居中
        dtoStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);               // 上边框
        dtoStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);            // 下边框
        dtoStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);              // 左边框
        dtoStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);             // 右边框

        return dtoStyle;

    }

    /**
     * @param book
     * @Description 获取基础数据行样式
     * @date 2016-02-01
     * @author zhangys
     */
    public static XSSFCellStyle getDtoStyle(XSSFWorkbook book, IndexedColors backgroundColor) {
        // 字体
        XSSFFont dtoFont = book.createFont();
        dtoFont.setFontName("宋体");
        dtoFont.setFontHeightInPoints((short) 9);

        // 样式
        XSSFCellStyle dtoStyle = book.createCellStyle();
        dtoStyle.setFont(dtoFont);                                      // 字体
        dtoStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);              // 左右居中
        dtoStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);   // 垂直居中
        dtoStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);               // 上边框
        dtoStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);            // 下边框
        dtoStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);              // 左边框
        dtoStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);             // 右边框
        dtoStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);        // 填充方式
        dtoStyle.setFillForegroundColor(backgroundColor.index);         // 背景颜色

        return dtoStyle;
    }

    /**
     * @param book
     * @Description 获取基础数据行样式
     * @date 2016-02-01
     * @author zhangys
     */
    public static XSSFCellStyle getDtoStyle(XSSFWorkbook book, IndexedColors backgroundColor, IndexedColors fontColor) {
        // 字体
        XSSFFont dtoFont = book.createFont();
        dtoFont.setFontName("宋体");
        dtoFont.setFontHeightInPoints((short) 9);
        if (fontColor != null) {
            dtoFont.setColor(fontColor.index);
        }

        // 样式
        XSSFCellStyle dtoStyle = book.createCellStyle();
        dtoStyle.setFont(dtoFont);                                      // 字体
        dtoStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);              // 左右居中
        dtoStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);   // 垂直居中
        dtoStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);               // 上边框
        dtoStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);            // 下边框
        dtoStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);              // 左边框
        dtoStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);             // 右边框
        if (backgroundColor != null) {
            dtoStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);    // 填充方式
            dtoStyle.setFillForegroundColor(backgroundColor.index);     // 背景颜色
        }

        return dtoStyle;
    }


}
