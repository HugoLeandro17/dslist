package com.hugoleandro.dslist.services;

import com.hugoleandro.dslist.dto.GameDTO;
import com.hugoleandro.dslist.models.Game;
import com.hugoleandro.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameDTO> findAll() {
        List<Game> listAllGames = gameRepository.findAll();

        return listAllGames.stream().map(game -> new GameDTO(game)).toList();
    }
}
