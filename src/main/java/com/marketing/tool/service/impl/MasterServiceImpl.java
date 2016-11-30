package com.marketing.tool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marketing.tool.domain.MasterEntity;
import com.marketing.tool.domain.MasterEntity.MasterDataType;
import com.marketing.tool.repository.MasterEntityRepository;
import com.marketing.tool.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService {
	
	@Autowired
	MasterEntityRepository repo;
	
	@Override
	@Transactional
	public void save(MasterEntity entity) {
		/*if(entity.getId()!=null) {
			entity = findById(entity.getId());
		}*/
		repo.save(entity);
	}

	@Override
	public List<MasterEntity> findAll() {
		return repo.findAll();
	}
	
	

	@Override
	public MasterEntity update(MasterEntity entity) {
		return repo.save(entity);
	}

	@Override
	public void delete(Integer id) {
		//MasterEntity entity = findById(id);
		repo.delete(id);
	}

	/*@Override
	public void delete(Serializable id, Class<MasterEntity> entityClass) {
		repo.delete(id, entityClass);
	}*/

	/*@Override
	public  List<MasterEntity> findAll(Class<MasterEntity> entityClass) {
		return repo.findAll(entityClass);
	}

	@Override
	public  List<MasterEntity> findAll(String query) {
		return repo.findAll(query);
	}*/

	@Override
	public MasterEntity findById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<MasterEntity> findByMasterDataType(MasterDataType masterDataType) {
		List<MasterEntity> list = repo.findByMasterDataType(masterDataType);
		return list;
	}

}
