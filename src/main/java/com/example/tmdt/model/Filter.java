package com.example.tmdt.model;

import com.example.tmdt.model.address.City;
import com.example.tmdt.model.address.District;
import com.example.tmdt.model.address.Wards;
import com.example.tmdt.model.fkProduct.Category;

public class Filter {
    private Double maxPrice;
    private Double minPrice;
    private Category category;
    private Wards wards;
    private District district;
    private City city;

    public Filter(Double maxPrice, Double minPrice, Category category, Wards wards, District district, City city) {
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.category = category;
        this.wards = wards;
        this.district = district;
        this.city = city;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Wards getWards() {
        return wards;
    }

    public void setWards(Wards wards) {
        this.wards = wards;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
