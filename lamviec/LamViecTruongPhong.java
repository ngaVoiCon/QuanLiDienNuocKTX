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
import lop.TruongPhong;

public class LamViecTruongPhong {

	public static Scene lamViecTruongPhong(Stage stage, TruongPhong truongPhong) throws Exception {
		// Image image1 = new Image(getClass().getResourceAsStream("/profile.png"));

		BorderPane bp = new BorderPane();

		MenuBar leftBar = new MenuBar();
		MenuBar rightBar = new MenuBar();
		Menu mTaiKhoan = new Menu("Tai khoan");

		// taiKhoan.setGraphic(new ImageView(image1));

		// capNhat.setStyle("-fx-background-color: #00ff00;");
		MenuItem miThongTin = new MenuItem("Thong tin");
		Menu mCapNhat = new Menu("Cap nhat");
		MenuItem miMatKhau = new MenuItem("Mat khau");
		MenuItem miSoDienThoat = new MenuItem("So dien thoai");
		MenuItem miPhong = new MenuItem("Phong");

		mCapNhat.getItems().addAll(miMatKhau, miSoDienThoat, miPhong);

		MenuItem miDangXuat = new MenuItem("Dang xuat");
		mTaiKhoan.getItems().addAll(miThongTin, mCapNhat, miDangXuat);
		rightBar.getMenus().addAll(mTaiKhoan);
		rightBar.getStyleClass().add("MenuBar");/**/
		Region spacer = new Region();
		spacer.getStyleClass().add("MenuBar");/**/
		HBox.setHgrow(spacer, Priority.SOMETIMES);
		HBox menubars = new HBox(leftBar, spacer, rightBar);
		bp.setTop(menubars);

		miThongTin.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(ChucNangTruongPhong.thongTin(truongPhong));
			}

		});

		miMatKhau.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(ChucNangTruongPhong.doiMatKhau(truongPhong));
			}

		});
		miSoDienThoat.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(ChucNangTruongPhong.doiSoDienThoai(truongPhong));
			}

		});
		miPhong.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				bp.setCenter(ChucNangTruongPhong.doiPhong(truongPhong));
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
		ObservableList<String> i = FXCollections.observableArrayList("Xem Thong tin Nhan vien",
				"Xem Thong tin dien da su dung", "Xem thong tin nuoc da su dung");
		lv.setItems(i);
		lv.setPrefWidth(300);
		bp.setLeft(lv);

		lv.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> object, Object oldValue, Object newValue) {
				System.out.println("value: " + newValue);
				if ("0".equals(newValue.toString())) {
					bp.setCenter(ChucNangTruongPhong.xemNhanVien());
				}
				if ("1".equals(newValue.toString())) {
					bp.setCenter(ChucNangTruongPhong.xemDien(truongPhong));
				}
				if ("2".equals(newValue.toString())) {
					bp.setCenter(ChucNangTruongPhong.xemNuoc(truongPhong));
				}
			}

		});

		lv.getSelectionModel().selectFirst();
		lv.getStyleClass().add("ListView");/**/

		Scene scene = new Scene(bp);
		scene.getStylesheets().add("style.css");/**/
		stage.setScene(scene);
		stage.setFullScreen(true);
		bp.getStyleClass().add("Root");/**/
		return scene;

	}

}
