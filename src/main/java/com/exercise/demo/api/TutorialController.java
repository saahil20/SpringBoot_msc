package com.exercise.demo.api;

import com.exercise.demo.model.Tutorial;
import com.exercise.demo.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/tutorials")
@RestController
public class TutorialController {

    private final TutorialService tutorialService;

    @Autowired
    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @PostMapping
    public void addTutorial(@RequestBody Tutorial tutorial){
        tutorialService.addTutorial(tutorial);
    }

    @GetMapping
    public List<Tutorial> getAllTutorial(){
        return tutorialService.getAllTutorial();
    }

    @GetMapping(path = "{id}")
    public Tutorial getTutorialById(@PathVariable("id") int id){
        return tutorialService.selectTutorialById(id).orElse(null);
    }


    @GetMapping(path ="/search")
    public List<Tutorial> getByTitleContaining(@RequestParam(name = "title") String keyword){
        return tutorialService.selectByTitleContaining(keyword);
    }

    @GetMapping(path = "/published")
    public List<Tutorial> getPublishedTutorial(){
        return tutorialService.selectPublishedTutorial();
    }

    @DeleteMapping(path = "{id}")
    public void deleteTutorialById(@PathVariable("id") int id){
        tutorialService.deleteTutorialById(id);
    }

    @DeleteMapping
    public void deleteAllTutorial(){
        tutorialService.deleteAllTutorial();
    }

    @PutMapping(path = "{id}")
    public void updateTutorialById(@PathVariable("id") int id,@RequestBody Tutorial tutorial){
        tutorialService.updateTutorialById(id,tutorial);
    }
}
