package org.courses.simpleweb.endpoint;

import org.courses.data.DAO.DAO;
import org.courses.data.DAO.hbm.TypeDao;
import org.courses.domain.hbm.Type;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Collection;

@WebService
public class TypeService implements ITypeService {

    DAO<Type, Integer> dao;
    public TypeService(DAO<Type, Integer> dao)
    {
      this.dao = dao;
    }
    @WebMethod
    @Override
    public void save(Collection<Type> entity) {
        dao.save(entity);
    }
    @WebMethod
    @Override
    public Type read(int id) {
        return dao.read(id);
    }
    @WebMethod
    @Override
    public Collection<Type> readAll() {
        return dao.readAll();
    }
    @WebMethod
    @Override
    public Collection<Type> find(String filter) {
        return dao.find(filter);
    }
    @WebMethod
    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
