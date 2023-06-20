package com.suyeon.bookstore.member.entity;


import com.suyeon.bookstore.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Auth extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;

    @Column(name = "access_token", nullable = false)
    private String accessToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private Member member;

    @Builder
    public Auth(Member member, String accessToken, String refreshToken){
        this.member = member;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
