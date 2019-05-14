package com.pardalis.betvictorassignment.unit;

import com.pardalis.betvictorassignment.dto.CommentDTO;
import com.pardalis.betvictorassignment.helper.enumeration.CommentDTOValidationError;
import com.pardalis.betvictorassignment.helper.exception.CommentDTOValidationException;
import com.pardalis.betvictorassignment.validator.CommentDTOValidator;
import com.pardalis.betvictorassignment.validator.CommentDTOValidatorImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommentDTOValidatorImplTest {
    private final CommentDTOValidator commentDTOValidator = new CommentDTOValidatorImpl();

    @Test
    public void validDTO() throws Exception {
        CommentDTO commentDTO = new CommentDTO("some_valid@mail.com", "arguably a short comment");

        commentDTOValidator.validateDTO(commentDTO);
    }

    @Test
    public void emailNull() {
        CommentDTO malformedDTO = new CommentDTO(null, "ignore me");

        try {
            commentDTOValidator.validateDTO(malformedDTO);
        } catch (CommentDTOValidationException e) {
            Assert.assertEquals(CommentDTOValidationError.NULL_EMAIL.toString(), e.getMessage());
        }
    }

    @Test
    public void emailEmpty() {
        CommentDTO malformedDTO = new CommentDTO("", "ignore me");

        try {
            commentDTOValidator.validateDTO(malformedDTO);
        } catch (CommentDTOValidationException e) {
            Assert.assertEquals(CommentDTOValidationError.NULL_EMAIL.toString(), e.getMessage());
        }
    }

    @Test
    public void emailMalformed() {
        CommentDTO malformedDTO = new CommentDTO("is this an email?", "ignore me");

        try {
            commentDTOValidator.validateDTO(malformedDTO);
        } catch (CommentDTOValidationException e) {
            Assert.assertEquals(CommentDTOValidationError.INVALID_EMAIL.toString(), e.getMessage());
        }
    }

    @Test
    public void commentEmpty() {
        CommentDTO malformedDTO = new CommentDTO("some_valid@mail.com", "");

        try {
            commentDTOValidator.validateDTO(malformedDTO);
        } catch (CommentDTOValidationException e) {
            Assert.assertEquals(CommentDTOValidationError.NULL_COMMENT.toString(), e.getMessage());
        }
    }
}