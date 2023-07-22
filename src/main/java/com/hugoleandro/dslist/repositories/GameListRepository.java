package com.hugoleandro.dslist.repositories;

import com.hugoleandro.dslist.models.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    @Modifying // Sempre que for uma query com uma operação de inserir, remover ou atualizar, esta anotação é necessária
    @Query(nativeQuery = true, value =
            "UPDATE Belonging SET position = :newPosition WHERE game_list_id = :gameListId AND game_id = :gameId")
    void updateBelongingPosition(Long gameListId, Long gameId, Integer newPosition);
}
