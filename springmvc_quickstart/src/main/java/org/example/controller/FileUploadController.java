package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * @author: ymm
 * @date: 2022/8/13
 * @version: 1.0.0l
 * @description:
 */
@Controller
public class FileUploadController {

    /**
     * 单文件上传
     *
     * @return
     */
    @PostMapping("/fileupload")
    public String fileupload(String username, MultipartFile filePic) throws IOException {
        // 获取表单提交参数，完成文件上传
        System.out.println("username = " + username);
        String originalFilename = filePic.getOriginalFilename(); // 原始文件名
        filePic.transferTo(new File("f:/upload/" + originalFilename));
        return "success";
    }

    /**
     * 多文件上传
     * @param username
     * @param filePics
     * @return
     * @throws IOException
     */
    @PostMapping("/filesupload")
    public String filesupload(String username, MultipartFile[] filePics) throws IOException {
        // 获取表单提交参数，完成文件上传
        System.out.println("username = " + username);

        for (MultipartFile filePic : filePics) {
            String originalFilename = filePic.getOriginalFilename(); // 原始文件名
            filePic.transferTo(new File("f:/upload/" + originalFilename));
        }


        return "success";
    }
}
