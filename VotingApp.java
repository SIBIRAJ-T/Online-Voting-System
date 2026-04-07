import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.*;

public class VotingApp {

    public static void main(String[] args) {

        port(8080);

        post("/vote", (req, res) -> {
            Gson gson = new Gson();
            Map<String, String> data = gson.fromJson(req.body(), Map.class);

            String username = data.get("username");
            String candidate = data.get("candidate");

            return VoteDAO.castVote(username, candidate);
        });

        get("/results", (req, res) -> {
            return "Results API working";
        });
    }
}