import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static StoryNode start;
    private static StoryNode second;
    private static StoryNode third;
    private static StoryNode last;

    private static void initStory()
    {
        UserQuery finalQuery1 = new UserQuery("Open door");
        UserQuery finalQuery2 = new UserQuery("Walk hallway");
        UserQuery finalQuery3 = new UserQuery("Enter kitchen");
        UserQuery finalQuery4 = new UserQuery("Drink tea");

        String defaultResponse = "wat";
        HashMap<UserQuery, ChatbotResponse> responses1 = new HashMap<>();
        responses1.put(new UserQuery("What now?"), new ChatbotResponse("You are in a room. There is a door."));
        responses1.put(finalQuery1, new ChatbotResponse("There is a hallway"));
        HashMap<UserQuery, ChatbotResponse> responses2 = new HashMap<>();
        responses2.put(new UserQuery("What now?"), new ChatbotResponse("There is a hallway"));
        responses2.put(finalQuery2, new ChatbotResponse("You are in front of the kitchen."));
        HashMap<UserQuery, ChatbotResponse> responses3 = new HashMap<>();
        responses3.put(new UserQuery("What now?"), new ChatbotResponse("You are in front of the kitchen."));
        responses3.put(finalQuery3, new ChatbotResponse("You are in the kitchen. There is tea."));
        HashMap<UserQuery, ChatbotResponse> responses4 = new HashMap<>();
        responses4.put(new UserQuery("What now?"), new ChatbotResponse("You are in the kitchen. There is tea."));
        responses4.put(finalQuery4, new ChatbotResponse("You are drinking tea."));

        last = new StoryNode(null, responses4, finalQuery4, defaultResponse);
        third = new StoryNode(last, responses3, finalQuery3, defaultResponse);
        second = new StoryNode(third, responses2, finalQuery2, defaultResponse);
        start = new StoryNode(second, responses1, finalQuery1, defaultResponse);
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Let's drink some tea together! If you are not sure what to do, just say WHAT NOW?");
        initStory();
        StoryNode storyNode = start;
        Scanner scanner = new Scanner(System.in);
        ChatbotGeneric generic = new ChatbotGeneric();

        while (true) {
            String question = scanner.nextLine();
            String answer = storyNode.ask(question);
            String response = answer != null ? answer : generic.ask(question);
            System.out.println(response);
            if (storyNode.isFinished) {
                storyNode = storyNode.nextNode;
                if (storyNode == null){
                    break;
                }
            }
        }
        System.out.println("You did it");
    }
}
