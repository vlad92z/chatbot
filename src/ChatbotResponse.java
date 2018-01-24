/**
 * Created by qqsil on 29-Dec-17.
 */
public class ChatbotResponse {
    String answer;

    ChatbotResponse (String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return answer;
    }
}
