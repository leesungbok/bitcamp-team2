package bitcamp.java89.ems.server.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bitcamp.java89.ems.server.vo.Curriculum;

public class CurriculumDao {
  static CurriculumDao obj;
  private String filename = "curriculum-v1.7.data";
  private ArrayList<Curriculum> list;
  
  public static CurriculumDao getInstance() {
    if (obj == null) {
      obj = new CurriculumDao();
    }
    return obj;
  }
 
  private CurriculumDao() {
    this.load(); 
  }

  @SuppressWarnings("unchecked")
  private void load() {
    FileInputStream in0 = null;
    ObjectInputStream in = null;
    
    try {
      in0 = new FileInputStream(this.filename);
      in = new ObjectInputStream(in0);

      list = (ArrayList<Curriculum>)in.readObject();
      
    } catch (EOFException e) {
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
      list = new ArrayList<>();
      
    } finally {
      try {
        in.close();
        in0.close();
      } catch (Exception e) {}
    }
  }

  public void save() throws Exception {
    FileOutputStream out0 = new FileOutputStream(this.filename);
    ObjectOutputStream out = new ObjectOutputStream(out0);

    out.writeObject(list);

    out.close();
    out0.close();
  }

  public ArrayList<Curriculum> getList() {
    return this.list;
  }
  
  public ArrayList<Curriculum> getListByName(String name) {
    ArrayList<Curriculum> results = new ArrayList<>();
    for (Curriculum curriculum : list) {
      if (curriculum.getName().equals(name)) {
        results.add(curriculum);
      }
    }
    return results;
  }
  
  synchronized public void insert(Curriculum curriculum) {
    list.add(curriculum);
    try {this.save();} catch (Exception e) {}
  }
  
  synchronized public void update(Curriculum curriculum) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getTarget().equals(curriculum.getTarget())) {
        list.set(i, curriculum);
        try {this.save();} catch (Exception e) {}
        return;
      }
    }
  }
  
  synchronized public void delete(String target) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getTarget().equals(target)) {
        list.remove(i);
        try {this.save();} catch (Exception e) {}
        return;
      }
    }
  }
  
  public boolean existTarget(String target) {
    for (Curriculum curriculum : list) {
      if (curriculum.getTarget().toLowerCase().equals(target.toLowerCase())) {
        return true;
      }
    }
    return false;
  }
}
