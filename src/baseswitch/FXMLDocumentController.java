package baseswitch;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.NotificationPane;
import org.controlsfx.control.Notifications;

public class FXMLDocumentController implements Initializable 
{
    @FXML JFXButton DecimalButton;
    @FXML JFXButton HexaButton;
    @FXML JFXButton OctalButton;
    @FXML JFXButton BinaryButton;
    @FXML AnchorPane MainPane;
    @FXML JFXTextField InputTextField;
    
    @FXML JFXTextField TextField1;
    @FXML JFXTextField TextField2;
    @FXML JFXTextField TextField3;
    
    @FXML Label Label1;
    @FXML Label Label2;
    @FXML Label Label3;

     NotificationPane notificationPane = new NotificationPane();   

    @FXML private void DecimalButtonFunction(MouseEvent event)
    {
        //Setting the Decimal button with the default effect.
        DecimalButton.setButtonType(JFXButton.ButtonType.RAISED);
        DecimalButton.setUnderline(true);
        //Resetting other buttons.
        BinaryButton.setUnderline(false);
        BinaryButton.setButtonType(JFXButton.ButtonType.FLAT);
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), MainPane);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.94);
        fadeOut.play();
        
        //Setting Labels.
        Label1.setText("Binary");
        Label2.setText("Octal");
        Label3.setText("Hexa");
        
        
        //Reading the Decimal Input.
        int readDecimal = Integer.parseInt(InputTextField.getText());
        
        //Converting Decimal To Binary.
        String Decimal2Binary = Integer.toBinaryString(readDecimal);
        TextField1.setText(Decimal2Binary);
        
        //Converting Decimal to Octal.
        String Decimal2Octal = Integer.toOctalString(readDecimal);
        TextField2.setText(Decimal2Octal);
        
        //Converting Decimal to HexaDecimal
        String Decimal2Hexa = Integer.toHexString(readDecimal).toUpperCase();
        TextField3.setText(Decimal2Hexa);
    }
    
    @FXML private void BinaryButtonFunction(MouseEvent event)
    {
        //Setting the Binary Button.
        BinaryButton.setButtonType(JFXButton.ButtonType.RAISED);
        BinaryButton.setUnderline(true);
        
        //Resetting Other Buttons
        DecimalButton.setButtonType(JFXButton.ButtonType.FLAT);
        DecimalButton.setUnderline(false);
        OctalButton.setButtonType(JFXButton.ButtonType.FLAT);
        OctalButton.setUnderline(false);
        HexaButton.setButtonType(JFXButton.ButtonType.FLAT);
        HexaButton.setUnderline(false);
        //Default effects
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), MainPane);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.92);
        fadeOut.play();
        
        //Adjusting Labels 
        Label1.setText("Decimal");
        Label2.setText("Octal");
        Label3.setText("Hexa");
        
        String readBinary = InputTextField.getText();
        //Making sure that the user input is either 0 or 1.
        if(readBinary.contains("2") | readBinary.contains("3")| readBinary.contains("4")| readBinary.contains("5")| readBinary.contains("6")| readBinary.contains("7")| readBinary.contains("8")| readBinary.contains("9"))
        {
            Notifications.create().title("Error").text("Binary can only contain 1 & 0.").position(Pos.CENTER).hideAfter(Duration.seconds(1.8)).showError();
            TextField1.clear();
            TextField2.clear();
            TextField3.clear();
        }
        
        else
        {
        int convertBinary2Decimal = Integer.parseInt(readBinary,2);
        String Binary2Octal = Integer.toOctalString(convertBinary2Decimal);
        String Binary2Hexa = Integer.toHexString(convertBinary2Decimal).toUpperCase();
        
        TextField1.setText(String.valueOf(convertBinary2Decimal));
        TextField2.setText(Binary2Octal);
        TextField3.setText(Binary2Hexa);
        }
    }
    
    @FXML private void OctalButtonFunction(MouseEvent event)
    {
        //Setting the Octal Button.
        OctalButton.setButtonType(JFXButton.ButtonType.RAISED);
        OctalButton.setUnderline(true);
        //Resetting Other Buttons
        DecimalButton.setButtonType(JFXButton.ButtonType.FLAT);
        DecimalButton.setUnderline(false);
        BinaryButton.setButtonType(JFXButton.ButtonType.FLAT);
        BinaryButton.setUnderline(false);
        HexaButton.setButtonType(JFXButton.ButtonType.FLAT);
        HexaButton.setUnderline(false);
        
        //Setting the default effect.
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), MainPane);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.90);
        fadeOut.play();
        
        //Setting Labels.
        Label1.setText("Decimal");
        Label2.setText("Binary");
        Label3.setText("Hexa");
        
        String readOctal =  InputTextField.getText();
        if(readOctal.contains("8") | readOctal.contains("9"))
        {
            Notifications.create().title("Error").text("Octal ranges from 0 to 7.").position(Pos.CENTER).hideAfter(Duration.seconds(1.8)).showError();
            TextField1.clear();
            TextField2.clear();
            TextField3.clear();
        }
        else
        {
        int convertOctal2Decimal = Integer.parseInt(readOctal,8);
        String Octal2Binary = Integer.toBinaryString(convertOctal2Decimal);
        String Octal2Hexa = Integer.toHexString(convertOctal2Decimal).toUpperCase();
        TextField1.setText(String.valueOf(convertOctal2Decimal));
        TextField2.setText(Octal2Binary);
        TextField3.setText(Octal2Hexa);
        }
    }
    
    @FXML private void HexaButtonFunction(MouseEvent event)
    {
        InputTextField.setText(InputTextField.getText().toUpperCase());
        //Setting the Hexa Button.
        HexaButton.setButtonType(JFXButton.ButtonType.RAISED);
        HexaButton.setUnderline(true);
        //Resetting other Buttons.
        DecimalButton.setButtonType(JFXButton.ButtonType.FLAT);
        DecimalButton.setUnderline(false);
        BinaryButton.setButtonType(JFXButton.ButtonType.FLAT);
        BinaryButton.setUnderline(false);
        OctalButton.setButtonType(JFXButton.ButtonType.FLAT);
        OctalButton.setUnderline(false);
        
        //Setting Labels.
        Label1.setText("Decimal");
        Label2.setText("Binary");
        Label3.setText("Octal");
        
        //Setting the default effect.
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(4), MainPane);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.88);
        fadeOut.play();
        
        String readHexa =  InputTextField.getText();
        //Checking that user input is within the correct range (0 to F).
        if(readHexa.contains("G") | readHexa.contains("H") | readHexa.contains("I") |readHexa.contains("J") |readHexa.contains("K") |readHexa.contains("L")
                |readHexa.contains("M") |readHexa.contains("N") |readHexa.contains("O") |readHexa.contains("P") |readHexa.contains("Q") |readHexa.contains("R") 
                |readHexa.contains("S") |readHexa.contains("T") |readHexa.contains("U") |readHexa.contains("V") |readHexa.contains("X") |readHexa.contains("Y") 
                |readHexa.contains("Z") )
        {
            Notifications.create().title("Error").text("Hexa ranges from 0 to F.").position(Pos.CENTER).hideAfter(Duration.seconds(1.8)).showError();
            TextField1.clear();
            TextField2.clear();
            TextField3.clear();
        }
        
        else
        {
        int convertHexa2Decimal = Integer.parseInt(readHexa,16);
        String Hexa2Binary = Integer.toBinaryString(convertHexa2Decimal);
        String Hexa2Octal = Integer.toOctalString(convertHexa2Decimal);
        TextField1.setText(String.valueOf(convertHexa2Decimal));
        TextField2.setText(Hexa2Binary);
        TextField3.setText(Hexa2Octal);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    }    
}
