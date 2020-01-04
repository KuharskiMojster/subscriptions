package si.kuharsmkimojster.subscriptions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import si.kuharsmkimojster.subscriptions.model.ResponseModel;
import si.kuharsmkimojster.subscriptions.model.Subscription;

@RestController
@RequestMapping("/v1")
public class SubscriptionController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${kafka.topic}")
    private String kafkaTopic;

    @GetMapping("/health")
    public ResponseEntity<ResponseModel> getHealth() {
        return new ResponseEntity<>(new ResponseModel("Subscription app is running...", HttpStatus.OK.value()), HttpStatus.OK);
    }

    @PostMapping("/subscription")
    public ResponseEntity<ResponseModel> postSubscription(@RequestParam(name = "userId") String userId, @RequestParam(name = "subscriberId") String subscriberId) {
        Subscription subscription = new Subscription(userId, subscriberId);
        String jsonSubscription = Subscription.toJson(subscription);
        sendMessage(jsonSubscription);
        return new ResponseEntity<>(new ResponseModel("Subscriber with id: " + subscriberId + " subscribed to user with id: " + userId+".", HttpStatus.OK.value()), HttpStatus.OK);
    }

    private void sendMessage(String msg) {
        kafkaTemplate.send(kafkaTopic, msg);
    }
}
