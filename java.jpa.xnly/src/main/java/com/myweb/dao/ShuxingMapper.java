package com.myweb.dao;

import com.myweb.pojo.Roletomenu;
import com.myweb.pojo.Shuxing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryDefinition(domainClass = Shuxing.class, idClass = Integer.class)
public interface ShuxingMapper extends JpaRepository  <Shuxing,Integer>{

}