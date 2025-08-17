package com.edu.ignis.MedicalCenter.persistence;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import com.edu.ignis.MedicalCenter.persistence.exceptions.NonexistentEntityException;

// DAO (Data Access Object)
public abstract class GenericDAO<T> {

  private Class<T> entityClass;

  /**
     * Constructs a GenericDAO with the specified entity class.
     *
     * @param entity the class type of the entity
     */
  public GenericDAO(Class<T> entity) {
    this.entityClass = entity;
  }

  /**
     * Creates a new entity in the database.
     * This method begins a transaction, persists the provided entity,
     * commits the transaction, and then closes the EntityManager.
     *
     * @param entity the entity to be created
     */
  public void create(T entity) {
    try (EntityManager em = ControllerPersistence.getEntityManager()) {
      em.getTransaction().begin();
      em.persist(entity);
      em.getTransaction().commit();
    }
  }

  /**
     * Edits an existing entity in the database.
     * This method begins a transaction, merges the provided entity,
     * commits the transaction, and then closes the EntityManager.
     * If the entity does not exist, a NonexistentEntityException is thrown.
     *
     * @param entity the entity to be edited
     * @param id the ID of the entity to be edited
     * @throws NonexistentEntityException if the entity with the given ID does not exist
     * @throws Exception if any other error occurs during the operation
     */
  public void edit(T entity, Object id) throws NonexistentEntityException, Exception {
    try (EntityManager em = ControllerPersistence.getEntityManager()) {
      em.getTransaction().begin();
      if (find(id) == null) {
        throw new NonexistentEntityException(
          entityClass.getSimpleName() + " with id " + id + " doesn't exist."
        );
      }
      em.merge(entity);
      em.getTransaction().commit();
    }
  }

  /**
     * Deletes an entity from the database by its ID.
     * This method begins a transaction, retrieves the entity by its ID,
     * removes it, commits the transaction, and then closes the EntityManager.
     * If the entity does not exist, a NonexistentEntityException is thrown.
     *
     * @param id the ID of the entity to be deleted
     * @throws NonexistentEntityException if the entity with the given ID does not exist
     */
  public void delete(Object id) throws NonexistentEntityException {
    try (EntityManager em = ControllerPersistence.getEntityManager()) {
      em.getTransaction().begin();
      T entity;
      try {
        entity = em.getReference(entityClass, id);
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException(entityClass.getSimpleName() + " with id: "
          + id + " doesn't exist. " + enfe.getMessage())
        ;
      }
      em.remove(entity);
      em.getTransaction().commit();
    }
  }

  /**
     * Finds an entity in the database by its ID.
     * Retrieves the entity with the specified ID using the EntityManager.
     *
     * @param id the ID of the entity to be found
     * @return the entity if found, or {@code null} if not found
     */
  public T find(Object id) {
    try (EntityManager em = ControllerPersistence.getEntityManager()) {
      return em.find(entityClass, id);
    }
  }

  /**
     * Retrieves all entities of the specified type from the database.
     * This method fetches all entities of this type with no restrictions on
     * the number of results or starting point.
     *
     * @return a list of all entities of the specified type
     */
  public List<T> findAll() {
    return findAll(true, -1, -1);
  }

  /**
     * Retrieves a list of entities of the specified type, with optional parameters
     * to limit the number of results and set a starting point.
     *
     * @param all if true, retrieves all entities; otherwise, applies maxResults and firstResult
     * @param maxResults the maximum number of results to retrieve
     * @param firstResult the starting position of the first result
     * @return a list of entities based on the specified criteria
     */
  public List<T> findAll(boolean all, int maxResults, int firstResult) {
    try (EntityManager em = ControllerPersistence.getEntityManager()) {
      CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
      cq.select(cq.from(entityClass));
      TypedQuery<T> q = em.createQuery(cq);
      if (!all) {
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
      }
      return q.getResultList();
    }
  }

  /**
     * Counts the total number of entities of the specified type in the database.
     * This method generates a criteria query to count all entities of this type.
     *
     * @return the total count of entities of the specified type
     */
  public int count() {
    try (EntityManager em = ControllerPersistence.getEntityManager()) {
      CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
      Root<T> rt = cq.from(entityClass);
      cq.select(em.getCriteriaBuilder().count(rt));
      return em.createQuery(cq).getSingleResult().intValue();
    }
  }
}
