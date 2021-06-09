package com.logging;

import model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
public class Controller {

    private static  final Logger logger = LoggerFactory.getLogger(Controller.class);

    @PostMapping("/player")
    ResponseEntity<Player> postPlayer(@RequestBody Player player)
    {

        //Bonus - Just to print the current file name, line number and function name use the below.
        //anyways we don;t need this
        StackTraceElement ele = Thread.currentThread().getStackTrace()[1];
        System.out.println("Sreejith --> "+ele+":");

        logger.info(player.toString());
        logger.warn(player.toString());
        logger.debug(player.toString());
        logger.error(player.toString());

        return ResponseEntity.status(HttpStatus.OK).body(player);
    }


}
