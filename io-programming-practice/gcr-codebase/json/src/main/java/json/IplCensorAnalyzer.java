package json;

import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IplCensorAnalyzer {

    // model
    static class IPLRecord {
        public int matchId;
        public String team1;
        public String team2;
        public String venue;
        public String commentary;
    }

    // banned words
    static List<String> bannedWords =
            Arrays.asList("idiot", "fix", "corrupt");

    // censor text
    static String sanitize(String text) {
        if (text == null) return "";
        String result = text;

        for (String word : bannedWords) {
            result = result.replaceAll("(?i)" + word, "*****");
        }
        return result;
    }

    public static void main(String[] args) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            List<IPLRecord> records;

            String inputFile = "C:\\Users\\USER\\Desktop\\New folder (3)\\json\\src\\main\\java\\json\\ipl.csv";   // change to ipl.csv if needed

            // read input
            if (inputFile.endsWith(".json")) {
                records = mapper.readValue(
                        new File(inputFile),
                        new TypeReference<List<IPLRecord>>() {}
                );
            } else {
                records = new ArrayList<>();
                BufferedReader br = new BufferedReader(new FileReader(inputFile));
                String line;
                br.readLine(); // skip header

                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    IPLRecord r = new IPLRecord();
                    r.matchId = Integer.parseInt(data[0]);
                    r.team1 = data[1];
                    r.team2 = data[2];
                    r.venue = data[3];
                    r.commentary = data[4];

                    records.add(r);
                }
                br.close();
            }

            // apply censor
            for (IPLRecord r : records) {
                r.venue = sanitize(r.venue);
                r.commentary = sanitize(r.commentary);
            }

            // write sanitized json
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("C:\\Users\\USER\\Desktop\\New folder (3)\\json\\src\\main\\java\\json\\ipl_clean.json"), records);

            // write sanitized csv
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("C:\\Users\\USER\\Desktop\\New folder (3)\\json\\src\\main\\java\\json\\ipl_clean.csv"));
            bw.write("matchId,team1,team2,venue,commentary");
            bw.newLine();

            for (IPLRecord r : records) {
                bw.write(r.matchId + "," +
                         r.team1 + "," +
                         r.team2 + "," +
                         r.venue + "," +
                         r.commentary);
                bw.newLine();
            }
            bw.close();

            System.out.println("Sanitized files created successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
