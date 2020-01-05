package si.kuharsmkimojster.subscriptions.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Subscription {
    private Long userId;
    private Long subscriberId;

    public Subscription(Long userId, Long subscriberId) {
        this.userId = userId;
        this.subscriberId = subscriberId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
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
