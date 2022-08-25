package com.emp.demo.IOStream;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.emp.demo.entity.Employee;

@Component
public interface FileOperation {

  public Map<Integer, Employee> readEmpRecords();

  public void updateLeaveRecord(List<Employee> updatedEmpData);

  public Map<Integer, Integer> getAppliedLeaves();
}
