package lab.mybatis.dao;

import lab.mybatis.domain.Customer;
import lab.mybatis.domain.CustomerBase;
import lab.mybatis.domain.CustomerExt;
import lab.mybatis.domain.CustomerExtExt;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    List<Customer> findAll();

    Customer get(long id);

    CustomerBase getBase(long id);

    CustomerExt getExt(long id);

    CustomerExtExt getExtExt(long id);

    List<Customer> find(@Param("email") String email, @Param("balance") double balance);

    List<Customer> findExt(@Param("name") String name, @Param("ids") Long... ids);

    int insert(Customer cust);

    int update(Customer customer);

    void updateId(@Param("from") long id, @Param("to") long newId);
}
