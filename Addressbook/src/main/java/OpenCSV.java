import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;


public class OpenCSV {

    public void writeToCSV(ArrayList<Contacts> contactDetails) throws IOException {
        Writer writer;
        try {
            writer = new FileWriter("./address-book-Csv.csv");
            {
                StatefulBeanToCsvBuilder<Contacts> builder = new StatefulBeanToCsvBuilder<>(writer);
                StatefulBeanToCsv<Contacts> beanWriter = builder.withQuotechar(CSVWriter.NO_ESCAPE_CHARACTER).build();
                beanWriter.write(contactDetails);
            }
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }

    }
}