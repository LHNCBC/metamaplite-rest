// mml-rest/src/main/java/gov/nih/nlm/nls/rest/EscapeHTML.java, Wed Dec 8 13:32:47 2021, edit by Will Rogers
package gov.nih.nlm.nls.rest;

/**
 * Utility for escaping HTML in input text.
 */
import java.lang.StringBuilder;

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
