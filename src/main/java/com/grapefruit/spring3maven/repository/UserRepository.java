package com.grapefruit.spring3maven.repository;

import com.grapefruit.spring3maven.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    // 自定义查询方法...
}
