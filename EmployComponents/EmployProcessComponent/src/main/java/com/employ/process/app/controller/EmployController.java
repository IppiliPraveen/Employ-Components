package com.employ.process.app.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.employ.app.entity.Employ;
import com.employ.app.entity.LogIn;
import com.employ.process.app.service.EmployService;
import com.employ.process.app.service.LogInService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class EmployController {
	
	@Autowired
	private EmployService employService;
	
	@Autowired
	private LogInService logInService;

//	--------------------------API START------------------------------
	@ResponseBody
	@GetMapping("/employList")
	public List<Employ> employList() {
		List<Employ> empList = employService.getActiveEmploy();
		return empList;
	}
	
	@ResponseBody
	@PostMapping("/empLogin")
	public boolean getLogIn(@RequestBody LogIn login) {
		return logInService.login(login.getUserId(), login.getPassword());
	}
	
	@ResponseBody
	@PostMapping("/empRigister")
	public boolean empRegister(@RequestBody LogIn login) {
		boolean isSaved = false;
		if(!logInService.login(login.getUserId(), login.getPassword())) {
			logInService.saveUser(login);
			isSaved = true;
		}
		return isSaved;
	}
	
	@ResponseBody
	@GetMapping("/employ/{id}")
	public Employ getEmploy(@PathVariable String id) {
		Employ employ = employService.getEmploy(id);
		return  employ;
	}
	@ResponseBody
	@PostMapping("/employ/addEmploy")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addEmploy(@RequestBody Employ employ) {
		employ.setEmpId(employService.genarateEmpID());
		employService.save(employ);
	}
	
	@ResponseBody
	@PostMapping("/employ/update")
	public void updateEmploy(@RequestBody Employ employ) {
		employService.updateEmploy(employ);
	}
//	-----------------------API END-------------------------------------------------------------------------

	private static final Logger LOG = Logger.getLogger(EmployController.class.getName());

	@GetMapping("/")
	public String showIndexPage() {
		LOG.info("------------------> Spring Boot Started");
		return "index";
	}
	

	@GetMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("login", new LogIn());
		return "login";

	}
	
	@GetMapping(value = "/register")
	public String register(Model model) {
		model.addAttribute("login", new LogIn());
		return "Register";

	}
	
	@PostMapping(value = "/userRegister")
	public ModelAndView userRegister(@ModelAttribute("login") LogIn login, ModelAndView model) {
		logInService.saveUser(login);
		return new ModelAndView("redirect:/login");

	}
	
	@PostMapping(value = "/loginDetails")
	public ModelAndView loginDetails(@ModelAttribute("login") LogIn login, ModelAndView model) {

		boolean isLogin = logInService.login(login.getUserId(), login.getPassword());
		LogIn loginDetails=logInService.loginDetails(login.getUserId());
		List<Employ> listEmploy = null;
		
		if (isLogin) {
			model.addObject("login", login);
			if(loginDetails.getAccess().equalsIgnoreCase("admin")) {
				model.addObject("errMsg","Invalid Credentials");
				LOG.info("Admin Log in ");
				listEmploy = employService.getAllEmployes();
				model.addObject("listEmploy", listEmploy);
				model.setViewName("Admin");
				return model;
			}
			LOG.info("Normal Log in ");
			return new ModelAndView("redirect:/searchemploy");
		}
		model.addObject("login", login);
		model.addObject("errMsg","Invalid Credentials");
		model.setViewName("login");
		return model;
	}

	@GetMapping(value = "/searchemploy")
	public String search(@ModelAttribute("employ") Employ employ) {
		return "SearchEmploy";
	}

	@PostMapping(value = "/result")
	public ModelAndView listEmploy(ModelAndView model, HttpServletRequest req, @RequestParam String clickedButton)
			throws IOException {
		if (!"Reset".equals(clickedButton)) {

			List<Employ> listEmploy = null;
			String empId = null;

			if (req.getParameter("empId") != null && !req.getParameter("empId").equals("")) {

				empId = req.getParameter("empId");
				listEmploy = employService.findEmployById(empId);
			} else {

				listEmploy = employService.getActiveEmploy();
			}

			if (listEmploy.size() > 0) {

				model.addObject("listEmploy", listEmploy);
				model.setViewName("ResultsPage");

				return model;
			} else {
				model.addObject("employ", new Employ());
				model.setViewName("SearchEmploy");
				return model;
			}
		}
		return new ModelAndView("redirect:/searchemploy");
	}

	@GetMapping(value = "/addemploy")
	public String addEmploy(Model model) {
		Employ employ = new Employ();
		employ.setEmpId(employService.genarateEmpID());
		model.addAttribute("employ", employ);
		return "AddEmploy";

	}

	@PostMapping(value = "/newEmploy")
	public ModelAndView newEmploy(@ModelAttribute("employ") Employ employ, ModelAndView model) {
		boolean flag = true;
		if (employ.getName() == null || employ.getName() == "") {
			model.addObject("name", " Please Enter Employ Name <br>");
			flag = false;
		}
		if (employ.getGender() == null || String.valueOf(employ.getGender()) == "") {
			model.addObject("gndr", " Please Enter Employ Gender <br>");
			flag = false;
		}
		if (employ.getDept() == null || employ.getDept() == "") {
			model.addObject("dpt", " Please Enter Employ Department <br>");
			flag = false;
		}
		if (employ.getDesig() == null || employ.getDesig() == "") {
			model.addObject("dsg", " Please Enter Employ Designation <br>");
			flag = false;
		}
		if(employ.getSalary()==null || employ.getSalary()==0) {
			model.addObject("sal", " Please Enter Employ Salary <br>");
			flag = false;
		}
		if (!flag) {
			employ.setEmpId(employService.genarateEmpID());
			model.addObject("employ", employ);
			model.setViewName("AddEmploy");
			return model;
		}
		employ.setStatus("a");
		employService.save(employ);
		return new ModelAndView("redirect:/searchemploy");

	}

	@GetMapping(value = "/editemploy")
	public ModelAndView editEmploy(ModelAndView model, HttpServletRequest req, @RequestParam("empId") String empId) {
		List<Employ> listEmploy = null;
		Employ employ = new Employ();
		
		listEmploy = employService.searchEmploy(empId);
		LOG.info("Employ object -------> " + listEmploy.get(0));
		employ = (Employ) listEmploy.get(0);
		model.addObject("employ", employ);
		model.setViewName("UpdateEmploy");
		return model;

	}

	@PostMapping(value = "/updateEmploy")
	public ModelAndView UpdateEmploy(@ModelAttribute("employ") Employ employ) {
		employService.updateEmploy(employ);
		return new ModelAndView("redirect:/searchemploy");

	}
	
	@GetMapping(value = "/adminEditemploy")
	public ModelAndView AdminEditEmploy(ModelAndView model, HttpServletRequest req, @RequestParam("empId") String empId) {
		List<Employ> listEmploy = null;
		Employ employ = new Employ();
		
		listEmploy = employService.searchEmploy(empId);
		LOG.info("Employ object -------> " + listEmploy.get(0).getEmpId());
		employ = (Employ) listEmploy.get(0);
		model.addObject("employ", employ);
		model.setViewName("AdminUpdate");
		return model;

	}
	
	@PostMapping(value = "/adminUpdateEmploy")
	public ModelAndView AdminUpdateEmploy(@ModelAttribute("employ") Employ employ) {
		employService.updateEmploy(employ);
		ModelAndView model=new ModelAndView();
		List<Employ> listEmploy = null;
		listEmploy = employService.getAllEmployes();
		model.addObject("listEmploy", listEmploy);
		model.setViewName("Admin");
		return model;

	}


	@GetMapping("/allEmployees")
	public String viewAllToDoItems(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("listEmploy", employService.getActiveEmploy());
		model.addAttribute("message", message);

		return "ResultsPage";
	}

	@PostMapping(value = "/logout")
	public ModelAndView logout(ModelAndView model) {
		return new ModelAndView("redirect:/login");

	}

	@PostMapping(value="/closeEmpSearch")
	public ModelAndView closeSearch(ModelAndView model){
		return new ModelAndView("redirect:/login");
	}

	@PostMapping(value = "/closeEmpResults")
	public ModelAndView closeResults(ModelAndView model) {
		return new ModelAndView("redirect:/searchemploy");

	}
}
