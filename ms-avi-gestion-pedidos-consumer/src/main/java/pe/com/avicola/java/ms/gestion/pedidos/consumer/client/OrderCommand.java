package pe.com.avicola.java.ms.gestion.pedidos.consumer.client;

import pe.com.avicola.java.ms.gestion.pedidos.document.Orden;

public interface OrderCommand {

	void enviar(Orden orden);

}
