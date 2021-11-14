package com.example.anglesea;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AngleseaAPI  {

    @GET("staffs")
    Call<List<StaffData>> getStaffData();


}
