package lamviec;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
import lop.LuongNhanVien;
import lop.NhanVien;
import lop.TruongPhong;

public class ChucNangNhanVien {

	static ILayDuLieu chucNang = new LayDuLieu();

	public static VBox thongTin(NhanVien nhanVien) {
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

		Label lId = new Label("Id: " + nhanVien.getId());
		gp.add(lId, 0, 0);
		GridPane.setConstraints(lId, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lTen = new Label("Ten: " + nhanVien.getTen());
		gp.add(lTen, 0, 1);
		GridPane.setConstraints(lTen, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lGioiTinh = new Label("Gioi tinh: " + nhanVien.getGioiTinh());
		gp.add(lGioiTinh, 0, 2);
		GridPane.setConstraints(lGioiTinh, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lNgaySinh = new Label("Ngay sinh: " + nhanVien.getNgaySinh());
		gp.add(lNgaySinh, 0, 3);
		GridPane.setConstraints(lNgaySinh, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lDiaChi = new Label("Dia chi: " + nhanVien.getDiaChi());
		gp.add(lDiaChi, 0, 4);
		GridPane.setConstraints(lDiaChi, 0, 4, 1, 1, HPos.LEFT, VPos.CENTER);

		Label lSoDienThoai = new Label("So dien thoai: " + nhanVien.getSoDienThoai());
		gp.add(lSoDienThoai, 0, 5);
		GridPane.setConstraints(lSoDienThoai, 0, 5, 1, 1, HPos.LEFT, VPos.CENTER);

		vb.getChildren().add(gp);
		return vb;
	}

	public static VBox doiMatKhau(NhanVien nhanVien) {
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

		Image imageXN = new Image("/checked.png");/**/
		Button bXacNhan = new Button("Xac nhan", new ImageView(imageXN));/**/
		bXacNhan.getStyleClass().add("Button");/**/
		gp.add(bXacNhan, 0, 3);
		GridPane.setConstraints(bXacNhan, 0, 3, 2, 1, HPos.CENTER, VPos.CENTER);
		vb.getChildren().add(gp);
		vb.setAlignment(Pos.CENTER);

		bXacNhan.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent keyEvent) {

				System.out.println(nhanVien.getPassword());
				if ("".equals(pfMatKhauCu.getText()) || "".equals(pfMatKhauMoi.getText())
						|| "".equals(pfNhapLai.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap du thong tin");
					alert.showAndWait();
				} else if (nhanVien.getPassword().equals(pfMatKhauCu.getText())) {
					if (pfMatKhauMoi.getText().equals(pfNhapLai.getText())) {
						nhanVien.setPassword(pfNhapLai.getText());
						chucNang.updateNhanVien(nhanVien);

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

		return vb;
	}

	public static VBox doiSoDienThoai(NhanVien nhanVien) {
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
		tfSoDienThoaiCu.setEditable(false);
		gp.add(tfSoDienThoaiCu, 1, 0);
		tfSoDienThoaiCu.setText(nhanVien.getSoDienThoai());
		tfSoDienThoaiCu.setEditable(false);

		Label lSoDienThoaiMoi = new Label("So dien thoai moi (*)");
		gp.add(lSoDienThoaiMoi, 0, 1);
		GridPane.setConstraints(lSoDienThoaiMoi, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfSoDienThoaiMoi = new TextField();
		gp.add(tfSoDienThoaiMoi, 1, 1);

		tfSoDienThoaiMoi.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

		Image imageXN = new Image("/checked.png");/**/
		Button bXacNhan = new Button("Xac nhan", new ImageView(imageXN));/**/
		bXacNhan.getStyleClass().add("Button");/**/

		gp.add(bXacNhan, 0, 2);
		GridPane.setConstraints(bXacNhan, 0, 2, 2, 1, HPos.CENTER, VPos.CENTER);
		vb.getChildren().add(gp);
		vb.setAlignment(Pos.CENTER);

		return vb;
	}

	public static VBox doiDiaChi(NhanVien nhanVien) {
		VBox vb = new VBox();
		vb.setPadding(new Insets(12, 12, 12, 12));
		vb.setSpacing(20);

		Image image = new Image("/map.png");/**/
		Label lb = new Label(" ", new ImageView(image));/**/
		GridPane.setConstraints(lb, 0, 0, 2, 1, HPos.CENTER, VPos.TOP);/**/
		vb.getChildren().add(lb);/**/

		Label lTenChucNang = new Label("DOI DIA CHI");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(15);
		gp.setVgap(10);
		Label lDiaChiCu = new Label("Dia chi cu");
		gp.add(lDiaChiCu, 0, 0);
		GridPane.setConstraints(lDiaChiCu, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfDiaChiCu = new TextField();
		tfDiaChiCu.setEditable(false);
		gp.add(tfDiaChiCu, 1, 0);
		tfDiaChiCu.setText(nhanVien.getDiaChi());
		tfDiaChiCu.setEditable(false);

		Label lDiaChiMoi = new Label("Dia chi moi (*)");
		gp.add(lDiaChiMoi, 0, 1);
		GridPane.setConstraints(lDiaChiMoi, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfDiaChiMoi = new TextField();
		gp.add(tfDiaChiMoi, 1, 1);
		Image imageXN = new Image("/checked.png");/**/
		Button bXacNhan = new Button("Xac nhan", new ImageView(imageXN));
		bXacNhan.getStyleClass().add("Button");
		gp.add(bXacNhan, 0, 2);
		GridPane.setConstraints(bXacNhan, 0, 2, 2, 1, HPos.CENTER, VPos.CENTER);
		vb.getChildren().add(gp);
		vb.setAlignment(Pos.CENTER);
		return vb;
	}

	public static VBox xemTruongPhong() {
		VBox vb = new VBox();

		vb.setPadding(new Insets(20, 20, 20, 20));
		vb.setSpacing(20);

		Label lTenChucNang = new Label("XEM THONG TIN TRUONG PHONG");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.getStyleClass().add("LabelTieuDe");
		vb.setAlignment(Pos.TOP_CENTER);

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

		Image imageTK = new Image("/loupe.png");/**/
		Button bTimKiem = new Button("Tim kiem", new ImageView(imageTK));/**/
		bTimKiem.getStyleClass().add("Button");/**/

		hb.getChildren().addAll(tfPhong, bTimKiem);
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

		bTimKiem.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				String phong = tfPhong.getText();

				ObservableList<TruongPhong> timKiem = FXCollections
						.observableArrayList(chucNang.timKiemTruongPhong(phong));
				tv.setItems(timKiem);

			}
		});

		return vb;
	}

	public static VBox nhapLuongDungNuoc() {
		VBox vb = new VBox();
		vb.setPadding(new Insets(12, 12, 12, 12));
		vb.setSpacing(20);
		Label lTenChucNang = new Label("NHAP LUONG NUOC DA SU DUNG CUA CAC PHONG");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(15);
		gp.setVgap(10);

		Label lNam = new Label("Nam");
		gp.add(lNam, 0, 0);
		GridPane.setConstraints(lNam, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfNam = new TextField();
		gp.add(tfNam, 1, 0);

		tfNam.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

		Label lThang = new Label("Thang");
		gp.add(lThang, 0, 1);
		GridPane.setConstraints(lThang, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfThang = new TextField();
		gp.add(tfThang, 1, 1);

		tfThang.setOnKeyPressed(new EventHandler<KeyEvent>() {
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


		Label lPhong = new Label("Phong");
		gp.add(lPhong, 0, 2);
		GridPane.setConstraints(lPhong, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER);

		ComboBox cbPhong = new ComboBox(FXCollections.observableArrayList(chucNang.getAllPhong()));
		cbPhong.setPrefWidth(230);
		gp.add(cbPhong, 1, 2);

	
		Label lChiSoCuoi = new Label("Chi so cuoi");
		gp.add(lChiSoCuoi, 0, 3);
		GridPane.setConstraints(lChiSoCuoi, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfChiSoCuoi = new TextField();
		gp.add(tfChiSoCuoi, 1, 3);

		tfChiSoCuoi.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
		Button bThem = new Button("Them", new ImageView(imageXN));/**/
		bThem.getStyleClass().add("Button");/**/
		gp.add(bThem, 0, 4);
		GridPane.setConstraints(bThem, 0, 4, 2, 1, HPos.CENTER, VPos.CENTER);

		vb.setAlignment(Pos.CENTER);

		TableView<Dung> tv = new TableView<>();

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
		cPhong.setCellValueFactory(new PropertyValueFactory<>("phong"));
		cNam.setCellValueFactory(new PropertyValueFactory<>("nam"));
		cThang.setCellValueFactory(new PropertyValueFactory<>("thang"));
		cSoDau.setCellValueFactory(new PropertyValueFactory<>("soDau"));
		cSoCuoi.setCellValueFactory(new PropertyValueFactory<>("soCuoi"));
		cLuongDung.setCellValueFactory(new PropertyValueFactory<>("luongDung"));
		cTien.setCellValueFactory(new PropertyValueFactory<>("tienNuoc"));
		vb.getChildren().addAll(gp, tv);


		bThem.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				Integer phong = Integer.valueOf(cbPhong.getValue().toString());
				System.out.println(phong);
				Integer soCuoiCu = chucNang.soCuoi("NUOC", phong);
				System.out.println(soCuoiCu);
				if ("".equals(tfNam.getText()) || "".equals(tfNam.getText()) || phong == null
						|| "".equals(tfChiSoCuoi.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap du thong tin");
					alert.showAndWait();
				} else if (Integer.valueOf(tfThang.getText()) > 12 || Integer.valueOf(tfThang.getText()) < 1
						|| Integer.valueOf(tfNam.getText()) < 0) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Nam hoac thang khong hop le");
					alert.showAndWait();
				} else {
					Integer nam = Integer.valueOf(tfNam.getText());
					Integer thang = Integer.valueOf(tfThang.getText());
					Integer soDau = soCuoiCu;
					Integer soCuoi = Integer.valueOf(tfChiSoCuoi.getText());
					chucNang.themDungNuoc(new Dung(phong, nam, thang, soDau, soCuoi));
				}

				ObservableList<Dung> data = FXCollections.observableArrayList(chucNang.getDungDien(null));
				tv.setItems(data);

			}
		});

		return vb;
	}

	public static VBox nhapLuongDungDien() {
		VBox vb = new VBox();
		vb.setPadding(new Insets(12, 12, 12, 12));
		vb.setSpacing(20);
		Label lTenChucNang = new Label("NHAP LUONG DIEN DA SU DUNG CUA CAC PHONG");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(15);
		gp.setVgap(10);

		Label lNam = new Label("Nam");
		gp.add(lNam, 0, 0);
		GridPane.setConstraints(lNam, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfNam = new TextField();
		gp.add(tfNam, 1, 0);
		
		tfNam.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

		Label lThang = new Label("Thang");
		gp.add(lThang, 0, 1);
		GridPane.setConstraints(lThang, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfThang = new TextField();
		gp.add(tfThang, 1, 1);
		
		tfThang.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

		Label lPhong = new Label("Phong");
		gp.add(lPhong, 0, 2);
		GridPane.setConstraints(lPhong, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER);

		ComboBox cbPhong = new ComboBox(FXCollections.observableArrayList(chucNang.getAllPhong()));
		cbPhong.setPrefWidth(230);
		gp.add(cbPhong, 1, 2);

		Label lChiSoCuoi = new Label("Chi so cuoi");
		gp.add(lChiSoCuoi, 0, 3);
		GridPane.setConstraints(lChiSoCuoi, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfChiSoCuoi = new TextField();
		gp.add(tfChiSoCuoi, 1, 3);
		
		
		tfChiSoCuoi.setOnKeyPressed(new EventHandler<KeyEvent>() {
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
		Button bThem = new Button("Them", new ImageView(imageXN));/**/
		bThem.getStyleClass().add("Button");/**/
		gp.add(bThem, 0, 4);
		GridPane.setConstraints(bThem, 0, 4, 2, 1, HPos.CENTER, VPos.CENTER);

		vb.setAlignment(Pos.CENTER);

		TableView<Dung> tv = new TableView<>();

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
		vb.getChildren().addAll(gp, tv);

		bThem.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				Integer phong = Integer.valueOf(cbPhong.getValue().toString());
				System.out.println(phong);
				Integer soCuoiCu = chucNang.soCuoi("DIEN", phong);
				System.out.println(soCuoiCu);
				if ("".equals(tfNam.getText()) || "".equals(tfNam.getText()) || phong == null
						|| "".equals(tfChiSoCuoi.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap du thong tin");
					alert.showAndWait();
				} else if (Integer.valueOf(tfThang.getText()) > 12 || Integer.valueOf(tfThang.getText()) < 1
						|| Integer.valueOf(tfNam.getText()) < 0) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao");
					alert.setHeaderText(null);
					alert.setContentText("Nam hoac thang khong hop le");
					alert.showAndWait();
				} else {
					Integer nam = Integer.valueOf(tfNam.getText());
					Integer thang = Integer.valueOf(tfThang.getText());
					Integer soDau = soCuoiCu;
					Integer soCuoi = Integer.valueOf(tfChiSoCuoi.getText());
					chucNang.themDungDien(new Dung(phong, nam, thang, soDau, soCuoi));
				}

				ObservableList<Dung> data = FXCollections.observableArrayList(chucNang.getDungDien(null));
				tv.setItems(data);

			}
		});

		return vb;

	}

	public static VBox xemLuong(NhanVien nhanVien) {
		VBox vb = new VBox();
		vb.setPadding(new Insets(12, 12, 12, 12));
		vb.setSpacing(20);
		Label lTenChucNang = new Label("XEM LUONG");
		vb.getChildren().add(lTenChucNang);
		lTenChucNang.setAlignment(Pos.TOP_CENTER);
		lTenChucNang.getStyleClass().add("LabelTieuDe");
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(15);
		gp.setVgap(10);

		Label lNam = new Label("Nam");
		gp.add(lNam, 0, 0);
		GridPane.setConstraints(lNam, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfNam = new TextField();
		gp.add(tfNam, 1, 0);

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

		Label lThang = new Label("Thang");
		gp.add(lThang, 0, 1);
		GridPane.setConstraints(lThang, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER);

		TextField tfThang = new TextField();
		gp.add(tfThang, 1, 1);

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

		Image imageXN = new Image("/checked.png");/**/
		Button bTimKiem = new Button("Tim kiem", new ImageView(imageXN));/**/
		bTimKiem.getStyleClass().add("Button");/**/
		gp.add(bTimKiem, 0, 2);
		GridPane.setConstraints(bTimKiem, 0, 2, 2, 1, HPos.CENTER, VPos.CENTER);
		vb.getChildren().add(gp);
		vb.setAlignment(Pos.CENTER);

		TableView<LuongNhanVien> tv = new TableView<>();
		vb.getChildren().addAll(tv);

		TableColumn<LuongNhanVien, Integer> cNam = new TableColumn<>("Nam");
		TableColumn<LuongNhanVien, Integer> cThang = new TableColumn<>("Thang");
		TableColumn<LuongNhanVien, Integer> cLuong = new TableColumn<>("Luong");
		tv.getColumns().addAll(cNam, cThang, cLuong);

		ObservableList<LuongNhanVien> data = FXCollections.observableArrayList(chucNang.getLuong(nhanVien.getId()));
		tv.setItems(data);
		cNam.setCellValueFactory(new PropertyValueFactory<>("nam"));
		cThang.setCellValueFactory(new PropertyValueFactory<>("thang"));
		cLuong.setCellValueFactory(new PropertyValueFactory<>("luong"));

		cThang.prefWidthProperty().bind(tv.widthProperty().multiply(0.2));
		cNam.prefWidthProperty().bind(tv.widthProperty().multiply(0.2));
		cLuong.prefWidthProperty().bind(tv.widthProperty().multiply(0.1));

		tv.setEditable(true);

		bTimKiem.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				String nam = tfNam.getText();
				String thang = tfThang.getText();

				ObservableList<LuongNhanVien> timKiem = FXCollections
						.observableArrayList(chucNang.timKiemLuong(nhanVien.getId(), nam, thang));
				tv.setItems(timKiem);

			}
		});

		return vb;
	}

}
