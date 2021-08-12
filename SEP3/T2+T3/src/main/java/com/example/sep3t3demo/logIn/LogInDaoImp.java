package com.example.sep3t3demo.logIn;

import com.example.sep3t3demo.daoInterfaces.LogInDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class LogInDaoImp implements LogInDao {
   @PersistenceContext
   @Autowired
   public EntityManager entityManager;
   @Override
  public boolean userAuthentication(String username, String password) {
       String jpql = "from User as a WHERE a.username = ?0  and a.password = ?1";
       int count = entityManager.createQuery(jpql).setParameter(0, username).setParameter(1, password).getResultList()
               .size();
       return count > 0;

   }
}
