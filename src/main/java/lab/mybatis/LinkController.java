package lab.mybatis;

import java.util.List;
import lab.mybatis.dao.LinkMapper;
import lab.mybatis.domain.Link;
import lab.mybatis.domain.LinkExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
public class LinkController {
    
    @Autowired
    LinkMapper liMap;
    
    @RequestMapping("get/{id:\\d+}")
    public Link get(@PathVariable long id) {
        return liMap.get(id);
    }

    @RequestMapping("getext/{id:\\d+}")
    public LinkExt getBase(@PathVariable long id) {
        return liMap.getExt(id);
    }

    @RequestMapping("customer/{id:\\d+}")
    public List<Link> customer(@PathVariable long id) {
        return liMap.findByCustomer(id);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Link add(@RequestBody Link link) {
        liMap.insert(link);
        return link;
    }
}
