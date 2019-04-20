/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stat_fx_line_pie_chart;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author mahjoub
 */
public class Stat_FX_line_pie_chart extends Application {
    
    private PieChart statPieChart=new PieChart();
    @Override
    public void start(Stage primaryStage) {
       
        
        ObservableList<String> cate = FXCollections.observableArrayList();
        cate.addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        final CategoryAxis xAxis = new CategoryAxis(cate);
        xAxis.setLabel("Mois");
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Nombre Reclamation");
        // ObservableList<Series<String,Number>> LineChartData = FXCollections.observableArrayList();

        LineChart lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Reclamation Par mois");
        XYChart.Series series = new XYChart.Series();
        
        
        
        
        

        
        series.setName("moyenne de reclamation par mois :  "+new DecimalFormat("0.00").format(120/12));
        series.getData().add(new XYChart.Data("Jan", 1));
        series.getData().add(new XYChart.Data("Feb", 2));
        series.getData().add(new XYChart.Data("Mar", 3));
        series.getData().add(new XYChart.Data("Apr", 4));
        series.getData().add(new XYChart.Data("May", 5));
        series.getData().add(new XYChart.Data("Jun", 6));
        series.getData().add(new XYChart.Data("Jul", 7));
        series.getData().add(new XYChart.Data("Aug", 8));
        series.getData().add(new XYChart.Data("Sep", 9));
        series.getData().add(new XYChart.Data("Oct", 10));
        series.getData().add(new XYChart.Data("Nov", 5));
        series.getData().add(new XYChart.Data("Dec", 11));

        //LineChartData.add(series);
        //lineChart.setData(LineChartData);
        lineChart.getData().add(series);
        
        Map<Integer, Integer> mapStat = new HashMap<>();
        mapStat.put(1, 11);
        mapStat.put(1, 11);mapStat.put(1, 11);
        mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);
        mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);
        mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);
        mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);
        mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);mapStat.put(1, 11);        
        
        
        
        int nbrTotal = 0;
        for (Map.Entry<Integer, Integer> entry : mapStat.entrySet()) {
            Integer value = entry.getValue();
            nbrTotal += value;
        }
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Integer c : mapStat.keySet()) {
            pieChartData.add(new PieChart.Data(c.toString(), mapStat.get(c)));
        }

        statPieChart.setTitle("Statistiques nombre produit par categorie");
        statPieChart.setClockwise(true);
        statPieChart.setLabelLineLength(50);
        statPieChart.setLabelsVisible(true);
        statPieChart.setStartAngle(180);
        statPieChart.setData(pieChartData);
        pieChartData.forEach(data
                -> data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " : ", data.pieValueProperty().intValue(), " Produits"
                        )
                )
        );

        final Label caption = new Label("");
        caption.setTextFill(Color.WHITE);
        caption.setStyle("-fx-font: 12 arial;");

        for (final PieChart.Data data : statPieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    caption.setTranslateX(e.getSceneX());
                    caption.setTranslateY(e.getSceneY());

                    // caption.setText(String.valueOf((data.pieValueProperty().intValue()/nbrTotal)*100));
                }
            });
        }
        
        
        
        StackPane root = new StackPane();
        root.getChildren().add(lineChart);
         root.getChildren().add(statPieChart);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
