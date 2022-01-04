package com.dhia.springsocialmediaapi.services.jpaImplementation;

import com.dhia.springsocialmediaapi.domain.Message;
import com.dhia.springsocialmediaapi.domain.User;
import com.dhia.springsocialmediaapi.exceptions.ResourceNotFoundException;
import com.dhia.springsocialmediaapi.model.MessageDTO;
import com.dhia.springsocialmediaapi.repositories.MessageRepository;
import com.dhia.springsocialmediaapi.repositories.UserRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageJpaService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public MessageJpaService(
            MessageRepository messageRepository,
            UserRepository userRepository,
            SimpMessagingTemplate simpMessagingTemplate) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public String save(MessageDTO messageDTO) {

        User sender = userRepository.findById(messageDTO.getSenderId())
                .orElseThrow(() -> new ResourceNotFoundException("invalid sender id"));

        User receiver = userRepository.findById(messageDTO.getReceiverId())
                .orElseThrow(() -> new ResourceNotFoundException("invalid receiver id"));


        Message messageToSave = new Message();
        messageToSave.setContent(messageDTO.getContent());
        messageToSave.setReceiver(receiver);
        messageToSave.setSender(sender);
        messageToSave.setDateTimeSent(LocalDateTime.now());

        messageRepository.save(messageToSave);
        simpMessagingTemplate.convertAndSend("/topic/" + receiver.getUsername(), messageDTO);

        return "saved";
    }

}
