package rmq;
import com.rabbitmq.client.*;
import java.io.IOException;

public class MessageReceiver {

  private final static String QUEUE_NAME = "in-queue";
  private final static String RMQ_SERVER_HOST = "localhost";

  public void start() {
    try {
        System.out.println("Message Receiver started....");
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(RMQ_SERVER_HOST);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
          @Override
          public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
              throws IOException {
            String message = new String(body, "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            
          }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
    catch (Exception e) {
        System.out.println("Exception occurred while recieving message from in-queue: " + e.toString());
    }
  }
}