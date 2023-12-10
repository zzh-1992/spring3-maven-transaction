package com.grapefruit.spring3maven.service;

import com.grapefruit.spring3maven.entity.User;
import com.grapefruit.spring3maven.exception.MyException;
import com.grapefruit.spring3maven.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    //@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    @Transactional
    public void saveUser(User user) throws MyException {
        userRepository.save(user);
        if (1 == 1) {
            //int i = 1 / 0;
            throw new MyException();
        }
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    // 其他操作方法...
}
