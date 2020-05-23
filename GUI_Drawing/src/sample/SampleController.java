package sample;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import javax.xml.bind.JAXB;

public class SampleController {

    // Holds the current selected color
    private Color fillColor = Color.BLACK;

    // holds the current selected radius
    private double radius = 10;

    // holds the current selected shape
    private String shape = "Circle";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton rbBlack;

    @FXML
    private ToggleGroup togGrpColor;

    @FXML
    private RadioButton rbRed;

    @FXML
    private ToggleGroup groupDrawingColor;

    @FXML
    private RadioButton rbGreen;

    @FXML
    private RadioButton rbBlue;

    @FXML
    private RadioButton rbSmall;

    @FXML
    private ToggleGroup togGrpSize;

    @FXML
    private RadioButton rbMedium;

    @FXML
    private ToggleGroup groupDrawingColor1;

    @FXML
    private RadioButton rbLarge;

    @FXML
    private ToggleGroup togGrpShape;

    @FXML
    private RadioButton rbCircle;

    @FXML
    private RadioButton rbSquare;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnClear;

    @FXML
    private Pane paneDraw;

    /**
     * clears the drawing area
     * 
     * @param event
     */
    @FXML
    void btnClearClicked(ActionEvent event) {

        paneDraw.getChildren().clear();
    }

    /**
     * undo the last added shape
     * 
     * @param event
     */
    @FXML
    void btnUndo(ActionEvent event) {

        if (!paneDraw.getChildren().isEmpty())
            paneDraw.getChildren().remove(paneDraw.getChildren().size() - 1);
    }

    /**
     * serialize circle shapes
     *
     * @param actionEvent
     */
    @FXML
    public void btnSerialize(ActionEvent actionEvent) {
        TextInputDialog textInputDialog = new TextInputDialog();

        // sets up the title, content text, and header text for the Text Input Dialog
        textInputDialog.setTitle("File Name");
        textInputDialog.setContentText("Enter a file name:");
        textInputDialog.setHeaderText("File Name Format:"+
                "\n\t 1. Starts with an uppercase letter" +
                "\n\t 2. Followed by two or more letters" +
                "\n\t 3. Followed by at least one number" +
                "\n\t 4. Followed by zero or more letters" +
                "\n\t 5. Ends with .XML");

        // wait for user to enter string
        Optional<String> str = textInputDialog.showAndWait();

        // if string is entered and regex pattern is matched. str.get() converts optional string to regular string
        if(str.isPresent() && Pattern.matches("[A-Z]{1}[A-Za-z]{2,}[0-9]{1,}+[A-Za-z]{0,}+.xml", str.get())) {
            // use BufferedWriter to write to the file that user has inputted
            try(BufferedWriter output = Files.newBufferedWriter(Paths.get(str.get()))) {
                A5Shapes a5ShapesTempContainer = new A5Shapes();

                // iterate through paneDraw children
                for(Node node : paneDraw.getChildren()) {
                    // if node is an instance of the Circle class
                    if(node instanceof Circle) {
                        double xcor = ((Circle) node).getCenterX();
                        double ycor = ((Circle) node).getCenterY();
                        double rad = ((Circle) node).getRadius();
                        String color = String.valueOf((Color) ((Circle) node).getFill());

                        // creates instance of A5Shape class
                        A5Shape a5Shape = new A5Shape(xcor, ycor, rad, color);

                        // adds instance of A5Shape class to the arraylist in the container class
                        a5ShapesTempContainer.getA5ShapeList().add(a5Shape);
                    }
                }

                // write XML to output
                JAXB.marshal(a5ShapesTempContainer, output);

                // sets up the title and header text for Success Alert
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Serialization");
                successAlert.setHeaderText("Successfully written all circles to file " + str.get());
                successAlert.showAndWait();
            }
            // print exception if serialization fails
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            // sets up the title and header text for Failure Alert (if regex isn't matched or user presses cancel)
            Alert failureAlert = new Alert(Alert.AlertType.INFORMATION);
            failureAlert.setTitle("Serialization cancelled");
            failureAlert.setHeaderText("File serialization cancelled by user or does not match RegEx");
            failureAlert.showAndWait();
        }
    }

    /**
     * Called when mouse is dragged on the drawing panel
     * 
     * @param event
     */
    @FXML
    void drawPaneMouseDrag(MouseEvent event) {

        if (shape.equals("Circle"))
            paneDraw.getChildren().add(new Circle(event.getX(), event.getY(), radius, fillColor));
        else if (shape.equals("Square")) {
            // create instance of rectangle class where length and width are equal to the radius
            Rectangle rectangle = new Rectangle(event.getX(), event.getY(), radius, radius);
            rectangle.setFill(fillColor);
            paneDraw.getChildren().add(rectangle);
        }
    }

    @FXML
    void initialize() {

        assert rbBlack != null : "fx:id=\"rbBlack\" was not injected: check your FXML file 'Sample.fxml'.";
        assert togGrpColor != null : "fx:id=\"togGrpColor\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbRed != null : "fx:id=\"rbRed\" was not injected: check your FXML file 'Sample.fxml'.";
        assert groupDrawingColor != null : "fx:id=\"groupDrawingColor\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbGreen != null : "fx:id=\"rbGreen\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbBlue != null : "fx:id=\"rbBlue\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbSmall != null : "fx:id=\"rbSmall\" was not injected: check your FXML file 'Sample.fxml'.";
        assert togGrpSize != null : "fx:id=\"togGrpSize\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbMedium != null : "fx:id=\"rbMedium\" was not injected: check your FXML file 'Sample.fxml'.";
        assert groupDrawingColor1 != null : "fx:id=\"groupDrawingColor1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert rbLarge != null : "fx:id=\"rbLarge\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnUndo != null : "fx:id=\"btnUndo\" was not injected: check your FXML file 'Sample.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Sample.fxml'.";
        assert paneDraw != null : "fx:id=\"paneDraw\" was not injected: check your FXML file 'Sample.fxml'.";

        // change listener for the color toggle group
        togGrpColor.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if (rbBlue.isSelected())
                    fillColor = Color.BLUE;
                else if (rbRed.isSelected())
                    fillColor = Color.RED;
                else if (rbGreen.isSelected())
                    fillColor = Color.GREEN;
                else
                    fillColor = Color.BLACK;
            }
        });

        // change listener for the size toggle group
        togGrpSize.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                if (rbLarge.isSelected())
                    radius = 15;
                else if (rbMedium.isSelected())
                    radius = 10;
                else
                    radius = 5;
            }
        });

        // change listener for the shape toggle group
        togGrpShape.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                // update value of shape depending on what option is selected
                if (rbCircle.isSelected())
                    shape = "Circle";
                else if (rbSquare.isSelected())
                    shape = "Square";
            }
        });
    }
}
