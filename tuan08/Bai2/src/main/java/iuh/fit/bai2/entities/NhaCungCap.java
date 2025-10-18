package iuh.fit.bai2.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maNcc;
    private String tenNcc;
    private String diaChi;
    private String soDienThoai;

    @OneToMany(mappedBy = "nhaCungCap")
    private List<DienThoai> dienThoais;
}
