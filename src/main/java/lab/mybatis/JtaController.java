package lab.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rumatoest
 */
@RestController
@RequestMapping("/jta")
public class JtaController {

    @Autowired
    JtaService jtaSrv;

    @RequestMapping("idupdate/{from:\\d+}/{to:\\d+}")
    public void updateCustomerId(@PathVariable long from, @PathVariable long to) {
        jtaSrv.updateCustomerId(from, to);
    }

    @RequestMapping("idupdatero/{from:\\d+}/{to:\\d+}")
    public void updateCustomerIdRo(@PathVariable long from, @PathVariable long to) {
        jtaSrv.updateCustomerIdRo(from, to);
    }

    @RequestMapping("idupdaterr/{from:\\d+}/{to:\\d+}")
    public void updateCustomerIdError(@PathVariable long from, @PathVariable long to) {
        jtaSrv.updateCustomerIdError(from, to);
    }

}
