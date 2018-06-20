package com.example.poonamiyer.pharmeasyassessment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Poonam Iyer on 6/19/2018.
 */

public class UserList {

    @SerializedName("page")
    @Expose
    protected Integer page;
    @SerializedName("per_page")
    @Expose
    protected Integer perPage;
    @SerializedName("total")
    @Expose
    protected Integer total;
    @SerializedName("total_pages")
    @Expose
    protected Integer totalPages;
    @SerializedName("data")
    @Expose
    protected List<User> data = null;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

}
