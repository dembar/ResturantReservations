package dashboard;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/fetchBookings")
public class FetchBookingsServlet extends HttpServlet {

    // Inner class to represent a Booking object
    public class Booking {
        int id;
        String userName;
        String tableNumber;
        String bookingDate;
        int numberOfPeople;
        String status;

        public Booking(int id, String userName, String tableNumber, String bookingDate, int numberOfPeople, String status) {
            this.id = id;
            this.userName = userName;
            this.tableNumber = tableNumber;
            this.bookingDate = bookingDate;
            this.numberOfPeople = numberOfPeople;
            this.status = status;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Booking> bookings = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Get a connection to the database
            conn = DatabaseConnection.getConnection();

            // SQL query to retrieve bookings and join user and table details
            String sql = "SELECT b.id, u.name AS userName, t.table_number AS tableNumber, b.booking_date, " +
                         "b.number_of_people, b.status FROM bookings b " +
                         "JOIN users u ON b.user_id = u.id " +
                         "JOIN tables t ON b.table_id = t.id";

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Process the result set and add bookings to the list
            while (rs.next()) {
                int id = rs.getInt("id");
                String userName = rs.getString("userName");
                String tableNumber = rs.getString("tableNumber");
                String bookingDate = rs.getTimestamp("booking_date").toString();
                int numberOfPeople = rs.getInt("number_of_people");
                String status = rs.getString("status");

                bookings.add(new Booking(id, userName, tableNumber, bookingDate, numberOfPeople, status));
            }

            // Convert the list of bookings to JSON
            Gson gson = new Gson();
            String json = gson.toJson(bookings);

            // Send the JSON response
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(json);
            out.flush();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
