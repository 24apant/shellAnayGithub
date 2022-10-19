package main.java.com.example;
import main.java.com.example.Example.PubSubMessage;
import com.google.cloud.functions.BackgroundFunction;
import com.google.cloud.functions.Context;
import java.util.Base64;
import java.util.Map;
import java.util.logging.Logger;

public class Example implements BackgroundFunction<PubSubMessage> {
    private static final Logger logger = Logger.getLogger(Example.class.getName());

    @Override
    public void accept(PubSubMessage message, Context context) {
        String data = message.data != null
                ? new String(Base64.getDecoder().decode(message.data))
                : "From Anay GCLOUD Shell";
        logger.info(data);
    }

    public static class PubSubMessage {
        String data;
        Map<String, String> attributes;
        String messageId;
        String publishTime;
    }
}

