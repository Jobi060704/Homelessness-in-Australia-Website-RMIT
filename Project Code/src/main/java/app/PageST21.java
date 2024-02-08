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
public class PageST21 implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/PageST21.html";
    private static final String TEMPLATE = ("PageST21.html");

    @Override
    public void handle(Context context) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();

        String html = "<html>";

        html = html + "<!DOCTYPE html>";

        html = html + "<html lang='en' xmlns='http://www.w3.org/1999/xhtml' xmlns:th='http://www.thymeleaf.org'>";

        html = html + "<head>";
        html = html + "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";
        html = html + "<title>Simple Data</title>";

        html = html + "<link rel='stylesheet' type='text/css' href='common.css'/>";
        html = html + "</head>";

        html = html + "<body onload = 'codeStartup()'>";

        // load all LGAS into the drop down box 
        html = html + """
                <script>
                function codeStartup()
                {
               
                }
                </script>
                """;

        html = html + "<header>";
        html = html + "<div class='topnav'>";
        html = html + "<a href='/'><span>Homepage</span></a>";
        html = html + "<a href='PageMission.html'><span>Our Mission</span></a>";
        html = html + "<a href='PageST21.html'><span>Simple Data</span></a>";
        html = html + "<a href='PageST31.html'><span>Advanced Data</span></a>";
        html = html + "<a href='PageUserForm.html'><span>User form</span></a>";
        html = html + "</div>";

        html = html + "<div class = 'TitleMissionPage'><span>Simple Data</span></div>";
        html = html + "</header> ";

        html = html + """
            <div class = 'DataDescription'>
                <span>Welcome to the simple Data Page!
                      On this Page you can interact with various filters to get a count of Homless / At Risk
                      Individuals. 
                      
                      You can Also use The LGA drop down box to find general facts related to your
                      selected LGA such as Area, Local population, LGA CODE, and other information.
                
                
                </span> 
                <h1>Page Desciption</h1>
            </div>    
                """;

        html = html + "<div class = 'ContentLevel2'>";
        html = html + "<form action='/PageST21.html' method='post'>";

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

        html = html + "<label for='AtRisk'>At Risk</label><br>";
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
        html = html + "<br>";


        // Next we will ask this *class* for the LGAs
        
       
                    html = html + "<input type='submit'class='SubmitST21' value='Search'>";
       

        ArrayList<String> LGA = new ArrayList<>();
        ArrayList<String> stat = new ArrayList<>();
        ArrayList<String> sex = new ArrayList<>();
        ArrayList<String> age = new ArrayList<>();
       

        // LGA
        String cb_LGA1 = context.formParam("cb_LGA1");
        if (cb_LGA1 != null) {
            LGA.add("NSW");
        }

        String cb_LGA2 = context.formParam("cb_LGA2");
        if (cb_LGA2 != null) {
            LGA.add("VIC");
        }

        String cb_LGA3 = context.formParam("cb_LGA3");
        if (cb_LGA3 != null) {
            LGA.add("QLD");
        }

        String cb_LGA4 = context.formParam("cb_LGA4");
        if (cb_LGA4 != null) {
            LGA.add("SA");
        }

        String cb_LGA5 = context.formParam("cb_LGA5");
        if (cb_LGA5 != null) {
            LGA.add("WA");
        }

        String cb_LGA6 = context.formParam("cb_LGA6");
        if (cb_LGA6 != null) {
            LGA.add("TAS");
        }

        String cb_LGA7 = context.formParam("cb_LGA7");
        if (cb_LGA7 != null) {
            LGA.add("NT");
        }

        String cb_LGA8 = context.formParam("cb_LGA8");
        if (cb_LGA8 != null) {
            LGA.add("ACT");
        }

        // stat
        String cb_stat1 = context.formParam("cb_stat1");
        if (cb_stat1 != null) {
            stat.add("at_risk");
        }

        String cb_stat2 = context.formParam("cb_stat2");
        if (cb_stat2 != null) {
            stat.add("homeless");
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

        html = html +"<div class = 'DropDownLGA'>";
        html = html + "      <label for='LGA_dropDown'>Select the LGA:</label>";
        html = html + "      <select id='movietype_drop' name='movietype_drop'>";
            JDBCConnection jdbc = new JDBCConnection();
            ArrayList<LGA> lgas = jdbc.getLGAs();

            html = html + " <option value:'-----'>-------</option>";

            for(int i = 0; i < lgas.size(); i++)
            {
                html = html + "<option value:'"+  lgas.get(i).getCode()+"'>"+ lgas.get(i).getName() +"</option>";
            }
            
            html = html + "</select>";
        

        html = html + "</form>";

        html = html + "</div>";

        html = html + "<div class = 'verticleLine'>";

        html = html + "</div>";
        html = html +"<div class = 'verticleLine2'></div>";

        
    
        html = html + "<div class = 'ResultsField'>";
        html = html + "<span>Resulting Query</span>";
        html = html + "<br>";
        html = html + "<p>Count of homeless under categories:" + outputCNT(LGA, stat, sex, age) + "</p>";
        html = html + "</div>";

        html = html + " <div class='footerIndex'>";
        html = html + "<p>COSC2803 - Studio Project- s3895754 Nathan & s3890406 Jabbar,G62 </p>";

        html = html + "<div class='GroupHeader'>";
        html = html + "<span>G66</span>";
        html = html + " </div>";
        html = html + " </div>";


        String movietype_drop = context.formParam("movietype_drop");

        if (movietype_drop == null) {
            // If NULL, nothing to show, therefore we make some "no results" HTML
        } else {
            // If NOT NULL, then lookup the movie by type!
            html = html + outputLgaFacts(movietype_drop);
        }

        html = html + "</body>";
        html = html + " </html>";
        context.html(html);
    
    
    }

    private String outputLgaFacts(String movietype_drop) {
        String html = "";
        JDBCConnection jdbc = new JDBCConnection();

        String area = jdbc.LgaGeneralArea(movietype_drop);
        String population = jdbc.LgaGeneralPopulation(movietype_drop);

html = html +"<div class = 'FactBlock'>";
        html = html + "<div class='LgaFactHeader'>";
            html = html + "<span>" + movietype_drop + " General Facts:" +"</span>";
        html = html + "</div>";

         html = html + "<div class =  'LgaArea'";
                html = html + "<span>" + area + "</span>";
         html = html + "</div>";

         html = html + "<div class =  'LgaPopulation'";
         html = html + "<span>" + population + "</span>";
  html = html + "</div>";
  html = html + "</div>";


        return html;
    }

    public int outputCNT(ArrayList<String> LGA, ArrayList<String> stat, ArrayList<String> sex, ArrayList<String> age) {
        JDBCConnection jdbc = new JDBCConnection();
        int cnt = jdbc.basicSearch(LGA, stat, sex, age);
        return cnt;
    }

    
}
