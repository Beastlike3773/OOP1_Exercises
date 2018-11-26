package topic07.atm;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ATMLayout extends Application {
    private VBox vBox = new VBox();
    private Button buttonCE = new Button("CE");
    private Button button0 = new Button("0");
    private Button buttonPoint = new Button(" . ");
    private Button buttonA = new Button("A");
    private Button buttonB = new Button("B");
    private Button buttonC = new Button("C");

    private TextArea textArea = new TextArea();
    private TextField textField = new TextField();
    private GridPane gridPane = new GridPane();

    @Override
    public void start(Stage stage) {
        textArea.setText("Enter customer number: ");
        HBox hBox1 = new HBox(textField);
        hBox1.setAlignment(Pos.CENTER);

        // grid stuff
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        addButtonsToButtonGrid();
        gridPane.setAlignment(Pos.CENTER);

        // button ce
        handleClearButton();

        // button .
        handlePointButton();

        // button 0
        handleButtonZero();

        ATM theATM;
        try {
            Bank theBank = new Bank();
            theBank.readCustomers("./src/topic07/atm/customers.txt");
            theATM = new ATM(theBank);
        } catch(IOException e) {
            System.out.println("Error opening accounts file.");
            return;
        }

        handleButtonA(theATM);
        handleButtonA(theATM);
        handleButtonA(theATM);


        // hbox for a b c buttons
        buttonA.setPrefSize(30,20);
        buttonB.setPrefSize(30,20);
        buttonC.setPrefSize(30,20);
        HBox hBox = new HBox(buttonA,buttonB,buttonC);

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        // global vBox
        vBox.getChildren().addAll(hBox1,gridPane,textArea,hBox);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(vBox, 300, 400);
        stage.setScene(scene);
        stage.show();
    }



    private void addButtonsToButtonGrid() {

        EventHandler<ActionEvent> buttonHandler = event -> {
            textField.setText(textField.getText() + ((Button)event.getSource()).getText());
            event.consume();
        };

        int row = 3;
        for(int i = 1; i <= 7; i += 3){
            int column = 0;
            for(int j = i; j <= i+2; j++){
                Button myButton = new Button("" + j);
                myButton.setPrefSize(30,20);
                myButton.setOnAction(buttonHandler);

                gridPane.add(myButton,column, row);
                column++;
            }
            row--;
        }
    }

    private void logic(ATM theATM) {
        int state = theATM.getState();
        if (state == ATM.START) {
            int number = Integer.parseInt(textField.getText());
            theATM.setCustomerNumber(number);
        } else if (state == ATM.PIN) {
            textArea.setText("Enter Pin");
            int pin = Integer.parseInt(textField.getText());
            theATM.selectCustomer(pin);
        } else if (state == ATM.ACCOUNT) {
            //System.out.print("A=Checking, B=Savings, C=Quit: ");
            String command = textField.getText();
            if (command.equalsIgnoreCase("A"))
                theATM.selectAccount(ATM.CHECKING);
            else if (command.equalsIgnoreCase("B"))
                theATM.selectAccount(ATM.SAVINGS);
            else if (command.equalsIgnoreCase("C"))
                theATM.reset();
            else
                System.out.println("Illegal input!");
        } else if (state == ATM.TRANSACT) {
            System.out.println("Balance=" + theATM.getBalance());
            System.out.print("A=Deposit, B=Withdrawal, C=Cancel: ");
            String command = textField.getText();
            if (command.equalsIgnoreCase("A")) {
                System.out.print("Amount: ");
                double amount = Double.parseDouble(textField.getText());
                theATM.deposit(amount);
                theATM.back();
            } else if (command.equalsIgnoreCase("B")) {
                System.out.print("Amount: ");
                double amount = Double.parseDouble(textField.getText());
                theATM.withdraw(amount);
                theATM.back();
            } else if (command.equalsIgnoreCase("C")) {
                theATM.back();
            } else {
                System.out.println("Illegal input!");
            }
        }
    }

    private void handleClearButton() {
        buttonCE.setOnAction(actionEvent -> textField.setText(""));
        buttonCE.setPrefSize(30,20);
        gridPane.add(buttonCE,0,4);
    }

    private void handleButtonZero() {
        button0.setOnAction(actionEvent -> textField.setText(textField.getText() + 0));
        button0.setPrefSize(30,20);
        gridPane.add(button0,1,4);
    }

    private void handlePointButton() {
        buttonPoint.setOnAction(actionEvent -> textField.setText(textField.getText() + "."));
        buttonPoint.setPrefSize(30,20);
        gridPane.add(buttonPoint,2,4);
    }

    private void handleButtonA(ATM theATM) {
        EventHandler<ActionEvent> buttonHandler = event -> {
            int state = theATM.getState();
            if (state == ATM.START) {
                int number = Integer.parseInt(textField.getText());
                theATM.setCustomerNumber(number);
                textArea.setText("Enter Pin");
                textField.setText("");
            } else if (state == ATM.PIN) {
                textArea.setText("A=Checking, B=Savings, C=Quit: ");
                int pin = Integer.parseInt(textField.getText());
                theATM.selectCustomer(pin);

            } else if (state == ATM.ACCOUNT) {
                theATM.selectAccount(ATM.CHECKING);
            }  else if (state == ATM.TRANSACT) {
                System.out.print("Amount: ");
                double amount = Double.parseDouble(textField.getText());
                theATM.deposit(amount);
                theATM.back();
            }
            event.consume();
        };
        buttonA.setOnAction(buttonHandler);
    }

    private void handleButtonB(ATM theATM) {
        EventHandler<ActionEvent> buttonHandler = event -> {
            logic(theATM);
            event.consume();
        };
        buttonB.setOnAction(buttonHandler);
    }

    private void handleButtonC(ATM theATM) {
        EventHandler<ActionEvent> buttonHandler = event -> {
            logic(theATM);
            event.consume();
        };
        buttonC.setOnAction(buttonHandler);
    }

    public static void main(String[] args) {
        launch();
    }
}
