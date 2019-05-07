package com.pzhu.shopping.myshop.controller.admin;


import com.pzhu.shopping.myshop.pojo.user.User;
import com.pzhu.shopping.myshop.service.user.UserService;
import com.pzhu.shopping.myshop.utils.PasswordUtils;
import com.pzhu.shopping.myshop.utils.StringUtil;
import com.pzhu.shopping.myshop.utils.TextUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author Administrator
 * @Date 2019/1/4 22:34
 * @Classname AdminLoginController
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginController {
    private static final Logger logger=Logger.getLogger(AdminLoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/adminLogin")
    public String adminLogin(HttpServletRequest request, HttpServletResponse response){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取密码盐
        String passwordSalt = userService.getPasswordSaltByUsername(username);

        if (TextUtils.empty(username)) {
            request.setAttribute("msg", "用户名不能为空");
            return "redirect:/admin/login.jsp";
        }
        if (TextUtils.empty(password)) {
            request.setAttribute("msg", "密码不能为空");
            return "redirect:/admin/login.jsp";
        }

        //管理员登录
        password= PasswordUtils.getPasswordMD5(password, passwordSalt, 1024);
        User admin = null;
        try {
            admin = userService.adminLogin(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("管理员登录失败");
            return "redirect:/admin/admin.jsp";
        }
        request.getSession().setAttribute("admin", admin);
        logger.info("管理员登录成功!==>"+username);
        return "redirect:/admin/admin.jsp";
    }

    @RequestMapping("/searchuserlist")
    @ResponseBody
    public List<User> searchUserList(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String gender = request.getParameter("gender");
        if ("1".equals(gender)) {
            gender = "男";
        } else if ("2".equals(gender)) {
            gender = "女";
        }
        List<User> userList=null;
        if (username != null || gender!=null) {
            userList = userService.findAllUser(username, gender);
        }
        logger.info("查询用户==>"+userList.toString());
        return userList;
    }

    @RequestMapping("/getuserlist")
    public String getUserList(HttpServletRequest request){
        List<User> userList = userService.getUserList();
        request.getSession().setAttribute("userList", userList);
        logger.info("获取所有用户==>"+userList.toString());
        return "redirect:/admin/userList.jsp";
    }

    @RequestMapping("/getinvaliduserlist")
    public String getInvalidUserList(HttpServletRequest request){
        List<User> userList = userService.getInvalidUserList();
        request.getSession().setAttribute("userList", userList);
        logger.info("获取无效用户==>"+userList.toString());
        return "redirect:/admin/invalidUser.jsp";
    }

    @GetMapping("/deleteuser")
    public String deleteUser(HttpServletRequest request, HttpServletResponse response){
        String _id = request.getParameter("id");
        if (TextUtils.empty(_id)) {
            return null;
        }
        int id = Integer.parseInt(_id);
        userService.remove(id);
        logger.info("删除用户,被删除的用户id为==>"+id);
        return "forward:getuserlist";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("admin");
        request.getSession().invalidate();
        logger.info("管理员退出成功!");
        return "/admin/login";
    }

    @RequestMapping("/updateuser")
    public int updateuser(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        int userId = 0;
        if (!StringUtil.isEmpty(id)) {
            userId = Integer.parseInt(id);
        }
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String role = request.getParameter("role");
        int userRole = 1 ;
        if ("管理员".equals(role)) {
            userRole = 0;
        }

        User user = new User();
        user.setEmail(email);
        user.setId(userId);
        user.setRole(userRole);
        user.setUsername(username);
        int flag = userService.updateUser(user);
        return flag;
    }

}
