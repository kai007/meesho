package meesho;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.logging.Logger;


public class MessageQueueProcessor {
    public static final int INITIAL_ATTEMPT = 1;

    private static final Logger logger = Logger.getLogger(MessageQueueProcessor.class.getName());

    private final RabbitMQ rabbitMQ = new RabbitMQ(this);

    private MessageQueueProcessor(){}

    private static MessageQueueProcessor messageQueueProcessor = new MessageQueueProcessor();

    public static MessageQueueProcessor getInstance() {
        return messageQueueProcessor == null ? new MessageQueueProcessor() : messageQueueProcessor;
    }

    public void receiveMessage(String queueName) throws IOException {
        rabbitMQ.recieveDirectedMessage(queueName);
    }
    public void pushMessage(JSONObject message) throws IOException {
        rabbitMQ.sendDirectedMessage(message.toString(),message.getString("queue"));
    }
}