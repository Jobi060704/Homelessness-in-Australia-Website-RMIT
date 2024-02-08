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
public class PageMission implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/PageMission.html";
    private static final String TEMPLATE = ("PageMission.html");

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String

        // Map<String, Object> model = new HashMap<String, Object>();
        // context.render(TEMPLATE,model);

        String html = "<html>";
        html = html + "<!DOCTYPE html>";
        html = html + "<html lang='en' xmlns='http://www.w3.org/1999/xhtml' xmlns:th='http://www.thymeleaf.org'>";

        html = html + "<head>";
        html = html + "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";

        html = html + " <title>Mission Statement</title>";

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

        html = html + "<div class = 'TitleMissionPage'><span>Mission Statement</span></div>";
        html = html + "</header> ";

        
        html = html + """
            <div class = 'MissionPurpose'>
                <Span>Day by day, the counts of the homeless in Australia increase. The economy marginally suffers, and more importantly, the pressure under which the people in that condition becomes more and more severe. 
                Our Mission is to create a space where anyone, be it a casual searcher or an expert, could obtain information about the ongoing problem, and have the ability to offer help towards the resolution of the problem.
                We give ways of search to obtain accurate info and created a simple form where you could make a donation, or note yourself to us, for which we could aid you.
                
                Please Scroll Down for information about intended users.
                </span>
        </div>
        """;

        html = html + "<div class = 'Personas'>";

        html = html + "<h1>Intended Users</h1>";
        /*  */
        html = html + "<div class = 'Persona1Image'>";
        html = html + "<img src ='Dylan.jpg' style = 'width:250px; height:250px;'>";
        html = html + "</div>";

        html = html +

        """
            <div class = 'Persona1Description'>
                <span> 
                    Dylan is a middle-aged Man (in his thirties), in a gated suburb. He currently works in marketing Selling Produce to Global Food Market Chains. Looking to help his son with his primary school project on homelessness using the website and their respected services given
                </span>
            </div>
                """;

                html = html + "<br>";
        html = html + "<div class = 'Persona2Image'>";
        html = html + "<img src ='Joanna.jpg' style = 'width:250px; height:250px;'>";

        
        html = html + "</div>";

        html = html +

        """
            <div class = 'Persona1Description'>
                <span> 
                Joanna is a lower-class middle-aged woman who has been living off her pension due to a workplace environment 
                and Currently at risk of being homeless with her three kids.
                </span>
            </div>
                """;

        /* */

        html = html + "</div>";

        html = html + "<div class = 'footer'>";

        html = html + "<p>COSC2803 - Studio Project- s3895754 Nathan & s3890406 Jabbar,G62 </p>";

        html = html + "<div class='GroupHeader'>";
        html = html + "<span>G66</span>";
        html = html + " </div>";

        html = html + "</div>";

        html = html + "</body>";
        html = html + "</html>";

        context.html(html);
    }

}
