package by.shcherbakov.usermicroservice.config.consumer.errorhandler;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.errors.RecordDeserializationException;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaErrorHandler implements CommonErrorHandler {
    @Override
    public void handleOtherException(Exception thrownException, Consumer<?, ?> consumer, MessageListenerContainer container, boolean batchListener) {
        handle(thrownException,consumer);
    }

    @Override
    public boolean handleOne(Exception thrownException, ConsumerRecord<?, ?> record, Consumer<?, ?> consumer, MessageListenerContainer container) {
        return handle(thrownException,consumer);
    }

    private boolean handle(Exception exception,Consumer<?,?> consumer) {
        log.error("Exception is thrown",exception);
        if (exception instanceof RecordDeserializationException ex) {
            consumer.seek(ex.topicPartition(),ex.offset() + 1L);
            consumer.commitSync();
        } else {
            log.error("Exception is not handled",exception);
        }
        return true;
    }
}
