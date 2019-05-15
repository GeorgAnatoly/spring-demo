package springfive.cms.models;

import lombok.Data;

@Data
public class User {
    private String id, identity, name;

    private Role role;
}
