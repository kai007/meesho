package meesho;

/**
 * Created by Kartikeya on 6/8/18.
 */

import java.util.ArrayList;
import java.util.List;

public enum Queue {
    SendSMS("send.sms"),
    SendEmail("send.email"),
    GenerateInvoice("generate.invoice"),
    Default("default");

    private boolean enabled;
    private String name;

    Queue(String name) {
        this.name = name;
        this.enabled = true;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return name + ".message";
    }

    public static Queue get(String message) {
        String name = message.replace(".message", "");
        for (Queue queue : values()) {
            if (queue.name.equals(name))
                return queue;
        }
        return Queue.Default;
    }

    public static List<Queue> enabledQueues() {
        List<Queue> enabledQueues = new ArrayList<>();
        for (Queue queue : Queue.values()) {
            if (queue.enabled) {
                enabledQueues.add(queue);
            }
        }
        return enabledQueues;
    }
}
