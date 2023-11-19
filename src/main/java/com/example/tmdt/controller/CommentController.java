package com.example.tmdt.controller;

import com.example.tmdt.dto.CommentDTO;
import com.example.tmdt.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @GetMapping("/")
    public ResponseEntity<?> findAllComment(){
        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id){
        CommentDTO commentDTO = commentService.findOne(id);
        if (commentDTO!= null){
            return  new ResponseEntity<>(commentDTO,HttpStatus.OK);
        } return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/")
    public ResponseEntity<?> saveComment(@RequestBody CommentDTO commentDTO){
        commentService.save(commentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCmt(@PathVariable Long id){
        commentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
