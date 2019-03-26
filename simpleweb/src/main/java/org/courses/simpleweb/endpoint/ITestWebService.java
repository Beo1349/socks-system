package org.courses.simpleweb.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ITestWebService {
    @WebMethod
    String Hello(String name);
}
