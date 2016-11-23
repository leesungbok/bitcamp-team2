package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
import bitcamp.java89.ems.server.dao.CurriculumDao;
import bitcamp.java89.ems.server.vo.Curriculum;

public class CurriculumListController implements Command {
  private CurriculumDao curriculumDao;

  public CurriculumListController() {
    curriculumDao = CurriculumDao.getInstance();
  }
  
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    ArrayList<Curriculum> list = curriculumDao.getList();
    for (Curriculum curriculum : list) {
      out.printf("%s,%s,%s,%s\n",
        curriculum.getName(),
        curriculum.getIntroduce(),
        curriculum.getTarget(),
        curriculum.getDocument());
    }
  }
}