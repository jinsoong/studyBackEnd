package jins.studyBackend.controller.main;

import jins.studyBackend.service.MainService;
import jins.studyBackend.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/getUser")
    public Object getUser() {
        System.out.println("getUser do");
        return mainService.getUser();
    }

    // @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}) 도 사용가능
    @PostMapping(path = "/regiUser", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Object regiUser(MemberVO memberVO){

        mainService.regiUser(memberVO);
        return mainService.getUser();
    }

    @PostMapping(path = "/regiUser2", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Object regiUser2(@RequestBody MemberVO memberVO){

        mainService.regiUser(memberVO);
        return mainService.getUser();
    }

    @PutMapping("updateUser")
    public Object updateUser(MemberVO memberVO){
        try{
            mainService.updateUser(memberVO);
        }catch (Exception e){
            e.printStackTrace();;
        }
        return mainService.getUser();
    }

    @PutMapping("/updateUser2/{id}")
    public Object updateUser2(@PathVariable long id, @RequestBody MemberVO memberVO){
        try{
            mainService.updateUser2(id, memberVO);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mainService.getUser();
    }

    @GetMapping("/getUserOne/{id}")
    public Object getUserOne(@PathVariable long id) {
        System.out.println("getUserOne do");
        return mainService.getUserOne(id);
    }

    @DeleteMapping("/delUser/{id}")
    public Object delUser(@PathVariable long id){
        mainService.delUser(id);
        return mainService.getUser();
    }

}
