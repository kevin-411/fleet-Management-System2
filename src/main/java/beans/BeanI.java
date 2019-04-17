package beans;

import javax.ejb.Local;

//@Local
public interface BeanI<T> {
    T add(T t);
    T edit(T t);
    T findById(int id);
    boolean remove(int id);
}
