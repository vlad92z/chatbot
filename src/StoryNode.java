import java.util.HashMap;

public class StoryNode {
    StoryNode nextNode;
    boolean isFinished = false;
    private HashMap<UserQuery, ChatbotResponse> responses;
    UserQuery finalQuery;
//    private String defaultResponse;

    public StoryNode(StoryNode nextNode, HashMap<UserQuery, ChatbotResponse> responses, UserQuery finalQuery, String defaultResponse) {
        this.nextNode = nextNode;
        this.responses = responses;
        this.finalQuery = finalQuery;
//        this.defaultResponse = defaultResponse;
    }

    public String ask(String question) {
        UserQuery userAsked = new UserQuery(question);
        if (finalQuery.equals(userAsked)) {
            isFinished = true;
            return nextNode.ask("WHAT NOW?");
        }
        ChatbotResponse answer = responses.get(userAsked);
        return answer != null ? answer.toString() : null;
    }
}