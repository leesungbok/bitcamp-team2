package bitcamp.java89.ems.server;

import java.net.ServerSocket;
import java.util.HashMap;

import bitcamp.java89.ems.server.controller.ContactAddController;
import bitcamp.java89.ems.server.controller.ContactDeleteController;
import bitcamp.java89.ems.server.controller.ContactListController;
import bitcamp.java89.ems.server.controller.ContactUpdateController;
import bitcamp.java89.ems.server.controller.ContactViewController;
import bitcamp.java89.ems.server.controller.CurriculumAddController;
import bitcamp.java89.ems.server.controller.CurriculumDeleteController;
import bitcamp.java89.ems.server.controller.CurriculumListController;
import bitcamp.java89.ems.server.controller.CurriculumUpdateController;
import bitcamp.java89.ems.server.controller.CurriculumViewController;

public class EduAppServer {
  HashMap<String,Command> commandMap = new HashMap<>();
  public EduAppServer() {
    commandMap.put("contact/list", new ContactListController());
    commandMap.put("contact/view", new ContactViewController());
    commandMap.put("contact/add", new ContactAddController());
    commandMap.put("contact/delete", new ContactDeleteController());
    commandMap.put("contact/update", new ContactUpdateController());
    commandMap.put("curriculum/list", new CurriculumListController());
    commandMap.put("curriculum/view", new CurriculumViewController());
    commandMap.put("curriculum/add", new CurriculumAddController());
    commandMap.put("curriculum/delete", new CurriculumDeleteController());
    commandMap.put("curriculum/update", new CurriculumUpdateController());
  }
  
  private void service() throws Exception {
    ServerSocket ss = new ServerSocket(8888);
    System.out.println("서버 실행 중...");
    
    while (true) {
      new RequestThread(ss.accept(), commandMap).start();
    }
    //ss.close();
  }
  public static void main(String[] args) throws Exception {
    EduAppServer eduServer = new EduAppServer();
    eduServer.service();
  }
}