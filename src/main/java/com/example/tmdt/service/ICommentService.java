package com.example.tmdt.service;

import com.example.tmdt.dto.CommentDTO;

import java.util.List;

public interface ICommentService extends BaseService<CommentDTO> {
    List<CommentDTO> findByIdProduct(Long id);
}
