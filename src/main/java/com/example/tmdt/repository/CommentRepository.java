package com.example.tmdt.repository;
import com.example.tmdt.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByProduct_Id(Long id);
    List<Comment> findAllByAccount_Id(Long id);
    @Query(value = "select * from comment where account_id = :idAccount and product_id = :idProduct",nativeQuery = true)
    Optional <Comment> findComment(@Param("idAccount")Long idAccount, @Param("idProduct")Long idProduct);
}
