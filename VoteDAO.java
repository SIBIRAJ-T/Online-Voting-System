import java.sql.*;

public class VoteDAO {

    public static String castVote(String username, String candidate) throws Exception {

        if (UserDAO.hasVoted(username)) {
            return "You have already voted!";
        }

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO votes(username, candidate) VALUES (?, ?)"
        );

        ps.setString(1, username);
        ps.setString(2, candidate);
        ps.executeUpdate();

        return "Vote Successful!";
    }
}