package com.suyeon.bookstore.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MemberDto {
    private String member_id;

    private String passwd;

    private String m_name;

    private Address address;

}
