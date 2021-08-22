package cg.wbd.grandemonstration;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.CustomerServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {
    //--tạo đối tượng kiểu CustomerService (interface) (vì getInstance() mehthod trả về đối tượng kiểu CustomerService)--//

         //private CustomerService customerService = CustomerServiceFactory.getInstance();
    @Autowired
    private CustomerService customerService;

    //
    @GetMapping("/customers")
    ////B1.
//    public String showList() {
//        return "customers/list.jsp"; //~ forward --> xxx.jsp
//    }
    ////B2.
//    public String showList(HttpServletRequest request) {
//        List<Customer> customers = customerService.findAll();
//        request.setAttribute("customers", customers);
//        return "customers/list.jsp";
//    }
    ////B3
//    public String showList(Model model) {
//        List<Customer> customers = customerService.findAll();
//        model.addAttribute("customers", customers);
//        return "customers/list.jsp";
//    }

    ////B4:
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list.jsp");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
