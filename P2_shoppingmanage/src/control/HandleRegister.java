package control;

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wskyt on 2017/5/5.
 */
public class HandleRegister extends HttpServlet {
    private static final long serialVersionUID = -3604402967605081862L;

    public HandleRegister(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        User userBean = new User();
        req.setAttribute("userBean",userBean);

        String username = "";
        String password = "";
        String password2 = "";
        String telephone = "";
        String address = "";
        String realname = "";

        username = req.getParameter("username").trim();//trim()去除字符串前后空白
        password = req.getParameter("password").trim();
        password2 = req.getParameter("password2").trim();
        telephone = req.getParameter("telephone").trim();
        address = req.getParameter("address").trim();
        realname = req.getParameter("realname").trim();

        if (username == null || username == ""){
            userBean.setBackNews("用户名不能为空");
            req.getRequestDispatcher("/jsp/login/register.jsp").forward(req,resp);
        }
        if (password ==null || password == ""){
            userBean.setBackNews("密码不能为空");
            req.getRequestDispatcher("/jsp/login/register.jsp").forward(req,resp);
        }
        String regex = "[\\d]{11}";
        if (!password.equals(password2)){
            userBean.setBackNews("两次密码不一致，请重新输入");
            req.getRequestDispatcher("/jsp/login/register.jsp").forward(req,resp);
        }
        if (telephone.length() > 0 && !telephone.matches(regex)){
            userBean.setBackNews("请正确填写11位手机号");
            req.getRequestDispatcher("/jsp/login/register.jsp").forward(req,resp);
        }
        User user = new User(username,password,telephone,realname);
//        System.out.println(user.toString());
        UserDao userDao = new UserDao();
        if (userDao.register(user)){
            userBean.setBackNews("注册成功");
            req.getRequestDispatcher("/jsp/login/registerSuccess.jsp").forward(req,resp);
        }else{
            userBean.setBackNews("注册失败，请重新注册");
            req.getRequestDispatcher("/jsp/login/register.jsp").forward(req,resp);
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
}
