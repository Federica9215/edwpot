package s09;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s21/Stati")
public class CountriesList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select c.country_id, c.country_name from regions r join countries c on(r.region_id=c.region_id) where r.region_id=1");

            List<Countries> countries = new ArrayList<>();
            while (rs.next()) {
                countries.add(new Countries(rs.getString("COUNTRY_ID"), rs.getString("COUNTRY_NAME")));
            }

            request.setAttribute("countries", countries);
        } catch (SQLException se) {
            se.printStackTrace();
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
        
        request.getRequestDispatcher("/s21/Stati.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}