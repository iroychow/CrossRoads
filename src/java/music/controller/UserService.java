/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import music.business.User;
import music.data.UserDB;
import music.util.MailUtilGmail;

/**
 *
 * @author Ishita
 */

public class UserService {
    
    /*validation when user registers*/
    public String checkValidation(User user){
        String message = "SUCCESS";
        if(null==user)
        {
            message="Please fill in all the required fields";
            
        }
        else if(user.getEmail() ==null ||"".equalsIgnoreCase(user.getEmail().trim()))
        {
            message="Email is mandatory";
        }
          else if(user.getName()==null ||"".equalsIgnoreCase(user.getName().trim()))
        {
            message="Username is mandatory";
        }
        else if(user.getPassword() ==null ||"".equalsIgnoreCase(user.getPassword().trim()))
        {
            message="Password is mandatory";
        }
        else if(UserDB.emailExists(user.getEmail())){
            message="Duplicate email address";
        }
        
        return message;
        
    } 
    
     /*Send email when user registers*/
    public String sendEmail(User user){
            String result = "SUCCESS";
        // send email to user
            String to = user.getEmail();
            String from = "email_list@murach.com";
            String subject = "Welcome to our email list";
            String body = "Dear " + user.getName() + ",\n\n"
                    + "Thanks for registering in our site. We'll make sure to send "
                    + "you announcements about new items and discounts.\n"
                    + "Have a great day and thanks again!\n\n"
                    + "Team CrossRoads";
                    
            boolean isBodyHTML = false;

            try {
                MailUtilGmail.sendMail(to, from, subject, body, isBodyHTML);
            } catch (MessagingException e) {
                System.out.println(e.getMessage());
                result = "ERROR: Unable to send email. "
                        + "NOTE: You may need to configure your system ";
               
            }
            
         return result;
        
    }
    
     /*User login*/
    public String Userlogin(User user){
        String result="SUCCESS";
        try{
            String message = UserDB.Userlogin(user.getEmail(), user.getPassword());
            if(message.startsWith("ERROR"))
                result = message;
            else{
               result =result+message; 
            }
           
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            result="User login error";
                   
        }
        
        return result;
    }
    
     /*Admin login along with Validation*/
     public String Adminlogin(User user){
        String result="SUCCESS";
        try{
            boolean message = UserDB.AdminLogin(user.getName(), user.getPassword());
            
            if(!message)
                result = "ERROR: Invalid username and password";
            else{
               result =result+user.getName(); 
            }
           
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            result="User login error";
                   
        }
        
        return result;
    }
     
     public void processUser(HttpServletRequest request,
            HttpServletResponse response) {
        
        String name = request.getParameter("Name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
        }

        if (UserDB.emailExists(email)) {
            user = UserDB.selectUser(email);
            user.setname(name);
            user.setEmail(email);
            user.setAddress(address);
            user.setCity(city);
            user.setState(state);
            user.setZip(zip);
            UserDB.update(user);
        } else {
            user.setname(name);
            user.setEmail(email);
            user.setAddress(address);
            user.setCity(city);
            user.setState(state);
            user.setZip(zip);
            UserDB.insert(user);
        }

        session.setAttribute("user", user);

        
    }
   
    
}
