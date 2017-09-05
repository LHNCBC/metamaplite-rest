package gov.nih.nlm.nls.rest;

import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;
import java.util.Comparator;
import gov.nih.nlm.nls.metamap.lite.types.Ev;

/**
 * Describe class EvScoreComparator here.
 *
 *
 * Created: Fri Aug 11 10:58:00 2017
 *
 * @author <a href="mailto:wjrogers@mail.nih.gov">Willie Rogers</a>
 * @version 1.0
 */
public class EvScoreComparator implements Comparator {

  /**
   * Creates a new <code>EvScoreComparator</code> instance.
   *
   */
  public EvScoreComparator() {

  }
 
  // Implementation of java.util.Comparator

  /**
   * Describe <code>equals</code> method here.
   *
   * @param object an <code>Object</code> value
   * @return a <code>boolean</code> value
   */
  public final boolean equals(final Object object) {
    return this == object;
  }

  /**
   * Describe <code>compare</code> method here.
   *
   * @param object an <code>Object</code> value
   * @param object1 an <code>Object</code> value
   * @return an <code>int</code> value
   */
  public final int compare(final Object object, final Object object1) {
    return Double.compare(((Ev)object).getScore(),((Ev)object1).getScore());
  }

  /**
   * Describe <code>reversed</code> method here.
   *
   * @return a <code>Comparator</code> value
   */
  public final Comparator reversed() {
    return null;
  }

  /**
   * Describe <code>thenComparing</code> method here.
   *
   * @param function a <code>Function</code> value
   * @return a <code>Comparator</code> value
   */
  public final Comparator thenComparing(final Function function) {
    return null;
  }

  /**
   * Describe <code>thenComparing</code> method here.
   *
   * @param function a <code>Function</code> value
   * @param comparator a <code>Comparator</code> value
   * @return a <code>Comparator</code> value
   */
  public final Comparator thenComparing(final Function function, final Comparator comparator) {
    return null;
  }

  /**
   * Describe <code>thenComparing</code> method here.
   *
   * @param comparator a <code>Comparator</code> value
   * @return a <code>Comparator</code> value
   */
  public final Comparator thenComparing(final Comparator comparator) {
    return null;
  }

  /**
   * Describe <code>thenComparingInt</code> method here.
   *
   * @param toIntFunction a <code>ToIntFunction</code> value
   * @return a <code>Comparator</code> value
   */
  public final Comparator thenComparingInt(final ToIntFunction toIntFunction) {
    return null;
  }

  /**
   * Describe <code>thenComparingLong</code> method here.
   *
   * @param toLongFunction a <code>ToLongFunction</code> value
   * @return a <code>Comparator</code> value
   */
  public final Comparator thenComparingLong(final ToLongFunction toLongFunction) {
    return null;
  }

  /**
   * Describe <code>thenComparingDouble</code> method here.
   *
   * @param toDoubleFunction a <code>ToDoubleFunction</code> value
   * @return a <code>Comparator</code> value
   */
  public final Comparator thenComparingDouble(final ToDoubleFunction toDoubleFunction) {
    return null;
  }

  /**
   * Describe <code>reverseOrder</code> method here.
   *
   * @return a <code>Comparator</code> value
   */
  public final Comparator reverseOrder() {
    return null;
  }

  /**
   * Describe <code>naturalOrder</code> method here.
   *
   * @return a <code>Comparator</code> value
   */
  public final Comparator naturalOrder() {
    return null;
  }

  /**
   * Describe <code>nullsFirst</code> method here.
   *
   * @param comparator a <code>Comparator</code> value
   * @return a <code>Comparator</code> value
   */
  public final Comparator nullsFirst(final Comparator comparator) {
    return null;
  }

  /**
   * Describe <code>nullsLast</code> method here.
   *
   * @param comparator a <code>Comparator</code> value
   * @return a <code>Comparator</code> value
   */
  public final Comparator nullsLast(final Comparator comparator) {
    return null;
  }

  /**
   * Describe <code>comparing</code> method here.
   *
   * @param function a <code>Function</code> value
   * @param comparator a <code>Comparator</code> value
   * @return a <code>Comparator</code> value
   */
  public final Comparator comparing(final Function function, final Comparator comparator) {
    return null;
  }

  /**
   * Describe <code>comparing</code> method here.
   *
   * @param function a <code>Function</code> value
   * @return a <code>Comparator</code> value
   */
  public final Comparator comparing(final Function function) {
    return null;
  }

  /**
   * Describe <code>comparingInt</code> method here.
   *
   * @param toIntFunction a <code>ToIntFunction</code> value
   * @return a <code>Comparator</code> value
   */
  public final Comparator comparingInt(final ToIntFunction toIntFunction) {
    return null;
  }

  /**
   * Describe <code>comparingLong</code> method here.
   *
   * @param toLongFunction a <code>ToLongFunction</code> value
   * @return a <code>Comparator</code> value
   */
  public final Comparator comparingLong(final ToLongFunction toLongFunction) {
    return null;
  }

  /**
   * Describe <code>comparingDouble</code> method here.
   *
   * @param toDoubleFunction a <code>ToDoubleFunction</code> value
   * @return a <code>Comparator</code> value
   */
  public final Comparator comparingDouble(final ToDoubleFunction toDoubleFunction) {
    return null;
  }
 
}
