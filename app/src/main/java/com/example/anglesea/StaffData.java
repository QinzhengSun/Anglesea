package com.example.anglesea;

public class StaffData {
    private int id;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String[] shifts;
    private String role;
    private Integer staff_id;

    //get method


    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String[] getShifts() {
        return shifts;
    }

    public String getRole() {
        return role;
    }

    public Integer getStaff_id() {
        return staff_id;
    }
}
