package com.myweb.dao;

import com.myweb.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = User.class, idClass = Integer.class)
public interface UserMapper extends JpaRepository<User,Integer> {

    public List<User> findByUsernameAndPassword(String username, String password);

    public List<User> findByUsernameAndIdNot(String username, Integer id);

    public List<User> findByUsernameNot(String username);

}