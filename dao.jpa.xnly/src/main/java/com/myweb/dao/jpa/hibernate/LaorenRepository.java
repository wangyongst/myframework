package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Jiashu;
import com.myweb.pojo.Laoren;
import com.myweb.pojo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.text.CollationElementIterator;
import java.util.Collections;
import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Laoren.class, idClass = Integer.class)
public interface LaorenRepository extends JpaRepository<Laoren, Integer> {

    @Modifying(clearAutomatically = true)
    @Query("update Laoren laoren set laoren.type =?1 where laoren.id = ?2")
    public int updateTypeById(int type, int id);

}