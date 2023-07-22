package com.hugoleandro.dslist.services;

import com.hugoleandro.dslist.dto.GameListDTO;
import com.hugoleandro.dslist.models.GameList;
import com.hugoleandro.dslist.projections.GameMinProjection;
import com.hugoleandro.dslist.repositories.GameListRepository;
import com.hugoleandro.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> gameLists = gameListRepository.findAll();

        return gameLists.stream().map(gameList -> new GameListDTO(gameList)).toList();
    }

    @Transactional
    public void move(Long gameListId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> gamesByList = gameRepository.searchByList(gameListId);

        GameMinProjection gameToMove = gamesByList.remove(sourceIndex);
        gamesByList.add(destinationIndex, gameToMove);

        //int minIndex = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        //int maxIndex = destinationIndex > sourceIndex ? destinationIndex : sourceIndex;
        int minIndex = Math.min(sourceIndex, destinationIndex);
        int maxIndex = Math.max(sourceIndex, destinationIndex);

        for (int i = minIndex; i <= maxIndex ; i++) {
            gameListRepository.updateBelongingPosition(gameListId, gamesByList.get(i).getId(), i);
        }
    }
}
