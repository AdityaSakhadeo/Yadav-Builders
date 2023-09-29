package com.example.yybuilders;

public class workDetails {

    public String work_description;
    public String raw_material;

    public String raw_expense;
    public String raw_quan;
    public String additional_work;
    public String additional_cost;
    public String additional_quan;


    public workDetails(String work_description, String raw_material, String raw_expense,String raw_quan, String additional_work, String additional_cost,String additional_quan) {
        this.work_description = work_description;
        this.raw_material = raw_material;
        this.raw_expense = raw_expense;
        this.raw_quan = raw_quan;
        this.additional_work = additional_work;
        this.additional_cost = additional_cost;
        this.additional_quan = additional_quan;
    }

    public workDetails()
    {}


    public String getWork_description() {
        return work_description;
    }

    public void setWork_description(String work_description) {
        this.work_description = work_description;
    }

    public String getRaw_material() {
        return raw_material;
    }

    public void setRaw_material(String raw_material) {
        this.raw_material = raw_material;
    }
    public String getRaw_expense() {
        return raw_expense;
    }

    public void setRaw_expense(String raw_expense) {
        this.raw_expense = raw_expense;
    }

    public String getAdditional_work() {
        return additional_work;
    }

    public void setAdditional_work(String additional_work) {
        this.additional_work = additional_work;
    }

    public String getAdditional_cost() {
        return additional_cost;
    }

    public void setAdditional_cost(String additional_cost) {
        this.additional_cost = additional_cost;
    }

    public String getRaw_quan() {
        return raw_quan;
    }

    public void setRaw_quan(String raw_quan) {
        this.raw_quan = raw_quan;
    }

    public String getAdditional_quan() {
        return additional_quan;
    }

    public void setAdditional_quan(String additional_quan) {
        this.additional_quan = additional_quan;
    }


}
