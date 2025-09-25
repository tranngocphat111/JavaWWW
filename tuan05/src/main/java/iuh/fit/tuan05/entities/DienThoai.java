package iuh.fit.tuan05.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDt;

    @NotBlank(message = "Tên điện thoại bắt buộc nhập")
    private String tenDt;

    @NotNull(message = "Năm sản xuất bắt buộc nhập")
    @Pattern(regexp = "\\d{4}", message = "Năm sản xuất phải là số nguyên 4 chữ số")
    private String namSanXuat;

    @NotBlank(message = "Cấu hình bắt buộc nhập")
    @Pattern(regexp = "^.{1,255}$", message = "Thông tin cấu hình không vượt quá 255 ký tự")
    private String cauHinh;

    @NotBlank(message = "Hình ảnh bắt buộc nhập")
    @Pattern(regexp = "([^\\s]+(\\.(?i)(png|jpg|jpeg))$)",
            message = "Chỉ chấp nhận định dạng ảnh: png, jpg, jpeg")
    private String hinhAnh;

    public DienThoai(String tenDt, String namSanXuat, String cauHinh, String hinhAnh, NhaCungCap nhaCungCap) {
        this.tenDt = tenDt;
        this.namSanXuat = namSanXuat;
        this.cauHinh = cauHinh;
        this.hinhAnh = hinhAnh;
        this.nhaCungCap = nhaCungCap;
    }

    @ManyToOne
    @JoinColumn(name = "maNcc")
    private NhaCungCap nhaCungCap;

}
