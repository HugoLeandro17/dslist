package com.hugoleandro.dslist.repositories;

import com.hugoleandro.dslist.models.Game;
import com.hugoleandro.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(nativeQuery = true, value = """
		SELECT g.id, g.title, g.game_year AS `year`, g.img_url AS imgUrl,
		g.short_description AS shortDescription
		FROM Game g
		INNER JOIN Belonging b ON g.id = b.game_id
		WHERE b.game_list_id = :gameListId
		ORDER BY b.position ASC
			""")
    List<GameMinProjection> searchByList(Long gameListId);
}
