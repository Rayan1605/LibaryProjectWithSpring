package com.project1.libaryproject.Service;

import com.project1.libaryproject.Repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MessagesService {
    MessageRepository messageRepository;


}
