package trangchu;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lamviec.LamViecChu;
import lamviec.LamViecNhanVien;
import lamviec.LamViecTruongPhong;
import laydulieu.ILayDuLieu;
import laydulieu.LayDuLieu;
import lop.Chu;
import lop.NhanVien;
import lop.TruongPhong;

public class DangNhap {

	static ILayDuLieu chucNang = new LayDuLieu();

	public static GridPane dangNhapChu(Stage stage, Scene scene, BorderPane bp, VBox vb) {
		GridPane gp = new GridPane();
		gp.setHgap(15);
		gp.setVgap(10);
		gp.getStyleClass().add("grid");
		gp.setPadding(new Insets(15, 15, 15, 15));

		Label lTenChucNang = new Label("Dang nhap chu");
		GridPane.setConstraints(lTenChucNang, 0, 1, 2, 1, HPos.CENTER, VPos.BASELINE);
		gp.add(lTenChucNang, 0, 1);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		Label lTenDangNhap = new Label("Ten dang nhap");
		gp.add(lTenDangNhap, 0, 2);

		TextField tfTenDangNhap = new TextField();
		gp.add(tfTenDangNhap, 1, 2);
		tfTenDangNhap.setPrefWidth(230);

		Label lMatKhau = new Label("Mat khau");
		gp.add(lMatKhau, 0, 3);

		PasswordField pfMatKhau = new PasswordField();
		gp.add(pfMatKhau, 1, 3);

		pfMatKhau.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {

				Chu chu = chucNang.getChu(tfTenDangNhap.getText(), pfMatKhau.getText(), "");
				if (keyEvent.getCode() == KeyCode.ENTER)

					if (chu != null)
						try {
							stage.setScene(LamViecChu.lamViecChu(stage, chu));
						} catch (Exception e) {
							e.printStackTrace();
						}

					else {
						pfMatKhau.clear();
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Loi dang nhap");
						alert.setHeaderText(null);
						alert.setContentText("Ten dang nhap hoac mat khau khong chinh xac. Nhap lai!");
						alert.showAndWait();
					}
			}
		});

		Image iXacNhan = new Image("/next.png");
		Button bXacNhan = new Button("Xac nhan", new ImageView(iXacNhan));
		gp.add(bXacNhan, 2, 4);
		GridPane.setConstraints(bXacNhan, 2, 4, 2, 1, HPos.RIGHT, VPos.BASELINE);
		bXacNhan.getStyleClass().add("Button");

		bXacNhan.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {

				Chu chu = chucNang.getChu(tfTenDangNhap.getText(), pfMatKhau.getText(), "");
				if ("".equals(tfTenDangNhap.getText()) || "".equals(pfMatKhau.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Loi");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap ten dang nhap hoac mat khau");
					alert.showAndWait();
				} else if (chu != null)
					try {
						stage.setScene(LamViecChu.lamViecChu(stage, chu));
					} catch (Exception e) {
						e.printStackTrace();
					}

				else {
					pfMatKhau.clear();
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Loi dang nhap");
					alert.setHeaderText(null);
					alert.setContentText("Ten dang nhap hoac mat khau khong chinh xac. Nhap lai!");
					alert.showAndWait();
				}
			}
		});

		Image iQuayLai = new Image("/previous.png");
		Button bQuayLai = new Button("Quay lai", new ImageView(iQuayLai));
		gp.add(bQuayLai, 1, 4);
		GridPane.setConstraints(bQuayLai, 1, 4, 2, 1, HPos.LEFT, VPos.CENTER);
		bQuayLai.getStyleClass().add("Button");
		bQuayLai.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {

				bp.setCenter(vb);
			}
		});

		HBox hb = new HBox();
		hb.getChildren().addAll(bQuayLai, bXacNhan);
		hb.setSpacing(67);
		gp.add(hb, 1, 4);

		Label lQuenMatKhau = new Label("Quen mat khau ?");
		gp.add(lQuenMatKhau, 1, 6);
		lQuenMatKhau.setTextFill(Color.BLUE);
		GridPane.setConstraints(lQuenMatKhau, 1, 6, 2, 1, HPos.LEFT, VPos.CENTER);

		lQuenMatKhau.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {

				bp.setCenter(QuenMatKhau.quenMatKhauChu(bp, vb));
			}

		});

		gp.setAlignment(Pos.CENTER);

		return gp;
	}

	public static GridPane dangNhapTruongPhong(Stage stage, Scene scene, BorderPane bp, VBox vb) {
		GridPane gp = new GridPane();
		gp.setHgap(15);
		gp.setVgap(10);
		gp.getStyleClass().add("grid");
		gp.setPadding(new Insets(15, 15, 15, 15));

		Label lTenChucNang = new Label("Dang nhap truong phong");
		GridPane.setConstraints(lTenChucNang, 0, 1, 2, 1, HPos.CENTER, VPos.BASELINE);
		gp.add(lTenChucNang, 0, 1);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		Label lTenDangNhap = new Label("Ten dang nhap");
		gp.add(lTenDangNhap, 0, 2);

		TextField tfTenDangNhap = new TextField();
		gp.add(tfTenDangNhap, 1, 2);
		tfTenDangNhap.setPrefWidth(230);

		Label lMatKhau = new Label("Mat khau");
		gp.add(lMatKhau, 0, 3);

		PasswordField pfMatKhau = new PasswordField();
		gp.add(pfMatKhau, 1, 3);

		pfMatKhau.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				TruongPhong truongPhong = chucNang.getTruongPhong(tfTenDangNhap.getText(), pfMatKhau.getText(), "");
				if (keyEvent.getCode() == KeyCode.ENTER)
					if (truongPhong != null)
						try {
							stage.setScene(LamViecTruongPhong.lamViecTruongPhong(stage, truongPhong));
						} catch (Exception e) {
							e.printStackTrace();
						}

					else {
						pfMatKhau.clear();
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Loi dang nhap");
						alert.setHeaderText(null);
						alert.setContentText("Ten dang nhap hoac mat khau khong chinh xac. Nhap lai!");
						alert.showAndWait();
					}
			}
		});

		Image iXacNhan = new Image("/next.png");
		Button bXacNhan = new Button("Xac nhan", new ImageView(iXacNhan));
		gp.add(bXacNhan, 2, 4);
		GridPane.setConstraints(bXacNhan, 2, 4, 2, 1, HPos.RIGHT, VPos.BASELINE);
		bXacNhan.getStyleClass().add("Button");

		bXacNhan.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				TruongPhong truongPhong = chucNang.getTruongPhong(tfTenDangNhap.getText(), pfMatKhau.getText(), "");
				if ("".equals(tfTenDangNhap.getText()) || "".equals(pfMatKhau.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Loi");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap ten dang nhap hoac mat khau");
					alert.showAndWait();
				} else if (truongPhong != null)
					try {
						stage.setScene(LamViecTruongPhong.lamViecTruongPhong(stage, truongPhong));
					} catch (Exception e) {
						e.printStackTrace();
					}

				else {
					pfMatKhau.clear();
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Loi dang nhap");
					alert.setHeaderText(null);
					alert.setContentText("Ten dang nhap hoac mat khau khong chinh xac. Nhap lai!");
					alert.showAndWait();
				}
			}
		});

		Image iQuayLai = new Image("/previous.png");
		Button bQuayLai = new Button("Quay lai", new ImageView(iQuayLai));
		gp.add(bQuayLai, 1, 4);
		GridPane.setConstraints(bQuayLai, 1, 4, 2, 1, HPos.LEFT, VPos.CENTER);
		bQuayLai.getStyleClass().add("Button");
		bQuayLai.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {

				bp.setCenter(vb);
			}
		});

		HBox hb = new HBox();
		hb.getChildren().addAll(bQuayLai, bXacNhan);
		hb.setSpacing(67);
		gp.add(hb, 1, 4);

		Label lQuenMatKhau = new Label("Quen mat khau ?");
		gp.add(lQuenMatKhau, 1, 6);
		lQuenMatKhau.setTextFill(Color.BLUE);
		GridPane.setConstraints(lQuenMatKhau, 1, 6, 2, 1, HPos.LEFT, VPos.CENTER);

		lQuenMatKhau.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				bp.setCenter(QuenMatKhau.quenMatKhauTruongPhong(bp, vb));
			}

		});
		gp.setAlignment(Pos.CENTER);

		return gp;
	}

	public static GridPane dangNhapNhanVien(Stage stage, Scene scene, BorderPane bp, VBox vb) {
		GridPane gp = new GridPane();
		gp.setHgap(15);
		gp.setVgap(10);
		gp.getStyleClass().add("grid");
		gp.setPadding(new Insets(15, 15, 15, 15));

		Label lTenChucNang = new Label("Dang nhap Nhan Vien");
		GridPane.setConstraints(lTenChucNang, 0, 1, 2, 1, HPos.CENTER, VPos.BASELINE);
		gp.add(lTenChucNang, 0, 1);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		Label lTenDangNhap = new Label("Ten dang nhap");
		gp.add(lTenDangNhap, 0, 2);

		TextField tfTenDangNhap = new TextField();
		gp.add(tfTenDangNhap, 1, 2);
		tfTenDangNhap.setPrefWidth(230);

		Label lMatKhau = new Label("Mat khau");
		gp.add(lMatKhau, 0, 3);

		PasswordField pfMatKhau = new PasswordField();
		gp.add(pfMatKhau, 1, 3);

		pfMatKhau.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				NhanVien nhanVien = chucNang.getNhanVien(tfTenDangNhap.getText(), pfMatKhau.getText(), "");

				if (keyEvent.getCode() == KeyCode.ENTER)
					if (nhanVien != null)
						try {
							stage.setScene(LamViecNhanVien.lamViecNhanVien(stage, nhanVien));
						} catch (Exception e) {
							e.printStackTrace();
						}

					else {
						pfMatKhau.clear();
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Loi dang nhap");
						alert.setHeaderText(null);
						alert.setContentText("Ten dang nhap hoac mat khau khong chinh xac. Nhap lai!");
						alert.showAndWait();
					}
			}
		});

		Image iXacNhan = new Image("/next.png");
		Button bXacNhan = new Button("Xac nhan", new ImageView(iXacNhan));
		gp.add(bXacNhan, 2, 4);
		GridPane.setConstraints(bXacNhan, 2, 4, 2, 1, HPos.RIGHT, VPos.BASELINE);
		bXacNhan.getStyleClass().add("Button");

		bXacNhan.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				NhanVien nhanVien = chucNang.getNhanVien(tfTenDangNhap.getText(), pfMatKhau.getText(), "");

				if ("".equals(tfTenDangNhap.getText()) || "".equals(pfMatKhau.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Loi");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap ten dang nhap hoac mat khau");
					alert.showAndWait();
				} else if (nhanVien != null)
					try {
						stage.setScene(LamViecNhanVien.lamViecNhanVien(stage, nhanVien));
					} catch (Exception e) {
						e.printStackTrace();
					}

				else {
					pfMatKhau.clear();
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Loi dang nhap");
					alert.setHeaderText(null);
					alert.setContentText("Ten dang nhap hoac mat khau khong chinh xac. Nhap lai!");
					alert.showAndWait();
				}
			}
		});

		Image iQuayLai = new Image("/previous.png");
		Button bQuayLai = new Button("Quay lai", new ImageView(iQuayLai));
		gp.add(bQuayLai, 1, 4);
		GridPane.setConstraints(bQuayLai, 1, 4, 2, 1, HPos.LEFT, VPos.CENTER);
		bQuayLai.getStyleClass().add("Button");
		bQuayLai.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {

				bp.setCenter(vb);
			}
		});

		HBox hb = new HBox();
		hb.getChildren().addAll(bQuayLai, bXacNhan);
		hb.setSpacing(67);
		gp.add(hb, 1, 4);

		Label lQuenMatKhau = new Label("Quen mat khau ?");
		gp.add(lQuenMatKhau, 1, 6);
		lQuenMatKhau.setTextFill(Color.BLUE);
		GridPane.setConstraints(lQuenMatKhau, 1, 6, 2, 1, HPos.LEFT, VPos.CENTER);

		lQuenMatKhau.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				bp.setCenter(QuenMatKhau.quenMatKhauNhanVien(bp, vb));
			}

		});
		gp.setAlignment(Pos.CENTER);

		return gp;
	}

}
