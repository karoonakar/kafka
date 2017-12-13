import org.apache.kafka.clients.producer.*;

import java.text.*;
import java.util.*;

public class BatchProducerApp {

    public static void main(String[] args){

        // Create the Properties class to instantiate the Consumer with the desired settings:
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "all");
        props.put("buffer.memory", 33554432);
        props.put("compression.type", "none");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("client.id", "");
        props.put("linger.ms", 0);
        props.put("max.block.ms", 60000);
        props.put("max.request.size", 1048576);
        props.put("partitioner.class", "org.apache.kafka.clients.producer.internals.DefaultPartitioner");
        props.put("request.timeout.ms", 30000);
        props.put("timeout.ms", 30000);
        props.put("max.in.flight.requests.per.connection", 5);
        props.put("retry.backoff.ms", 5);

        KafkaProducer<String, String> myProducer = new KafkaProducer<String, String>(props);
        DateFormat dtFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        String topic = "my-topic";

        try {
            int batchNumber = 1;
            int counter = 0;
            int recCounter = 0;
            do {
                do {                	
                	ProducerRecord<String, String> myRecord = new ProducerRecord<String, String>(topic,Integer.toString(counter), String.format("Batch: %s || RecNo: %s|| %s", Integer.toString(batchNumber), Integer.toString(recCounter),dtFormat.format(new Date())));
                    myProducer.send(myRecord);
                    counter++; 
                    recCounter++;
                } while (counter < 10); // Number of records sent in a batch...
                counter = 0; 
                Thread.sleep(500); // Set how long before a new batch is sent...
                batchNumber++; // Increase the batch number...
            }while (true);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myProducer.close();
        }

    }
}
