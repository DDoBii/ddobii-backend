package com.ddobii.back.ddobii.board.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board_cat")
@NoArgsConstructor
public class BoardCat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID

    @Column(length = 20, nullable = false)
    private String mbtiCat; // 엠비티아이 카테고리

}
