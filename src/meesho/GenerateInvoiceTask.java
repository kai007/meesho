package meesho;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by Kartikeya on 6/8/18.
 */
public class GenerateInvoiceTask extends BaseWorkflowTask {

    @Autowired
    MessageServiceDAO messageServiceDAO;

    @Override
    protected boolean processTask(JSONObject message) throws IOException {

        //call invoice generation API

        MessageServiceBean object = messageServiceDAO.getObject(MessageServiceBean.class,message.getLong("id"));
        object.setInvoiceGenerated(true);
        messageServiceDAO.updateObject(object);
        return true;
    }
}