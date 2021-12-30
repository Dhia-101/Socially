package com.dhia.springsocialmediaapi.services.jpaImplementation;

import com.dhia.springsocialmediaapi.domain.Comment;
import com.dhia.springsocialmediaapi.domain.Post;
import com.dhia.springsocialmediaapi.mapper.CommentMapper;
import com.dhia.springsocialmediaapi.model.CommentDTO;
import com.dhia.springsocialmediaapi.repositories.CommentRepository;
import com.dhia.springsocialmediaapi.repositories.PostRepository;
import com.dhia.springsocialmediaapi.services.CommentService;
import com.dhia.springsocialmediaapi.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

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
    public List<CommentDTO> findAll(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("No post with id: " + postId + " was found."));

        List<CommentDTO> comments = new ArrayList<>();
        post.getComments().forEach(comment -> {
            comments.add(commentMapper.commentToCommentDTO(comment));
        });
        return comments;
    }

    @Override
    public CommentDTO findById(Long postId, Long commentId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("No post with id: " + postId + " was found."));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("no comment with id: " + commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new RuntimeException("Comment does not belongs to post");
        }

        return commentMapper.commentToCommentDTO(comment);
    }

    @Override
    public CommentDTO save(Long postId ,CommentDTO commentDTO) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("No post with id: " + postId + " was found."));

        Comment comment = commentMapper.CommentDTOToComment(commentDTO);
        post.addComment(comment);
        comment.setPost(post);
        comment.setDateTimePosted(LocalDateTime.now());

        return commentMapper.commentToCommentDTO(commentRepository.save(comment));
    }

    @Override
    public CommentDTO update(Long postId, Long commentId, CommentDTO commentDTO) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("no post with id: " + postId));

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("no comment width id: " + commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new RuntimeException("Comment does not belongs to post");
        }

        comment.setContent(commentDTO.getContent());
        Comment updatedComment = commentRepository.save(comment);

        return commentMapper.commentToCommentDTO(commentRepository.save(updatedComment));
    }

    @Override
    public void delete(Long aLong) {

    }
}
