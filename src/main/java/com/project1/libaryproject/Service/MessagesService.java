package com.project1.libaryproject.Service;

import com.project1.libaryproject.Repository.MessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessagesService {
    MessageRepository messageRepository;


}
