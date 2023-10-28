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
        //if account ! null return true
        return account != null;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(isAuthenticated(request)){
            //login
            processPost(request, response);
        }
        else {
            response.getWriter().println("access denied!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(isAuthenticated(request)){
            //login
            processGet(request, response);
        }
        else {
            response.getWriter().println("access denied!");
        }
    }
    
    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
    
    
    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
}
