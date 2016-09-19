package big.proj.ee.JMS;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;

/**
 * Created by Влад on 18.09.2016.
 */
public class OrderProducer {

    public static void main(String[] args) throws NamingException {

        Float totalAmount = Float.valueOf(args[0]);
        OrderDTO order = new OrderDTO(1234L, new Date(), "Бетти Морри", totalAmount);

        InitialContext jndiContext = new InitialContext();

        ConnectionFactory connection = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");

        Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Topic");

        try(JMSContext context = connection.createContext()){
            context.createProducer().setProperty("orderAmount", totalAmount).send(topic, order);
        }
    }
}
