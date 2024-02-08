package app;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

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
public class PageIndex implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/";
    private static final String TEMPLATE = ("PageIndex.html");

    @Override
    public void handle(Context context) throws Exception {

        Map<String, Object> model = new HashMap<String, Object>();

        String html = "<html>";

        html = html + " <!doctype html>";

        html = html + "<html lang='en'; xmlns='http://www.w3.org/1999/xhtml' xmlns:th='http://www.thymeleaf.org'>";
        html = html + "<script src='Slideshow.js'></script>";

        html = html + "<head>";
        html = html + "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";
        html = html + "<title>Homepage</title>";
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "</head>";

        html = html + "<body onload = 'codeStartup()'>";

        html = html + """
                <script>
                function codeStartup()
                {
                   let slidesx = document.getElementsByClassName('mySlides');
                   slidesx[0].style.display = 'block';
                   slidesx[1].style.display = 'none';
                   slidesx[2].style.display = 'none';
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

        html = html + "<div class = 'TitleMissionPage'><span>HomePage</span></div>";
        html = html + "</header> ";

        html = html + "<div class ='slideshow-container'>";
        html = html + " <script src='JS/Slideshow.js'></script>";

        JDBCConnection cap1 = new JDBCConnection();
        String CaptionOne = ""+(Math.round(cap1.getTotalMinors()/(double)cap1.getTotalHMLS()*100))+"% of Homeless are Minors according to 2016 census data.";

        html = html + "<div class = 'mySlides Fade'>";
        html = html + "<div class = 'numbertext'>1/3</div>";
        html = html + "<img src = 'Homeless.jpeg' style='width:100%'>";
        html = html + "<div class='text'><span th:text=" + CaptionOne + ">" + CaptionOne + "</span></div> ";
        html = html + " </div>";

        String CaptionTwo = "During the years 2016 to 2018, homlessness has grown by 1.6% in Brisbane.";

        html = html + " <div class = 'mySlides Fade'>";
        html = html + "<div class = 'numbertext'>2/3</div>";
        html = html + "<img src = 'Homeless2.jpeg' style='width:100%'>";
        html = html + "<div class='text'><span th:text=" + CaptionTwo + ">" + CaptionTwo + "</span> </div>";
        html = html + "</div>";

        JDBCConnection cap3 = new JDBCConnection();
        ArrayList<String> sam = cap3.getWorst();
        


        String CaptionThree = "The worst case of Homeless has occured in "+sam.get(0)+" with a total amount of\n "+sam.get(1)+" total homeless.";

        html = html + "<div class = 'mySlides Fade'>";
        html = html + "<div class = 'numbertext'>3/3</div>";
        html = html + " <img src = 'Homeless3.jpeg' style='width:100%'>";
        html = html + "<div class='text'><span th:text=" + "CaptionThree" + ">" + CaptionThree + "</span></div> ";
        html = html + " </div>";

        html = html + "<a class='prev' onclick='plusSlides(-1)'>&#10094</a>";
        html = html + "<a class='next' onclick='plusSlides(1)'>&#10095</a>";

        html = html + " </div> ";

        html = html + "<div style='text-align:center'>";
        html = html + "<span class='dot' onclick='currentSlide(1)'></span>";
        html = html + "<span class='dot' onclick='currentSlide(2)'></span>";
        html = html + "<span class='dot' onclick='currentSlide(3)'></span>";

        html = html + " </div> ";

        html = html + " <div class = 'HyperLinks'> ";
        html = html + "<a href='shorturl.at/vDLOS' id = 'hyper'><span id='spax'>shorturl.at/vDLOS</span></a> ";
        html = html + " </div> ";

        html = html + " <div class='footerIndex'>";
        html = html + "<p>COSC2803 - Studio Project- s3895754 Nathan & s3890406 Jabbar,G62 </p>";

        html = html + "<div class='GroupHeader'>";
        html = html + "<span>G66</span>";
        html = html + " </div>";
        html = html + " </div>";

        html = html + " </body>";

        html = html + "</html>";


        

        context.html(html);
    }

}