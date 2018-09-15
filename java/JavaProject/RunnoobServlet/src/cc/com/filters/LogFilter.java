package cc.com.filters;

import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

@WebFilter(filterName = "LogFilter")
public class LogFilter implements Filter {

    /**
     * 需要排除的页面
     */
    private String excludedPages;
    private String[] excludedPageArray;

    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        boolean pass = false;
        HttpServletRequest request = (HttpServletRequest) req;
        String path = request.getServletPath();
        for (String excludedPage: excludedPageArray){
            if( path.contains(excludedPage) ) {
                System.out.println(excludedPage + path);
                pass = true;
            }

        }

        // 输出站点名称
        System.out.println(req.getServerName());
        String requestValue = req.getParameter("name");


        if(requestValue == null)
            requestValue = "unknown";

        // get cookie
        if(!requestValue.equals("root") && !pass){
            Cookie[] cookies = request.getCookies();
            if( cookies != null ){
                for(Cookie cookie: cookies){
                    if(cookie.getName().equals("name")) {
                        requestValue = cookie.getValue();
                        System.out.println(cookie.getValue());
                    }
                }
            }
        }

        try {
            if (requestValue.equals("root")) {
                pass = true;
            } else if (!requestValue.equals("root") && !pass) {
                // 如果name不是root

                resp.setContentType("text/html;charset=utf-8");
                PrintWriter out = resp.getWriter();
                System.out.println("?????"+requestValue);
                out.println("權限不足拒絕訪問");
                out.println("request 或 cookie 的 name 非 root");

                // 關閉PrintWriter
                out.close();
            }
        }catch (NullPointerException e){
            // 如果name為空值

            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println("沒有權限拒絕訪問");
            out.println("request 的 name 為空值");
            // 關閉PrintWriter
            out.close();

        }finally {
            if (pass){
                // 把请求传回过滤链
                chain.doFilter(req, resp);
            }

        }

    }

    public void init(FilterConfig config) throws ServletException {
        // 獲取初始化參數
        String site = config.getInitParameter("Site");
        excludedPages = config.getInitParameter("excludedPage");
        excludedPageArray = excludedPages.split(",");
        // 寫到抓取 web.xml 的預設數值，該如何取得頁面的請求 url 跟預設排除 url 比對?


        // 輸出初始化參數
        System.out.println(site);

    }

}
