package app;

import java.util.ArrayList;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database.
 * Allows SQL queries to be used with the SQLLite Databse in Java.
 *
 * @author Timothy Wiley, 2022. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */

public class JDBCConnection {
    private static final String DATABASE = "jdbc:sqlite:database/homelessness.db";
    private static final String CTG = "jdbc:sqlite:database/ctg.db";


    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }

    /*
     * public xxx xxx() {
     * 
     * Connection connection = null;
     * 
     * try {
     * connection = DriverManager.getConnection(DATABASE);
     * 
     * Statement statement = connection.createStatement();
     * statement.setQueryTimeout(30);
     * 
     * String query = "xxx";
     * 
     * ResultSet results = statement.executeQuery(query);
     * 
     * while (results.next()) {
     * 
     * }
     * 
     * statement.close();
     * } catch (SQLException e) {
     * System.err.println(e.getMessage());
     * } finally {
     * try {
     * if (connection != null) {
     * connection.close();
     * }
     * } catch (SQLException e) {
     * System.err.println(e.getMessage());
     * }
     * }
     * 
     * return xxx;
     * }
     */

    public ArrayList<LGA> getLGAs() {
        // Create the ArrayList of LGA objects to return
        ArrayList<LGA> lgas = new ArrayList<LGA>();

        // Setup the variable for the JDBC connection
        Connection connection = null;

        try {
            // Connect to JDBC data base
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT * FROM LGA";

            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int code = results.getInt("lga_code");
                String name = results.getString("lga_name");

                // Create a LGA Object
                LGA lga = new LGA(code, name);

                // Add the lga object to the array
                lgas.add(lga);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally we return all of the lga
        return lgas;
    }

    public int getTotalHMLS() {
        int tot_hmls = 0;

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT SUM(count) as sum FROM HomlessGroup";

            ResultSet results = statement.executeQuery(query);

            tot_hmls = results.getInt("sum");

            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return tot_hmls;
    }

    public double getSexMajority() {

        int m_count = 0;
        int f_count = 0;
        double rat = 0;

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query1 = "SELECT SUM(count) as sum FROM HomlessGroup WHERE sex = \"m\"";

            ResultSet results1 = statement.executeQuery(query1);

            m_count = results1.getInt("sum");

            String query2 = "SELECT SUM(count) as sum FROM HomlessGroup WHERE sex = 'f'";

            ResultSet results2 = statement.executeQuery(query2);

            f_count = results2.getInt("sum");

            rat = (double) (m_count) / f_count;

            rat = (rat >= 1) ? rat - 1 : -(1 / rat - 1);

            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return rat;
    }

    public int getTotalMinors() {

        int tot_min = 0;

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT SUM(count) as count FROM HomlessGroup WHERE age_group = '_0_9' OR age_group = '_10_19'";

            ResultSet results = statement.executeQuery(query);

            tot_min = results.getInt("count");

            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

        return tot_min;
    }

    public void crtHMLS(String fname, String phone, String email, int age, String stat, String sex) {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "INSERT INTO U_HMLS VALUES ('" + fname + "','" + phone + "','" + email + "'," + age + ",'"
                    + stat + "','" + sex + "')";
            // INSERT INTO U_HMLS VALUES ("A,B","+123 456 78
            // 90","EXAMPLE@EXAMPLE.COM",69,"at_risk","MALE","VIC")

            statement.executeQuery(query);

            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void crtDNTRS(String fname, String email, int dntn) {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "INSERT INTO U_DNTRS VALUES ('" + fname + "','" + email + "'," + dntn + ")";

            statement.executeQuery(query);

            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public String LgaGeneralPopulation(String LgaName)
    {
        Connection connection = null;

        String result = "";

        try {
            connection = DriverManager.getConnection(CTG);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query2 = "SELECT SUM(count) as cnt FROM PopulationStatistics Join LGA ON (PopulationStatistics.lga_code16 = LGA.lga_code16) WHERE lga_name16 = '" + LgaName + "'";
            ResultSet results2 = statement.executeQuery(query2);
            int cnt = results2.getInt("cnt");
            result =  "Population: "+Integer.toString(cnt);
          
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        


        return result;
    }

    public String LgaGeneralArea(String LgaName)
    {
        Connection connection = null;

        String result = "";

        try {
            connection = DriverManager.getConnection(CTG);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            


            
            String query = "SELECT area_sqkm as area FROM LGA WHERE lga_name16 = '" + LgaName + "'";
            ResultSet results = statement.executeQuery(query);
            double area = results.getDouble("area");
            result += "\n Area (km^2): " + Double.toString(area);
    
          
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        


        return result;
    }
    
    
    public int basicSearch(ArrayList<String> LGA, ArrayList<String> stat, ArrayList<String> sex,
            ArrayList<String> age) {
        Connection connection = null;
        int i = 0;
        String q_add = "(";

        if (LGA.size() == 1) {
            switch (LGA.get(0)) {
                case "NSW":
                    q_add += "(lga_code >= 10050 AND lga_code <= 19399)";
                    break;
                case "VIC":
                    q_add += "(lga_code >= 20110 AND lga_code <= 29399)";
                    break;
                case "QLD":
                    q_add += "(lga_code >= 30250 AND lga_code <= 37600)";
                    break;
                case "SA":
                    q_add += "(lga_code >= 40070 AND lga_code <= 49399)";
                    break;
                case "WA":
                    q_add += "(lga_code >= 50080 AND lga_code <= 59370)";
                    break;
                case "TAS":
                    q_add += "(lga_code >= 60210 AND lga_code <= 65810)";
                    break;
                case "NT":
                    q_add += "(lga_code >= 70200 AND lga_code <= 79399)";
                    break;
                case "ACT":
                    q_add += "(lga_code = 89399)";
                    break;
            }
        } else if (LGA.size() > 1) {
            q_add += "(";
            for (String temp1 : LGA) {
                switch (temp1) {
                    case "NSW":
                        q_add += "(lga_code >= 10050 AND lga_code <= 19399)";
                        break;
                    case "VIC":
                        q_add += "(lga_code >= 20110 AND lga_code <= 29399)";
                        break;
                    case "QLD":
                        q_add += "(lga_code >= 30250 AND lga_code <= 37600)";
                        break;
                    case "SA":
                        q_add += "(lga_code >= 40070 AND lga_code <= 49399)";
                        break;
                    case "WA":
                        q_add += "(lga_code >= 50080 AND lga_code <= 59370)";
                        break;
                    case "TAS":
                        q_add += "(lga_code >= 60210 AND lga_code <= 65810)";
                        break;
                    case "NT":
                        q_add += "(lga_code >= 70200 AND lga_code <= 79399)";
                        break;
                    case "ACT":
                        q_add += "(lga_code = 89399)";
                }
                q_add += " OR ";
            }
            q_add = q_add.substring(0, q_add.length() - 4);
            q_add += ")";
        } else {
            q_add += "(TRUE)";
        }
        q_add += " AND ";

        if (stat.size() == 1) {
            switch (stat.get(0)) {
                case "at_risk":
                    q_add += "(status = 'at_risk')";
                    break;
                case "homeless":
                    q_add += "(status = 'homeless')";
                    break;
            }
        } else if (stat.size() > 1) {
            q_add += "(";
            for (String temp2 : stat) {
                switch (temp2) {
                    case "at_risk":
                        q_add += "(status = 'at_risk')";
                        break;
                    case "homeless":
                        q_add += "(status = 'homeless')";
                        break;
                }
                q_add += " OR ";
            }
            q_add = q_add.substring(0, q_add.length() - 4);
            q_add += ")";
        } else {
            q_add += "(TRUE)";
        }
        q_add += " AND ";

        if (sex.size() == 1) {
            switch (sex.get(0)) {
                case "m":
                    q_add += "(sex = 'm')";
                    break;
                case "f":
                    q_add += "(sex = 'f')";
                    break;
            }
        } else if (sex.size() > 1) {
            q_add += "(";
            for (String temp3 : sex) {
                switch (temp3) {
                    case "m":
                        q_add += "(sex = 'm')";
                        break;
                    case "f":
                        q_add += "(sex = 'f')";
                        break;
                }
                q_add += " OR ";
            }
            q_add = q_add.substring(0, q_add.length() - 4);
            q_add += ")";
        } else {
            q_add += "(TRUE)";
        }
        q_add += " AND ";

        if (age.size() == 1) {
            switch (age.get(0)) {
                case "_0_9":
                    q_add += "(age_group = '_0_9')";
                    break;
                case "_10_19":
                    q_add += "(age_group = '_10_19')";
                    break;
                case "_20_29":
                    q_add += "(age_group = '_20_29')";
                    break;
                case "_30_39":
                    q_add += "(age_group = '_30_39')";
                    break;
                case "_40_49":
                    q_add += "(age_group = '_40_49')";
                    break;
                case "_50_59":
                    q_add += "(age_group = '_50_59')";
                    break;
                case "_60_plus":
                    q_add += "(age_group = '_60_plus')";
                    break;
            }
        } else if (age.size() > 1) {
            q_add += "(";
            for (String temp4 : age) {
                switch (temp4) {
                    case "_0_9":
                        q_add += "(age_group = '_0_9')";
                        break;
                    case "_10_19":
                        q_add += "(age_group = '_10_19')";
                        break;
                    case "_20_29":
                        q_add += "(age_group = '_20_29')";
                        break;
                    case "_30_39":
                        q_add += "(age_group = '_30_39')";
                        break;
                    case "_40_49":
                        q_add += "(age_group = '_40_49')";
                        break;
                    case "_50_59":
                        q_add += "(age_group = '_50_59')";
                        break;
                    case "_60_plus":
                        q_add += "(age_group = '_60_plus')";
                        break;
                }
                q_add += " OR ";
            }
            q_add = q_add.substring(0, q_add.length() - 4);
            q_add += ")";
        } else {
            q_add += "(TRUE)";
        }

        q_add += ")";
        try {
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT SUM(count) as cnt FROM HomLessGroup WHERE " + q_add;
            ResultSet results = statement.executeQuery(query);
            i = results.getInt("cnt");
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return i;
    }

    public ArrayList<ArrayList<String>> advSearch(ArrayList<String> LGA, ArrayList<String> stat, ArrayList<String> sex, ArrayList<String> age, ArrayList<String> SortType) {
        Connection connection = null;
        int i = 0;
        String q_add = "(";

        for(String s: LGA)
        {
            System.out.println(s);
            System.out.println("j");

        }
        if (LGA.size() == 1) {
            switch (LGA.get(0)) {
                case "NSW":
                    q_add += "(lga_code1 >= 10050 AND lga_code1 <= 19399)";
                    System.out.println("success");
                    break;
                case "VIC":
                    q_add += "(lga_code1 >= 20110 AND lga_code1 <= 29399)";
                    System.out.println("success");
                    break;
                case "QLD":
                    q_add += "(lga_code1 >= 30250 AND lga_code1 <= 37600)";
                    System.out.println("success");

                    break;
                case "SA":
                    q_add += "(lga_code1 >= 40070 AND lga_code1 <= 49399)";
                    System.out.println("success");

                    break;
                case "WA":
                    q_add += "(lga_code1 >= 50080 AND lga_code1 <= 59370)";
                    System.out.println("success");

                    break;
                case "TAS":
                    q_add += "(lga_code1 >= 60210 AND lga_code1 <= 65810)";
                    System.out.println("success");

                    break;
                case "NT":
                    q_add += "(lga_code1 >= 70200 AND lga_code1 <= 79399)";
                    System.out.println("success");

                    break;
                case "ACT":
                    q_add += "(lga_code1 = 89399)";
                    System.out.println("success");

                    break;
            }
        } else if (LGA.size() > 1) {
            q_add += "(";
            for (String temp1 : LGA) {
                switch (temp1) {
                    case "NSW":
                    q_add += "(lga_code1 >= 10050 AND lga_code1 <= 19399)";
                    break;
                case "VIC":
                    q_add += "(lga_code1 >= 20110 AND lga_code1 <= 29399)";
                    break;
                case "QLD":
                    q_add += "(lga_code1 >= 30250 AND lga_code1 <= 37600)";
                    break;
                case "SA":
                    q_add += "(lga_code1 >= 40070 AND lga_code1 <= 49399)";
                    break;
                case "WA":
                    q_add += "(lga_code1 >= 50080 AND lga_code1 <= 59370)";
                    break;
                case "TAS":
                    q_add += "(lga_code1 >= 60210 AND lga_code1 <= 65810)";
                    break;
                case "NT":
                    q_add += "(lga_code1 >= 70200 AND lga_code1 <= 79399)";
                    break;
                case "ACT":
                    q_add += "(lga_code1 = 89399)";
                    break;
                }
                q_add += " OR ";
            }
            q_add = q_add.substring(0, q_add.length() - 4);
            q_add += ")";
        } else {
            q_add += "(TRUE)";
        }
        q_add += " AND ";

        if (stat.size() == 1) {
            switch (stat.get(0)) {
                case "at_risk":
                    q_add += "(status = 'at_risk')";
                    break;
                case "homeless":
                    q_add += "(status = 'homeless')";
                    break;
            }
        } else if (stat.size() > 1) {
            q_add += "(";
            for (String temp2 : stat) {
                switch (temp2) {
                    case "at_risk":
                        q_add += "(status = 'at_risk')";
                        break;
                    case "homeless":
                        q_add += "(status = 'homeless')";
                        break;
                }
                q_add += " OR ";
            }
            q_add = q_add.substring(0, q_add.length() - 4);
            q_add += ")";
        } else {
            q_add += "(TRUE)";
        }
        q_add += " AND ";

        if (sex.size() == 1) {
            switch (sex.get(0)) {
                case "m":
                    q_add += "(sex = 'm')";
                    break;
                case "f":
                    q_add += "(sex = 'f')";
                    break;
            }
        } else if (sex.size() > 1) {
            q_add += "(";
            for (String temp3 : sex) {
                switch (temp3) {
                    case "m":
                        q_add += "(sex = 'm')";
                        break;
                    case "f":
                        q_add += "(sex = 'f')";
                        break;
                }
                q_add += " OR ";
            }
            q_add = q_add.substring(0, q_add.length() - 4);
            q_add += ")";
        } else {
            q_add += "(TRUE)";
        }
        q_add += " AND ";

        if (age.size() == 1) {
            switch (age.get(0)) {
                case "_0_9":
                    q_add += "(age_group = '_0_9')";
                    break;
                case "_10_19":
                    q_add += "(age_group = '_10_19')";
                    break;
                case "_20_29":
                    q_add += "(age_group = '_20_29')";
                    break;
                case "_30_39":
                    q_add += "(age_group = '_30_39')";
                    break;
                case "_40_49":
                    q_add += "(age_group = '_40_49')";
                    break;
                case "_50_59":
                    q_add += "(age_group = '_50_59')";
                    break;
                case "_60_plus":
                    q_add += "(age_group = '_60_plus')";
                    break;
            }
        } else if (age.size() > 1) {
            q_add += "(";
            for (String temp4 : age) {
                switch (temp4) {
                    case "_0_9":
                        q_add += "(age_group = '_0_9')";
                        break;
                    case "_10_19":
                        q_add += "(age_group = '_10_19')";
                        break;
                    case "_20_29":
                        q_add += "(age_group = '_20_29')";
                        break;
                    case "_30_39":
                        q_add += "(age_group = '_30_39')";
                        break;
                    case "_40_49":
                        q_add += "(age_group = '_40_49')";
                        break;
                    case "_50_59":
                        q_add += "(age_group = '_50_59')";
                        break;
                    case "_60_plus":
                        q_add += "(age_group = '_60_plus')";
                        break;
                }
                q_add += " OR ";
            }
            q_add = q_add.substring(0, q_add.length() - 4);
            q_add += ")";
        } else {
            q_add += "(TRUE)";
        }
        

        q_add += ")";

        if(SortType.size() == 1)
    {
    switch (SortType.get(0)) {
        case "lga_name":
            q_add += "ORDER BY lga_name DESC";
            break;
        case "lga_code1":
            q_add += "ORDER BY lga_code1 DESC";
            break;
        case "age_group":
            q_add += " ORDER BY age_group DESC";
            break;
        case "Count":
            q_add += "ORDER BY Count DESC";
            break;
            
        
    }

}          
        
        ArrayList<String> LGA_num_n = new ArrayList<>();
        ArrayList<String> LGA_nam_n = new ArrayList<>();
        ArrayList<String> stat_n = new ArrayList<>();
        ArrayList<String> sex_n = new ArrayList<>();
        ArrayList<String> age_n = new ArrayList<>();
        ArrayList<String> Count = new ArrayList<>();
        ArrayList<ArrayList<String>> MAJOR = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT lga_name, HomlessGroup.lga_code as lga_code1, status, sex, age_group, count FROM HomLessGroup INNER JOIN LGA on HomlessGroup.lga_code=LGA.lga_code WHERE " + q_add;
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                LGA_nam_n.add(results.getString("lga_name"));
                LGA_num_n.add(results.getString("lga_code1"));
                stat_n.add(results.getString("status"));
                sex_n.add(results.getString("sex"));
                age_n.add(results.getString("age_group"));
                Count.add(results.getString("count"));
            }

            MAJOR.add(LGA_nam_n);
            MAJOR.add(LGA_num_n);
            MAJOR.add(stat_n);
            MAJOR.add(sex_n);
            MAJOR.add(age_n);
            MAJOR.add(Count);
            
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return MAJOR;
    }

    public ArrayList<String> getWorst() {

        ArrayList<String> result = new ArrayList<String>();

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String query = "SELECT MAX(count) as cnt, lga_name as name FROM HomlessGroup JOIN LGA ON (HomlessGroup.lga_code = LGA.lga_code)";
            ResultSet results = statement.executeQuery(query);
            int Max = results.getInt("cnt");
            String name = results.getString("name");

            String MaxNumber = Integer.toString(Max);

            result.add(name);
            result.add(MaxNumber);

            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
        
    }

    //unimplemented comm (unfixed 'change' result)
    /*public int getYearChange() {

        int result = 0;

        Connection connection1 = null;
        Connection connection2 = null;

        try {
            connection1 = DriverManager.getConnection(DATABASE);
            Statement statement1 = connection1.createStatement();
            statement1.setQueryTimeout(30);
            String query1 = "SELECT SUM(count) as cnt FROM HomlessGroup WHERE lga_code=31000";
            ResultSet results1 = statement1.executeQuery(query1);
            int cnt8 = results1.getInt("cnt");
            results1.close();

            connection2 = DriverManager.getConnection(CTG);
            Statement statement2 = connection2.createStatement();
            statement2.setQueryTimeout(30);
            String query2 = "SELECT SUM(count) as cnt FROM PopulationStatistics WHERE lga_code16=31000 AND indigenous_status='indig'";
            ResultSet results2 = statement2.executeQuery(query2);
            int cnt6 = results2.getInt("cnt");
            results2.close();

            result = (int)(Math.round((double)(cnt6 - cnt8) / cnt8 * 100));

            System.out.println(cnt8);
            System.out.println(cnt6);
            System.out.println(result);


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return result;
        
    }*/

}
