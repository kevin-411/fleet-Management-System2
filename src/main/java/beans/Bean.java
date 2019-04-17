package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@Stateless
public class Bean<T> implements BeanI<T> {
    private final Class<T> type;

    public Bean(Class<T> type) { this.type = type; }

    @PersistenceContext(unitName = "fleetManagementSystem")
    EntityManager entityManager;


    @Override
    public T add(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T edit(T t) {
        entityManager.merge(t);
        return t;
    }

    @Override
    public T findById(int id) {
        T t1 = entityManager.find(type, id);
        return t1;
    }

    @Override
    public boolean remove(int id) {
        T t = entityManager.find(type, id);
        try{
            entityManager.remove(t);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
