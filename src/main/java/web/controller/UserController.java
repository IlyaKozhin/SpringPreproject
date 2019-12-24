package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String modifyUsers(ModelMap modelMap) {
        List<User> users = userService.listUsers();
        modelMap.addAttribute("users", users);
        return "users";
    }
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String deleteUser(HttpServletRequest request){
		String string = request.getParameter("update");

		Long id = Long.parseLong(string.substring(3));
		userService.delete(id);
		return "redirect:/users";

	}
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request){
		String name = request.getParameter("nameToAdd");
		String password = request.getParameter("passwordToAdd");
		String role = request.getParameter("roleToAdd");
		if(role=="") {
			role = "user";
		}
		userService.add(new User(name, password,role));
		return "redirect:/users";

	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request){
		String string = request.getParameter("update");

		Long id = Long.parseLong(string.substring(3));
		String name = request.getParameter("name" + id);
		String password = request.getParameter("password" + id);
		String role = request.getParameter("role" + id);
		userService.update(new User(id, name, password,role));
		return "redirect:/users";
	}
}