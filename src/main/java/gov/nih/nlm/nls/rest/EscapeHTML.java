// mml-rest/src/main/java/gov/nih/nlm/nls/rest/EscapeHTML.java, Wed Dec 8 13:32:47 2021, edit by Will Rogers
package gov.nih.nlm.nls.rest;

/**
 * Utility for escaping HTML in input text.
 */
import java.lang.StringBuilder;
import java.util.regex.Pattern;
// import ESSAPI;

public class EscapeHTML {

  /**
   * Escape HTML in input string.
   * @param s input string
   * @return modified input string with HTML special characters escaped)
   */
  public static String escapeHTML(String s) {
    StringBuilder out = new StringBuilder(Math.max(16, s.length()));
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c > 127 || c == '"' || c == '\'' || c == '<' || c == '>' || c == '&') {
	out.append("&#");
	out.append((int) c);
	out.append(';');
      } else {
	out.append(c);
      }
    }
    return out.toString();
  }
  
  public static String stripXSS(String value) {
    if (value != null) {
      // NOTE: It's highly recommended to use the ESAPI library and uncomment the following line to
      // avoid encoded attacks.
      // value = ESAPI.encoder().canonicalize(value);
 
      // Avoid null characters
      value = value.replaceAll("", "");
 
      // Avoid anything between script tags
      Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
      value = scriptPattern.matcher(value).replaceAll("");
 
      // Avoid anything in a src='...' type of expression
      scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
 
      scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
 
      // Remove any lonesome </script> tag
      scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
      value = scriptPattern.matcher(value).replaceAll("");
 
      // Remove any lonesome <script ...> tag
      scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
 
      // Avoid eval(...) expressions
      scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
 
      // Avoid expression(...) expressions
      scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
 
      // Avoid javascript:... expressions
      scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
      value = scriptPattern.matcher(value).replaceAll("");
 
      // Avoid vbscript:... expressions
      scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
      value = scriptPattern.matcher(value).replaceAll("");
 
      // Avoid onload= expressions
      scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
    }
    return value;
  }

  public static void main(String[] args) {
    String[] stringList = { "<a href=\"https://ii.nlm.nih.gov/\">pneumonia</a>",
			    "<a href=\"https://ii.nlm.nih.gov/\">cold</a>",
			    "<a href=\"https://ii.nlm.nih.gov/\">culture</a>",
			    "heart attack\n<a href=\"https://ii.nlm.nih.gov/\">pneumonia</a>" };
    for (String s: stringList) {
      System.out.println(s + " -> " + escapeHTML(s));
    }
  }
}
