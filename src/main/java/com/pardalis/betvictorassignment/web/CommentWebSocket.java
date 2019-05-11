package com.pardalis.betvictorassignment.web;

import com.pardalis.betvictorassignment.dto.CommentDTO;
import com.pardalis.betvictorassignment.dto.DisplayableCommentDTO;

import java.util.List;

public interface CommentWebSocket {
    List<DisplayableCommentDTO> onSubscribe();

    void onMessage(CommentDTO commentDTO);
}