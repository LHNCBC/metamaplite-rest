package gov.nih.nlm.nls.rest;

public class MMRequest {
  String inputtext;
  String docformat;
  String resultformat;
  String sources;
  String semtypes;
  public String getInputtext() { return this.inputtext; }
  public void setInputtext(String text) { this.inputtext = text; }
  public String getDocformat() { return this.docformat; }
  public void setDocformat(String format) { this.docformat = format; }
  public String getResultformat() { return this.resultformat; }
  public void setResultformat(String format) { this.resultformat = format; }
  public String getSources() { return this.sources; }
  public void setSources(String sourceList) { this.sources = sourceList; }
  public String getSemtypes() { return this.semtypes; }
  public void setSemtypes(String semanticTypeList) { this.semtypes = semanticTypeList; }
}

