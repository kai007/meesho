package meesho;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by Kartikeya on 6/8/18.
 */
public class SendSMSTask extends BaseWorkflowTask {

    @Autowired
    MessageServiceDAO messageServiceDAO;

    @Override
    protected boolean processTask(JSONObject message) throws IOException {

        //call SMS sending API

        MessageServiceBean object = messageServiceDAO.getObject(MessageServiceBean.class,message.getLong("id"));
        object.setSmsSent(true);
        messageServiceDAO.updateObject(object);
        return true;
    }
}