package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryDefinition(domainClass = Video.class, idClass = Integer.class)
public interface VideoRepository extends JpaRepository<Video,Integer> {
}