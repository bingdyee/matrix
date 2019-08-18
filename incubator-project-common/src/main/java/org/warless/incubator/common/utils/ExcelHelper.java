package org.warless.incubator.common.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
//import org.springframework.web.multipart.MultipartFile;

//import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 *  EasyExcel Helper
 *
 * @author : yubb
 * @date : 2019-07-16
 */
public class ExcelHelper {

    private static<T extends BaseRowModel> void export(OutputStream out, List<T> models, ExcelTypeEnum excelType, Class<T> clazz) throws IOException {
        ExcelWriter writer = EasyExcelFactory.getWriter(out, excelType, Boolean.TRUE);
        Sheet sheet = new Sheet(1, 0, clazz);
        sheet.setAutoWidth(Boolean.TRUE);
        writer.write(models, sheet);
        writer.finish();
        out.flush();
    }

    private static<T extends BaseRowModel> List<T> importing(InputStream in, Class<T> clazz) {
        List<T> modelList = new ArrayList<>();
        ExcelReader reader = EasyExcelFactory.getReader(in, new AnalysisEventListener(){
            @Override
            public void invoke(Object object, AnalysisContext context) {
                modelList.add((T) object);
            }
            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {}
        });
        reader.getSheets().forEach(sheet -> {
            sheet.setClazz(clazz);
            reader.read(sheet);
        });
        return modelList;
    }

    public static<T extends BaseRowModel> void exportToFile(String fileName, List<T> models, ExcelTypeEnum excelType, Class<T> clazz) {
        try(OutputStream out = new FileOutputStream(fileName)) {
            export(out, models, excelType, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static<T extends BaseRowModel> List<T> importFromFile(String fileName, Class<T> clazz) {
        try(InputStream in = new FileInputStream(fileName)) {
            return importing(in, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
/*
    public static<T extends BaseRowModel> void exports(HttpServletResponse response, String fileName, List<T> models, ExcelTypeEnum excelType, Class<T> clazz) {
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        try {
            response.setHeader("Content-disposition", "attachment;filename=" +  URLEncoder.encode(fileName,"utf-8"));
            OutputStream out = response.getOutputStream();
            export(out, models, excelType, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static<T extends BaseRowModel> List<T> imports(MultipartFile excel, Class<T> clazz) {
        try {
            InputStream in = excel.getInputStream();
            return importing(in, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
*/

}
