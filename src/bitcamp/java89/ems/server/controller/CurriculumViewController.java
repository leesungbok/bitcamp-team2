package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.CurriculumDao;
import bitcamp.java89.ems.server.vo.Curriculum;

public class CurriculumViewController implements Command {
  private CurriculumDao curriculumDao;

  public CurriculumViewController() {
    curriculumDao = CurriculumDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Curriculum> list = curriculumDao.getListByName(paramMap.get("name"));
    for (Curriculum curriculum : list) {
      out.println("--------------------------");
      out.printf("강좌명: %s\n", curriculum.getName());
      out.printf("강좌소개: %s\n", curriculum.getIntroduce());
      out.printf("강좌대상: %s\n", curriculum.getTarget());
      out.printf("강좌준비서류: %s\n", curriculum.getDocument());
    }
  }
}