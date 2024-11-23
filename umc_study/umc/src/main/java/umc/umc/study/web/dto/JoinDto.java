package umc.umc.study.web.dto;

import lombok.Getter;
import umc.umc.study.validation.annotation.ExistCategories;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class JoinDto{
    String name;
    Integer gender;
    Integer birthYear;
    Integer birthMonth;
    Integer birthDay;
    String address;
    String specAddress;
    Integer id;
    Integer rating;
    String review;
    Integer re_store_id;
    Integer re_user_id;
    @ExistCategories
    List<Long> preferCategory;
    Integer clear;
    Integer store_id;
    LocalDateTime cleartime;
}
