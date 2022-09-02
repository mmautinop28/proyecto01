package pe.com.avicola.java.ms.avi.gestion.pedidos.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.com.avicola.java.ms.avi.gestion.pedidos.document.Orden;

@Slf4j
@Service
public class OrderProducerImpl implements OrdenProducer {

	@Value("${custom.kafka.topic-name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, Orden> ordenKafkaTemplate;

	@Override
	public void sendMessage(Orden orden) {
		log.info("send", orden);
		log.info("topicName", topicName);
		ordenKafkaTemplate.send(topicName, orden);
	}

}
