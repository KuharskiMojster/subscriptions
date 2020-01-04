package si.kuharsmkimojster.subscriptions.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Subscription {
    private String userId;
    private String subsriberId;

    public Subscription(String userId, String subsriberId) {
        this.userId = userId;
        this.subsriberId = subsriberId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubsriberId() {
        return subsriberId;
    }

    public void setSubsriberId(String subsriberId) {
        this.subsriberId = subsriberId;
    }

    public static String toJson(Subscription subscription){
        // Creating Object of ObjectMapper define in Jakson Api
        ObjectMapper Obj = new ObjectMapper();

        String jsonStr = null;
        try {
            jsonStr = Obj.writeValueAsString(subscription);
            // Displaying JSON String
            System.out.println(jsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr ;
    }
}
