package lab.mybatis.domain;

import lombok.Data;

@Data
public class CustomerBase {

    private long id;

    private boolean enabled;

    private String login;
}
