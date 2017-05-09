package control;

import dao.UserDao;
import pojo.Login;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by wskyt on 2017/5/5.
 */
public class HandleLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public HandleLogin(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username = "";
        String password = "";
        String cookies = "";
        username = req.getParameter("username");
        password = req.getParameter("password");
        cookies = req.getParameter("isCookie");
        handleCookies(req,resp,username,password,cookies);
        User user = new User(username,password);
        UserDao userDao = new UserDao();
        if (userDao.login(user)){
            success(req,resp,username);
            req.getRequestDispatcher("/jsp/login/loading.jsp").forward(req,resp);
        }else {
            String backNews = "用户名或者密码错误！";
            fail(req,resp,backNews);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    public void handleCookies(HttpServletRequest request,HttpServletResponse response,String username,String password,String cookie)
            throws ServletException,IOException{
        if ("isCookie".equals(cookie)){
            String newusername = URLEncoder.encode(username,"UTF-8");
            String newpassword = URLEncoder.encode(password,"UTF-8");

            Cookie usernameCookie = new Cookie("username",newusername);
            Cookie passwordCookie = new Cookie("password",newpassword);

            usernameCookie.setPath("/");
            passwordCookie.setPath("/");
            usernameCookie.setMaxAge(864000);
            passwordCookie.setMaxAge(864000);
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        }else {
            Cookie[] cookies = null;
            cookies = request.getCookies();
            if (cookies != null && cookies.length > 0){
                for (Cookie c : cookies){
                    if ("username".equals(c.getName()) || "password".equals(c.getName())){
                        c.setMaxAge(0);
                        c.setPath("/");
                        response.addCookie(c);
                    }
                }
            }
        }
    }

    public void success(HttpServletRequest request,HttpServletResponse response,String username){
        Login loginBean = null;
        HttpSession session = request.getSession(true);
        try{
            loginBean = (Login)session.getAttribute("loginBean");
            if (loginBean == null){
                loginBean = new Login();
                session.setAttribute("loginBean",loginBean);
                session.setMaxInactiveInterval(600);
                loginBean = (Login) session.getAttribute("loginBean");
            }
            String name = loginBean.getUsername();
            if (name.equals(username)){
                loginBean.setBackNews(username+" 您已登录，无需再次登录！");
                loginBean.setUsername(username);
            }
        }catch (Exception e){
            String backNews = "登录失败！"+e;
            fail(request,response,backNews);
        }
    }

    public void fail(HttpServletRequest request,HttpServletResponse response,String backNews){
        try{
            PrintWriter out = response.getWriter();
            out.print(backNews+"<br>");
            out.print("返回"+"<a href=/p2/jsp/login/login.jsp>登录界面</a>");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
