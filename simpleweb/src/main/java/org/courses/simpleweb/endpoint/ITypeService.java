package org.courses.simpleweb.endpoint;

import org.courses.data.DAO.hbm.TypeDao;
import org.courses.domain.hbm.Type;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Collection;

@WebService
public interface ITypeService {

    @WebMethod
    void save(Collection<Type> entity);
    @WebMethod
    Type read(int id);
    @WebMethod
    Collection<Type> readAll();
    @WebMethod
    Collection<Type> find(String filter);
    @WebMethod
    void delete(int id);
}
