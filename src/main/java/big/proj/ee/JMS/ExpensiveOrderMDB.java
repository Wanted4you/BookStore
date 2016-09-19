package big.proj.ee.JMS;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by Влад on 18.09.2016.
 */
@MessageDriven(mappedName = "jms/javaee7/Topic", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode",
                                propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "messageSelector",
                                propertyValue = "orderAmount > 1000")
})
public class ExpensiveOrderMDB implements MessageListener{

    @Override
    public void onMessage(Message message) {

        try{
            OrderDTO order = message.getBody(OrderDTO.class);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
