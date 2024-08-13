package com.leegeonhee.myum.user.entity;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDate;


@Entity
@Table(name="board")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
public class Board {
    @PrePersist
    public void prePersist(){
        this.likes = this.likes == null? 0: this.likes;
    }

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name="content",nullable = false)
    private String content;
    @Column(name="writer", nullable = false)
    private String writer;
    @Column(name="likes")
    @ColumnDefault("0")
    private Long likes;
}
