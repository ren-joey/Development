package cc.com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "UploadFiles")
public class UploadFiles extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // 文件儲存目錄
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上傳配置
    private static final int MEMORY_THRESHOLD   = 1024 * 100 ;  // 100k
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 1; // 1MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 2; // 2MB

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 檢查是否為多媒體上傳
        if(!ServletFileUpload.isMultipartContent(request)){
            // 如果不是則停止

            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("Error: 表單格式必須為多媒體型態(enctype=multipart/form-data)");

            out.flush();
            out.close();
            return;
        }

        // 配置上傳參數
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 設置內存臨界值，超過後產生臨時文件儲存於臨時目錄中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 設置臨時儲存目錄
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 設置最大文件上傳值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 設置最大請求值 (包含文件及表單數據)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文處理
        upload.setHeaderEncoding("utf-8");

        // 構造臨時路徑
        // 此路徑相等於當前應用目錄
        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
        System.out.println("$$$$$ get realpath:" + request.getServletContext().getRealPath("./"));
        System.out.println("$$$$$ get File.separator:" + File.separator);

        // 如果目錄不存在則創建
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()){
            uploadDir.mkdir();
        }

        try{

            // 解析請求內容，提取文件數據
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        request.setAttribute("message","文件上传成功!");

                        fileName = URLEncoder.encode(fileName, "UTF-8");
                        String linkPath = UPLOAD_DIRECTORY + File.separator + fileName;

                        response.sendRedirect(linkPath);
                    }
                }
            }

        }catch (Exception e){
            request.setAttribute("message",
                    "错误信息: " + e.getMessage());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
