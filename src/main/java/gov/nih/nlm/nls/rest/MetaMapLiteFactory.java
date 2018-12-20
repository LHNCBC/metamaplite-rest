package gov.nih.nlm.nls.rest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import gov.nih.nlm.nls.ner.MetaMapLite;
import gov.nih.nlm.nls.metamap.lite.resultformats.ResultFormatter;
import gov.nih.nlm.nls.metamap.lite.resultformats.ResultFormatterRegistry;
import gov.nih.nlm.nls.metamap.lite.resultformats.mmi.MMI;
import gov.nih.nlm.nls.metamap.lite.resultformats.Brat;
import gov.nih.nlm.nls.metamap.lite.resultformats.CuiList;
import gov.nih.nlm.nls.metamap.lite.resultformats.BcEvaluate;


/**
 * Describe class MetaMapLiteFactory here.
 *
 *
 * Created: Wed Apr 26 16:05:12 2017
 *
 * @author <a href="mailto:wjrogers@mail.nih.gov">Willie Rogers</a>
 * @version 1.0
 */
public class MetaMapLiteFactory {
  /** log4j logger instance */
  private static final Logger logger = LogManager.getLogger(MetaMapLiteFactory.class);

  /**
   * Creates a new <code>MetaMapLiteFactory</code> instance.
   *
   */
  public MetaMapLiteFactory() {

  }

  public static Properties getMetaMapProperties(String rootPath) {
    String configPath = rootPath + "/config";
    String dataPath = rootPath + "/data";
    logger.info("rootPath", rootPath);
    logger.info("dataPath", dataPath);
    logger.info("configPath", configPath);
    try {
      String configPropertyFilename = configPath + "/" +
 	System.getProperty("metamaplite.property.file",
			   "metamaplite.properties");
      Properties properties = new Properties();
      // default properties that can be overriden
      properties.setProperty("metamaplite.semanticgroup", "all");
      // "cgab,acab,inpo,patf,dsyn,anab,neop,mobd,sosy"
      properties.setProperty("metamaplite.usecontext", "false");
    
      // load user properties from file
      properties.load(new FileReader(configPropertyFilename));

      // Add data path from servlet context for the following
      // properties.  Paths to files, models and indexes must be
      // relative to webapps/<servlet-dir>/data directory.
      properties.setProperty("metamaplite.ivf.cuiconceptindex",
			     dataPath + "/" +
			     properties.getProperty("metamaplite.ivf.cuiconceptindex",
						    "ivf/strict/indices/cuiconcept"));
      properties.setProperty("metamaplite.ivf.cuisourceinfoindex",
			     dataPath + "/" +
			     properties.getProperty("metamaplite.ivf.cuisourceinfoindex",
						    "ivf/strict/indices/cuisourceinfo"));
      properties.setProperty("metamaplite.ivf.cuisemantictypeindex",
			     dataPath + "/" +
			     properties.getProperty("metamaplite.ivf.cuisemantictypeindex",
						    "ivf/strict/indices/cuist"));

      properties.setProperty("metamaplite.ivf.varsindex",
			     dataPath + "/" +
			     properties.getProperty("metamaplite.ivf.varsindex",
						    "ivf/strict/indices/vars"));
      properties.setProperty("metamaplite.ivf.meshtcrelaxedindex", 
			     dataPath + "/" +
			     properties.getProperty("metamaplite.ivf.meshtcrelaxedindex",
						    "ivf/strict/indices/meshtcrelaxedindex"));
      
      properties.setProperty("metamaplite.excluded.termsfile",
			     dataPath + "/" +
			     properties.getProperty("metamaplite.excluded.termsfile",
						    "specialterms.txt"));
      properties.setProperty("opennlp.en-pos.bin.path",
			     dataPath + "/" +
			     properties.getProperty("opennlp.en-pos.bin.path",
						    "models/en-pos-maxent.bin"));
      properties.setProperty("opennlp.en-sent.bin.path",
			     dataPath + "/" +
			     properties.getProperty("opennlp.en-sent.bin.path",
						    "models/en-sent.bin"));
      properties.setProperty("opennlp.en-chunker.bin.path",
			     dataPath + "/" +
			     properties.getProperty("opennlp.en-chunker.bin.path",
						    "models/en-chunker.bin"));
      return properties;
    } catch (FileNotFoundException fnfe) {
      throw new RuntimeException(fnfe);
    } catch (IOException ioe) {
      throw new RuntimeException(ioe);
    }

  }

  public static MetaMapLite newInstance(String rootPath) {
    MetaMapLite metaMapLiteInst;
    try {
      Properties properties = getMetaMapProperties(rootPath);

      
      ResultFormatterRegistry.register("bc",
				       "BioCreative Evaluation Format",
				       new BcEvaluate());
      ResultFormatterRegistry.register("bc-evaluate",
				       "BioCreative Evaluation Format",
				       new BcEvaluate());
      ResultFormatterRegistry.register("bioc",
				       "BioCreative Evaluation Format",
				       new BcEvaluate());
      ResultFormatterRegistry.register("cdi",
				       "BioCreative Evaluation Format",
				       new BcEvaluate());
      ResultFormatterRegistry.register("brat",
				       "BRAT Annotation format (.ann)",
				       new Brat());
      ResultFormatterRegistry.register("mmi",
				       "Fielded MetaMap Indexing-like Output",
				       new MMI());

      /** augment or override any built-in formats with ones specified by property file. */
      // BioCDocumentLoaderRegistry.register(properties);
      ResultFormatterRegistry.register(properties);

      metaMapLiteInst = new MetaMapLite(properties);

      // logger.info("MetaMapLiteFactory: metaMapLiteInst = " + metaMapLiteInst);

      return metaMapLiteInst;
    } catch (IllegalAccessException iae) {
      throw new RuntimeException(iae);
    } catch (NoSuchMethodException nsme) {
      throw new RuntimeException(nsme);
    } catch (InstantiationException ie) {
      throw new RuntimeException(ie);
    } catch (ClassNotFoundException cnfe) {
      throw new RuntimeException(cnfe);
    } catch (FileNotFoundException fnfe) {
      throw new RuntimeException(fnfe);
    } catch (IOException ioe) {
      throw new RuntimeException(ioe);
    }

  }

}
