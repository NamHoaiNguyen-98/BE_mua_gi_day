package com.example.tmdt.service.impl;

import com.example.tmdt.dto.CommentDTO;
import com.example.tmdt.mapper.CommentMapper;
import com.example.tmdt.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentService implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public void save(CommentDTO dto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CommentDTO findOne(Long id) {
        return null;
    }

    @Override
    public List<CommentDTO> findAll() {
        return null;
    }
}
