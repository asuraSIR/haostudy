package com.hao.file.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Company:
 * @version: 1.0
 * @date 2021/2/4 - 17:20
 */

@Entity
@Table(name = "file")
public class File implements Serializable {
    /** 主键 */
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", unique = true, nullable = false)
    private String id;


    /** 文件路径 */
    @Column(name = "FILE_URL")
    private String fileUrl;

    /** 入库时间 */
    @Column(name = "INPUT_DATE")
    private Date inputDate;

    /** 文件类型 */
    @Column(name = "FILE_TYPE")
    private String fileType;

    /** 文件名称 */
    @Column(name = "FILE_NAME")
    private String fileName;

    /** 文件扩展名 */
    @Column(name = "FILE_EXT")
    private String fileExt;

    /** 文件大小 */
    @Column(name = "FILE_SIZE")
    private Long fileSize;

    public File() {
    }

    public File(String id, String fileUrl, Date inputDate, String fileType, String fileName, String fileExt, Long fileSize) {
        this.id = id;
        this.fileUrl = fileUrl;
        this.inputDate = inputDate;
        this.fileType = fileType;
        this.fileName = fileName;
        this.fileExt = fileExt;
        this.fileSize = fileSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}
