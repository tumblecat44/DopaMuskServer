package com.leegeonhee.myum.user.repository;

import com.leegeonhee.myum.user.entity.Board;
import lombok.NonNull;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    @NonNull List<Board> findAll(@NonNull Sort sort);
}
