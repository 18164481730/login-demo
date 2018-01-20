package com.tangzhihe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.tangzhihe.domain.User;
import com.tangzhihe.service.UserService;
import com.tangzhihe.util.Md5Util;
import com.tangzhihe.util.StringUtil;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/** 
 * 登录
 */
@Controller
public class LoginController extends  AbstractController{
    @Autowired
    private UserService userService;
    
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        model.addAttribute("ctx", getContextPath()+"/");
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("ctx",request.getContextPath());
        Map<String,Object> map =new HashMap<String,Object>();
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        if(StringUtil.isNull(userName)){
        	map.put("result", "0");
        } else if(StringUtil.isNull(password)) {
        	map.put("result", "1");
        } else{
            User user =new User();
            user.setUsername(userName);
            request.getSession().setAttribute("user",user);
            System.out.println("userName: " + userName + " , password: " + password + " , 加密后: " + Md5Util.encrypt(password));
	        List<User> userList = userService.queryUserList(user);
	        if(userList.size()!=0 && Md5Util.encrypt(password).equals(userList.get(0).getPassword())) {
	        	map.put("result", "2");
	        }else {
	        	map.put("result", "3");
	        }
        }
        return map;
    }
}
