package Variables;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class objectProperties {

    public objectProperties() throws FileNotFoundException {
        try {
            InputStream input = new FileInputStream(new File("ObjectRepository/Object.yml"));
            Map<String, Object> data = new Yaml().load(input);
        String choixpersonnel= (String) data.get("modeaccess1");
        String choixentreprise= (String) data.get("modeaccess2");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
