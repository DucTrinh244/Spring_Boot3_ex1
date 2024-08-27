package com.JPA_SpringBoot_3.Springboot_3.repository;

import com.JPA_SpringBoot_3.Springboot_3.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // SPRING SẼ TỰ ĐỘNG KIỂM TRA USERNAME CÓ TỒN TẠI HAY CHƯA
    // SAU ĐÓ NÓ SẼ ĐƯỢC TRẢ VỀ
    boolean existsByUsername(String Username);
}
