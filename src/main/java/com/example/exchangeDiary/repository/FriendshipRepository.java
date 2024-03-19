package com.example.exchangeDiary.repository;

import com.example.exchangeDiary.entity.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    Optional<Friendship> findByUserId(String id);

}
