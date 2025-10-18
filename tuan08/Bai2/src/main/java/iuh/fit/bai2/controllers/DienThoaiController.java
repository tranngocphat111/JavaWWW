package iuh.fit.bai2.controllers;
import iuh.fit.bai2.entities.DienThoai;
import iuh.fit.bai2.entities.NhaCungCap;
import iuh.fit.bai2.services.DienThoaiService;
import iuh.fit.bai2.services.NhaCungCapService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class DienThoaiController {

    private DienThoaiService dienThoaiService;
    private NhaCungCapService nhaCungCapService;

    public DienThoaiController(DienThoaiService dienThoaiService, NhaCungCapService nhaCungCapService){
        this.dienThoaiService = dienThoaiService;
        this.nhaCungCapService = nhaCungCapService;
    }

    @GetMapping
    public String list(Model model) {
        List<DienThoai> list = dienThoaiService.getAll();
        model.addAttribute("phones", list);
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("phone", new DienThoai());
        model.addAttribute("suppliers", nhaCungCapService.getAll());
        return "add";
    }

    @PostMapping("/add")
    public String addPhone(@ModelAttribute("phone") DienThoai phone,
                           @RequestParam("file") MultipartFile file) {
//        dienThoaiService.add(phone, file);
        return "redirect:/";
    }

    @GetMapping("/management")
    public String admin(Model model) {
        List<DienThoai> list = dienThoaiService.getAll();
        model.addAttribute("phones", list);
        return "management";
    }



    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        DienThoai dt = dienThoaiService.getDienThoaiById(id);
        model.addAttribute("phone", dt);
        model.addAttribute("suppliers", nhaCungCapService.getAll());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("phone") @Valid DienThoai dt,
                         BindingResult result,
                         @RequestParam("file") MultipartFile file,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("suppliers", nhaCungCapService.getAll());
            return "update";
        }
//        dienThoaiService.update(dt, file);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        dienThoaiService.remove(id);
        return "redirect:/";
    }
}
