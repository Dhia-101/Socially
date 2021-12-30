package com.dhia.springsocialmediaapi.services.jpaImplementation;

import com.dhia.springsocialmediaapi.domain.Comment;
import com.dhia.springsocialmediaapi.domain.Post;
import com.dhia.springsocialmediaapi.mapper.CommentMapper;
import com.dhia.springsocialmediaapi.model.CommentDTO;
import com.dhia.springsocialmediaapi.repositories.CommentRepository;
import com.dhia.springsocialmediaapi.repositories.PostRepository;
import com.dhia.springsocialmediaapi.services.CommentService;
import com.dhia.springsocialmediaapi.services.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentJpaService implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final PostRepository postRepository;

    public CommentJpaService(CommentRepository commentRepository, CommentMapper commentMapper, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.postRepository = postRepository;
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
    public CommentDTO findById(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("no comment with id: " + commentId));
        return commentMapper.commentToCommentDTO(comment);
    }

    @Override
    public CommentDTO save(Long postId ,CommentDTO commentDTO) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("No post with id: " + postId + " was found."));

        Comment comment = commentMapper.CommentDTOToComment(commentDTO);
        post.addComment(comment);
        comment.setDateTimePosted(LocalDateTime.now());

        return commentMapper.commentToCommentDTO(comment);
    }

    @Override
    public CommentDTO update(Long aLong, CommentDTO object) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
