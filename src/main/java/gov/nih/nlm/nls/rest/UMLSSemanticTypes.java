package gov.nih.nlm.nls.rest;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Describe class UMLSSemanticTypes here.
 *
 *
 * Created: Thu Sep  7 12:39:42 2017
 *
 * @author <a href="mailto:wjrogers@mail.nih.gov">Willie Rogers</a>
 * @version 1.0
 */
public class UMLSSemanticTypes {
  /** slf4j logger instance */
  private static final Logger logger = LoggerFactory.getLogger(UMLSSemanticTypes.class);

  String listFilename = "data/SemanticTypes_2013AA.txt";
  
  public class TypeRecord {
    /** semantic type abbreviation */
    String abbrev;
    /** semantic type id */
    String id;
    /** semantic type full name */
    String name;

    public TypeRecord(String abbrev, String id, String name) {
      this.abbrev = abbrev;
      this.id = id;
      this.name = name;
    }
    public String getAbbrev() { return this.abbrev; }
    public String getId() { return this.id; }
    public String getName() { return this.name; }
    public String toString() {
      return this.abbrev + "|" +
	this.id + "|" +
	this.name + "|";
    }
  }

  /** semantic type list */
  List<TypeRecord> semanticTypeList = new ArrayList();

  /**
   * Creates a new <code>UMLSSemanticTypes</code> instance using
   * user-supplied list of semantic type, each line containing
   * semantic type abbreviation, id, and full name..
   * @param filename name of semantic type information file.
   */
  public UMLSSemanticTypes(String filename) {
    loadTable(filename);
  }

  public void loadTable(String filename) {
    try {
      BufferedReader br = new BufferedReader(new FileReader(filename));
      String line;
      while ((line = br.readLine()) != null) {
	String[] fields = line.split("\\|");
	TypeRecord typeRecord = 
	  new TypeRecord(fields[0], fields[1], fields[2]);
	this.semanticTypeList.add(typeRecord);
	logger.debug(typeRecord.toString());
      }
      br.close();
    } catch (FileNotFoundException fnfe) {
	throw new RuntimeException(fnfe);
    } catch (IOException ioe) {
      	throw new RuntimeException(ioe);
    }
  }

  public List<TypeRecord> getSemanticTypeList() {
    return this.semanticTypeList;
  }

}
