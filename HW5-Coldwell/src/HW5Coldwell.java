/**
 * Homework 5: JavaFx GUI
 * Student Name: Alex Coldwell
 * Course: CIS 357, Winter 2017
 * Instructor: Dr. Cho
 * Date Finished: 04/05/2.017
 * File Name: HW5Coldwell.java
 * Program Description: This program runs a POST system through a JavaFx GUI.
 * This program allows users to select a type and quantity of an Item and then
 * tells the user how much it would cost them. The Program then allows users
 * to add the item, quantity, and its total cost to its shopping cart. When 
 * the user adds items to their cart the program then displays the subtotal
 * and the tax total of all of their items. When the user is done shopping the
 * user enters how much they want to pay and the program will tell the user 
 * how change the customer is owned or how much they owe if there is not 
 * enough. When done the user is finished with the sale they press done and the
 * sale is recorded in the Total Sale object, and the total sales for the day
 * are displayed.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * JavaFx GUI for a POST system
 *
 * @author Alexander Coldwell
 */
public class HW5Coldwell extends Application {
    public double total = 0;
    public String[] products = new String[1];
    public TotalSale dailySale = new TotalSale();
    public int cost = 0;
    
    /**
     * This method runs the JavaFX GUI. This method first creates all of the
     * controls to go on each scene. It then creates event handlers for the
     * controls that produce events. This method then creates three scenes
     * and adds the controls to each scene and then sets the POSTRegester scene
     * as the current scene for the stage. The action events then manipulate
     * the GUI and The TotalSale Object.
     *
     * 
     * @param Stage JavaFx Stage to hold the scenes
    */
    @Override
    public void start(Stage Stage) {
        // Labels
        
        Label lblName = new Label("NA");
        Label lblPrice = new Label("$0.00");
        Label lblTotal = new Label("$0.00");
        Label lblSubTotal = new Label("$0.00");
        Label lblTaxTotal = new Label("$0.00");
        Label lblChange = new Label("$0.00");
        
        // Text Area
        TextArea lstRecipt = new TextArea();
        TextArea lstTotalSales = new TextArea();
        
        // Borders
        Border def = new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
        
        // ComboBox
        ComboBox<String> cbxItemId = new ComboBox<>();
        cbxItemId.setMinWidth(150);
        ArrayList<Items> list = new ArrayList<>();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(Stage);
        if (file != null) {
             ReadItems(list, file);
        }
        
        // Set Items into ComboBox
        for (int x = 0; x < list.size(); x++) {
            cbxItemId.getItems().add(String.valueOf(list.get(x).code));
        }
        
        // TextFiled
        TextField txtQuantity = new TextField();
        TextField txtTendered = new TextField();
        txtQuantity.setText("0");
        txtTendered.setText("0");
        
        // Buttons
        Button btnNewSale = new Button("New Sale");
        Button btnDone = new Button("Done");
        Button btnAdd = new Button("Add");
        btnAdd.setMinWidth(150);
        Button btnCheckout = new Button("Checkout");
        Button btnOk = new Button("Ok");
        Button btnTotalSales = new Button("Total Sales");
        
        // Create AddItem and CheckOutVbox
        GridPane AddItem = new GridPane();
        VBox CheckOutVbox = new VBox();
        AddItem.setPadding(new Insets(10, 10, 10, 10));
        CheckOutVbox.setPadding(new Insets(10, 10, 10, 10));
        
        // Create 
        GridPane CheckOut = new GridPane();
        AddItem.getColumnConstraints().add(new ColumnConstraints(20));
        AddItem.getColumnConstraints().add(new ColumnConstraints(70));
        CheckOut.getColumnConstraints().add(new ColumnConstraints(20));
        CheckOut.getColumnConstraints().add(new ColumnConstraints(110));
        CheckOut.getColumnConstraints().add(new ColumnConstraints(70));
        CheckOut.getColumnConstraints().add(new ColumnConstraints(70));
        AddItem.setBorder(def);
        CheckOutVbox.setBorder(def);
        
        // Add Children to AddItems
        AddItem.add(new Label("Item ID:"), 1, 1);
        AddItem.add(new Label("Item Name:"), 1, 2);
        AddItem.add(new Label("Item Price"), 1, 3);
        AddItem.add(new Label("Quantity"), 1, 4);
        AddItem.add(new Label("Item Total:"), 1, 5);
        AddItem.add(new Label(""), 1, 6);
        AddItem.add(cbxItemId, 2, 1);
        AddItem.add(lblName, 2, 2);
        AddItem.add(lblPrice, 2, 3);
        AddItem.add(txtQuantity, 2, 4);
        AddItem.add(lblTotal, 2, 5);
        AddItem.add(btnAdd, 2, 6);
        
         // Add Children to CheckOut
        CheckOut.add(new Label("Sale Sub Total:"), 1,2);
        CheckOut.add(new Label("Sale Tax Total (6%):"), 1,3);
        CheckOut.add(new Label("Tendered Amount:"), 1,4);
        CheckOut.add(new Label("Change:"), 1,5);
        CheckOut.add(lblSubTotal, 2,2);
        CheckOut.add(lblTaxTotal, 2,3);
        CheckOut.add(txtTendered, 2,4);
        CheckOut.add(btnCheckout, 3,4);
        CheckOut.add(lblChange, 2,5);
        
         
        // Add Items to Post
        VBox PostRegister = new VBox();
        PostRegister.setAlignment(Pos.CENTER);
        PostRegister.setSpacing(40);
        PostRegister.getChildren().add(new Label("Welcome to the POST System!!!"));
        PostRegister.getChildren().add(btnNewSale);
        PostRegister.getChildren().add(btnTotalSales);
        
        // Add Items to New Sale
        CheckOutVbox.getChildren().add(lstRecipt);
        CheckOutVbox.getChildren().add(CheckOut);
        VBox NewSaleRegister = new VBox();
        NewSaleRegister.setPadding(new Insets(10, 10, 10, 10));
        NewSaleRegister.getChildren().add(AddItem);
        NewSaleRegister.getChildren().add(CheckOutVbox);
        NewSaleRegister.getChildren().add(btnDone);
        
         // Create TotalSalesRegister
         VBox TotalSalesRegister = new VBox();
         TotalSalesRegister.setPadding(new Insets(10, 10, 10, 10));
         TotalSalesRegister.setAlignment(Pos.CENTER);
         TotalSalesRegister.getChildren().add(lstTotalSales);
         TotalSalesRegister.getChildren().add(btnOk);
        
        // Create scenes
        Scene Post = new Scene(PostRegister, 300, 250);
        Scene NewSale = new Scene(NewSaleRegister, 330, 500);
        Scene TotalSales = new Scene(TotalSalesRegister, 300, 250);

        Stage.setTitle("POST Register");
        Stage.setScene(Post);
        Stage.show();
        
        // Button Event Handelers
        btnNewSale.setOnAction((ActionEvent e) -> {
            total = 0;
            products = new String[1];
            lblName.setText("NA");
            lblPrice.setText("$0.00");
            lblTotal.setText("$0.00");
            lblSubTotal.setText("$0.00");
            lblTaxTotal.setText("$0.00");
            lblChange.setText("$0.00");
            txtQuantity.setText("");
            txtTendered.setText("");
            lstRecipt.clear();
            Stage.setTitle("New Sale");
            Stage.setScene(NewSale);
        });
        btnDone.setOnAction((ActionEvent e) -> {
            dailySale.addSale(products, (total * 1.06));
            Stage.setScene(TotalSales);
            Stage.setTitle("Total Sales");
            lstTotalSales.setText("");
            lstTotalSales.setText("All Items Sold: \n\n" + dailySale.getSales()
            + "\n Total Sales: " + String.format("%.2f", 
                    dailySale.getTotalSale()));
        });
        
        btnOk.setOnAction((ActionEvent e) -> {
            Stage.setScene(Post);
            Stage.setTitle("POST Register");
        });
        btnAdd.setOnAction((ActionEvent e) -> {
            double itemTotal;
            if (lstRecipt.getText().trim().isEmpty()) {
                itemTotal = Integer.parseInt(lblTotal.getText().
                        substring(1, lblTotal.getText().length() - 3));
                lstRecipt.setText("Items List \n\n");
                products[0] = (txtQuantity.getText() 
                        + " " + lblName.getText() + "   $" + 
                        itemTotal + "0");
                lstRecipt.setText(lstRecipt.getText() + products[0] + "\n");
                total = total +   itemTotal;
                lblSubTotal.setText(Double.toString(total));
                lblTaxTotal.setText(String.format("%.2f", total * 1.06));
            }
            else {
                itemTotal = Integer.parseInt(lblTotal.getText().
                        substring(1, lblTotal.getText().length() - 3));
                products = Arrays.copyOf(products,products.length + 1);
                products[products.length - 1] = (txtQuantity.getText() 
                        + " " + lblName.getText() + "   $" + 
                        itemTotal + "0");
                lstRecipt.setText(lstRecipt.getText() + 
                        products[products.length - 1] + "\n");
                total = total +   itemTotal;
                lblSubTotal.setText(Double.toString(total));
                lblTaxTotal.setText(Double.toString(total * 1.06));
            }
        });
        btnCheckout.setOnAction((ActionEvent e) -> {
        if (txtTendered.getText() == "") {
            lblChange.setText(String.format("%.2f", (0 - Double.
                    valueOf(lblTaxTotal.getText()))));
        }
        else {
            lblChange.setText(String.format("%.2f", (Double.
                    valueOf(txtTendered.getText())- Double.
                    valueOf(lblTaxTotal.getText()))));
        }
            
        });
        btnTotalSales.setOnAction((ActionEvent e) ->{
            Stage.setScene(TotalSales);
            Stage.setTitle("Total Sales");
        });
        txtQuantity.textProperty().addListener((observable, oldValue, newValue) 
        ->{
            lblTotal.setText("$" + String.valueOf(cost * Integer.parseInt
            (txtQuantity.getText()) + ".00"));
        });
        cbxItemId.setOnAction((ActionEvent e) ->{
            if ("A".equals(cbxItemId.getValue())) {
                lblName.setText(list.get(0).name);
                lblPrice.setText("$" + String.valueOf(list.get(0).cost)
                        + ".00");
                cost = list.get(0).cost;
            }
            else if ("B".equals(cbxItemId.getValue())) {
                lblName.setText(list.get(1).name);
                lblPrice.setText("$" + String.valueOf(list.get(1).cost)
                        + ".00");
                cost = list.get(1).cost;
            }
            else if ("C".equals(cbxItemId.getValue())) {
                lblName.setText(list.get(2).name);
                lblPrice.setText("$" + String.valueOf(list.get(2).cost)
                        + ".00");
                cost = list.get(2).cost;
            }
            else if ("D".equals(cbxItemId.getValue())) {
                lblName.setText(list.get(3).name);
                lblPrice.setText("$" + String.valueOf(list.get(3).cost)
                        + ".00");
                cost = list.get(3).cost;
            }
            else if ("E".equals(cbxItemId.getValue())) {
                lblName.setText(list.get(4).name);
                lblPrice.setText("$" + String.valueOf(list.get(4).cost)
                        + ".00");
                cost = list.get(4).cost;
            }
            else if ("F".equals(cbxItemId.getValue())) {
                lblName.setText(list.get(5).name);
                lblPrice.setText("$" + String.valueOf(list.get(5).cost)
                        + ".00");
                cost = list.get(5).cost;
            }
            else if ("G".equals(cbxItemId.getValue())) {
                lblName.setText(list.get(6).name);
                lblPrice.setText("$" + String.valueOf(list.get(6).cost)
                        + ".00");
                cost = list.get(6).cost;
            }
            else if ("H".equals(cbxItemId.getValue())) {
                lblName.setText(list.get(7).name);
                lblPrice.setText("$" + String.valueOf(list.get(7).cost)
                        + ".00");
                cost = list.get(7).cost;
            }
            else if ("I".equals(cbxItemId.getValue())) {
                lblName.setText(list.get(8).name);
                lblPrice.setText("$" + String.valueOf(list.get(8).cost)
                        + ".00");
                cost = list.get(8).cost;
            }
            else {
                lblName.setText(list.get(9).name);
                lblPrice.setText("$" + String.valueOf(list.get(9).cost)
                        + ".00");
                cost = list.get(9).cost;
            }
        });
    }

    /**
     * This method runs the program. it launches the JavaFx GUI
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * This method reads in the Item info from a file and then places it 
     * into an ArratList of Items objects.
     *
     * @param list ArrayList of Items to hold the store Items
     * @param file File object to open
     */
    public void ReadItems(ArrayList<Items> list, File file) {
        Charset charset = Charset.forName("US-ASCII");
        try { 
            //Construct BufferedReader from InputStreamReader
            BufferedReader reader = new BufferedReader(new FileReader(file));

            int ctr = 0;
            String line = null;
            while ((line = reader.readLine()) != null) {
                Items hold = new Items();
                String[] splited = line.split("\\s+");
                hold.code = splited[0].charAt(0);
                hold.name = splited[1];
                hold.cost = Integer.parseInt(splited[2]);
                list.add(hold);
            }

            reader.close();
        }
        catch (IOException e) {
            
        }
        
    }

}


