package rmq;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class MessageSender {

    private final static String QUEUE_NAME = "out-queue";
    private final static String RMQ_SERVER_HOST = "localhost";

    public void sendMessage(String message) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(RMQ_SERVER_HOST);
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        catch (Exception ex) {
            System.out.println("ex" + ex.toString());
        }
    }
}