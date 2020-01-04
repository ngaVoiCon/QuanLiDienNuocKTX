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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import laydulieu.ILayDuLieu;
import laydulieu.LayDuLieu;
import lop.Chu;
import lop.Dung;
import lop.LuongNhanVien;
import lop.NhanVien;
import lop.TruongPhong;

public class ChucNangChu {

	static ILayDuLieu chucNang = new LayDuLieu();

	public static VBox thongTin(Chu chu) {
		VBox vb = new VBox();
		vb.setPadding(new Insets(12, 12, 12, 12));
		vb.setSpacing(20);
		Label lTenChucNang = new Label("THONG TIN TAI KHOAN");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.setAlignment(Pos.CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		Image image1 = new Image("/boy.png");

		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(15);
		gp.setVgap(10);

		Label lId = new Label("Id: " + chu.getId());
		gp.add(lId, 0, 0);
		GridPane.setConstraints(lId, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lTen = new Label("Ten: " + chu.getTen());
		gp.add(lTen, 0, 1);
		GridPane.setConstraints(lTen, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lGioiTinh = new Label("Gioi tinh: " + chu.getGioiTinh());
		gp.add(lGioiTinh, 0, 2);
		GridPane.setConstraints(lGioiTinh, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lNgaySinh = new Label("Ngay sinh: " + chu.getNgaySinh());
		gp.add(lNgaySinh, 0, 3);
		GridPane.setConstraints(lNgaySinh, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lDiaChi = new Label("Dia chi: " + chu.getDiaChi());
		gp.add(lDiaChi, 0, 4);
		GridPane.setConstraints(lDiaChi, 0, 4, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lSoDienThoai = new Label("So dien thoai: " + chu.getSoDienThoai());
		gp.add(lSoDienThoai, 0, 5);
		GridPane.setConstraints(lSoDienThoai, 0, 5, 1, 1, HPos.LEFT, VPos.CENTER);
		hb.getChildren().addAll(new ImageView(image1), gp);
		vb.getChildren().add(hb);
		return vb;
	}

	public static VBox doiMatKhau(Chu chu) {
		VBox vb = new VBox();
		vb.setPadding(new Insets(12, 12, 12, 12));
		vb.setSpacing(20);

		Image image = new Image("/login.png");/**/
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

		Image iXacNhan = new Image("/checked.png");/**/
		Button bXacNhan = new Button("Xac nhan", new ImageView(iXacNhan));/**/
		gp.add(bXacNhan, 0, 3);
		bXacNhan.getStyleClass().add("Button");/**/

		bXacNhan.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent keyEvent) {

				System.out.println(chu.getPassword());
				if ("".equals(pfMatKhauCu.getText()) || "".equals(pfMatKhauMoi.getText())
						|| "".equals(pfNhapLai.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap du thong tin");
					alert.showAndWait();
				} else if (chu.getPassword().equals(pfMatKhauCu.getText())) {
					if (pfMatKhauMoi.getText().equals(pfNhapLai.getText())) {
						chu.setPassword(pfNhapLai.getText());
						chucNang.updateChu(chu);

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
				} else if (chu.getPassword().equals(pfMatKhauCu.getText())) {

					if (pfMatKhauMoi.getText().equals(pfNhapLai.getText())) {
						chu.setPassword(pfNhapLai.getText());
						chucNang.updateChu(chu);

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

	public static VBox doiSoDienThoai(Chu chu) {
		VBox vb = new VBox();
		vb.setPadding(new Insets(12, 12, 12, 12));
		vb.setSpacing(20);

		Image image = new Image("/phone-call.png");/**/
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
		tfSoDienThoaiCu.setText(chu.getSoDienThoai());
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
					chu.setSoDienThoai(tfSoDienThoaiMoi.getText());
					chucNang.updateChu(chu);
					tfSoDienThoaiCu.setText(chu.getSoDienThoai());
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

		Image imageXN = new Image("/checked.png");/**/
		Button bXacNhan = new Button("Xac nhan", new ImageView(imageXN));/**/
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
					chu.setSoDienThoai(tfSoDienThoaiMoi.getText());
					chucNang.updateChu(chu);
					tfSoDienThoaiCu.setText(chu.getSoDienThoai());
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

	public static VBox doiDiaChi(Chu chu) {
		VBox vb = new VBox();
		vb.setPadding(new Insets(12, 12, 12, 12));
		vb.setSpacing(20);
		Label lTenChucNang = new Label("DOI DIA CHI");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		Image image = new Image("/map.png");/**/
		Label lb = new Label(" ", new ImageView(image));/**/
		GridPane.setConstraints(lb, 0, 0, 2, 1, HPos.CENTER, VPos.TOP);/**/
		vb.getChildren().add(lb);/**/

		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(15);
		gp.setVgap(10);
		Label lDiaChiCu = new Label("Dia chi cu");
		gp.add(lDiaChiCu, 0, 0);
		GridPane.setConstraints(lDiaChiCu, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfDiaChiCu = new TextField();
		tfDiaChiCu.setText(chu.getDiaChi());
		tfDiaChiCu.setEditable(false);
		gp.add(tfDiaChiCu, 1, 0);

		Label lDiaChiMoi = new Label("Dia chi moi (*)");
		gp.add(lDiaChiMoi, 0, 1);
		GridPane.setConstraints(lDiaChiMoi, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfDiaChiMoi = new TextField();
		gp.add(tfDiaChiMoi, 1, 1);

		Image imageXN = new Image("/checked.png");/**/
		Button bXacNhan = new Button("Xac nhan", new ImageView(imageXN));/**/
		gp.add(bXacNhan, 0, 2);
		GridPane.setConstraints(bXacNhan, 0, 2, 2, 1, HPos.CENTER, VPos.CENTER);
		bXacNhan.getStyleClass().add("Button");/**/

		bXacNhan.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent mouseEvent) {
				if ("".equals(tfDiaChiMoi.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap thong tin");
					alert.showAndWait();
				} else {
					chu.setDiaChi(tfDiaChiMoi.getText());
					chucNang.updateChu(chu);
					tfDiaChiCu.setText(chu.getDiaChi());
					tfDiaChiMoi.clear();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Thong bao");
					alert.setHeaderText(null);
					alert.setContentText("Cap nhat thanh cong");
					alert.showAndWait();
				}
			}
		});

		vb.getChildren().add(gp);
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
		// rbNam.setSelected(true);;
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
		hb.setSpacing(10);
		Image imageTK = new Image("/loupe.png");/**/
		Button bTimKiem = new Button("Tim kiem", new ImageView(imageTK));/**/
		bTimKiem.setPrefWidth(100);/**/
		bTimKiem.getStyleClass().add("Button");/**/
		Image imageXoa = new Image("/delete.png");/**/
		Button bXoa = new Button("Xoa", new ImageView(imageXoa));/**/
		bXoa.setPrefWidth(100);
		bXoa.getStyleClass().add("Button");/**/

		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(bTimKiem, bXoa);
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

		cGioiTinh.setPrefWidth(100);

		tv.setEditable(true);

		cTen.setCellFactory(TextFieldTableCell.<NhanVien>forTableColumn());
		cTen.setOnEditCommit((CellEditEvent<NhanVien, String> event) -> {
			TablePosition<NhanVien, String> pos = event.getTablePosition();

			String newTen = event.getNewValue();

			int row = pos.getRow();
			NhanVien nhanVien = event.getTableView().getItems().get(row);
			nhanVien.setTen(newTen);
			chucNang.updateNhanVien(nhanVien);

		});

		cGioiTinh.setCellFactory(TextFieldTableCell.<NhanVien>forTableColumn());
		cGioiTinh.setOnEditCommit((CellEditEvent<NhanVien, String> event) -> {
			TablePosition<NhanVien, String> pos = event.getTablePosition();

			String newGioiTinh = event.getNewValue();

			int row = pos.getRow();
			NhanVien nhanVien = event.getTableView().getItems().get(row);
			nhanVien.setTen(newGioiTinh);
			chucNang.updateNhanVien(nhanVien);

		});

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

		bXoa.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				chucNang.xoaNhanVien(tv.getSelectionModel().getSelectedItem());
				tv.getItems().removeAll(tv.getSelectionModel().getSelectedItem());
			}
		});

		return vb;
	}

	public static VBox xemTruongPhong() {
		VBox vb = new VBox();

		vb.setPadding(new Insets(20, 20, 20, 20));
		vb.setSpacing(20);

		Label lTenChucNang = new Label("XEM THONG TIN TRUONG PHONG");
		vb.getChildren().add(lTenChucNang);
		vb.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		HBox hb = new HBox();
		hb.setSpacing(15);
		TextField tfPhong = new TextField();
		tfPhong.setPromptText("Phong");

		tfPhong.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() != KeyCode.BACK_SPACE && keyEvent.getCode() != KeyCode.TAB
						&& keyEvent.getCode() != KeyCode.LEFT && keyEvent.getCode() != KeyCode.RIGHT)
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

		Image imageTK = new Image("/loupe.png");/**/
		Button bTimKiem = new Button("Tim kiem", new ImageView(imageTK));/**/
		bTimKiem.setPrefWidth(100);/**/
		bTimKiem.getStyleClass().add("Button");/**/
		Image imageXoa = new Image("/delete.png");/**/
		Button bXoa = new Button("Xoa", new ImageView(imageXoa));/**/
		bXoa.setPrefWidth(75);
		bXoa.getStyleClass().add("Button");/**/
		hb.getChildren().addAll(tfPhong, bTimKiem, bXoa);
		hb.setAlignment(Pos.CENTER);

		TableView<TruongPhong> tv = new TableView<>();
		vb.getChildren().addAll(hb, tv);

		TableColumn<TruongPhong, String> cId = new TableColumn<>("Id");
		TableColumn<TruongPhong, Integer> cPhong = new TableColumn<>("Phong");
		TableColumn<TruongPhong, String> cTen = new TableColumn<>("Ten");
		TableColumn<TruongPhong, String> cGioiTinh = new TableColumn<>("Gioi tinh");
		TableColumn<TruongPhong, String> cSoDienThoai = new TableColumn<>("So dien thoai");
		tv.getColumns().addAll(cId, cPhong, cTen, cGioiTinh, cSoDienThoai);

		ObservableList<TruongPhong> data = FXCollections.observableArrayList(chucNang.getToanTruongPhong());
		tv.setItems(data);

		cId.setCellValueFactory(new PropertyValueFactory<>("id"));
		cPhong.setCellValueFactory(new PropertyValueFactory<>("phong"));
		cTen.setCellValueFactory(new PropertyValueFactory<>("ten"));
		cGioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
		cSoDienThoai.setCellValueFactory(new PropertyValueFactory<>("soDienThoai"));

		cGioiTinh.setPrefWidth(100);

		tv.setEditable(true);

		cTen.setCellFactory(TextFieldTableCell.<TruongPhong>forTableColumn());
		cTen.setOnEditCommit((CellEditEvent<TruongPhong, String> event) -> {
			TablePosition<TruongPhong, String> pos = event.getTablePosition();

			String newTen = event.getNewValue();

			int row = pos.getRow();
			TruongPhong truongPhong = event.getTableView().getItems().get(row);
			truongPhong.setTen(newTen);
			chucNang.updateTruongPhong(truongPhong);

		});

		cGioiTinh.setCellFactory(TextFieldTableCell.<TruongPhong>forTableColumn());
		cGioiTinh.setOnEditCommit((CellEditEvent<TruongPhong, String> event) -> {
			TablePosition<TruongPhong, String> pos = event.getTablePosition();

			String newGioiTinh = event.getNewValue();

			int row = pos.getRow();
			TruongPhong truongPhong = event.getTableView().getItems().get(row);
			truongPhong.setTen(newGioiTinh);
			chucNang.updateTruongPhong(truongPhong);

		});

		bTimKiem.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				String phong = tfPhong.getText();

				ObservableList<TruongPhong> timKiem = FXCollections
						.observableArrayList(chucNang.timKiemTruongPhong(phong));
				tv.setItems(timKiem);

			}
		});

		bXoa.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				chucNang.xoaTruongPhong(tv.getSelectionModel().getSelectedItem());
				tv.getItems().removeAll(tv.getSelectionModel().getSelectedItem());
			}
		});

		return vb;
	}

	public static VBox xemDien() {
		VBox vb = new VBox();

		vb.setPadding(new Insets(20, 20, 20, 20));
		vb.setSpacing(20);

		Label lTenChucNang = new Label("XEM THONG TIN DUNG DIEN");
		vb.getChildren().add(lTenChucNang);
		vb.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		HBox hb = new HBox();
		hb.setSpacing(15);
		TextField tfPhong = new TextField();
		tfPhong.setPromptText("Phong");

		tfPhong.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

		Image imageTK = new Image("/loupe.png");/**/
		Button bTimKiem = new Button("Tim kiem", new ImageView(imageTK));/**/
		bTimKiem.setPrefWidth(100);/**/
		bTimKiem.getStyleClass().add("Button");/**/

		hb.getChildren().addAll(tfPhong, tfNam, tfThang, bTimKiem);
		hb.setAlignment(Pos.CENTER);

		TableView<Dung> tv = new TableView<>();
		vb.getChildren().addAll(hb, tv);

		TableColumn<Dung, String> cPhong = new TableColumn<>("Phong");
		TableColumn<Dung, Integer> cNam = new TableColumn<>("Nam");
		TableColumn<Dung, Integer> cThang = new TableColumn<>("Thang");
		TableColumn<Dung, Integer> cSoDau = new TableColumn<>("So dau");
		TableColumn<Dung, Integer> cSoCuoi = new TableColumn<>("So cuoi");
		TableColumn<Dung, Integer> cLuongDung = new TableColumn<>("Luong dung");
		TableColumn<Dung, Integer> cTien = new TableColumn<>("Tien");
		tv.getColumns().addAll(cPhong, cNam, cThang, cSoDau, cSoCuoi, cLuongDung, cTien);

		ObservableList<Dung> data = FXCollections.observableArrayList(chucNang.getDungDien(null));
		tv.setItems(data);

		cPhong.setCellValueFactory(new PropertyValueFactory<>("phong"));
		cNam.setCellValueFactory(new PropertyValueFactory<>("nam"));
		cThang.setCellValueFactory(new PropertyValueFactory<>("thang"));
		cSoDau.setCellValueFactory(new PropertyValueFactory<>("soDau"));
		cSoCuoi.setCellValueFactory(new PropertyValueFactory<>("soCuoi"));
		cLuongDung.setCellValueFactory(new PropertyValueFactory<>("luongDung"));
		cTien.setCellValueFactory(new PropertyValueFactory<>("tienDien"));

		bTimKiem.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				String phong = tfPhong.getText();
				String nam = tfNam.getText();
				String thang = tfThang.getText();

				ObservableList<Dung> timKiem = FXCollections
						.observableArrayList(chucNang.timKiemDungDien(phong, nam, thang));
				tv.setItems(timKiem);

			}
		});

