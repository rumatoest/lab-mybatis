package lab.mybatis;

import java.io.IOException;
import java.util.List;
import lab.mybatis.dao.CustomerMapper;
import lab.mybatis.domain.Customer;
import lab.mybatis.domain.CustomerBase;
import lab.mybatis.domain.CustomerExt;
import lab.mybatis.domain.CustomerExtExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerMapper cuMapper;

    @RequestMapping("get/{id:\\d+}")
    public Customer get(@PathVariable long id) {
        return cuMapper.get(id);
    }

    @RequestMapping("getext/{id:\\d+}")
    public CustomerExt getExt(@PathVariable long id) {
        return cuMapper.getExt(id);
    }

    @RequestMapping("getextext/{id:\\d+}")
    public CustomerExtExt getExtExt(@PathVariable long id) {
        return cuMapper.getExtExt(id);
    }

    @RequestMapping("getbase/{id:\\d+}")
    public CustomerBase getBase(@PathVariable long id) {
        return cuMapper.getBase(id);
    }

    @RequestMapping("find")
    public List<Customer> find(
        @RequestParam(name = "email", required = false) String email, 
        @RequestParam("balance") double balance
    ) {
        return cuMapper.find(email, balance);
    }

    @RequestMapping("findExt")
    public List<Customer> findExt(
        @RequestParam(name = "name", required = false) String name, 
        @RequestParam("id") List<Long> ids
    ) {
        return cuMapper.findExt(name, ids.toArray(new Long[0]));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Customer add(@RequestBody Customer customer) throws IOException {
        cuMapper.insert(customer);
        return customer;
    }

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public Customer set(@RequestBody Customer customer) throws IOException {
        if (customer.getId() == 0) {
            cuMapper.insert(customer);
        } else {
            cuMapper.update(customer);
        }
        return customer;
    }
}
