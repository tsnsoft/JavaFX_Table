package javafxapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TableView<String[]> table;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Utils.buildTable(table, 8, 6, 24, 90, true, null);
//        Utils.buildTable(table, 8, 6, 24, 90, true, new String[] {"1","2","3","4","5","6"}); // Вариант с шапкой
        doRandom(null);
        
        //table.getItems().add(new String[6]); // Так можно добавить строку
        //table.getItems().remove(table.getItems().size()-1); // Так можно удалить строку
        //table.refresh(); // Обновить таблицу на экране
    }

    @FXML
    private void doRandom(ActionEvent event) {
        // Заполнение таблицы случайными числами
        for (int row = 0; row < table.getItems().size(); row++) {
            for (int col = 0; col < table.getColumns().size(); col++) {
                int rand = (int) Math.round(-100 + Math.random() * 201);
                table.getItems().get(row)[col] = String.valueOf(rand);
            }
        }
        table.refresh();
    }

    @FXML
    private void doSum(ActionEvent event) {
        // Расчет суммы чисел таблицы
        double sum = 0;
        for (int row = 0; row < table.getItems().size(); row++) {
            for (int col = 0; col < table.getColumns().size(); col++) {
                sum = sum + Double.parseDouble(table.getItems().get(row)[col]);
            }
        }
        label.setText("sum=" + String.valueOf(sum));
    }

}
