package lab.mybatis.dao;

import java.util.List;
import lab.mybatis.domain.Link;
import lab.mybatis.domain.LinkExt;

public interface LinkMapper {

    Link get(long id);

    LinkExt getExt(long id);

    List<Link> findByCustomer(long customerId);

    int insert(Link link);
}
