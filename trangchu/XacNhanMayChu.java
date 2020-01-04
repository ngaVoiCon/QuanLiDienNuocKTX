package trangchu;

import javafx.event.ActionEvent;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class XacNhanMayChu {

	public static GridPane xacNhanMayChu(Stage stage, Scene scene, BorderPane bp, VBox vb) {

		GridPane gp = new GridPane();
		gp.setHgap(15);
		gp.setVgap(10);
		gp.getStyleClass().add("grid");
		gp.setPadding(new Insets(15, 15, 15, 15));

		Label lTenChucNang = new Label("Ban chi co the dang ki khi ban la chu!");
		gp.add(lTenChucNang, 0, 0);
		GridPane.setConstraints(lTenChucNang, 0, 0, 2, 1, HPos.CENTER, VPos.TOP);
		lTenChucNang.setFont(new Font(25));
		lTenChucNang.getStyleClass().add("LabelTieuDe");

		Label lMaBaoMat = new Label("Nhap ma bao mat");
		gp.add(lMaBaoMat, 0, 1);

		PasswordField pfMaBaoMat = new PasswordField();
		gp.add(pfMaBaoMat, 1, 1);

		Button bXacNhan = new Button("Xac nhan");
		gp.add(bXacNhan, 2, 1);
		bXacNhan.getStyleClass().add("Button");
		bXacNhan.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {

				if ("123456".equals(pfMaBaoMat.getText()))
					bp.setCenter(DangKi.dangKi(stage, scene, bp, vb));
				else if ("".equals(pfMaBaoMat.getText())) {
					pfMaBaoMat.clear();
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao!");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap ma bao mat");
					alert.showAndWait();
				} else {
					pfMaBaoMat.clear();
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao!");
					alert.setHeaderText(null);
					alert.setContentText("Sai ma bao mat");
					alert.showAndWait();
				}
			}

		});

		pfMaBaoMat.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				if ("123456".equals(pfMaBaoMat.getText()))
					bp.setCenter(DangKi.dangKi(stage, scene, bp, vb));
				else if ("".equals(pfMaBaoMat.getText())) {
					pfMaBaoMat.clear();
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao!");
					alert.setHeaderText(null);
					alert.setContentText("Chua nhap ma bao mat");
					alert.showAndWait();
				} else {
					pfMaBaoMat.clear();
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Canh bao!");
					alert.setHeaderText(null);
					alert.setContentText("Sai ma bao mat");
					alert.showAndWait();
				}
			}
		});

		gp.setAlignment(Pos.CENTER);

		return gp;

	}

}
