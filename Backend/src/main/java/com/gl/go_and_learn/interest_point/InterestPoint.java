package com.gl.go_and_learn.interest_point;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stroll_TO")
public class InterestPoint {
    @Id
    @Column(name = "_id", unique = true)
    private Integer _id;
    private String neighbourhood;
    private Integer neighbourhood_num;
    private String ward;
    private String ward_name;
    private String _order;
    private String title;
    private String address;
    private String description;
    private String link_url;
    private String _geometry;

    public InterestPoint() {
    }

    public InterestPoint(Integer _id) {
        this._id = _id;
    }

    public InterestPoint(Integer _id, String neighbourhood, Integer neighbourhood_num, String ward, String ward_name, String _order, String title, String address, String description, String link_url, String _geometry) {
        this._id = _id;
        this.neighbourhood = neighbourhood;
        this.neighbourhood_num = neighbourhood_num;
        this.ward = ward;
        this.ward_name = ward_name;
        this._order = _order;
        this.title = title;
        this.address = address;
        this.description = description;
        this.link_url = link_url;
        this._geometry = _geometry;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public Integer getNeighbourhood_num() {
        return neighbourhood_num;
    }

    public void setNeighbourhood_num(Integer neighbourhood_num) {
        this.neighbourhood_num = neighbourhood_num;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getWard_name() {
        return ward_name;
    }

    public void setWard_name(String ward_name) {
        this.ward_name = ward_name;
    }

    public String get_order() {
        return _order;
    }

    public void set_order(String _order) {
        this._order = _order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public String get_geometry() {
        return _geometry;
    }

    public void set_geometry(String _geometry) {
        this._geometry = _geometry;
    }
}
