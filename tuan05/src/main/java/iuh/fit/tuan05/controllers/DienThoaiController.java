package iuh.fit.tuan05.controllers;

import iuh.fit.tuan05.daos.DienThoaiDAO;
import iuh.fit.tuan05.daos.Impl.DienThoaiDAOImpl;
import iuh.fit.tuan05.daos.Impl.NhaCungCapDAOImpl;
import iuh.fit.tuan05.daos.NhaCungCapDAO;
import iuh.fit.tuan05.entities.DienThoai;
import iuh.fit.tuan05.entities.NhaCungCap;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "phones", urlPatterns = {"/phones", "/phones*"})
@MultipartConfig( // 👈 thêm dòng này
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,  // 10 MB
        maxRequestSize = 1024 * 1024 * 50 // 50 MB
)
public class DienThoaiController extends HttpServlet {
    private DienThoaiDAO dienThoaiDAO;
    private NhaCungCapDAO nhaCungCapDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choose = req.getParameter("choose");
        String page = "";
        nhaCungCapDAO = new NhaCungCapDAOImpl();
        dienThoaiDAO = new DienThoaiDAOImpl();
        List<DienThoai> dienThoais = dienThoaiDAO.getAll();
        if (choose == null || choose.equals("list")) {

            req.setAttribute("phones", dienThoais);
            page = "views/phones/list.jsp";
        } else if (choose.equals("add")) {
            req.setAttribute("suppliers", nhaCungCapDAO.getAll());
            page = "views/phones/add.jsp";
        } else if (choose.equals("management")) {
            req.setAttribute("phones", dienThoais);
            page = "views/phones/management.jsp";
        } else if (choose.equals("update")) {
            req.setAttribute("suppliers", nhaCungCapDAO.getAll());
            DienThoai dienThoai = dienThoaiDAO.getDienThoaiById(Integer.parseInt( req.getParameter("maDt")));
            req.setAttribute("phone", dienThoai);
            page = "views/phones/update.jsp";
        } else if (choose.equals("delete")) {
            dienThoaiDAO.remove(Integer.parseInt(req.getParameter("maDt")));
            List<DienThoai> dienThoaiList = dienThoaiDAO.getAll();
            req.setAttribute("phones", dienThoaiList);
            page = "views/phones/management.jsp";
        }else {
            page = "views/phones/list.jsp";
        }
        req.setAttribute("page", page);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");




        // Lấy action để biết là 'add' hay 'update'
        String action = req.getParameter("action");

        // 1. Lấy các field text
        String maDtStr = req.getParameter("maDt");
        String tenDt = req.getParameter("tenDt");
        String namSanXuat = req.getParameter("namSanXuat");
        String cauHinh = req.getParameter("cauHinh");
        String maNcc = req.getParameter("maNcc");
        String hinhAnhCu = req.getParameter("hinhAnhCu"); // Lấy tên ảnh cũ từ trường hidden

        // 2. Xử lý file upload
        Part filePart = req.getPart("hinhAnh");
        String newFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        String finalFileName;
        boolean hasNewFile = newFileName != null && !newFileName.isEmpty();

        if (hasNewFile) {
            // Nếu có file mới được tải lên, dùng tên file mới
            finalFileName = newFileName;
        } else {
            // Nếu không, giữ lại tên file cũ
            finalFileName = hinhAnhCu;
        }

        Map<String, String> errors = new HashMap<>();

        // 3. Tạo entity để Bean Validation check
        NhaCungCap nhaCungCap = new NhaCungCap();
        if (maNcc != null && !maNcc.isEmpty()) {
            nhaCungCap.setMaNcc(Integer.parseInt(maNcc));
        }

        DienThoai dt;
        if ("add".equals(action)) {
            dt = new DienThoai(tenDt, namSanXuat, cauHinh, finalFileName, nhaCungCap);
        } else { // "update"
            int maDt = Integer.parseInt(maDtStr);
            dt = new DienThoai(maDt, tenDt, namSanXuat, cauHinh, finalFileName, nhaCungCap);
        }


        // 4. Validate với Bean Validation
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<DienThoai>> violations = validator.validate(dt);

        for (ConstraintViolation<DienThoai> violation : violations) {
            String field = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(field, message);
        }

        // 5. Nếu có lỗi thì trả về form tương ứng
        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            nhaCungCapDAO = new NhaCungCapDAOImpl();
            req.setAttribute("suppliers", nhaCungCapDAO.getAll());

            String page;
            if ("update".equals(action)) {
                // Nếu là update lỗi, phải gửi lại đối tượng 'phone' để điền form
                req.setAttribute("phone", dt);
                page = "views/phones/update.jsp";
            } else {
                page = "views/phones/add.jsp";
            }

            req.setAttribute("page", page);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }

        // 6. Nếu hợp lệ VÀ có file mới được upload => lưu file
        if (hasNewFile) {
            // Đường dẫn tới thư mục target (runtime server)
            String uploadPathTarget = req.getServletContext().getRealPath("/images");
            File targetDir = new File(uploadPathTarget);
            if (!targetDir.exists()) targetDir.mkdirs();

            // Đường dẫn tới thư mục src (source code) - Cẩn thận với đường dẫn tuyệt đối
            File srcDir = new File("D:\\IUH\\ky8\\javaWWW\\JavaWWW\\tuan05\\src\\main\\webapp\\images");
            if (!srcDir.exists()) srcDir.mkdirs();

            try (InputStream inputStream = filePart.getInputStream()) {
                Files.copy(inputStream,
                        Paths.get(targetDir.getAbsolutePath(), finalFileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }

            try (InputStream inputStream = filePart.getInputStream()) {
                Files.copy(inputStream,
                        Paths.get(srcDir.getAbsolutePath(), finalFileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }


        // 7. Lưu vào database
        dienThoaiDAO = new DienThoaiDAOImpl();
        if ("add".equals(action)) {
            dienThoaiDAO.add(dt);
            resp.sendRedirect("phones?choose=list");
        } else { // "update"
            dienThoaiDAO.update(dt);
            resp.sendRedirect("phones?choose=management");
        }


    }


}
