package com.dhia.springsocialmediaapi.controllers;

import com.dhia.springsocialmediaapi.model.MessageDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@Api(tags = {"messages"})
@CrossOrigin
@RequestMapping()
public class MessageController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public MessageController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @ApiOperation(value = "send a message")
    @PostMapping(value = "/messages")
    public String savePost(@RequestBody MessageDTO message) {
        simpMessagingTemplate.convertAndSend("/topic", "test");
        return "test post message";
    }

}
