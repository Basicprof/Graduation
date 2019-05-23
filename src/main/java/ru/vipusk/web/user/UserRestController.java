package ru.vipusk.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.vipusk.model.User;
import ru.vipusk.repository.jpa.JpaUserRepositoryI;
import ru.vipusk.util.exception.NotFoundException;

import java.util.List;

import static ru.vipusk.util.ValidationUtil.*;

@Service
public class UserRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final JpaUserRepositoryI repository;

    @Autowired
    public UserRestController(JpaUserRepositoryI repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        log.info("getAll");
        return repository.getAll();
    }

    public User get(int id) {
        log.info("get {}", id);
        return checkNotFoundWithId(repository.get(id), id);
    }

    public User create(User user) {
        log.info("create {}", user);
        checkNew(user);
        return repository.save(user);
    }


    public void update(User user, int id) {
        log.info("update {} with id={}", user, id);
        Assert.notNull(user, "user must not be null");
        assureIdConsistent(user, id);
        repository.save(user);
    }

    public User getByMail(String email) throws NotFoundException {
        Assert.notNull(email, "email must not be null");
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }
}