		return vb;
	}

	public static VBox xemNuoc() {
		VBox vb = new VBox();

		vb.setPadding(new Insets(20, 20, 20, 20));
		vb.setSpacing(20);

		Label lTenChucNang = new Label("XEM THONG TIN DUNG NUOC");
		vb.getChildren().add(lTenChucNang);
		vb.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		HBox hb = new HBox();
		hb.setSpacing(15);
		TextField tfPhong = new TextField();
		tfPhong.setPromptText("Phong");

		tfPhong.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

		Image imageTK = new Image("/loupe.png");/**/
		Button bTimKiem = new Button("Tim kiem", new ImageView(imageTK));/**/
		bTimKiem.setPrefWidth(100);/**/
		bTimKiem.getStyleClass().add("Button");/**/

		hb.getChildren().addAll(tfPhong, tfNam, tfThang, bTimKiem);
		hb.setAlignment(Pos.CENTER);

		TableView<Dung> tv = new TableView<>();
		vb.getChildren().addAll(hb, tv);

		TableColumn<Dung, String> cPhong = new TableColumn<>("Phong");
		TableColumn<Dung, Integer> cNam = new TableColumn<>("Nam");
		TableColumn<Dung, Integer> cThang = new TableColumn<>("Thang");
		TableColumn<Dung, Integer> cSoDau = new TableColumn<>("So dau");
		TableColumn<Dung, Integer> cSoCuoi = new TableColumn<>("So cuoi");
		TableColumn<Dung, Integer> cLuongDung = new TableColumn<>("Luong dung");
		TableColumn<Dung, Integer> cTien = new TableColumn<>("Tien");
		tv.getColumns().addAll(cPhong, cNam, cThang, cSoDau, cSoCuoi, cLuongDung, cTien);

		ObservableList<Dung> data = FXCollections.observableArrayList(chucNang.getDungNuoc(null));
		tv.setItems(data);

		tv.setItems(data);
		cPhong.setCellValueFactory(new PropertyValueFactory<>("phong"));
		cNam.setCellValueFactory(new PropertyValueFactory<>("nam"));
		cThang.setCellValueFactory(new PropertyValueFactory<>("thang"));
		cSoDau.setCellValueFactory(new PropertyValueFactory<>("soDau"));
		cSoCuoi.setCellValueFactory(new PropertyValueFactory<>("soCuoi"));
		cLuongDung.setCellValueFactory(new PropertyValueFactory<>("luongDung"));
		cTien.setCellValueFactory(new PropertyValueFactory<>("tienNuoc"));

		bTimKiem.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				String phong = tfPhong.getText();
				String nam = tfNam.getText();
				String thang = tfThang.getText();

				ObservableList<Dung> timKiem = FXCollections
						.observableArrayList(chucNang.timKiemDungNuoc(phong, nam, thang));
				tv.setItems(timKiem);

			}
		});

		return vb;
	}

	public static VBox nhapLuong() {
		VBox vb = new VBox();

		vb.setPadding(new Insets(20, 20, 20, 20));
		vb.setSpacing(20);

		Label lTenChucNang = new Label("NHAP LUONG CHO NHAN VIEN");
		vb.getChildren().add(lTenChucNang);
		vb.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		HBox hb = new HBox();
		hb.setSpacing(15);
		TextField tfId = new TextField();
		tfId.setPromptText("Id nhan vien");
		tfId.setPrefWidth(100);
		tfId.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

		TextField tfNam = new TextField();
		tfNam.setPromptText("Nam");
		tfNam.setPrefWidth(100);

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

		tfThang.setPrefWidth(100);
		TextField tfLuong = new TextField();
		tfLuong.setPromptText("Luong");
		tfLuong.setPrefWidth(100);

		tfLuong.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

		Image imageTK = new Image("/icon.png");/**/
		Button bThem = new Button("Them", new ImageView(imageTK));/**/
		bThem.getStyleClass().add("Button");/**/
		hb.getChildren().addAll(tfId, tfNam, tfThang, tfLuong, bThem);
		hb.setAlignment(Pos.CENTER);

		TableView<LuongNhanVien> tv = new TableView<>();
		vb.getChildren().addAll(hb, tv);

		TableColumn<LuongNhanVien, Integer> cId = new TableColumn<>("Id Nhan Vien");
		TableColumn<LuongNhanVien, String> cTen = new TableColumn<>("Ten");
		TableColumn<LuongNhanVien, Integer> cNam = new TableColumn<>("Nam");
		TableColumn<LuongNhanVien, Integer> cThang = new TableColumn<>("Thang");
		TableColumn<LuongNhanVien, Integer> cLuong = new TableColumn<>("Luong");
		tv.getColumns().addAll(cId, cTen, cNam, cThang, cLuong);

		ObservableList<LuongNhanVien> data = FXCollections.observableArrayList(chucNang.getLuong(null));
		tv.setItems(data);

		cId.setCellValueFactory(new PropertyValueFactory<>("idNhanVien"));
		cTen.setCellValueFactory(new PropertyValueFactory<>("ten"));
		cNam.setCellValueFactory(new PropertyValueFactory<>("nam"));
		cThang.setCellValueFactory(new PropertyValueFactory<>("thang"));
		cLuong.setCellValueFactory(new PropertyValueFactory<>("luong"));
		
		tv.setEditable(true);

		/*cLuong.setCellFactory(TextFieldTableCell.<LuongNhanVien>forTableColumn());
		cLuong.setOnEditCommit((CellEditEvent<LuongNhanVien, Integer> event) -> {
			TablePosition<LuongNhanVien, Integer> pos = event.getTablePosition();

			Integer newLuong = Integer.valueOf(event.getNewValue());

			int row = pos.getRow();
			LuongNhanVien luong = event.getTableView().getItems().get(row);
			luong.setLuong(luong);
			//chucNang.updateNhanVien(nhanVien);

		});*/

		bThem.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent keyEvent) {
				if ("".equals(tfId.getText()) || "".equals(tfNam.getText()) || "".equals(tfThang.getText())
						|| "".equals(tfLuong.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bai");
					alert.setHeaderText(null);
					alert.setContentText("Vui long nhap du cac thong tin");
					alert.showAndWait();
				} else {
					chucNang.themLuong(new LuongNhanVien(Integer.valueOf(tfId.getText()), tfId.getText(),
							Integer.valueOf(tfNam.getText()), Integer.valueOf(tfThang.getText()),
							Integer.valueOf(tfLuong.getText())));

					ObservableList<LuongNhanVien> data = FXCollections.observableArrayList(chucNang.getLuong(null));
					tv.setItems(data);
				}
			}
		});

		return vb;
	}

	public static VBox chonTaoTaiKhoan(BorderPane bp) {
		VBox vb = new VBox();
		vb.setPadding(new Insets(12, 12, 12, 12));
		vb.setSpacing(20);

		Image image = new Image("/users-group.png");/**/
		Label lb = new Label(" ", new ImageView(image));/**/
		GridPane.setConstraints(lb, 0, 0, 2, 1, HPos.CENTER, VPos.TOP);/**/
		vb.getChildren().add(lb);/**/

		Label lTenChucNang = new Label("CHON LOAI TAI KHOAN MUON TAO");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		HBox hb = new HBox();
		hb.setSpacing(50);
		Image imageTP = new Image("/avatar.png");/**/
		Button bTruongPhong = new Button("Truong Phong", new ImageView(imageTP));/**/
		bTruongPhong.getStyleClass().add("Button");/**/
		Image imageNV = new Image("/avatar.png");/**/
		Button bNhanVien = new Button("Nhan Vien", new ImageView(imageNV));/**/
		bNhanVien.getStyleClass().add("Button");/**/
		hb.getChildren().addAll(bTruongPhong, bNhanVien);
		hb.setAlignment(Pos.CENTER);
		vb.getChildren().add(hb);
		vb.setAlignment(Pos.CENTER);

		bNhanVien.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(taoNhanVien(bp));
			}
		});

		bTruongPhong.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(taoTruongPhong(bp));
			}
		});

		return vb;
	}

	public static VBox taoNhanVien(BorderPane bp) {
		VBox vb = new VBox();

		GridPane gp = new GridPane();
		gp.setHgap(20);
		gp.setVgap(10);
		gp.getStyleClass().add("grid");
		gp.setPadding(new Insets(15, 15, 15, 15));

		Label lTenChucNang = new Label("TAO MOI NHAN VIEN");
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		GridPane.setConstraints(lTenChucNang, 0, 0, 4, 1, HPos.CENTER, VPos.TOP);
		gp.add(lTenChucNang, 0, 0);

		Label lTenDangNhap = new Label("Ten dang nhap");
		gp.add(lTenDangNhap, 0, 1);

		TextField tfTenDangNhap = new TextField();
		gp.add(tfTenDangNhap, 1, 1);
		tfTenDangNhap.setPrefWidth(175);

		tfTenDangNhap.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.SPACE) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Khong duoc chua khoang trang (\" \")");
					alert.showAndWait();
				}
			}
		});

		Label lMatKhau = new Label("Mat khau");
		gp.add(lMatKhau, 2, 1);

		TextField tfMatKhau = new TextField();
		gp.add(tfMatKhau, 3, 1);

		tfMatKhau.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.SPACE) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Khong duoc chua khoang trang (\" \")");
					alert.showAndWait();
				}
			}
		});

		Label lTenNhanVien = new Label("Ten nhan vien");
		gp.add(lTenNhanVien, 0, 2);

		TextField tfTenNhanVien = new TextField();
		gp.add(tfTenNhanVien, 1, 2);

		Label lDiaChi = new Label("Dia chi");
		gp.add(lDiaChi, 0, 3);

		TextField tfDiaChi = new TextField();
		gp.add(tfDiaChi, 1, 3);

		Label lSoDienThoai = new Label("So dien thoai");
		gp.add(lSoDienThoai, 2, 3);

		TextField tfSoDienThoai = new TextField();
		gp.add(tfSoDienThoai, 3, 3);
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

		Label lGioiTinh = new Label("Gioi tinh");
		gp.add(lGioiTinh, 0, 4);

		ToggleGroup tg = new ToggleGroup();

		RadioButton rbNam = new RadioButton("Nam");
		rbNam.requestFocus();
		rbNam.setUserData(new String("Nam"));
		rbNam.setToggleGroup(tg);
		GridPane.setConstraints(rbNam, 1, 4, 1, 1, HPos.LEFT, VPos.BASELINE);
		gp.add(rbNam, 1, 4);

		RadioButton rbNu = new RadioButton("Nu");
		rbNu.setUserData(new String("Nu"));
		rbNu.setToggleGroup(tg);
		GridPane.setConstraints(rbNu, 1, 4, 1, 1, HPos.RIGHT, VPos.BASELINE);
		gp.add(rbNu, 1, 4);

		Label lNgaySinh = new Label("Ngay sinh");

		gp.add(lNgaySinh, 2, 2);

		DatePicker dpNgaySinh = new DatePicker();

		gp.add(dpNgaySinh, 3, 2);
		HBox hb = new HBox();
		hb.setSpacing(20);
		Image imageHT = new Image("/checked.png");/**/
		Button bHoanThanh = new Button("Hoan thanh", new ImageView(imageHT));/**/
		bHoanThanh.getStyleClass().add("Button");/**/
		Image imageQL = new Image("/previous.png");/**/
		Button bQuayLai = new Button("Quay lai", new ImageView(imageQL));/**/
		bQuayLai.getStyleClass().add("Button");/**/
		hb.getChildren().addAll(bHoanThanh, bQuayLai);
		hb.setAlignment(Pos.CENTER);

		bHoanThanh.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if (tfTenDangNhap.getText().equals("") || dpNgaySinh.getValue() == null
						|| (rbNam.isSelected() == false && rbNu.isSelected() == false)
						|| tfSoDienThoai.getText().equals("") || tfDiaChi.getText().equals("")
						|| tfMatKhau.getText().equals("") || tfTenNhanVien.getText().equals("")) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Vui long nhap toan bo thong tin");
					alert.showAndWait();
				} else {

					NhanVien nhanVien = new NhanVien();

					nhanVien.setUserName(tfTenDangNhap.getText());
					nhanVien.setPassword(tfMatKhau.getText());
					nhanVien.setTen(tfTenNhanVien.getText());
					nhanVien.setGioiTinh(tg.getSelectedToggle().getUserData().toString());
					nhanVien.setNgaySinh(Date.valueOf(dpNgaySinh.getValue()));
					nhanVien.setDiaChi(tfDiaChi.getText());
					nhanVien.setSoDienThoai(tfSoDienThoai.getText());

					if (chucNang.themNhanVien(nhanVien)) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Thong bao");
						alert.setHeaderText(null);
						alert.setContentText("Thang cong");
						alert.showAndWait();
					}
				}
			}
		});

		bQuayLai.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(chonTaoTaiKhoan(bp));
			}

		});

		gp.setAlignment(Pos.CENTER);
		vb.setAlignment(Pos.CENTER);

		vb.getChildren().addAll(gp, hb);
		return vb;

	}

	public static VBox taoTruongPhong(BorderPane bp) {
		VBox vb = new VBox();

		GridPane gp = new GridPane();
		gp.setHgap(20);
		gp.setVgap(10);
		gp.getStyleClass().add("grid");
		gp.setPadding(new Insets(15, 15, 15, 15));

		Label lTenChucNang = new Label("TAO MOI TRUONG PHONG");
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		GridPane.setConstraints(lTenChucNang, 0, 0, 4, 1, HPos.CENTER, VPos.TOP);
		gp.add(lTenChucNang, 0, 0);

		Label lTenDangNhap = new Label("Ten dang nhap");
		gp.add(lTenDangNhap, 0, 1);
		TextField tfTenDangNhap = new TextField();
		gp.add(tfTenDangNhap, 1, 1);
		tfTenDangNhap.setPrefWidth(175);

		tfTenDangNhap.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.SPACE) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Khong duoc chua khoang trang (\" \")");
					alert.showAndWait();
				}
			}

		});

		Label lMatKhau = new Label("Mat khau");
		gp.add(lMatKhau, 2, 1);
		TextField tfMatKhau = new TextField();
		gp.add(tfMatKhau, 3, 1);

		tfMatKhau.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.SPACE) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Khong duoc chua khoang trang (\" \")");
					alert.showAndWait();
				}
			}
		});

		Label lPhong = new Label("Phong");
		gp.add(lPhong, 0, 2);

		ComboBox cbPhong = new ComboBox(FXCollections.observableArrayList(chucNang.getAllPhong()));
		gp.add(cbPhong, 1, 2);
		cbPhong.setPrefWidth(230);

		Label lTenTruongPhong = new Label("Ten truong phong");
		gp.add(lTenTruongPhong, 2, 2);
		TextField tfTenTruongPhong = new TextField();
		gp.add(tfTenTruongPhong, 3, 2);

		Label lGioiTinh = new Label("Gioi tinh");
		gp.add(lGioiTinh, 0, 3);
		ToggleGroup tg = new ToggleGroup();
		RadioButton rbNam = new RadioButton("Nam");
		rbNam.requestFocus();
		rbNam.setUserData(new String("Nam"));
		rbNam.setToggleGroup(tg);
		GridPane.setConstraints(rbNam, 1, 4, 1, 1, HPos.LEFT, VPos.CENTER);
		gp.add(rbNam, 1, 3);
		RadioButton rbNu = new RadioButton("Nu");
		rbNu.setUserData(new String("Nu"));
		rbNu.setToggleGroup(tg);
		GridPane.setConstraints(rbNu, 1, 4, 1, 1, HPos.RIGHT, VPos.CENTER);
		gp.add(rbNu, 1, 3);

		Label lSoDienThoai = new Label("So dien thoai");
		gp.add(lSoDienThoai, 2, 3);
		TextField tfSoDienThoai = new TextField();
		gp.add(tfSoDienThoai, 3, 3);
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

		HBox hb = new HBox();
		hb.setSpacing(20);
		Image imageHT = new Image("/checked.png");/**/
		Button bHoanThanh = new Button("Hoan thanh", new ImageView(imageHT));/**/
		bHoanThanh.getStyleClass().add("Button");/**/
		Image imageQL = new Image("/previous.png");/**/
		Button bQuayLai = new Button("Quay lai", new ImageView(imageQL));/**/
		bQuayLai.getStyleClass().add("Button");/**/

		bHoanThanh.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {

				if (tfTenDangNhap.getText().equals("") || (rbNam.isSelected() == false && rbNu.isSelected() == false)
						|| tfSoDienThoai.getText().equals("") || cbPhong.getValue() == null
						|| tfMatKhau.getText().equals("") || tfTenTruongPhong.getText().equals("")) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Vui long nhap toan bo thong tin");
					alert.showAndWait();
				} else {

					TruongPhong truongPhong = new TruongPhong();

					truongPhong.setUserName(tfTenDangNhap.getText());
					truongPhong.setPassword(tfMatKhau.getText());
					truongPhong.setPhong(Integer.valueOf(cbPhong.getValue().toString()));
					truongPhong.setTen(tfTenTruongPhong.getText());
					truongPhong.setGioiTinh(tg.getSelectedToggle().getUserData().toString());
					truongPhong.setSoDienThoai(tfSoDienThoai.getText());

					if (chucNang.themTruongPhong(truongPhong)) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Thong bao");
						alert.setHeaderText(null);
						alert.setContentText("Thang cong");
						alert.showAndWait();
					}
				}
			}
		});

		hb.getChildren().addAll(bHoanThanh, bQuayLai);
		hb.setAlignment(Pos.CENTER);

		bQuayLai.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(chonTaoTaiKhoan(bp));
			}

		});

		gp.setAlignment(Pos.CENTER);
		vb.setAlignment(Pos.CENTER);

		vb.getChildren().addAll(gp, hb);
		return vb;
	}
}
