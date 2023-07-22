package com.hugoleandro.dslist.controllers;

import com.hugoleandro.dslist.dto.GameDTO;
import com.hugoleandro.dslist.dto.GameListDTO;
import com.hugoleandro.dslist.dto.ReplacementDTO;
import com.hugoleandro.dslist.services.GameListService;
import com.hugoleandro.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{gameListId}/games")
    public List<GameDTO> findByList(@PathVariable Long gameListId) {
        return gameService.findByList(gameListId);
    }

    @PostMapping(value = "/{gameListId}/replacement")
    public void move(@PathVariable Long gameListId, @RequestBody ReplacementDTO body) {
        gameListService.move(gameListId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
