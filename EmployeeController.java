import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Display form on the landing page
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    // Handle form submission and save employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/displayAll";
    }

    // Display all employees
    @GetMapping("/displayAll")
    public String displayAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employeeList";
    }

    // Display employee by ID
    @GetMapping("/display/{employeeId}")
    public String displayEmployee(@PathVariable String employeeId, Model model) {
        Employee employee = employeeService.getEmployeeByEmployeeId(employeeId);
        model.addAttribute("employee", employee);
        return "employeeDetails";
    }
}
