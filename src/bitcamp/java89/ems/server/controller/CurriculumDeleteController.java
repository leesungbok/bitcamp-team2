package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.CurriculumDao;

public class CurriculumDeleteController implements Command {
  private CurriculumDao curriculumDao;

  public CurriculumDeleteController() {
    curriculumDao = CurriculumDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (!curriculumDao.existTarget(paramMap.get("target"))) {
      out.println("해당 데이터가 없습니다.");
      return;
    }
    
    curriculumDao.delete(paramMap.get("target"));
    out.println("해당 데이터를 삭제 완료하였습니다.");
  }
}