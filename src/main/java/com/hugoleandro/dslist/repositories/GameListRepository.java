package com.hugoleandro.dslist.repositories;

import com.hugoleandro.dslist.models.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
