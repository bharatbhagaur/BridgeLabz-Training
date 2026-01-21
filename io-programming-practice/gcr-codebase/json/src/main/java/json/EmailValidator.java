package json;

import java.io.InputStream;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

public class EmailValidator {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            //  Load schema from resources folder
            InputStream schemaStream =
                    EmailValidator.class.getClassLoader()
                            .getResourceAsStream("C:\\Users\\USER\\Desktop\\New folder (3)\\json\\src\\main\\java\\json\\email-schema.json");

            //  Load JSON data from resources folder
            InputStream jsonStream =
                    EmailValidator.class.getClassLoader()
                            .getResourceAsStream("C:\\Users\\USER\\Desktop\\New folder (3)\\json\\src\\main\\java\\json\\user-email.json");

            // safety check
            if (schemaStream == null || jsonStream == null) {
                System.out.println(" JSON files not found in resources folder!");
                return;
            }

            JsonSchemaFactory factory =
                    JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

            JsonSchema schema = factory.getSchema(schemaStream);
            JsonNode jsonNode = mapper.readTree(jsonStream);

            // Validate JSON
            Set<ValidationMessage> errors = schema.validate(jsonNode);

            if (errors.isEmpty()) {
                System.out.println(" Email is VALID");
            } else {
                System.out.println(" Email is INVALID");
                for (ValidationMessage error : errors) {
                    System.out.println(error.getMessage());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
