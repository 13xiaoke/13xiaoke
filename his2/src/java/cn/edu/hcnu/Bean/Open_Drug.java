/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.hcnu.Bean;

/**
 *
 * @author Administrator
 */
public class Open_Drug {

    private String drugID;
    private String drugname; 
    private String spec;
    private String date;
    private String drug_number;
    private String open_number;

    public String getDrugID() {
        return drugID;
    }

    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDrug_number() {
        return drug_number;
    }

    public void setDrug_number(String drug_number) {
        this.drug_number = drug_number;
    }

    public String getOpen_number() {
        return open_number;
    }

    public void setOpen_number(String open_number) {
        this.open_number = open_number;
    }

    public String getWays() {
        return ways;
    }

    public void setWays(String ways) {
        this.ways = ways;
    }
    private String ways;
}
