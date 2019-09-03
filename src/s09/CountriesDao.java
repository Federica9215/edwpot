package s09;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CountriesDao {
    private Connection conn;

    public CountriesDao(DataSource ds) {
        try {
            this.conn = ds.getConnection();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
    }

    public List<Countries> getAll() {
        List<Countries> results = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select c.country_id, c.country_name from regions r join countries c on(r.region_id=c.region_id) where r.region_id=1");

            while (rs.next()) {
                results.add(new Countries(rs.getString("COUNTRY_ID"), rs.getString("COUNTRY_NAME")));
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }

        return results;
    }
}