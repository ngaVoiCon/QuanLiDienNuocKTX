package lamviec;

import chay.TrangChu;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import lop.NhanVien;

public class LamViecNhanVien {
	public static Scene lamViecNhanVien(Stage stage, NhanVien nhanVien) throws Exception {

		BorderPane bp = new BorderPane();
		MenuBar leftBar = new MenuBar();
		MenuBar rightBar = new MenuBar();
		Menu mTaiKhoan = new Menu("Tai khoan");

		MenuItem miThongTin = new MenuItem("Thong tin");
		Menu mCapNhat = new Menu("Cap nhat");
		MenuItem miDoiMatKhau = new MenuItem("Mat khau");
		MenuItem miDoiSoDienThoai = new MenuItem("So dien thoai");
		MenuItem miDoiDiaChi = new MenuItem("Dia chi");

		mCapNhat.getItems().addAll(miDoiMatKhau, miDoiSoDienThoai, miDoiDiaChi);

		MenuItem miDangXuat = new MenuItem("Dang xuat");
		mTaiKhoan.getItems().addAll(miThongTin, mCapNhat, miDangXuat);
		rightBar.getMenus().addAll(mTaiKhoan);
		rightBar.getStyleClass().add("MenuBar");
		Region spacer1 = new Region();
		spacer1.getStyleClass().add("MenuBar");
		HBox.setHgrow(spacer1, Priority.SOMETIMES);
		Region spacer2 = new Region();
		spacer2.getStyleClass().add("MenuBar");
		HBox menubars = new HBox(leftBar, spacer1, rightBar, spacer2);
		bp.setTop(menubars);

		miThongTin.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(ChucNangNhanVien.thongTin(nhanVien));
			}

		});

		miDoiMatKhau.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(ChucNangNhanVien.doiMatKhau(nhanVien));
			}

		});

		miDoiSoDienThoai.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(ChucNangNhanVien.doiSoDienThoai(nhanVien));
			}

		});

		miDoiDiaChi.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(ChucNangNhanVien.doiDiaChi(nhanVien));
			}

		});

		miDangXuat.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				try {
					TrangChu.trangChu(stage);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}

		});

		ListView<String> lv = new ListView<>();
		lv.setPrefWidth(170);
		ObservableList<String> i = FXCollections.observableArrayList("Nhap luong su dung nuoc cua cac phong",
				"Nhap luong su dung dien cua cac phong", "Xem thong tin cua cac truong phong", "Xem luong cua minh");
		lv.setItems(i);
		bp.setLeft(lv);

		lv.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {
			public void changed(ObservableValue<? extends Object> object, Object oldValue, Object newValue) {
				if ("0".equals(newValue.toString())) {
					bp.setCenter(ChucNangNhanVien.nhapLuongDungNuoc());
				}
				if ("1".equals(newValue.toString())) {
					bp.setCenter(ChucNangNhanVien.nhapLuongDungDien());

				}
				if ("2".equals(newValue.toString())) {
					bp.setCenter(ChucNangNhanVien.xemTruongPhong());

				}
				if ("3".equals(newValue.toString())) {
					bp.setCenter(ChucNangNhanVien.xemLuong(nhanVien));

				}

			}

		});

		lv.getSelectionModel().selectFirst();
		lv.getStyleClass().add("ListView");
		
		Scene scene = new Scene(bp);
		scene.getStylesheets().add("style.css");
		stage.setScene(scene);
		stage.setFullScreen(true);
		bp.getStyleClass().add("Root");
		return scene;
	}
}
