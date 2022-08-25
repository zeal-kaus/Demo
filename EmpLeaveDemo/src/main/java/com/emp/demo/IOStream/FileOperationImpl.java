package com.emp.demo.IOStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.emp.demo.entity.Employee;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.exceptions.CsvException;

public class FileOperationImpl implements FileOperation {
  
  private String empDataFileName = "C:\\Users\\kjhanwar\\My Stuff\\LeaveManager\\EmployeeData.csv";

  @Override
  public Map<Integer, Employee> readEmpRecords() {
    Map<Integer, Employee> empLeaveData = new HashMap<Integer, Employee>();
    Map<String, String> mapping = new HashMap<String, String>();
    mapping.put("empId", "eId");
    mapping.put("name", "name");
    mapping.put("leavesTaken", "leavesTaken");
    mapping.put("availableLeaves", "availableLeaves");

    HeaderColumnNameTranslateMappingStrategy<Employee> strategy = new HeaderColumnNameTranslateMappingStrategy<Employee>();
    strategy.setType(Employee.class);
    strategy.setColumnMapping(mapping);

    // CSVReader csvReader = null;
    try (CSVReader csvReader = new CSVReader(new FileReader(empDataFileName))) {
      CsvToBean<Employee> csvToBean = new CsvToBean<Employee>();
      csvToBean.setMappingStrategy(strategy);
      csvToBean.setCsvReader(csvReader);
      List<Employee> list = csvToBean.parse();
      list.stream().forEach(e -> empLeaveData.put(e.geteId(), e));
      csvReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return empLeaveData;
  }

  @Override
  public void updateLeaveRecord(List<Employee> updatedEmpRecords) {
    // Read existing file

    List<String[]> csvBody;
    try {
      CSVReader reader = new CSVReaderBuilder(new FileReader(empDataFileName)).withSkipLines(1).build();
      csvBody = reader.readAll();
      for (Employee empRecord : updatedEmpRecords) {
        int recordId = empRecord.geteId() - 1;
        csvBody.get(recordId)[2] = String.valueOf(empRecord.getLeavesTaken());
        csvBody.get(recordId)[3] = String.valueOf(empRecord.getAvailableLeaves());
      }

      reader.close();

      // Write to CSV file which is open
      CSVWriter writer = new CSVWriter(new FileWriter(empDataFileName));
      String[] header = { "empId", "name", "leavesTaken", "availableLeaves" };
      writer.writeNext(header);
      writer.writeAll(csvBody);
      writer.flush();
      writer.close();

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (CsvException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public Map<Integer, Integer> getAppliedLeaves() {

    Map<Integer, Integer> appliedLeavesData = new HashMap<Integer, Integer>();
    String leavesFileName = "C:\\Users\\kjhanwar\\My Stuff\\LeaveManager\\Leaves.csv";
    try {
      CSVReader csvReader = new CSVReaderBuilder(new FileReader(leavesFileName)).withSkipLines(1).build();
      List<String[]> allData = csvReader.readAll();
      for (String[] leaveRecord : allData) {
        appliedLeavesData.put(Integer.valueOf(leaveRecord[0]), Integer.valueOf(leaveRecord[1]));
      }
      csvReader.close();
      if (!appliedLeavesData.isEmpty()) {
        CSVWriter writer = new CSVWriter(new FileWriter(leavesFileName));
        String[] header = { "empId", "appliedLeaves" };
        writer.writeNext(header);
        writer.flush();
        writer.close();
      }
    } catch (FileNotFoundException e) {

    } catch (Exception e) {
      e.printStackTrace();
    }
    return appliedLeavesData;
  }

}
