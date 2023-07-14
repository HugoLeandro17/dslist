package com.hugoleandro.dslist.repositories;

import com.hugoleandro.dslist.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
