package com.superwalletuser.adapters.out.repository;

import com.superwalletuser.adapters.out.repository.entities.JpaUserEntity;
import com.superwalletuser.domain.entity.User;
import com.superwalletuser.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User save(User user) {
        var userEntity = jpaUserRepository.save(new JpaUserEntity(user));
        return new User(userEntity);
    }

    @Override
    public Optional<User> findById(UUID id) {
        var optUserEntity = jpaUserRepository.findById(id) ;
        return optUserEntity.map(User::new);
    }

    @Override
    public List<User> findAll() {
        var userEntityList = jpaUserRepository.findAll();
        return userEntityList.stream().map(User::new).collect(toList());
    }

    @Override
    public List<User> findByIsActiveTrue() {
        var userEntityList = jpaUserRepository.findByIsActiveTrue();
        return userEntityList.stream().map(User::new).collect(toList());
    }


    @Override
    public Optional<User> findByEmailOrDocument(User user) {
        var userEntityList = jpaUserRepository.findByEmailOrDocument(user.getEmail(), user.getDocument());
        return userEntityList.stream().map(User::new).findFirst();
    }



}
