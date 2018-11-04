//package com.nghia.libraries.mysql.infrustructure.repository;
//
//
//import com.nghia.libraries.mysql.infrustructure.domain.AbstractEntity;
//
//import java.util.Collection;
//import java.util.List;
//
//public interface CustomRepository<E extends AbstractEntity> {
//
//    E createOne(E entity);
//
//    void createBatch(Collection<E> entities);
//
//    boolean updateMulti(Query query, Update update);
//
//    void update(E entity);
//
//    boolean remove(E entity);
//
//    void softRemove(E entity);
//
//    List<E> findAll();
//
//    List<E> find(Query query);
//
//    E findOne(Query query);
//}
