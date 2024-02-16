package com.ddobii.back.ddobii.board.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board")
@NoArgsConstructor
public class Board extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;            // ID

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @Column(name = "public_yn", length = 1)
    private String publicYn;

    @Column(name = "created_name", nullable = false, length = 100)
    private String createdName;

    @Column(name = "updated_name", nullable = true, length = 100)
    private String updatedName;

    @Column(name = "deleted_yn", length = 1)
    private String deletedYn;

}
