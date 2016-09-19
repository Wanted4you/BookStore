package big.proj.ee.JMS;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Влад on 18.09.2016.
 */
public class OrderConsumer {

    public static void main(String[] args) throws NamingException {

        InitialContext jndiContext = new InitialContext();

        ConnectionFactory connection = (ConnectionFactory)jndiContext.lookup("jms/javaee7/ConnectionFactory");

        Destination topic = (Destination)jndiContext.lookup("jms/javaee7/Topic");

        try(JMSContext context = connection.createContext()){

            while(true){
                OrderDTO order = context.createConsumer(topic).receiveBody(OrderDTO.class);
            }
        }
    }
}
