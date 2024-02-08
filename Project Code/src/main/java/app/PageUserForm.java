package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.javalin.http.Context;
import io.javalin.http.Handler;


public class PageUserForm  implements Handler{


    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/PageUserForm.html";
    private static final String TEMPLATE = ("PageUserForm.html");

    @Override
    public void handle(Context context) throws Exception {
       
        String html = "<html>";
        html = html + "<!DOCTYPE html>";
        html = html + "<html lang='en' xmlns='http://www.w3.org/1999/xhtml' xmlns:th='http://www.thymeleaf.org'>";

        html = html + "<head>";
        html = html + "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";

        html = html + " <title>User Form</title>";

        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "</head>";

        html = html + "<body>";

        html = html + "<header>";
        html = html + "<div class='topnav'>";
        html = html + "<a href='/'><span>Homepage</span></a>";
        html = html + "<a href='PageMission.html'><span>Mission Statement</span></a>";
        html = html + "<a href='PageST21.html'><span>Simple Data</span></a>";
        html = html + "<a href='PageST31.html'><span>Advanced Data</span></a>";
        html = html + "<a href='PageUserForm.html'><span>User form</span></a>";
        html = html + "</div>";

        html = html + "<div class = 'TitleMissionPage'><span>User Input Form</span></div>";
        html = html + "</header> ";

        html = html + "<div class 'UserFormDescription'>";
                html = html + "<span>This WebPage will be used to collect Your data for the purpose of collecting additional data with respect to homelessness. If willing Please enter your details, below all details must be filled in. Please then click the submit button.</span>";        
        html = html + "</div>";


        
        html = html + "<div class = 'Content form'>";
        html = html + "<form action='/PageUserForm.html' method='post'>";



        html = html + "<div class = 'Name'>";
                html = html + "Full Name: <input type='text' name='user_firstName'>";
        html = html + "</div>";

        html = html + "<div class = 'PhoneTextBox'>";
                html = html + "Please enter your phone numberx: <input type='text' name='user_PhoneNumber'>";
        html = html + "</div>";

        html = html + "<div class = 'EmailTextBox'>";
                html = html + "Please enter your Email: <input type='text' name='user_Email'>";
        html = html + "</div>";

        html = html + "<div class = 'AgeTextBox'>";
                html = html + "Please enter your Age: <input type='text' name='user_Age'>";
        html = html + "</div>";

        html = html + "<div class = 'StatusTextBox' >";
                html = html + "Please enter your current Status, AtRisk or Homeless: <input type='text' name='user_Status'>";
        html = html + "</div>";

        html = html + "<div class = 'GenderTextBox'>";
        html = html + "Please enter your Gender, Female 'F' or Male 'M': <input type='text' name='user_Gender'>";
        html = html + "</div>";

        // html = html + "<div class = 'LGATextBox'>";
        // html = html + "Please enter your LGA_CODE: <input type='text' name='user_LGA'>";
        // html = html + "</div>";


   

        html = html + "<div class = 'UserFormSubmitButton'>";

        html = html + "<input type='submit' value='Submit' text='Submit User Data to Form'>";
        html = html + "</div>";


        html = html + "</form>";
        html = html + "</div>";
    

        html = html + "<div class = 'footer'>";

        html = html + "<p>COSC2803 - Studio Project- s3895754 Nathan & s3890406 Jabbar,G62 </p>";

        html = html + "<div class='GroupHeader'>";
        html = html + "<span>G66</span>";
        html = html + " </div>";

        html = html + "</div>";

        html = html + "</body>";
        html = html + "</html>";

        
        String FullName = context.formParam("user_firstName");

        String Phone = context.formParam("user_PhoneNumber");

        String Email = context.formParam("user_Email");

        String Age = context.formParam("user_Age");

        String Status = context.formParam("user_Status");

        String Gender = context.formParam("user_Gender");

        // String LGA = context.formParam("user_LGA");




        JDBCConnection jdbc = new JDBCConnection();
        

        if(FullName != "" && Age != null && Status != "" && Gender != "")
        {
                int age = Integer.parseInt(Age);
                jdbc.crtHMLS(FullName, Phone, Email, age, Status, Gender);
        }
       
        context.html(html);

    }

}