package com.practice.controller;

import com.practice.model.dto.ServiceDto;
import com.practice.model.entity.Service;
import com.practice.model.service.IRentType;
import com.practice.model.service.IService;
import com.practice.model.service.IServiceType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IService iService;

    @Autowired
    private IRentType iRentType;

    @Autowired
    private IServiceType iServiceType;

    @GetMapping
    public ModelAndView showList(@PageableDefault(value = 4) Pageable pageable) {
        return new ModelAndView("service/list", "serviceList", iService.findAllPage(pageable));
    }

//    //EDIT
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Service service = iService.findById(id).get();
        //copy Service --> ServiceDto
        ServiceDto serDtoObj = new ServiceDto();
        BeanUtils.copyProperties(service, serDtoObj);
        //gender-->view
        addData(serDtoObj, model);
        return "service/edit";
    }

    @PostMapping("/edit")
    public String editService(@ModelAttribute("serDtoObj") ServiceDto serDtoObj,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        //Note: không cần check optional (vì không dùng @PathVariable)
        callSaveFunction(serDtoObj, redirectAttributes);
        return "redirect:/service";
    }

    //create customer:
    @GetMapping("/create")
    public ModelAndView createForm(ModelAndView modelAndView) {
        modelAndView.setViewName("service/create");
        modelAndView.addObject("rentTyeList", iRentType.findAll()); //select-option
        modelAndView.addObject("serviceTypeList", iServiceType.findAll()); //select-option
        modelAndView.addObject("serDtoObj", new ServiceDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createService(@ModelAttribute("serDtoObj") ServiceDto serDtoObj,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        callSaveFunction(serDtoObj, redirectAttributes);
        return "redirect:/service";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        iService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete service successfully!");
        return "redirect:/service";
    }

    //Ham common: save
    public void callSaveFunction(ServiceDto serviceDto, RedirectAttributes redirectAttributes) {
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        iService.save(service);
        redirectAttributes.addFlashAttribute("message", "Action has been completed Successfully!");
    }

    //addData data - save/edit:
    public void addData(ServiceDto serDtoObj,
                        Model model) {
        model.addAttribute("serDtoObj",serDtoObj);
        model.addAttribute("rentTyeList", iRentType.findAll()); //select-option
        model.addAttribute("serviceTypeList", iServiceType.findAll()); //select-option
    }
}
