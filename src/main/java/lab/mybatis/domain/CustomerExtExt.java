package lab.mybatis.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerExtExt extends Customer {

    private List<LinkExt> links;
}
