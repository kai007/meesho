package meesho;

/**
 * Created by Kartikeya on 6/8/18.
 */

import net.sf.json.JSONObject;

import java.io.IOException;



public abstract class BaseWorkflowTask {
    protected MessageQueueProcessor messageQueueProcessor;

    public void execute(JSONObject messageJson, MessageQueueProcessor messageQueueProcessor) throws IOException {
        this.messageQueueProcessor = messageQueueProcessor;
        try {
            if (processTask(messageJson)) {
                onSuccess(messageJson);
                pushMessageToNextQueue(messageJson);
            } else {
                retry(messageJson);
            }

        } catch (Exception e) {
            pushMessageToNextQueue(messageJson);
            retry(messageJson);
        }
        finally {
            updateTaskStatus(messageJson);
        }
    }

    protected void updateTaskStatus(JSONObject message) {

    }

    private void pushToFailedQueue(JSONObject messageJson) throws IOException {

    }

    private boolean retryExceeded(JSONObject messageJson) {
        if(!messageJson.containsKey("max_attempts"))
            return false;
        return messageJson.getInt("attempts") >= messageJson.getInt("max_attempts");
    }

    protected void onSuccess(JSONObject messageJson) throws IOException{}

    private void retry(JSONObject messageJson) throws IOException {
        if (retryExceeded(messageJson)){
            onProcessUnsuccessful(messageJson);
            pushToFailedQueue(messageJson);
        }
        messageQueueProcessor.pushMessage(messageJson);
    }

    protected void pushMessageToNextQueue(JSONObject messageJson) throws IOException {

    }

    protected void onProcessUnsuccessful(JSONObject messageJson) {
    }

    protected boolean processTask(JSONObject messageJson) throws IOException {
        return processTask(messageJson);
    }
}
