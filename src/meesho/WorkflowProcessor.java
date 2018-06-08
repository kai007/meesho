package meesho;

/**
 * Created by Kartikeya on 6/8/18.
 */
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WorkflowProcessor {

    private static Map<String, BaseWorkflowTask> messageProcessorMap = new HashMap<>();

            static{
                messageProcessorMap.put(Queue.SendSMS.getMessage(), new SendSMSTask());
                messageProcessorMap.put(Queue.SendEmail.getMessage(), new SendEmailTask());
                messageProcessorMap.put(Queue.GenerateInvoice.getMessage(), new GenerateInvoiceTask());
            }

    public void processTask(String message, MessageQueueProcessor messageQueueProcessor) {
        JSONObject messageJson = JSONObject.fromObject(message);
        try {
            messageProcessorMap.get(messageJson.getString("message")).execute(messageJson, messageQueueProcessor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
