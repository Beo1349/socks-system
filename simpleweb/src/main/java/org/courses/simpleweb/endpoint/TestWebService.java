package org.courses.simpleweb.endpoint;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class TestWebService implements ITestWebService {

    @Override
    @WebMethod
    public String Hello(String name)
    {
        return "Hellow " + name;
    }
}
