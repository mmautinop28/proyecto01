package pe.com.avicola.java.ms.gestion.pedidos.consumer;

import pe.com.avicola.java.ms.gestion.pedidos.document.Orden;

public interface OrdenConsumer {

	public void consumeMessage(Orden orden);

}
