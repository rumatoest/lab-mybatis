package lab.mybatis.domain;

import java.util.List;
import lombok.Data;

@Data
public class CustomerExtExt extends Customer {

    private List<LinkExt> links;
}
