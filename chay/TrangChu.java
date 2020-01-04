package chay;

import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import trangchu.DangNhap;
import trangchu.XacNhanMayChu;

public class TrangChu extends Application {

	public void start(Stage stage) throws Exception {

		trangChu(stage);
	}

	public static void trangChu(Stage stage) throws Exception {

		GridPane gp = new GridPane();
		gp.setHgap(350);
		gp.setVgap(350);
		gp.getStyleClass().add("grid");
		gp.setPadding(new Insets(15, 15, 15, 15));

		StackPane root = new StackPane();

		BorderPane bp = new BorderPane();

		Label lTenUngDungTren = new Label("Dien Va Nuoc");
		Label lTenUngDungDuoi = new Label("KTX Truong Cao Dang Luong Thuc - Thuc Pham");

		VBox vbTenUngDung = new VBox();
		vbTenUngDung.getChildren().addAll(lTenUngDungTren, lTenUngDungDuoi);
		vbTenUngDung.setAlignment(Pos.CENTER);
		gp.add(vbTenUngDung, 0, 0);
		GridPane.setConstraints(vbTenUngDung, 0, 0, 3, 1, HPos.CENTER, VPos.TOP);
		vbTenUngDung.getStyleClass().add("Label");

		Image image = new Image("/1.jpg");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		gp.add(imageView, 0, 1);

		Label lDiaChi = new Label("Dia chi: 101B Le Huu Trac - Phuoc My - Son Tra - Da Nang");
		gp.add(lDiaChi, 0, 2);
		GridPane.setConstraints(lDiaChi, 0, 2, 3, 2, HPos.RIGHT, VPos.BOTTOM);
		lDiaChi.getStyleClass().add("grid");
		lDiaChi.setFont(new Font(15));

		VBox vb = new VBox();
		root.getChildren().add(vb);
		vb.setSpacing(20);
		vb.setPadding(new Insets(15, 12, 15, 12));
		vb.getChildren().addAll(vbTenUngDung, imageView, lDiaChi);
		vb.setAlignment(Pos.CENTER);

		MenuBar mb = new MenuBar();

		Menu mDangNhap = new Menu("Dang nhap");

		MenuItem miChu = new MenuItem("Chu");
		MenuItem miTruongPhong = new MenuItem("Truong phong");
		MenuItem miNhanVien = new MenuItem("Nhan vien");

		mDangNhap.getItems().addAll(miChu, miTruongPhong, miNhanVien);

		Menu mDangKi = new Menu("Dang ki");
		MenuItem miDangKiChu = new MenuItem("Dang ki Chu");
		mDangKi.getItems().add(miDangKiChu);

		mb.getMenus().addAll(mDangNhap, mDangKi);
		GridPane.setConstraints(mb, 0, 0, 3, 1, HPos.RIGHT, VPos.TOP);
		gp.add(mb, 0, 0);

		MenuBar leftBar = new MenuBar();
		Region spacer = new Region();
		mb.getStyleClass().add("MenuBar");
		spacer.getStyleClass().add("MenuBar");
		leftBar.getStyleClass().add("MenuBar");
		HBox.setHgrow(spacer, Priority.SOMETIMES);
		HBox menubars = new HBox(leftBar, spacer, mb);

		bp.setTop(menubars);
		bp.setCenter(vb);
		root.getChildren().addAll(bp);
		root.getStyleClass().add("Root");

		Scene scene = new Scene(root);
		scene.getStylesheets().add("style.css");
		stage.setTitle("Quan li dien nuoc");
		stage.getIcons().add(new Image("/light-bulb.png"));
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();

		miChu.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(DangNhap.dangNhapChu(stage, scene, bp, vb));
			}

		});

		miTruongPhong.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(DangNhap.dangNhapTruongPhong(stage, scene, bp, vb));
			}

		});

		miNhanVien.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(DangNhap.dangNhapNhanVien(stage, scene, bp, vb));
			}

		});

		miDangKiChu.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(XacNhanMayChu.xacNhanMayChu(stage, scene, bp, vb));
			}

		});

		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent windowEvent) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Thoat");
				alert.setHeaderText(null);
				alert.setContentText("Ban co chac chan khong?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {

				} else {
					windowEvent.consume();
				}
			}

		});

	}

	public static void main(String[] args) {
		launch(args);

	}

}
