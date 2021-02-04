package com.hao.file.controller;

import com.hao.commont.base.web.ControllerUtils;
import com.hao.commont.util.date.DateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @Description:
 * @Company:
 * @version: 1.0
 * @date 2021/2/4 - 17:40
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/saveimage")
    public Map<String, Object> saveImage(HttpServletRequest request, RedirectAttributes redirectAttributes, String module, @RequestParam("file") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            // 获取目标文件夹
            String urlPath = "/uploadfiles/" + module + "/" + DateUtils.getNowDate("yyyy-MM-dd") + "/";
            String path = request.getSession().getServletContext().getRealPath(urlPath);
            File filePath = new File(path);
            System.out.println("path:" + path);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }

            // 获取用户上传的源文件名
            String fileName = file.getOriginalFilename();

            String fileExt = fileName.lastIndexOf(".") > 0 ? fileName.substring(fileName.lastIndexOf(".") + 1) : null;
            String newFileName = DateUtils.getNowDate("yyyyMMddHHmmss") + System.currentTimeMillis() + (fileExt == null ? "" : ("." + fileExt));
            // 新建文件
            File file1 = new File(filePath, newFileName);

            // 将文件写入
            file.transferTo(file1);

            return ControllerUtils.dealResult(true, urlPath + newFileName);

        }
        return ControllerUtils.dealResult(false, "无上传文件");
    }

}
