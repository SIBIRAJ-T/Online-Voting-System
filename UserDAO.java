import java.sql.*;

public class UserDAO {

    public static boolean hasVoted(String username) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM votes WHERE username=?"
        );
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        return rs.next();
    }
}