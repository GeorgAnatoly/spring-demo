package springfive.cms.vo;

import lombok.Data;
import springfive.cms.models.Role;

@Data
public class UserRequest {
    private String identity, name;
    private Role role;
}
