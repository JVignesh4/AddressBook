import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class OpenCSVAndGSON {
    public static final String ADDRESS_BOOK_CSV_PATH = "./address-book-Csv.csv";
    public static final String ADDRESS_BOOK_JSON_PATH = "./address-book.json";


    public void writeToCSV(ArrayList<Contacts> contactDetails) throws IOException {
        Writer writer = null;
        try {
            writer = new FileWriter(ADDRESS_BOOK_CSV_PATH);
            {
                StatefulBeanToCsvBuilder<Contacts> builder = new StatefulBeanToCsvBuilder<>(writer);
                StatefulBeanToCsv<Contacts> beanWriter = builder.withQuotechar(CSVWriter.NO_ESCAPE_CHARACTER).build();
                beanWriter.write(contactDetails);
            }
        } catch (IOException ignored) {
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } finally {
            assert writer != null;
            writer.close();
        }
    }
    public void writeToJson(ArrayList<Contacts> contactDetails){
        try(Writer writer = new FileWriter(ADDRESS_BOOK_JSON_PATH)){

            JSONObject jsonAddressBookObject = new JSONObject();
            JSONArray jsonArr = new JSONArray();
            for (Contacts person :
                    contactDetails) {
                JSONObject object = new JSONObject();
                object.put("FirstName",  person.getFirstName());
                object.put("LastName", person.getLastName());
                object.put("City", person.getCity());
                object.put("State", person.getState());
                object.put("Zip", person.getZipCode());
                object.put("PhoneNumber",person.getPhNumber());
                object.put("Email", person.getEMail());
                jsonArr.put(object);
            }

            jsonAddressBookObject.put("book",jsonArr);
            writer.write(jsonAddressBookObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}