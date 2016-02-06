package lab.mybatis.dao;

import java.util.List;
import lab.mybatis.domain.Customer;
import lab.mybatis.domain.CustomerBase;
import lab.mybatis.domain.CustomerExt;
import lab.mybatis.domain.CustomerExtExt;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {

    Customer get(long id);

    CustomerBase getBase(long id);

    CustomerExt getExt(long id);

    CustomerExtExt getExtExt(long id);

    List<Customer> find(@Param("email") String email, @Param("balance") double balance);

    List<Customer> findExt(@Param("name") String name, @Param("ids") Long... ids);

    int insert(Customer cust);

    int update(Customer customer);
}
