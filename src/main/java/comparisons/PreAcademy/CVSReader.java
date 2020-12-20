package comparisons.PreAcademy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CVSReader {

    public static List<PreAcademyStudent> read(String fileName) {
        List<PreAcademyStudent> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                PreAcademyStudent student = new PreAcademyStudent(
                        values[0],
                        Integer.parseInt(values[1]),
                        Integer.parseInt(values[2]),
                        Integer.parseInt(values[3])
                );
                records.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return records;
    }
}
