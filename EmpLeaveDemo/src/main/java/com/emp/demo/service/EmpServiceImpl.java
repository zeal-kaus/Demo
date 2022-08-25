package com.emp.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.emp.demo.IOStream.FileOperation;
import com.emp.demo.IOStream.FileOperationImpl;
import com.emp.demo.entity.Employee;

@Service
public class EmpServiceImpl implements EmpService {

  private FileOperation fileOperation = new FileOperationImpl();

  private Map<Integer, Employee> empRecords = new HashMap<Integer, Employee>();

  @Override
  public void startOperation() {
    setEmpRecords(this.fileOperation.readEmpRecords());
    this.getAppliedLeaves();
  }

  private void getAppliedLeaves() {
    System.out.println("\n===============================================================================================\n");
    while (true) {
      Map<Integer, Integer> appliedLeavesData = fileOperation.getAppliedLeaves();
      if (appliedLeavesData.size() > 0) {
        this.validateAppliedLeaves(appliedLeavesData);
      }
      try {
        Thread.sleep(60000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  private void validateAppliedLeaves(Map<Integer, Integer> appliedLeavesData) {
    List<Employee> updatedEmpData = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : appliedLeavesData.entrySet()) {
      Employee emp = this.getEmpRecords().get(entry.getKey());
      if (emp.getAvailableLeaves() >= (int) entry.getValue()) {
        System.out.println(emp.getName().trim() + " is eligible for the leave");
        emp.setAvailableLeaves(emp.getAvailableLeaves() - (int) entry.getValue());
        emp.setLeavesTaken(emp.getLeavesTaken() + (int) entry.getValue());
        updatedEmpData.add(emp);
      } else {
        System.out.println(emp.getName().trim() + " is not eligible for the leave");
      }
    }
    if (!updatedEmpData.isEmpty()) {
      fileOperation.updateLeaveRecord(updatedEmpData);
    }
  }

  public Map<Integer, Employee> getEmpRecords() {
    return empRecords;
  }

  public void setEmpRecords(Map<Integer, Employee> empRecords) {
    this.empRecords = empRecords;
  }

}
