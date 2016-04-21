package lab.mybatis;

import lab.mybatis.dao.CustomerMapper;
import lab.mybatis.dao.LinkMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JtaServiceImpl implements JtaService {

    @Autowired
    CustomerMapper cuMap;

    @Autowired
    LinkMapper liMap;

    @Override
    @Transactional
    public void updateCustomerId(long id, long newId) {
        liMap.updateOwner(id, newId);
        cuMap.updateId(id, newId);
    }

    @Override
    @Transactional(readOnly = true)
    public void updateCustomerIdRo(long id, long newId) {
        liMap.updateOwner(id, newId);
        cuMap.updateId(id, newId);
    }

    @Override
    @Transactional
    public void updateCustomerIdError(long id, long newId) {
        liMap.updateOwner(id, newId);
        cuMap.updateId(id, newId);
        throw new UnsupportedOperationException("Can not process it");
    }

}
