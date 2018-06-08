package meesho;

import java.io.IOException;

/**
 * Created by Kartikeya on 6/8/18.
 */
public class RabbitMQ {

    public RabbitMQ(final MessageQueueProcessor messageQueueProcessor){
        try {
            String message = ""; // message picked up from the queue
            new WorkflowProcessor().processTask(message, messageQueueProcessor);
        }
        catch (Exception e) {

        }
    }

    public void recieveDirectedMessage(String queueName) throws IOException {

    }
    public void sendDirectedMessage(String message, String queueName) throws IOException {

    }
}
