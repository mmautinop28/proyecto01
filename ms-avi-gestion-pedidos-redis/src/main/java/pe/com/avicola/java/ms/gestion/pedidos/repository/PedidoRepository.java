package pe.com.avicola.java.ms.gestion.pedidos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import pe.com.avicola.java.ms.gestion.pedidos.model.Pedido;

@Slf4j
@Repository

@SuppressWarnings("rawtypes")
public class PedidoRepository {

	public static final String PEDIDO_KEY = "PEDIDO";

	private HashOperations hashOperations;// PreparedStatemnt

	private RedisTemplate redisTemplate;  // Connection

	public PedidoRepository(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;

		this.hashOperations = this.redisTemplate.opsForHash(); //K,V
	}

	@SuppressWarnings("unchecked")
	public void save(Pedido pedido) {
		log.info("save...");
		hashOperations.put(PEDIDO_KEY, pedido.getId(), pedido);
	}

	@SuppressWarnings("unchecked")
	public List<Pedido> findAll() {
		log.info("findAll...");
		return hashOperations.values(PEDIDO_KEY);
	}

	@SuppressWarnings("unchecked")
	public Pedido findById(Long id) {
		log.info("findById...");
		return (Pedido) hashOperations.get(PEDIDO_KEY, id);
	}

	
	public void update(Pedido pedido) {
		log.info("update...");
		save(pedido);
	}

	@SuppressWarnings("unchecked")
	public void delete(Long id) {
		log.info("delete...");
		hashOperations.delete(PEDIDO_KEY, id);
	}

}
