package com.suyeon.bookstore.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MemberResponse {
    private Long id;
    private String username;
    private String name;
}
