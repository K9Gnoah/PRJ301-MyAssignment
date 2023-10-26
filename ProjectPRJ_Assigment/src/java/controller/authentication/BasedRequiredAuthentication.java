/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.authentication;

import dal.UserDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.User;

/**
 *
 * @author THINKPAD
 */
public abstract class BasedRequiredAuthentication extends HttpServlet{
    private boolean isAuthenticated(HttpServletRequest request){
        User account = (User) request.getSession().getAttribute("account");
        if(account != null){
            return true;
        }
        else{
            String user = null;
            String pass = null;
            Cookie[] cookies = request.getCookies();
            //check if have cookies already
            if(cookies != null){
                for(Cookie cooky : cookies){
                    if(user != null && pass != null){
                        break;
                    }
                    if(cooky.getName().equals("user")){
                        user =cooky.getValue();
                    }
                    if(cooky.getName().equals("pass")){
                        pass = cooky.getValue();
                    }
                }
            }
            if(user != null && pass != null){
                UserDBContext db = new UserDBContext();
                User param = new User();
                param.setUsername(user);
                param.setPassword(pass);
                account = db.getUsers(param);
                return account != null;
            }
            else{
                return false;
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
