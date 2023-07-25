package com.project1.libaryproject.Repository;

import com.project1.libaryproject.Entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface MessageRepository extends JpaRepository<Message, Long> {
//This will find all messages by user email and return a page of messages

    Page<Message> findByUserEmail(@RequestParam("user_email") String userEmail, Pageable pageable);
//This is going to be the endpoint to find all messages by closed status
// and return a page of messages
    //So all user who have closed messages the admin can see them and that what this is going to return
    Page<Message> findbyClosed(@RequestParam("closed") boolean closed, Pageable pageable);

}
