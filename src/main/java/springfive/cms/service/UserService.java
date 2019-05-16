package springfive.cms.service;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import springfive.cms.models.User;
import springfive.cms.repository.UserRepository;
import springfive.cms.vo.UserRequest;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Contract(pure = true)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // FIXME another mis-used Optional.get() call
    public User update(String id, @NotNull UserRequest userRequest) {
        final var user  = userRepository.findOne(id).get();

        user.setIdentity(userRequest.getIdentity());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());

        return userRepository.save(user);
    }

    public User create(@NotNull UserRequest userRequest) {
        var user = new User();

        user.setId(UUID.randomUUID().toString());
        user.setIdentity(userRequest.getIdentity());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());

        return userRepository.save(user);
    }

    // FIXME another mis-used Optional.get() call
    public void delete(String id) {
        final var user = userRepository.findOne(id).get();

        userRepository.delete(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    // FIXME mis-used Optional.get()
    public User findOne(String id) {
        return userRepository.findOne(id).get();
    }
}
