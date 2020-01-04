package trangchu;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import laydulieu.ILayDuLieu;
import laydulieu.LayDuLieu;
import lop.Chu;
import lop.NhanVien;
import lop.TruongPhong;

public class QuenMatKhau {

	static ILayDuLieu chucNang = new LayDuLieu();

	public static GridPane quenMatKhauChu(BorderPane bp, VBox vb) {
		GridPane gp = new GridPane();
		gp.setHgap(25);
		gp.setVgap(20);
		gp.getStyleClass().add("grid");
		gp.setPadding(new Insets(15, 15, 15, 15));

		Label lTenChucNang = new Label("Quen mat khau chu");
		GridPane.setConstraints(lTenChucNang, 0, 0, 2, 1, HPos.CENTER, VPos.TOP);
		gp.add(lTenChucNang, 0, 0);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		Label lTenDangNhap = new Label("Ten dang nhap");
		gp.add(lTenDangNhap, 0, 1);
		lTenDangNhap.setPrefWidth(140);

		TextField tfTenDangNhap = new TextField();
		gp.add(tfTenDangNhap, 1, 1);
		tfTenDangNhap.setPrefWidth(140);

		Label lSoDienThoai = new Label("So dien thoai");
		gp.add(lSoDienThoai, 0, 2);

		TextField tfSoDienThoai = new TextField();
		gp.add(tfSoDienThoai, 1, 2);

		tfSoDienThoai.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() != KeyCode.BACK_SPACE && keyEvent.getCode() != KeyCode.TAB
						&& keyEvent.getCode() != KeyCode.LEFT && keyEvent.getCode() != KeyCode.RIGHT)

