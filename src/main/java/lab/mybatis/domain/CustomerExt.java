package lab.mybatis.domain;

import java.util.List;
import lombok.Data;

@Data
public class CustomerExt extends Customer {

    private List<Link> links;
}
