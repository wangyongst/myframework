package com.myweb.dao;

import com.myweb.pojo.Jiashu;
import com.myweb.pojo.Laoren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryDefinition(domainClass = Laoren.class, idClass = Integer.class)
public interface LaorenMapper extends JpaRepository <Laoren,Integer>{

}