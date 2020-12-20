package comparisons.PreAcademy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CVSWriter implements AutoCloseable{

    public static void main(String[] args) throws IOException {
        List<PreAcademyStudent> students = new ArrayList<>();
        PreAcademyStudent s1 = new PreAcademyStudent("Paulina Ksienzyk", 5, 10, 15);
        PreAcademyStudent s2 = new PreAcademyStudent("Rafał Mazurek", 17, 10, 7);
        PreAcademyStudent s3 = new PreAcademyStudent("Anna Ignacy", 5, 20, 3);
        students.add(s1);
        students.add(s2);
        students.add(s3);

        List<String[]> data = new ArrayList<>();
        for (var student : students) {
            String[] studentData = new String[4];
            studentData[0] = student.getName();
            studentData[1] = String.valueOf(student.getQuizzesPoints());
            studentData[2] = String.valueOf(student.getTasksPoints());
            studentData[3] = String.valueOf(student.getLectureActivity());
            data.add(studentData);
        }

        CVSWriter cvsWriter = new CVSWriter();
        cvsWriter.givenDataArray_whenConvertToCSV_thenOutputCreated(data, "preAcademyStudents.csv");

    }

    private String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    private String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public void givenDataArray_whenConvertToCSV_thenOutputCreated(List<String[]> dataLines, String fileName) throws IOException {
        File csvOutputFile = new File(fileName);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
        assert (csvOutputFile.exists());
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing!");
    }
}
