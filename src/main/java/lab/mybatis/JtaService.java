package lab.mybatis;

public interface JtaService {

    void updateCustomerId(long id, long newId);

    void updateCustomerIdRo(long id, long newId);

    void updateCustomerIdError(long id, long newId);
}
