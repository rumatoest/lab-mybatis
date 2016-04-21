package lab.mybatis.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LinkExt extends Link {

    private Customer customer;
}
