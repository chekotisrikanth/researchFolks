package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.MasterDataType;
import com.marketing.tool.domain.MasterEntity;

public interface MasterService {

	public void save(MasterEntity entity);    
    
    public List<MasterEntity> findAll();
    
    public List<MasterEntity> findByMasterDataType(MasterDataType masterDataType);
    
    public MasterEntity update(final MasterEntity entity);
    
    public  void delete(final Integer id);

    //public  void delete(Serializable id, Class<MasterEntity> entityClass);
    
    /*@SuppressWarnings("unchecked")  
    public  List<MasterEntity> findAll(Class<MasterEntity> entityClass);
  
    @SuppressWarnings("rawtypes")
    public List<MasterEntity> findAll(String query);*/
    
    @SuppressWarnings("unchecked")
    public MasterEntity findById(Integer id) ;
}
