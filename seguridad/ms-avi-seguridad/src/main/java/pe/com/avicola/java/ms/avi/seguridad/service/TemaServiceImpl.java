package pe.com.avicola.java.ms.avi.seguridad.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.avicola.java.ms.avi.seguridad.entity.TemaEntity;
import pe.com.avicola.java.ms.avi.seguridad.repository.TemaRepository;
import pe.com.avicola.java.ms.avi.seguridad.service.exception.ServiceException;

@Service
public class TemaServiceImpl implements TemaService {

	@Autowired
	private TemaRepository temaRepository;

	public TemaServiceImpl() {
	}

	@Override
	public Object findById(TemaEntity t) throws ServiceException {
		Optional<TemaEntity> opt=temaRepository.findById(t.getId());
		if (opt!=null && opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public Object save(TemaEntity temaEntity) throws ServiceException {
		return temaRepository.save(temaEntity);
	}

	@Override
	public Object delete(TemaEntity temaEntity) throws ServiceException {
		Object ret= this.findById(temaEntity);
		if (ret!=null) {
			TemaEntity oTemaEntity= (TemaEntity) ret;
			oTemaEntity.setEstado("0");
			return temaRepository.save(oTemaEntity);
		}
		return null;
	}

	@Override
	public List<TemaEntity> findLikeNombre(String nombre) throws ServiceException {
		List<TemaEntity> lstTemaEntity = temaRepository.findLikeNombre("%"+nombre+"%");
		return lstTemaEntity;
	}

	@Override
	public Object findAll(TemaEntity t) throws ServiceException {
		List<TemaEntity> lstTemaEntity = temaRepository.findAllActivos();
		return lstTemaEntity;
	}



}
