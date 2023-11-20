package com.example.tmdt.service.impl;

import com.example.tmdt.dto.CommentDTO;
import com.example.tmdt.mapper.CommentMapper;
import com.example.tmdt.model.Comment;
import com.example.tmdt.repository.CommentRepository;
import com.example.tmdt.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public void save(CommentDTO dto) {
        Comment comment = commentMapper.toEntity(dto);
        comment.setCreateAt(LocalDateTime.now());
        commentMapper.toDto(commentRepository.save(comment));
    }

    @Override
    public void delete(Long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()){
            Comment comment = commentOptional.get();
            comment.setStatus("1");
            commentRepository.save(comment);
        }
    }

    @Override
    public CommentDTO findOne(Long id) {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        if (commentOptional.isPresent()){
            Comment comment = commentOptional.get();
            return commentMapper.toDto(comment);
        }
        return null;
    }

    @Override
    public List<CommentDTO> findAll() {
        List<Comment> comments = commentRepository.findAll();
        return commentMapper.toDto(comments);
    }

    @Override
    public List<CommentDTO> findByIdProduct(Long id) {
        List<Comment> comments = commentRepository.findAllByProduct_Id(id);
        if (comments != null){
            return commentMapper.toDto(comments);
        }
        return null;
    }
}
