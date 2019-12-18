package fr.reference.it.projectref.dataacces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserDAO extends JpaRepository<UserEntity,Integer>{
}
