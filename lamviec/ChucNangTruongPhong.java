package lamviec;

import java.sql.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import laydulieu.ILayDuLieu;
import laydulieu.LayDuLieu;
import lop.Dung;
import lop.NhanVien;
import lop.TruongPhong;

public class ChucNangTruongPhong {
	static ILayDuLieu chucNang = new LayDuLieu();

	public static VBox thongTin(TruongPhong truongPhong) {
		VBox vb = new VBox();
		vb.setPadding(new Insets(12, 12, 12, 12));
		vb.setSpacing(20);
		Label lTenChucNang = new Label("THONG TIN TAI KHOAN");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.setAlignment(Pos.CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(15);
		gp.setVgap(10);

		Label lId = new Label("Id: " + truongPhong.getId());
		gp.add(lId, 0, 0);
		GridPane.setConstraints(lId, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lTen = new Label("Ten: " + truongPhong.getTen());
		gp.add(lTen, 0, 1);
		GridPane.setConstraints(lTen, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lGioiTinh = new Label("Gioi tinh: " + truongPhong.getGioiTinh());
		gp.add(lGioiTinh, 0, 2);
		GridPane.setConstraints(lGioiTinh, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lDiaChi = new Label("Phong: " + truongPhong.getPhong());
		gp.add(lDiaChi, 0, 3);
		GridPane.setConstraints(lDiaChi, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lSoDienThoai = new Label("So dien thoai: " + truongPhong.getSoDienThoai());
		gp.add(lSoDienThoai, 0, 4);
		GridPane.setConstraints(lSoDienThoai, 0, 4, 1, 1, HPos.LEFT, VPos.CENTER);

		vb.getChildren().add(gp);
		return vb;
	}

	public static VBox doiMatKhau(TruongPhong truongPhong) {
		VBox vb = new VBox();
		vb.setPadding(new Insets(12, 12, 12, 12));
		vb.setSpacing(20);
		
		Image image= new Image("/login.png");/**/
		Label lb = new Label(" ", new ImageView(image));/**/
		GridPane.setConstraints(lb, 0, 0, 2, 1, HPos.CENTER, VPos.TOP);/**/
		vb.getChildren().add(lb);/**/
		
		Label lTenChucNang = new Label("DOI MAT KHAU");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(15);
		gp.setVgap(10);

		Label lMatKhauCu = new Label("Mat khau cu (*)");
		gp.add(lMatKhauCu, 0, 0);
		GridPane.setConstraints(lMatKhauCu, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);

		PasswordField pfMatKhauCu = new PasswordField();
		gp.add(pfMatKhauCu, 1, 0);

		Label lMatKhauMoi = new Label("Mat khau moi (*)");
		gp.add(lMatKhauMoi, 0, 1);
		GridPane.setConstraints(lMatKhauMoi, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);

		PasswordField pfMatKhauMoi = new PasswordField();
		gp.add(pfMatKhauMoi, 1, 1);

		Label lNhapLai = new Label("Nhap lai mat khau moi (*)");
		gp.add(lNhapLai, 0, 2);
		GridPane.setConstraints(lNhapLai, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER);

		PasswordField pfNhapLai = new PasswordField();
		gp.add(pfNhapLai, 1, 2);

		Image imageXN=new Image("/checked.png");/**/
		Button bXacNhan = new Button("Xac nhan",new ImageView(imageXN));/**/
		bXacNhan.getStyleClass().add("Button");/**/
		gp.add(bXacNhan, 0, 3);

		bXacNhan.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent keyEvent) {

				System.out.println(truongPhong.getPassword());
				if ("".equals(pfMatKhauCu.getText()) || "".equals(pfMatKhauMoi.getText())
						|| "".equals(pfNhapLai.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap du thong tin");
					alert.showAndWait();
				} else if (truongPhong.getPassword().equals(pfMatKhauCu.getText())) {
					if (pfMatKhauMoi.getText().equals(pfNhapLai.getText())) {
						truongPhong.setPassword(pfNhapLai.getText());
						chucNang.updateTruongPhong(truongPhong);

						pfMatKhauCu.clear();
						pfMatKhauMoi.clear();
						pfNhapLai.clear();

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Thong bao");
						alert.setHeaderText(null);
						alert.setContentText("Cap nhat thanh cong");
						alert.showAndWait();
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Canh bao");
						alert.setHeaderText(null);
						alert.setContentText("Mat khau moi nhap lai khong trung khop");
						alert.showAndWait();
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Mat khau cu khong chinh xac");
					alert.showAndWait();
				}
			}
		});

		pfMatKhauMoi.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.SPACE) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Mat khau khong duoc chua khoang trang (\" \")");
					alert.showAndWait();
				}
			}
		});

