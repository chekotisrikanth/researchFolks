package com.marketing.tool.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.marketing.tool.domain.MasterEntity;
import com.marketing.tool.domain.MasterEntity.MasterDataType;

public interface MasterEntityRepository extends CrudRepository<MasterEntity,Integer> {

	  //public  MasterEntity save(MasterEntity entity);  
      
	  
      public List<MasterEntity> findAll();
      
      public List<MasterEntity> findByMasterDataType(MasterDataType masterDataType);
      
      //public MasterEntity update(final MasterEntity entity);
      
      //public  void delete(final MasterEntity entity);

      //public  void delete(Serializable id, Class entityClass);
      
      /*@SuppressWarnings("unchecked")  
      public  List<MasterEntity> findAll(Class entityClass);
    
      @SuppressWarnings("rawtypes")
      public  List<MasterEntity> findAll(String query);*/
      
      @SuppressWarnings("unchecked")
      public  MasterEntity findById(Integer id) ;
   
	
}
