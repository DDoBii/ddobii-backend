package com.ddobii.back.ddobii.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(length = 10)
    private String activated;   // 사용여부

    @Column
    private String created;     // 생성일시

    @Column
    private String updated;     // 수정일시

    @Column
    private String user_info;   // 회원정보

    @Column(length = 10)
    private String sleep;       // 휴먼여부

}
