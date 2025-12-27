package org.template.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class DaoJpa implements BaseDao {

    @PersistenceContext
    private EntityManager entityManager;

    public DaoJpa(){
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public <T> T getById(Class<T> clazz, long id) {
        return this.entityManager.find(clazz, id);
    }

    @Override
    public <T> List<T> getAll(Class<T> clazz) {
        return entityManager
                .createQuery("SELECT e FROM " + clazz.getSimpleName() + " e", clazz)
                .getResultList();
    }

    @Override
    public void save(Object obj) {
        this.entityManager.persist(obj);
    }

    @Override
    public void update(Object obj) {
        this.entityManager.merge(obj);
    }

    @Override
    public void delete(Object obj) {
        Object managed = entityManager.contains(obj)
                ? obj
                : entityManager.merge(obj);
        entityManager.remove(managed);
    }
}