		pfNhapLai.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent keyEvent) {
				if ("".equals(pfMatKhauCu.getText()) || "".equals(pfMatKhauMoi.getText())
						|| "".equals(pfNhapLai.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap du thong tin");
					alert.showAndWait();
				} else if (truongPhong.getPassword().equals(pfMatKhauCu.getText())) {

					if (pfMatKhauMoi.getText().equals(pfNhapLai.getText())) {
						truongPhong.setPassword(pfNhapLai.getText());
						chucNang.updateTruongPhong(truongPhong);

						pfMatKhauCu.clear();
						pfMatKhauMoi.clear();
						pfNhapLai.clear();

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Thong bao");
						alert.setHeaderText(null);
						alert.setContentText("Cap nhat thanh cong");
						alert.showAndWait();
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Canh bao");
						alert.setHeaderText(null);
						alert.setContentText("Mat khau moi nhap lai khong trung khop");
						alert.showAndWait();
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Mat khau cu khong chinh xac");
					alert.showAndWait();
				}
			}
		});

		GridPane.setConstraints(bXacNhan, 0, 3, 2, 1, HPos.CENTER, VPos.CENTER);
		vb.getChildren().add(gp);
		vb.setAlignment(Pos.CENTER);
		return vb;
	}

	public static VBox doiSoDienThoai(TruongPhong truongPhong) {
		VBox vb = new VBox();
		vb.setPadding(new Insets(12, 12, 12, 12));
		vb.setSpacing(20);
		
		Image image= new Image("/phone-call.png");/**/
		Label lb = new Label(" ", new ImageView(image));/**/
		GridPane.setConstraints(lb, 0, 0, 2, 1, HPos.CENTER, VPos.TOP);/**/
		vb.getChildren().add(lb);/**/

		
		Label lTenChucNang = new Label("DOI SO DIEN THOAI");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(15);
		gp.setVgap(10);
		Label lSoDienThoaiCu = new Label("So dien thoai cu");
		gp.add(lSoDienThoaiCu, 0, 0);
		GridPane.setConstraints(lSoDienThoaiCu, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfSoDienThoaiCu = new TextField();
		tfSoDienThoaiCu.setText(truongPhong.getSoDienThoai());
		tfSoDienThoaiCu.setEditable(false);
		gp.add(tfSoDienThoaiCu, 1, 0);

		Label lSoDienThoaiMoi = new Label("So dien thoai moi (*)");
		gp.add(lSoDienThoaiMoi, 0, 1);
		GridPane.setConstraints(lSoDienThoaiMoi, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfSoDienThoaiMoi = new TextField();
		gp.add(tfSoDienThoaiMoi, 1, 1);

		tfSoDienThoaiMoi.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent mouseEvent) {
				if ("".equals(tfSoDienThoaiMoi.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap thong tin");
					alert.showAndWait();
				} else {
					truongPhong.setSoDienThoai(tfSoDienThoaiMoi.getText());
					chucNang.updateTruongPhong(truongPhong);
					tfSoDienThoaiCu.setText(truongPhong.getSoDienThoai());
					tfSoDienThoaiMoi.clear();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thong bao");
					alert.setHeaderText(null);
					alert.setContentText("Cap nhat thanh cong");
					alert.showAndWait();
				}
			}
		});

		tfSoDienThoaiMoi.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() != KeyCode.BACK_SPACE && keyEvent.getCode() != KeyCode.ENTER
						&& keyEvent.getCode() != KeyCode.TAB && keyEvent.getCode() != KeyCode.LEFT
						&& keyEvent.getCode() != KeyCode.RIGHT)

					try {
						Double.valueOf(keyEvent.getText());
					} catch (NumberFormatException ex) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Canh bao");
						alert.setHeaderText(null);
						alert.setContentText("Vui long nhap so");
						alert.showAndWait();
					}
			}
		});

		Image imageXN=new Image("/checked.png");/**/
		Button bXacNhan = new Button("Xac nhan",new ImageView(imageXN));/**/
		bXacNhan.getStyleClass().add("Button");/**/
		gp.add(bXacNhan, 0, 2);
		GridPane.setConstraints(bXacNhan, 0, 2, 2, 1, HPos.CENTER, VPos.CENTER);
		vb.getChildren().add(gp);

		bXacNhan.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent mouseEvent) {
				if ("".equals(tfSoDienThoaiMoi.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap thong tin");
					alert.showAndWait();
				} else {
					truongPhong.setSoDienThoai(tfSoDienThoaiMoi.getText());
					chucNang.updateTruongPhong(truongPhong);
					tfSoDienThoaiCu.setText(truongPhong.getSoDienThoai());
					tfSoDienThoaiMoi.clear();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thong bao");
					alert.setHeaderText(null);
					alert.setContentText("Cap nhat thanh cong");
					alert.showAndWait();
				}
			}
		});

		vb.setAlignment(Pos.CENTER);

		return vb;
	}

	public static VBox doiPhong(TruongPhong truongPhong) {

		VBox vb = new VBox();
		vb.setPadding(new Insets(12, 12, 12, 12));
		vb.setSpacing(20);
		
		Image image= new Image("/retirement.png");/**/
		Label lb = new Label(" ", new ImageView(image));/**/
		GridPane.setConstraints(lb, 0, 0, 2, 1, HPos.CENTER, VPos.TOP);/**/
		vb.getChildren().add(lb);/**/
		
		Label lTenChucNang = new Label("DOI PHONG");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(15);
		gp.setVgap(10);
		Label lPhongCu = new Label("Phong o cu");
		gp.add(lPhongCu, 0, 0);
		GridPane.setConstraints(lPhongCu, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfPhongCu = new TextField();
		tfPhongCu.setText(String.valueOf(truongPhong.getPhong()));
		tfPhongCu.setEditable(false);
		gp.add(tfPhongCu, 1, 0);

		Label lPhongMoi = new Label("Phong o moi (*)");
		gp.add(lPhongMoi, 0, 1);
		GridPane.setConstraints(lPhongMoi, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);

		ComboBox cbPhong = new ComboBox(FXCollections.observableArrayList(112, 206, 310, 406));
		gp.add(cbPhong, 1, 1);
		cbPhong.setPrefWidth(175);

		Image imageXN=new Image("/checked.png");/**/
		Button bXacNhan = new Button("Xac nhan",new ImageView(imageXN));/**/
		bXacNhan.getStyleClass().add("Button");/**/
		gp.add(bXacNhan, 0, 2);
		GridPane.setConstraints(bXacNhan, 0, 2, 2, 1, HPos.CENTER, VPos.CENTER);
		vb.getChildren().add(gp);

		bXacNhan.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent mouseEvent) {
				if (cbPhong.getValue() == null) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap thong tin");
					alert.showAndWait();
				} else {
					truongPhong.setPhong(Integer.valueOf(cbPhong.getValue().toString()));
					chucNang.updateTruongPhong(truongPhong);
					tfPhongCu.setText(String.valueOf(truongPhong.getPhong()));
					cbPhong.setValue(null);
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thong bao");
					alert.setHeaderText(null);
					alert.setContentText("Cap nhat thanh cong");
					alert.showAndWait();
				}
			}
		});

		vb.setAlignment(Pos.CENTER);

		return vb;
	}

	public static VBox xemNhanVien() {
		VBox vb = new VBox();

		vb.setPadding(new Insets(20, 20, 20, 20));
		vb.setSpacing(20);

		Label lTenChucNang = new Label("XEM THONG TIN NHAN VIEN");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		VBox vbTimKiem = new VBox();
		vbTimKiem.setSpacing(20);
		GridPane gp = new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		TextField tfTen = new TextField();
		tfTen.setPromptText("Ten nhan vien");
		gp.add(tfTen, 0, 0);
		TextField tfSoDienThoai = new TextField();
		tfSoDienThoai.setPromptText("So dien thoai");
		gp.add(tfSoDienThoai, 1, 0);

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

		TextField tfThangSinh = new TextField();
		gp.add(tfThangSinh, 0, 1);
		tfThangSinh.setPromptText("Thang sinh");
		tfThangSinh.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

		TextField tfDiaChi = new TextField();
		gp.add(tfDiaChi, 1, 1);
		tfDiaChi.setPromptText("Dia chi");
		ToggleGroup tg = new ToggleGroup();
		RadioButton rbNam = new RadioButton("Nam");
		rbNam.setUserData(new String("Nam"));
		rbNam.requestFocus();
		rbNam.setToggleGroup(tg);
		RadioButton rbNu = new RadioButton("Nu");
		rbNu.setUserData(new String("Nu"));
		rbNu.requestFocus();
		rbNu.setToggleGroup(tg);
		HBox hbGioiTinh = new HBox();
		hbGioiTinh.setSpacing(10);
		hbGioiTinh.getChildren().addAll(rbNam, rbNu);
		gp.add(hbGioiTinh, 0, 2);
		GridPane.setConstraints(hbGioiTinh, 0, 2, 2, 1);
		hbGioiTinh.setAlignment(Pos.CENTER);
		gp.setAlignment(Pos.CENTER);
		HBox hb = new HBox();
		Image imageTK=new Image("/loupe.png");/**/
		Button bTimKiem = new Button("Tim kiem",new ImageView(imageTK));/**/
		bTimKiem.getStyleClass().add("Button");/**/
		bTimKiem.setPrefWidth(100);
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(bTimKiem);
		vbTimKiem.getChildren().addAll(gp, hb);

		TableView<NhanVien> tv = new TableView<>();
		vb.getChildren().addAll(vbTimKiem, tv);

		TableColumn<NhanVien, String> cId = new TableColumn<>("Id");
		TableColumn<NhanVien, String> cTen = new TableColumn<>("Ten");
		TableColumn<NhanVien, String> cGioiTinh = new TableColumn<>("Gioi tinh");
		TableColumn<NhanVien, Date> cNgaySinh = new TableColumn<>("Ngay sinh");
		TableColumn<NhanVien, String> cDiaChi = new TableColumn<>("Dia chi");
		TableColumn<NhanVien, String> cSoDienThoai = new TableColumn<>("So dien thoai");
		tv.getColumns().addAll(cId, cTen, cGioiTinh, cNgaySinh, cDiaChi, cSoDienThoai);

		ObservableList<NhanVien> data = FXCollections.observableArrayList(chucNang.getToanNhanVien());
		tv.setItems(data);

		cId.setCellValueFactory(new PropertyValueFactory<>("id"));
		cTen.setCellValueFactory(new PropertyValueFactory<>("ten"));
		cGioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
		cNgaySinh.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
		cSoDienThoai.setCellValueFactory(new PropertyValueFactory<>("soDienThoai"));
		cDiaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
		vb.setAlignment(Pos.CENTER);

		bTimKiem.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				String ten = tfTen.getText();
				String gioiTinh;
				if (tg.getSelectedToggle() != null) {
					gioiTinh = tg.getSelectedToggle().getUserData().toString();
				} else {
					gioiTinh = "";
				}
				String thangSinh = tfThangSinh.getText();
				String diaChi = tfDiaChi.getText();
				String soDienThoai = tfSoDienThoai.getText();

				ObservableList<NhanVien> timKiem = FXCollections
						.observableArrayList(chucNang.timKiemNhanVien(ten, gioiTinh, thangSinh, diaChi, soDienThoai));
				tv.setItems(timKiem);

			}
		});

		return vb;
	}

	public static VBox xemDien(TruongPhong truongPhong) {
		VBox vb = new VBox();

		vb.setPadding(new Insets(20, 20, 20, 20));
		vb.setSpacing(20);

		Label lTenChucNang = new Label("XEM THONG TIN DUNG DIEN");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.setFont(new Font(25));
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		HBox hb = new HBox();
		hb.setSpacing(15);

		TextField tfNam = new TextField();
		tfNam.setPromptText("Nam");

		tfNam.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

		TextField tfThang = new TextField();
		tfThang.setPromptText("Thang");

		tfThang.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

		Image imageTK=new Image("/loupe.png");/**/
		Button bTimKiem = new Button("Tim kiem",new ImageView(imageTK));/**/
		bTimKiem.getStyleClass().add("Button");/**/
		bTimKiem.setPrefWidth(100);/**/
		hb.getChildren().addAll(tfNam, tfThang, bTimKiem);
		hb.setAlignment(Pos.CENTER);

		TableView<Dung> tv = new TableView<>();
		vb.getChildren().addAll(hb, tv);

		TableColumn<Dung, Integer> cNam = new TableColumn<>("Nam");
		TableColumn<Dung, Integer> cThang = new TableColumn<>("Thang");
		TableColumn<Dung, Integer> cSoDau = new TableColumn<>("So dau");
		TableColumn<Dung, Integer> cSoCuoi = new TableColumn<>("So cuoi");
		TableColumn<Dung, Integer> cLuongDung = new TableColumn<>("Luong dung");
		TableColumn<Dung, Integer> cTien = new TableColumn<>("Tien");
		tv.getColumns().addAll(cNam, cThang, cSoDau, cSoCuoi, cLuongDung, cTien);

		ObservableList<Dung> data = FXCollections.observableArrayList(chucNang.getDungDien(truongPhong.getPhong()));
		tv.setItems(data);
		cNam.setCellValueFactory(new PropertyValueFactory<>("nam"));
		cThang.setCellValueFactory(new PropertyValueFactory<>("thang"));
		cSoDau.setCellValueFactory(new PropertyValueFactory<>("soDau"));
		cSoCuoi.setCellValueFactory(new PropertyValueFactory<>("soCuoi"));
		cLuongDung.setCellValueFactory(new PropertyValueFactory<>("luongDung"));
		cTien.setCellValueFactory(new PropertyValueFactory<>("tienDien"));

		bTimKiem.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				String nam = tfNam.getText();
				String thang = tfThang.getText();

				ObservableList<Dung> timKiem = FXCollections.observableArrayList(
						chucNang.timKiemDungDien(String.valueOf(truongPhong.getPhong()), nam, thang));
				tv.setItems(timKiem);

			}
		});

		return vb;
	}

	public static VBox xemNuoc(TruongPhong truongPhong) {
		VBox vb = new VBox();

		vb.setPadding(new Insets(20, 20, 20, 20));
		vb.setSpacing(20);

		Label lTenChucNang = new Label("XEM THONG TIN DUNG NUOC");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.getStyleClass().add("LabelTieuDe");
		vb.setAlignment(Pos.TOP_CENTER);

		HBox hb = new HBox();
		hb.setSpacing(15);

		TextField tfNam = new TextField();
		tfNam.setPromptText("Nam");

		tfNam.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

		TextField tfThang = new TextField();
		tfThang.setPromptText("Thang");

		tfThang.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
		Image imageTK=new Image("/loupe.png");/**/
		Button bTimKiem = new Button("Tim kiem",new ImageView(imageTK));/**/
		bTimKiem.getStyleClass().add("Button");/**/
		hb.getChildren().addAll(tfNam, tfThang, bTimKiem);
		hb.setAlignment(Pos.CENTER);

		TableView<Dung> tv = new TableView<>();
		vb.getChildren().addAll(hb, tv);

		TableColumn<Dung, Integer> cNam = new TableColumn<>("Nam");
		TableColumn<Dung, Integer> cThang = new TableColumn<>("Thang");
		TableColumn<Dung, Integer> cSoDau = new TableColumn<>("So dau");
		TableColumn<Dung, Integer> cSoCuoi = new TableColumn<>("So cuoi");
		TableColumn<Dung, Integer> cLuongDung = new TableColumn<>("Luong dung");
		TableColumn<Dung, Integer> cTien = new TableColumn<>("Tien");
		tv.getColumns().addAll(cNam, cThang, cSoDau, cSoCuoi, cLuongDung, cTien);

		ObservableList<Dung> data = FXCollections.observableArrayList(chucNang.getDungNuoc(truongPhong.getPhong()));
		tv.setItems(data);
		cNam.setCellValueFactory(new PropertyValueFactory<>("nam"));
		cThang.setCellValueFactory(new PropertyValueFactory<>("thang"));
		cSoDau.setCellValueFactory(new PropertyValueFactory<>("soDau"));
		cSoCuoi.setCellValueFactory(new PropertyValueFactory<>("soCuoi"));
		cLuongDung.setCellValueFactory(new PropertyValueFactory<>("luongDung"));
		cTien.setCellValueFactory(new PropertyValueFactory<>("tienNuoc"));
		
		
		bTimKiem.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				String nam = tfNam.getText();
				String thang = tfThang.getText();

				ObservableList<Dung> timKiem = FXCollections.observableArrayList(
						chucNang.timKiemDungNuoc(String.valueOf(truongPhong.getPhong()), nam, thang));
				tv.setItems(timKiem);

			}
		});
		

		return vb;
	}
}
