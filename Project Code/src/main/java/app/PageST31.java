package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.javalin.http.Context;
import io.javalin.http.Handler;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2021. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageST31 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/PageST31.html";
    private static final String TEMPLATE = ("PageST31.html");

    @Override
    public void handle(Context context) throws Exception {

        ArrayList<String> State = new ArrayList<>();
        ArrayList<String> status = new ArrayList<>();
        ArrayList<String> sex = new ArrayList<>();
        ArrayList<String> age = new ArrayList<>();

        String html = "<html>";
        html = html + "<!DOCTYPE html>";
        html = html + "<html lang='en' xmlns='http://www.w3.org/1999/xhtml' xmlns:th='http://www.thymeleaf.org'>";

        html = html + "<head>";

       

        html = html + "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";

        html = html + " <title>Advanced Data    </title>";

        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "</head>";

        html = html + "<body>";
        
   

        html = html + "<header>";
        html = html + "<div class='topnav'>";
        html = html + "<a href='/'><span>Homepage</span></a>";
        html = html + "<a href='PageMission.html'><span>Our Mission</span></a>";
        html = html + "<a href='PageST21.html'><span>Simple Data</span></a>";
        html = html + "<a href='PageST31.html'><span>Advanced Data</span></a>";
        html = html + "<a href='PageUserForm.html'><span>User form</span></a>";
        html = html + "</div>";

        html = html + "<div class = 'TitleMissionPage'><span>Advanced Data</span></div>";
        html = html + "</header> ";

        html = html + """
            <div class = 'DataDescription'>
                <span>Welcome to the Advanced Data Page!
                      On this Page you can interact with various filters to get a count of Homless / At Risk
                      Individuals on a spreadsheet of coloums within a Table. .
                
                
                </span> 
                <h1>Page Desciption</h1>
            </div>    
                """;

        html = html + "<div class = 'ContentLevel2'>";
        html = html + "<form action='/PageST31.html' method='post'>";

        // LGA
        html = html + "<div class='LgaCheckboxes'>";

        html = html + "<label for='NSW'>NSW</label><br>";
        html = html + "<input type='checkbox' id='NSW' name='cb_LGA1' value='NSW' class = 'mr0'>";

        html = html + "<label for='VIC'>VIC</label><br>";
        html = html + "<input type='checkbox' id='VIC' name='cb_LGA2' value='VIC' class = 'mr0'>";

        html = html + "<label for='QLD'>QLD</label><br>";
        html = html + "<input type='checkbox' id='QLD' name='cb_LGA3' value='QLD' class = 'mr0'>";

        html = html + "<label for='SA'>SA</label><br>";
        html = html + "<input type='checkbox' id='SA' name='cb_LGA4' value='SA' class = 'mr0'>";

        html = html + "<label for='WA'>WA</label><br>";
        html = html + "<input type='checkbox' id='WA' name='cb_LGA5' value='WA' class = 'mr0'>";

        html = html + "<label for='TAS'>TAS</label><br>";
        html = html + "<input type='checkbox' id='TAS' name='cb_LGA6' value='TAS' class = 'mr0'>";

        html = html + "<label for='NT'>NT</label><br>";
        html = html + "<input type='checkbox' id='NT' name='cb_LGA7' value='NT' class = 'mr0'>";

        html = html + "<label for='ACT'>ACT</label><br>";
        html = html + "<input type='checkbox' id='ACT' name='cb_LGA8' value='ACT' class = 'mr0'>";

        html = html + "</div>";

        html = html + "<br>";

        html = html + "<div class='StatusCheckbox'>";

        html = html + "<label for='Homeless'>Homeless</label><br>";
        html = html + "<input type='checkbox' id='Homeless' name='cb_stat1' value='Homeless' class = 'mr0'>";

        html = html + "<label for='AtRisk'>AtRisk</label><br>";
        html = html + "<input type='checkbox' id='AtRisk' name='cb_stat2' value='At Risk' class = 'mr0'>";

        html = html + "</div>";

        html = html + "<br>";

        html = html + "<div class='GenderCheckbox'>";

        html = html + "<label for='Male'>Male</label><br>";
        html = html + "<input type='checkbox' id='Male' name='cb_sex1' value='Male' class = 'mr0'>";

        html = html + "<label for='Female'>Female</label><br>";
        html = html + "<input type='checkbox' id='Female' name='cb_sex2' value='Female' class = 'mr0'>";

        html = html + "</div>";

        html = html + "<br>";

        html = html + "<div class='AgeCheckbox'>";

        html = html + "<label for='0-9'>0-9</label><br>";
        html = html + "<input type='checkbox' id='0-9' name='cb_age1' value='0-9' class = 'mr0'>";

        html = html + "<label for='10-19'>10-19</label><br>";
        html = html + "<input type='checkbox' id='10-19' name='cb_age2' value='10-19' class = 'mr0'>";

        html = html + "<label for='20-29'>20-29</label><br>";
        html = html + "<input type='checkbox' id='20-29' name='cb_age3' value='20-29' class = 'mr0'>";

        html = html + "<label for='30-39'>30-39</label><br>";
        html = html + "<input type='checkbox' id='30-39' name='cb_age4' value='30-39' class = 'mr0'>";

        html = html + "<label for='40-49'>40-49</label><br>";
        html = html + "<input type='checkbox' id='40-49' name='cb_age5' value='40-49' class = 'mr0'>";

        html = html + "<label for='50-59'>50-59</label><br>";
        html = html + "<input type='checkbox' id='50-59' name='cb_age6' value='50-59' class = 'mr0'>";

        html = html + "<label for='60+'>60+</label><br>";
        html = html + "<input type='checkbox' id='60+' name='cb_age7' value='60+' class = 'mr0'>";

        

        html = html + "</div>";

        html = html + "<br>";

        html = html + "<div class='SubCheckbox'>";

        html = html + "<label for='sub'>Please select this before the search</label><br>";
        html = html + "<input type='checkbox' id='sub' name='cb_sub' value='Submit' class = 'mr0'>";

        html = html + "</div>";


        html = html + "<br>";

        html = html + "<div class = 'sortDropDown'>";

        html = html + "<label for='SortType_drop'>Pick an option to Sort the table:</label>";
        html = html + "      <select id='SortType_drop' name='SortType_drop'>";
        html = html + " <option value:'-----'>-----</option>";

        html = html + " <option value:'lga_name'>Local Area Name</option>";
        html = html + " <option value:'lga_code1'>Local Area Code</option>";
        html = html + " <option value:'age_group'>Age</option>";
        html = html + " <option value:'count'>Count</option>";
        html = html + "</select>";

        
        String SortType_drop = context.formParam("SortType_drop");

        ArrayList<String> SortType = new ArrayList<>();

        if(SortType_drop != null)
        {
            SortType.add(SortType_drop);
        }


        html = html + "</div>";
        html = html + "<br>";
        html = html + "<br>";


        // Next we will ask this *class* for the LGAs
        
       html = html + "<div class = 'ST31Submit'>";
        html = html + "<input type='submit' value='Submit Filters'>";
        html = html + "</div>";

        
       

        // LGA
        String cb_LGA1 = context.formParam("cb_LGA1");
        if (cb_LGA1 != null) {
            State.add("NSW");
        }

        String cb_LGA2 = context.formParam("cb_LGA2");
        if (cb_LGA2 != null) {
            State.add("VIC");
        }

        String cb_LGA3 = context.formParam("cb_LGA3");
        if (cb_LGA3 != null) {
            State.add("QLD");
        }

        String cb_LGA4 = context.formParam("cb_LGA4");
        if (cb_LGA4 != null) {
            State.add("SA");
        }

        String cb_LGA5 = context.formParam("cb_LGA5");
        if (cb_LGA5 != null) {
            State.add("WA");
        }

        String cb_LGA6 = context.formParam("cb_LGA6");
        if (cb_LGA6 != null) {
            State.add("TAS");
        }

        String cb_LGA7 = context.formParam("cb_LGA7");
        if (cb_LGA7 != null) {
            State.add("NT");
        }

        String cb_LGA8 = context.formParam("cb_LGA8");
        if (cb_LGA8 != null) {
            State.add("ACT");
        }

        // stat
        String cb_stat1 = context.formParam("cb_stat1");
        if (cb_stat1 != null) {
            status.add("homeless");
        }

        String cb_stat2 = context.formParam("cb_stat2");
        if (cb_stat2 != null) {
            status.add("at_risk");
        }

        // sex
        String cb_sex1 = context.formParam("cb_sex1");
        if (cb_sex1 != null) {
            sex.add("m");
        }

        String cb_sex2 = context.formParam("cb_sex2");
        if (cb_sex2 != null) {
            sex.add("f");
        }

        // age
        String cb_age1 = context.formParam("cb_age1");
        if (cb_age1 != null) {
            age.add("_0_9");
        }

        String cb_age2 = context.formParam("cb_age2");
        if (cb_age2 != null) {
            age.add("_10_19");
        }

        String cb_age3 = context.formParam("cb_age3");
        if (cb_age3 != null) {
            age.add("_20_29");
        }

        String cb_age4 = context.formParam("cb_age4");
        if (cb_age4 != null) {
            age.add("_30_39");
        }

        String cb_age5 = context.formParam("cb_age5");
        if (cb_age5 != null) {
            age.add("_40_49");
        }

        String cb_age6 = context.formParam("cb_age6");
        if (cb_age6 != null) {
            age.add("_50_59");
        }

        String cb_age7 = context.formParam("cb_age7");
        if (cb_age7 != null) {
            age.add("_60_plus");
        }

        html = html + "<br>";

        

        html = html + "</form>";

/**
 * html = html + "<div class = 'HorizontalLine'></div>";
        html = html + "<div class = 'HorizontalLine2'></div>";
 */
        
        String sub = context.formParam("cb_sub");
        System.out.println(sub);
        html = html + TableOut(State, status, sex, age, SortType, sub);
       
    
    
        html = html + "<div class = 'footer'>";

        html = html + "<p>COSC2803 - Studio Project- s3895754 Nathan & s3890406 Jabbar,G62 </p>";


        html = html + "</div>";

        System.out.println("SDD");
        ArrayList<String> list = new ArrayList<String>();



        
        // stats
        

        
        
        

        html = html + "</body>";
        html = html + "</html>";


       

        context.html(html);
    }


    



    private String TableOut( ArrayList<String> LGA, ArrayList<String> stat, ArrayList<String> sex, ArrayList<String> age, ArrayList<String> SortType, String sub)
    {
        String html = "";

        
        
        html = html + "<div class = 'tableContent'>";


            html = html + "<table style='width:100%'>";
                html = html + "<tr>";
                    html = html + "<th>Lga_name</th>"; 
                    html = html + "<th>Lga_num</th>";
                    html = html + "<th>Status</th>"; 
                    html = html + "<th>Sex</th>";
                    html = html + "<th>AgeGroup</th>"; 
                    html = html + "<th>Homeless Count</th>"; 

                html = html + "</tr>";

            JDBCConnection jdbc = new JDBCConnection();
            

            ArrayList<ArrayList<String>> Table = new ArrayList<ArrayList<String>>();

            Table = jdbc.advSearch(LGA, stat, sex, age, SortType);
           


             
             
            
            int currentColoumn = 0;
            int z = 0;
            boolean isEmpty = true;

            if(isEmpty == true)
            {
                for(int x = 0; x < LGA.size(); x++)
                {
                    if(LGA.get(x) != null)
                    {
                        System.out.println(LGA.get(x) + "");
                        isEmpty = false;
                    }
                }

            }
            
            
        if(sub != null)
        {
            for(int x = 0; x < Table.get(0).size(); x++) 
            {
                
             
               
                html = html + "<tr>"; 

                
                      html = html + "<td>" + Table.get(0).get(x) +"</td>";
                  
                      html = html + "<td>" + Table.get(1).get(x) +"</td>";
                 
                      html = html + "<td>" + Table.get(2).get(x) +"</td>";
                    
                      html = html + "<td>" + Table.get(3).get(x) +"</td>";
                  
                      html = html + "<td>" + Table.get(4).get(x) +"</td>";

                      html = html + "<td>" + Table.get(5).get(x) +"</td>";

                html = html + "</tr>"; 
            } 
                  
        }
            
                  html = html + "</tbody>";

                 
            
    

                

            html = html + "</table>";

            

        html = html + "</div>";     
        html = html + "</div>";

        return html;

    }

    
}
