package com.project1.libaryproject.Repository;

import com.project1.libaryproject.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public class MessageRepository extends JpaRepository<Message, Long> {
}
