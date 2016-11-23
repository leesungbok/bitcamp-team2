package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.CurriculumDao;
import bitcamp.java89.ems.server.vo.Curriculum;

public class CurriculumAddController implements Command {
  private CurriculumDao curriculumDao;

  public CurriculumAddController() {
    curriculumDao = CurriculumDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    if (curriculumDao.existTarget(paramMap.get("target"))) {
      out.println("같은 강좌대상이 존재합니다. 등록을 취소합니다.");
      return;
    }
    
    Curriculum curriculum = new Curriculum();
    curriculum.setName(paramMap.get("name"));
    curriculum.setIntroduce(paramMap.get("introduce"));
    curriculum.setTarget(paramMap.get("target"));
    curriculum.setDocument(paramMap.get("document"));
    
    curriculumDao.insert(curriculum);
    out.println("등록하였습니다.");
  }
}