package com.dhia.springsocialmediaapi.controllers;

import com.dhia.springsocialmediaapi.model.MessageDTO;
import com.dhia.springsocialmediaapi.services.jpaImplementation.MessageJpaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"messages"})
@CrossOrigin
@RequestMapping()
public class MessageController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageJpaService messageJpaService;

    public MessageController(SimpMessagingTemplate simpMessagingTemplate, MessageJpaService messageJpaService) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.messageJpaService = messageJpaService;
    }

    @ApiOperation(value = "send a message")
    @PostMapping(value = "/messages")
    public String savePost(@RequestBody MessageDTO message) {
        System.out.println(messageJpaService.save(message));
        return "test post message";
    }

}
