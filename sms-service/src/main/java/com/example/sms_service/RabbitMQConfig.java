import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue pushQueue() {
        return new Queue("smsQueue", true);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("notifications.topic.exchange");
    }

    @Bean
    public Binding pushBinding(Queue pushQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(pushQueue).to(topicExchange).with("notification.push");
    }
}