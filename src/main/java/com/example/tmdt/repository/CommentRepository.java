package com.example.tmdt.repository;
import com.example.tmdt.model.fkProduct.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
