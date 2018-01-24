/**
 * Created by qqsil on 29-Dec-17.
 */
public class QueryResponsePair {

    UserQuery userQuery;
    ChatbotResponse chatbotResponse;

    QueryResponsePair(UserQuery query, ChatbotResponse response) {
        this.userQuery = query;
        this.chatbotResponse = response;
    }

    QueryResponsePair(String query, String response) {
        this.userQuery = new UserQuery(query);
        this.chatbotResponse = new ChatbotResponse(response);
    }
}
