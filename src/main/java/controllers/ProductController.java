package controllers;

import entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/list")
    public String index() {
        return "list";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("img") File file) {
        try {
            String rootPath = "D:\\CodeGym\\Practice\\Java\\Module4\\UploadFileDemo\\src\\main\\webapp\\files";
            File dir = new File(rootPath + File.separator + "tmpFiles");
            if (!dir.exists())
                dir.mkdirs();

            File serverFile = new File(dir.getAbsolutePath()
                    + File.separator + file.getName());
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return "redirect:/";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product, Model model) {
        return "";
    }
}
