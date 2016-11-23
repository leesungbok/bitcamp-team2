package bitcamp.java89.ems.server.vo;

import java.io.Serializable;

public class Curriculum implements Serializable {
  private static final long serialVersionUID = 1L;
  
  protected String name;
  protected String introduce;
  protected String target;
  protected String document;
  
  public Curriculum() {
    super();
  }

  public Curriculum(String name, String introduce, String target, String document) {
    this.name = name;
    this.introduce = introduce;
    this.target = target;
    this.document = document;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIntroduce() {
    return introduce;
  }

  public void setIntroduce(String introduce) {
    this.introduce = introduce;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  @Override
  public String toString() {
    return "Curriculum [name=" + name + ", introduce=" + introduce + ", target=" + target + ", document=" + document
        + "]";
  }
}
