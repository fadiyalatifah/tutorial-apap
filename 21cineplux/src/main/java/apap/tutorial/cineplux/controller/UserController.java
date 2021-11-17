package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping("/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/viewall")
    public String listUser(Model model){
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable String username, Model model) {
        UserModel user = userService.getUserByUsername(username);
        userService.deleteUser(user);
        model.addAttribute("user", user);
        return "redirect:/user/viewall";
    }

    @RequestMapping(value = "/update-password", method = RequestMethod.GET)
    private String updatePasswordForm(Model model){
        model.addAttribute("text", "");
        return "form-update-password";
    }

    @RequestMapping(value = "/update-password", method = RequestMethod.POST)
    private String updatePasswordSubmit(@RequestParam String oldPass, String newPass, String confirmPass, String username, Model model){
        UserModel user = userService.getUserByUsername(username);
        if(userService.checkMatch(oldPass, user.getPassword())){
            if(newPass.equals(confirmPass)){
                userService.updatePassword(user, newPass);
                model.addAttribute("pesan","Password berhasil diubah");
            }
            else{
                model.addAttribute("pesan", "Password baru yang dimasukkan tidak sesuai");
            }
        }
        else{
            model.addAttribute("pesan", "Password lama yang dimasukkan salah");
        }
        return "form-update-password";
    }



}