					try {
						Double.valueOf(keyEvent.getText());
					} catch (NumberFormatException ex) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Error");
						alert.setHeaderText(null);
						alert.setContentText("Vui long nhap so");
						alert.showAndWait();
					}
			}
		});

		Button bHoanThanh = new Button("Hoan thanh");
		gp.add(bHoanThanh, 1, 3);
		GridPane.setConstraints(bHoanThanh, 1, 3, 2, 1, HPos.RIGHT, VPos.BASELINE);
		bHoanThanh.getStyleClass().add("Button");

		bHoanThanh.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				Chu chu = chucNang.getChu(tfTenDangNhap.getText(), "", tfSoDienThoai.getText());
				if ("".equals(tfTenDangNhap.getText()) || "".equals(tfSoDienThoai.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Loi");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap ten dang nhap hoac mat khau");
					alert.showAndWait();
				} else if (chu != null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Quen mat khau");
					alert.setContentText("Mat khau cua ban la: " + chu.getPassword());
					alert.showAndWait();
					
				} else {
					tfSoDienThoai.clear();
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Loi dang nhap");
					alert.setHeaderText(null);
					alert.setContentText("Ten dang nhap hoac so dien thoai khong chinh xac. Nhap lai!");
					alert.showAndWait();
				}
			}
		});

		gp.setAlignment(Pos.CENTER);
		return gp;

	}

	public static GridPane quenMatKhauTruongPhong(BorderPane bp, VBox vb) {
		GridPane gp = new GridPane();
		gp.setHgap(25);
		gp.setVgap(20);
		gp.getStyleClass().add("grid");
		gp.setPadding(new Insets(15, 15, 15, 15));

		Label lTenChucNang = new Label("Quen mat khau truong phong");
		GridPane.setConstraints(lTenChucNang, 0, 0, 2, 1, HPos.CENTER, VPos.TOP);
		gp.add(lTenChucNang, 0, 0);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		Label lTenDangNhap = new Label("Ten dang nhap");
		gp.add(lTenDangNhap, 0, 1);
		lTenDangNhap.setPrefWidth(140);

		TextField tfTenDangNhap = new TextField();
		gp.add(tfTenDangNhap, 1, 1);
		tfTenDangNhap.setPrefWidth(140);

		Label lSoDienThoai = new Label("So dien thoai");
		gp.add(lSoDienThoai, 0, 2);

		TextField tfSoDienThoai = new TextField();
		gp.add(tfSoDienThoai, 1, 2);

		tfSoDienThoai.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() != KeyCode.BACK_SPACE && keyEvent.getCode() != KeyCode.TAB
						&& keyEvent.getCode() != KeyCode.LEFT && keyEvent.getCode() != KeyCode.RIGHT)

					try {
						Double.valueOf(keyEvent.getText());
					} catch (NumberFormatException ex) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Error");
						alert.setHeaderText(null);
						alert.setContentText("Vui long nhap so");
						alert.showAndWait();
					}
			}
		});

		Button bHoanThanh = new Button("Hoan thanh");
		gp.add(bHoanThanh, 1, 3);
		GridPane.setConstraints(bHoanThanh, 1, 3, 2, 1, HPos.RIGHT, VPos.BASELINE);
		bHoanThanh.getStyleClass().add("Button");

		bHoanThanh.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				TruongPhong truongPhong = chucNang.getTruongPhong(tfTenDangNhap.getText(), "", tfSoDienThoai.getText());
				if ("".equals(tfTenDangNhap.getText()) || "".equals(tfSoDienThoai.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Loi");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap ten dang nhap hoac mat khau");
					alert.showAndWait();
				} else if (truongPhong != null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Quen mat khau");
					alert.setContentText("Mat khau cua ban la: " + truongPhong.getPassword());
					alert.showAndWait();
					
				} else {
					tfSoDienThoai.clear();
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Loi dang nhap");
					alert.setHeaderText(null);
					alert.setContentText("Ten dang nhap hoac so dien thoai khong chinh xac. Nhap lai!");
					alert.showAndWait();
				}
			}
		});

		gp.setAlignment(Pos.CENTER);
		return gp;

	}

	public static GridPane quenMatKhauNhanVien(BorderPane bp, VBox vb) {
		GridPane gp = new GridPane();
		gp.setHgap(25);
		gp.setVgap(20);
		gp.getStyleClass().add("grid");
		gp.setPadding(new Insets(15, 15, 15, 15));

		Label lTenChucNang = new Label("Quen mat khau nhan vien");
		GridPane.setConstraints(lTenChucNang, 0, 0, 2, 1, HPos.CENTER, VPos.TOP);
		gp.add(lTenChucNang, 0, 0);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		Label lTenDangNhap = new Label("Ten dang nhap");
		gp.add(lTenDangNhap, 0, 1);
		lTenDangNhap.setPrefWidth(140);

		TextField tfTenDangNhap = new TextField();
		gp.add(tfTenDangNhap, 1, 1);
		tfTenDangNhap.setPrefWidth(140);

		Label lSoDienThoai = new Label("So dien thoai");
		gp.add(lSoDienThoai, 0, 2);

		TextField tfSoDienThoai = new TextField();
		gp.add(tfSoDienThoai, 1, 2);

		tfSoDienThoai.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() != KeyCode.BACK_SPACE && keyEvent.getCode() != KeyCode.TAB
						&& keyEvent.getCode() != KeyCode.LEFT && keyEvent.getCode() != KeyCode.RIGHT)

					try {
						Double.valueOf(keyEvent.getText());
					} catch (NumberFormatException ex) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Error");
						alert.setHeaderText(null);
						alert.setContentText("Vui long nhap so");
						alert.showAndWait();
					}
			}
		});

		Button bHoanThanh = new Button("Hoan thanh");
		gp.add(bHoanThanh, 1, 3);
		GridPane.setConstraints(bHoanThanh, 1, 3, 2, 1, HPos.RIGHT, VPos.BASELINE);
		bHoanThanh.getStyleClass().add("Button");

		bHoanThanh.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				NhanVien nhanVien = chucNang.getNhanVien(tfTenDangNhap.getText(), "", tfSoDienThoai.getText());
				if ("".equals(tfTenDangNhap.getText()) || "".equals(tfSoDienThoai.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Loi");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap ten dang nhap hoac mat khau");
					alert.showAndWait();
				} else if (nhanVien != null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Quen mat khau");
					alert.setContentText("Mat khau cua ban la: " + nhanVien.getPassword());
					alert.showAndWait();
					
				} else {
					tfSoDienThoai.clear();
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Loi dang nhap");
					alert.setHeaderText(null);
					alert.setContentText("Ten dang nhap hoac so dien thoai khong chinh xac. Nhap lai!");
					alert.showAndWait();
				}
			}
		});


		gp.setAlignment(Pos.CENTER);
		return gp;

	}
}
