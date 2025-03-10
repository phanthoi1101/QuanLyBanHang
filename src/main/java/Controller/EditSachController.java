package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import SachModal.Sach;
import SachModal.SachBo;

/**
 * Servlet implementation class EditSachController
 */
@WebServlet("/EditSachController")
public class EditSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//upload file
		SachBo sachBo = new SachBo();
		 DiskFileItemFactory factory = new DiskFileItemFactory();
		 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		 String anh="", maSach="", maLoai ="", tenSach = "",soTap="",tacGia=""; long soLuong = 0, gia=0;
		
		 try {
				List<FileItem> fileItems = upload.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					 if (!fileItem.isFormField()) {
						 String nameimg = fileItem.getName();
						 anh = "image_sach/"+nameimg;
						 if (!nameimg.equals("")) {
							 String dirUrl = request.getServletContext().getRealPath("") +  File.separator + "image_sach";
								File dir = new File(dirUrl);
								if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
									dir.mkdir();
								}
								String fileImg = dirUrl + File.separator + nameimg;
								File file = new File(fileImg);
								try {
						               fileItem.write(file);//lưu file
						              System.out.println("UPLOAD THÀNH CÔNG...!");
						              System.out.println("Đường dẫn lưu file là: "+dirUrl);
						 } catch (Exception e) {
						    e.printStackTrace();
						}
						 }
					 }else//Neu la control
					 	{
							String tentk=fileItem.getFieldName();
							if(tentk.equals("masach"))
								maSach = fileItem.getString();
							if(tentk.equals("maloai"))
								maLoai = fileItem.getString();
							if(tentk.equals("tensach"))
								tenSach = fileItem.getString();
							if(tentk.equals("soluong"))
								soLuong = Long.parseLong(fileItem.getString());
							if(tentk.equals("gia"))
								gia = Long.parseLong(fileItem.getString());
							if(tentk.equals("sotap"))
								soTap = fileItem.getString();
							if(tentk.equals("tacgia"))
								tacGia = fileItem.getString();
						}
					} 
				}catch (Exception e) {
				e.printStackTrace();
			}	
		 System.out.println(anh +tenSach+maLoai );
//		 if(maSach!="" && maLoai !="" && tenSach!="" && soLuong!=0 && gia!=0 && soTap!=""&&tacGia!=""&&anh!="") {
				Sach sach = new Sach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai);
				sachBo.UpdateSach(sach);
				session.setAttribute("checkLoiEdit", 1);
//			}
//			else{
//				session.setAttribute("checkLoiEdit", 0);
//			}
			RequestDispatcher rd = request.getRequestDispatcher("TrangChuAdmin.jsp");
			rd.forward(request, response);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
