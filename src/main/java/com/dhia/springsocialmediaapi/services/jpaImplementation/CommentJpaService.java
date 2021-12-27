package com.dhia.springsocialmediaapi.services.jpaImplementation;

import com.dhia.springsocialmediaapi.mapper.CommentMapper;
import com.dhia.springsocialmediaapi.model.CommentDTO;
import com.dhia.springsocialmediaapi.repositories.CommentRepository;
import com.dhia.springsocialmediaapi.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentJpaService implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentJpaService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentDTO> findAll() {
        List<CommentDTO> comments = new ArrayList<>();
        commentRepository.findAll().forEach(comment -> {
            comments.add(commentMapper.commentToCommentDTO(comment));
        });
        return comments;
    }

    @Override
    public CommentDTO findById(Long aLong) {
        return null;
    }

    @Override
    public CommentDTO update(Long aLong, CommentDTO object) {
        return null;
    }

    @Override
    public CommentDTO save(CommentDTO object) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
