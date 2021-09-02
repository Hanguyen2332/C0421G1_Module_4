package com.practice.controller;

import com.practice.model.dto.SongDto;
import com.practice.model.entity.Song;
import com.practice.model.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;


    //show List song
    @GetMapping("")
    public ModelAndView showList() {
        return new ModelAndView("index","songList",iSongService.findAll());
    }

    //create
    @GetMapping("/create")
    public ModelAndView createForm() {
        return new ModelAndView("create","songDto",new SongDto());
    }
    @PostMapping("/create")
    public String save(@Valid @ModelAttribute SongDto songDto,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("songDto",songDto);
            return "create";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            iSongService.createSong(song);
            redirectAttributes.addFlashAttribute("message","Create new Song successfully!");
            return "redirect:/";
        }
    }

    //edit
    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Integer id) {
        Song song = iSongService.findById(id).get();  //RETURN: Song
        //coppy song --> songDto
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song,songDto);
        //render --> view
        return new ModelAndView("edit","songDto",songDto);
    }
    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute SongDto songDto,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("songDto",songDto);
            return "edit";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            iSongService.createSong(song);
            redirectAttributes.addFlashAttribute("message","Edit Song successfully!");
            return "redirect:/";
        }
    }
}
