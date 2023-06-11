package com.suyeon.bookstore.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MemberDto {

    @NotBlank
    private String member_id;

    @NotBlank
    private String passwd;

    @NotBlank
    private String m_name;

    @NotNull
    private Address address;

}
