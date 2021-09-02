package com.practice.model.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SongDto implements Validator {

    private Integer id;

    private String name;

    private String singer;

    private String musicGenre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        //validate Name:
        if (songDto.name.isEmpty()) {
            errors.rejectValue("name","field.empty","KHONG duoc de trong truong nay");
        }
        if (songDto.name.length() > 800) {
            errors.rejectValue("name","name.length","KHONG vuot qua 800 ky tu");
        }
        if (!songDto.name.matches("^[a-zA-Z0-9 ]+$")) {
            errors.rejectValue("name","field.forbidden","KHONG duoc chua cac ky tu dac biet nhu  @ ; , . = - + , ….");
        }
        //validate singer:
        if (songDto.singer.isEmpty()) {
            errors.rejectValue("singer","field.empty","KHONG duoc de trong truong nay");
        }
        if (songDto.singer.length() > 300) {
            errors.rejectValue("singer","singerName.length","KHONG vuot qua 300 ky tu");
        }
        if (!songDto.singer.matches("^[a-zA-Z0-9 ]+$")) {
            errors.rejectValue("singer","field.forbidden","KHONG duoc chua cac ky tu dac biet nhu  @ ; , . = - + , ….");
        }
        //validate musicGenre:
        if (songDto.musicGenre.isEmpty()) {
            errors.rejectValue("musicGenre","field.empty","KHONG duoc de trong truong nay");
        }
        if (songDto.singer.length() > 1000) {
            errors.rejectValue("musicGenre","musicGenre.length","KHONG vuot qua 1000 ky tu");
        }
        if (!songDto.singer.matches("^[a-zA-Z0-9, ]+$")) {
            errors.rejectValue("musicGenre","musicGenre.forbidden","KHONG duoc chua cac ky tu dac biet nhu  @ ; . = - + , ….");
        }
    }
}
