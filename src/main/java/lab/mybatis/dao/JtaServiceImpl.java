package lab.mybatis.dao;

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
    @Transactional(readOnly = true)
    public void updateCustomerId(long id, long newId) {
        liMap.updateOwner(id, newId);
        cuMap.updateId(id, newId);
    }

}
