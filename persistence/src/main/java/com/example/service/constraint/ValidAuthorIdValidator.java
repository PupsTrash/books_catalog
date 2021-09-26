package com.example.service.constraint;

import com.example.db.author.AuthorEntity;
import com.example.db.author.AuthorsRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class ValidAuthorIdValidator implements ConstraintValidator<ValidAuthorId, String> {

    @Autowired
    private final AuthorsRepo authorsRepo;


    @Override
    public void initialize(ValidAuthorId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext constraintValidatorContext) {
        long authorId;

        try {
            authorId = Long.parseLong(id);
            AuthorEntity found = authorsRepo.findById(authorId).get();
        }
        catch (RuntimeException ex) {
            return false;
        }


        return true;
    }
}
