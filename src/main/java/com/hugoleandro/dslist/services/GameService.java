package com.hugoleandro.dslist.services;

import com.hugoleandro.dslist.dto.GameAllDTO;
import com.hugoleandro.dslist.dto.GameDTO;
import com.hugoleandro.dslist.models.Game;
import com.hugoleandro.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameDTO> findAll() {
        List<Game> listAllGames = gameRepository.findAll();

        return listAllGames.stream().map(game -> new GameDTO(game)).toList();
    }

    @Transactional(readOnly = true)
    public GameAllDTO findById(Long id) {
        Optional<Game> game = gameRepository.findById(id);

        if (game.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Game with id %d not found", id));

        return new GameAllDTO(game.get());
    }
}
