/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import music.business.User;
import music.data.UserDB;

/**
 *
 * @author Ishita
 */
public class registercontroller extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           
        String url;
        String operationType = request.getParameter("operationType");
        HttpSession session = request.getSession(false);
         
        UserService service = new UserService();
        User user=new User();
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
            
        if("Register".equalsIgnoreCase(operationType)){
            String validationmsg=service.checkValidation(user);
            if("SUCCESS".equalsIgnoreCase(validationmsg)){
                //proceed with registration
                 int result = UserDB.UserRegistration(user);
                  if(result == -1){
                     //display error msg
                        request.setAttribute("message", "Incorrect registration");
                        getServletContext().getRequestDispatcher("/index1.jsp").forward(request,response); 
                 }
                 
                 String emailsuccess=service.sendEmail(user);
                 if("SUCCESS".equalsIgnoreCase(emailsuccess)){
                            session.setAttribute("name", user.getName());
                          url="/welcomeuser.jsp"; 
                         getServletContext().getRequestDispatcher(url).forward(request,response);  
                 }
                 else{
                     //display error msg
                        request.setAttribute("message", emailsuccess);
                        getServletContext().getRequestDispatcher("/index1.jsp").forward(request,response); 
                 }
                 
            }
            else{
            //display error msg
           request.setAttribute("message", validationmsg);
            getServletContext().getRequestDispatcher("/index1.jsp").forward(request,response);  
            }
           
        }
       else if("Login".equalsIgnoreCase(operationType)){
           String loginMsg = service.Userlogin(user);
            if(loginMsg.contains("SUCCESS")){
                         session.setAttribute("name", loginMsg.substring(7));
                         url="/welcomeuser.jsp";  
                         getServletContext().getRequestDispatcher(url).forward(request,response);  
                 }
                 else{
                     //display error msg
                        request.setAttribute("message1", loginMsg);
                        getServletContext().getRequestDispatcher("/index1.jsp").forward(request,response); 
                 }
        }
        
        else if("Submit".equalsIgnoreCase(operationType)){
           String msg = service.Adminlogin(user);
            if(msg.contains("SUCCESS")){
                         session.setAttribute("name", msg.substring(7));
                         url="/welcome.jsp";  
                         getServletContext().getRequestDispatcher(url).forward(request,response);  
                 }
                 else{
                     //display error msg
                        request.setAttribute("message2", msg);
                        getServletContext().getRequestDispatcher("/index1.jsp").forward(request,response); 
                 }
        }
        
        
        }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
          
    }



   
   


