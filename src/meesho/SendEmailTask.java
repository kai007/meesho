package meesho;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by Kartikeya on 6/8/18.
 */
public class SendEmailTask extends BaseWorkflowTask {

    @Autowired
    MessageServiceDAO messageServiceDAO;

    @Override
    protected boolean processTask(JSONObject message) throws IOException {

        MessageServiceBean object = messageServiceDAO.getObject(MessageServiceBean.class,message.getLong("id"));
        if(!object.isInvoiceGenerated() &&!object.isEmailSent()){
            //send email with footer that invoice is about to get generated
            object.setEmailSent(true);
            messageServiceDAO.updateObject(object);
            messageQueueProcessor.pushMessage(message); //retry the email sending task for after invoice generation
        }
        else if(object.isInvoiceGenerated() &&!object.isEmailSent()){
            //send email with invoice
            object.setEmailSent(true);
            messageServiceDAO.updateObject(object);
        }
        return true;
    }
}