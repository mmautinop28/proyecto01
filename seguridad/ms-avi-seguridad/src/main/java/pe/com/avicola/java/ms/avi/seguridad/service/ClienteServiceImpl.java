package pe.com.avicola.java.ms.avi.seguridad.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.avicola.java.ms.avi.seguridad.entity.ClienteEntity;
import pe.com.avicola.java.ms.avi.seguridad.repository.ClienteRepository;
import pe.com.avicola.java.ms.avi.seguridad.service.exception.ServiceException;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteServiceImpl() {
	}

	@Override
	public Object findById(ClienteEntity c) throws ServiceException {
		System.out.println("c -->" + c);
		System.out.println("c.getId() -->" + c.getId());
		Optional<ClienteEntity> opt=clienteRepository.findById(c.getId());
		System.out.println("opt -->" + opt);
		System.out.println("opt.isPresent() -->" + opt.isPresent());
		if (opt!=null && opt.isPresent()) {		
			return opt.get();
		}
		return null;
	}

	@Override
	public Object save(ClienteEntity clienteEntity) throws ServiceException {
		return clienteRepository.save(clienteEntity);
	}

	@Override
	public Object delete(ClienteEntity clienteEntity) throws ServiceException {
		Object ret= this.findById(clienteEntity);
		if (ret!=null) {
			ClienteEntity oClienteEntity= (ClienteEntity) ret;
			oClienteEntity.setEstado(0);
			return clienteRepository.save(oClienteEntity);
		}
		return null;
	}

	@Override
	public List<ClienteEntity> findLikeNombre(String nombre) throws ServiceException {
		List<ClienteEntity> lstClienteEntity = clienteRepository.findLikeNombre("%"+nombre+"%");
		return lstClienteEntity;
	}

	@Override
	public Object findAll(ClienteEntity c) throws ServiceException {
		List<ClienteEntity> lstClienteEntity = clienteRepository.findAllActivos();
		return lstClienteEntity;
	}



}
