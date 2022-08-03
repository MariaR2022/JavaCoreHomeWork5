package JavaCoreHomeWork5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateFileCsv {
    public static void main(String args[]){
        try (PrintWriter writer = new PrintWriter(new File("table.csv"))) {

            StringBuilder sb = new StringBuilder();
            sb.append("Value 1");
            sb.append(';');
            sb.append("Value 2");
            sb.append(';');
            sb.append("Value 3");
            sb.append('\n');

            sb.append("110");
            sb.append(';');
            sb.append('\t');
            sb.append("210");
            sb.append(';');
            sb.append('\t');
            sb.append("551");
            sb.append('\n');

            sb.append("410");
            sb.append(';');
            sb.append('\t');
            sb.append("310");
            sb.append(';');
            sb.append('\t');
            sb.append("630");
            sb.append('\n');

            writer.write(sb.toString());
            writer.close();
            System.out.println("Готово");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        GenerateFileCsv tableCSV =  new GenerateFileCsv();
        tableCSV.readCSVFile();
    }

    public void readCSVFile(){
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("table.csv"));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(records.toString());
    }
    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

}