package pe.com.avicola.java.ms.avi.seguridad.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.avicola.java.ms.avi.seguridad.entity.TallerEntity;
import pe.com.avicola.java.ms.avi.seguridad.repository.TallerRepository;
import pe.com.avicola.java.ms.avi.seguridad.repository.TemaRepository;
import pe.com.avicola.java.ms.avi.seguridad.service.exception.ServiceException;

@Service
public class TallerServiceImpl implements TallerService {

	@Autowired
	private TallerRepository tallerRepository;
	
	@Autowired
	private TemaRepository temaRepository;

	public TallerServiceImpl() {
	}

	@Override
	public Object findById(TallerEntity tallerEntity) throws ServiceException {
		Optional<TallerEntity> opt=tallerRepository.findById(tallerEntity.getId());
		if (opt!=null && opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public Object save(TallerEntity tallerEntity) throws ServiceException {
		TallerEntity oTalleEntity= tallerRepository.saveAndFlush(tallerEntity);
		if (oTalleEntity.getId()!=null) {
			oTalleEntity.getTemas().forEach(temaEntity ->
			{
				temaEntity.setTallerEntity(tallerEntity);
				temaRepository.save(temaEntity);
			});
		}
		return oTalleEntity;
	}

	@Override
	public Object delete(TallerEntity tallerEntity) throws ServiceException {
		Object ret= this.findById(tallerEntity);
		if (ret!=null) {
			tallerEntity.setEstado("0");
			return tallerRepository.save(tallerEntity);
		}
		return null;
	}

	@Override
	public List<TallerEntity> findLikeNombre(String nombre) throws ServiceException {
		List<TallerEntity> lstTallerEntity = tallerRepository.findLikeNombre("%"+nombre+"%");
		return lstTallerEntity;
	}

	@Override
	public Object findAll(TallerEntity t) throws ServiceException {
		List<TallerEntity> lstTallerEntity = tallerRepository.findAllActivos();
		return lstTallerEntity;
	}

	@Override
	public TallerEntity findByNombre(String nombre) throws ServiceException {
		TallerEntity tallerEntity = tallerRepository.findByNombre(nombre);
		return tallerEntity;
	}
	
}
