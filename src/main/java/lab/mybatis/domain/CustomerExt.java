package lab.mybatis.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerExt extends Customer {

    private List<Link> links;
}
