import rmq.*;
import soundProcessors.*;
import fileProcessors.*;
import langProcessors.*;

public class Worker {
	public static void main(String [] args) {
		System.out.println("Worker started...");
		MessageReceiver messageReceiver = new MessageReceiver();
		messageReceiver.start();
	}
}