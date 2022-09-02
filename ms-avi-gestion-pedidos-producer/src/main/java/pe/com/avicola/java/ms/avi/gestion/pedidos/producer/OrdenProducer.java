package pe.com.avicola.java.ms.avi.gestion.pedidos.producer;

import pe.com.avicola.java.ms.avi.gestion.pedidos.document.Orden;

public interface OrdenProducer {

	public void sendMessage(Orden orden);

}
