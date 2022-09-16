package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HOANG SON
 */
public class DienThoai {
    private Long id;
    private String tenMay;
    private Integer hang;
    private Float gia;

    public DienThoai() {
    }

    public DienThoai(Long id, String tenMay, Integer hang, Float gia) {
        this.id = id;
        this.tenMay = tenMay;
        this.hang = hang;
        this.gia = gia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public Integer getHang() {
        return hang;
    }

    public void setHang(Integer hang) {
        this.hang = hang;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public String getTT(){
        if (gia >= 3000) {
            return "Tốt";
        }
        return "Bình thường";
    }
}
