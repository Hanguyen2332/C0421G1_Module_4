package com.practice.controller;

import com.practice.model.dto.ContractDto;
import com.practice.model.entity.Contract;
import com.practice.model.service.IContractService;
import com.practice.model.service.ICustomerService;
import com.practice.model.service.IEmployeeService;
import com.practice.model.service.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IService iService;
    //view list đang SD dịch vụ

    @GetMapping("/find")
    public ModelAndView viewList(@PageableDefault(value = 3)Pageable pageable, ModelAndView modelAndView) {

        modelAndView.setViewName("contract/view");
        modelAndView.addObject("nowCusList",iContractService.findNowCustomerPage(pageable));
        return modelAndView;
    }

    //create customer:
    @GetMapping("/contract/create")
    public ModelAndView createForm(ModelAndView modelAndView) {
        modelAndView.setViewName("contract/contract_create");
        modelAndView.addObject("employeeList", iEmployeeService.findAll()); //select-option
        modelAndView.addObject("customerList", iCustomerService.findAll()); //select-option
        modelAndView.addObject("serviceList", iService.findAll()); //select-option

        modelAndView.addObject("contrDtoObj", new ContractDto());
        return modelAndView;
    }

    @PostMapping("/contract/create")
    public String createContract(@Validated @ModelAttribute("contrDtoObj") ContractDto contrDtoObj,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {

        new ContractDto().validate(contrDtoObj, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            addData(contrDtoObj, model);
            return "contract/contract_create";
        }

        //tinh phi:
        double totalFee = contrDtoObj.getService().getCost() + contrDtoObj.getDeposit();
        contrDtoObj.setTotalFee(totalFee);
        //lưu:
        callSaveFunction(contrDtoObj);
        model.addAttribute("contrDtoObj", contrDtoObj);
        model.addAttribute("message","Create new contract successful");
        return "contract/contract_info";
    }
    //Ham common: save
    public void callSaveFunction(ContractDto contrDtoObj) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contrDtoObj, contract);
        iContractService.save(contract);
    }

    //addData data - save/edit:
    public void addData(ContractDto contrDtoObj,
                        Model model) {
        model.addAttribute("employeeList", iEmployeeService.findAll()); //select-option
        model.addAttribute("customerList", iCustomerService.findAll()); //select-option
        model.addAttribute("serviceList", iService.findAll()); //select-option
        model.addAttribute("contrDtoObj", contrDtoObj);
    }

}
