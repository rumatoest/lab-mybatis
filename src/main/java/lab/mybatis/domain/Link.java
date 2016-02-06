package lab.mybatis.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import lombok.Data;

@Data
public class Link {

    private long id;

    private Long customerId;

    private String url;

    @JsonCreator
    public static Link factory(String json) throws IOException {
        return new ObjectMapper().readValue(json, Link.class);
    }
}
