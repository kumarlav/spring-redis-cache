package com.lk.dto;

public class EmployeeDTO {
    private long serialVersionUID;
    private Integer id;
    private String empName;
    private Double empSal;

    public EmployeeDTO() {
    }

    public void setSerialVersionUID(long serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpName() {
        return this.empName;
    }

    public void setEmpSal(Double empSal) {
        this.empSal = empSal;
    }

    public Double getEmpSal() {
        return this.empSal;
    }
}