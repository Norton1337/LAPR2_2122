package app.domain.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class ParserCSV implements Serializable {

    //ParserCSV.parsePerformanceData("data/performanceData.csv", true); -> true = arrival time
    //ParserCSV.parsePerformanceData("data/performanceData.csv", false); -> false = ultima coluna


    public static void parsePerformanceData(String path, boolean algorithm) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("M/dd/yyyy H:mm");
        String[] values;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            boolean hasHeader = csvHasHeader(path);

            if (hasHeader) line = br.readLine();

            Map<LocalDateTime, String> map = new TreeMap<>();

            while ((line = br.readLine()) != null) {
                values = line.split(";");

                if (algorithm) map.put(LocalDateTime.parse(values[5], format), line);
                else map.put(LocalDateTime.parse(values[7], format), line);
            }

            for (Map.Entry<LocalDateTime, String> o : map.entrySet()) {
                System.out.println(o.getValue());
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    private static boolean csvHasHeader(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            return line.contains(";");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}