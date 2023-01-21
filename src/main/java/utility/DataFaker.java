package utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.io.Resources;
import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class DataFaker {

    private static final Random random=new Random();
    private static DataFaker instance;

    private List<String> firstname;
    private List<String> lastname;
    private List<String> gender;
    private List<String> countryEN;
    private List<String> countryTR;
    private List<String> cities;
    private List<String> gameOfThronesCharacters;


    private DataFaker(){}

    public static DataFaker getInstance() {
        if (instance == null) {
            try {
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                instance = mapper.readValue(Resources.getResource("data_faker.yaml"), DataFaker.class);
            } catch (Exception e) {
                System.out.println("data_faker.yaml Config Dosyası Okunurken hata alındı!"+ e);
            }
        }
        return instance;
    }
}
