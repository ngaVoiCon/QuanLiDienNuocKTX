package trangchu;

import java.sql.Date;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import laydulieu.ILayDuLieu;
import laydulieu.LayDuLieu;
import lop.Chu;

public class DangKi {
	
	static ILayDuLieu chucNang = new LayDuLieu();
	public static GridPane dangKi(Stage stage, Scene scene,BorderPane bp, VBox vb) {

		GridPane gp = new GridPane();
		gp.setHgap(25);
		gp.setVgap(20);
		gp.getStyleClass().add("grid");
		gp.setPadding(new Insets(15, 15, 15, 15));

		Label lTenChucNang = new Label("Dang Ki");
		GridPane.setConstraints(lTenChucNang, 0, 0, 4, 1, HPos.CENTER, VPos.TOP);
		gp.add(lTenChucNang, 0, 0);
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		Label lTenDangNhap = new Label("Ten dang nhap");
		gp.add(lTenDangNhap, 0, 1);
		lTenDangNhap.setPrefWidth(140);

		TextField tfTenDangNhap = new TextField();
		gp.add(tfTenDangNhap, 1, 1);
		tfTenDangNhap.setPrefWidth(230);
		
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

		Label lTen = new Label("Ten");
		gp.add(lTen, 2, 1);
		lTen.setPrefWidth(140);

		TextField tfTen = new TextField();

		gp.add(tfTen, 3, 1);
		tfTen.setPrefWidth(230);

		Label lMatKhau = new Label("Mat khau");
		gp.add(lMatKhau, 0, 2);

		TextField tfMatKhau = new TextField();
		gp.add(tfMatKhau, 1, 2);
		


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

		Label lSoDienThoai = new Label("So dien thoai");
		gp.add(lSoDienThoai, 2, 2);
		TextField tfSoDienThoai = new TextField();

	/*	tfSoDienThoai.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent keyEvent) {
				
			}
		});*/

		gp.add(tfSoDienThoai, 3, 2);
		
		tfSoDienThoai.setOnKeyPressed(new EventHandler<KeyEvent>() {
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

		Label lDiaChi = new Label("Dia chi");
		gp.add(lDiaChi, 0, 3);

		TextField tfDiaChi = new TextField();
		gp.add(tfDiaChi, 1, 3);

		Label lGioiTinh = new Label("Gioi tinh");
		gp.add(lGioiTinh, 0, 4);

		final ToggleGroup toggleGroup = new ToggleGroup();

		RadioButton rbNam = new RadioButton("Nam");
		rbNam.setSelected(false);
		rbNam.requestFocus();
		rbNam.setUserData(new String("Nam"));
		rbNam.setToggleGroup(toggleGroup);
		gp.add(rbNam, 1, 4);
		GridPane.setConstraints(rbNam, 1, 4, 1, 1, HPos.LEFT, VPos.BASELINE);

		RadioButton rbNu = new RadioButton("Nu");
		rbNu.setUserData(new String("Nu"));
		rbNu.setToggleGroup(toggleGroup);
		gp.add(rbNu, 1, 4);
		GridPane.setConstraints(rbNu, 1, 4, 1, 1, HPos.RIGHT, VPos.BASELINE);

		Label lNgaySinh = new Label("Ngay sinh");
		gp.add(lNgaySinh, 2, 3);

		DatePicker dpNgaySinh = new DatePicker();
		dpNgaySinh.setPrefWidth(230);
		gp.add(dpNgaySinh, 3, 3);

		Image image = new Image("/checked.png");
		Button bHoanThanh = new Button("Hoan thanh", new ImageView(image));
		
		bHoanThanh.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent) {
				if (tfTenDangNhap.getText().equals("") || dpNgaySinh.getValue() == null
						|| (rbNam.isSelected() == false && rbNu.isSelected() == false)
						|| tfSoDienThoai.getText().equals("") || tfDiaChi.getText().equals("")
						|| tfMatKhau.getText().equals("") || tfTen.getText().equals("")) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Vui long nhap toan bo thong tin");
					alert.showAndWait();
				} else {

					Chu chu = new Chu();

					chu.setUserName(tfTenDangNhap.getText());
					chu.setPassword(tfMatKhau.getText());
					chu.setTen(tfTen.getText());
					chu.setGioiTinh(toggleGroup.getSelectedToggle().getUserData().toString());
					chu.setNgaySinh(Date.valueOf(dpNgaySinh.getValue()));
					chu.setDiaChi(tfDiaChi.getText());
					chu.setSoDienThoai(tfSoDienThoai.getText());

					if (chucNang.themChu(chu)) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Thong bao");
						alert.setHeaderText(null);
						alert.setContentText("Thang cong");
						alert.showAndWait();
						
						bp.setCenter(DangNhap.dangNhapChu(stage, scene, bp, vb));
					}
				}
			}
		});
		
		
		gp.add(bHoanThanh, 1, 6);
		bHoanThanh.getStyleClass().add("Button");
		GridPane.setConstraints(bHoanThanh, 1, 6, 4, 1, HPos.CENTER, VPos.CENTER);

		
 
		gp.setAlignment(Pos.CENTER);

		return gp;
	}

}
