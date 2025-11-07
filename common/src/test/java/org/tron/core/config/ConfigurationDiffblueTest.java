package org.tron.core.config;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConfigurationDiffblueTest {
  /**
   * Test {@link Configuration#getByFileName(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#getByFileName(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"com.typesafe.config.Config Configuration.getByFileName(String, String)"})
  public void testGetByFileName_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Configuration.getByFileName("", "foo.txt"));
  }

  /**
   * Test {@link Configuration#getByFileName(String, String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#getByFileName(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"com.typesafe.config.Config Configuration.getByFileName(String, String)"})
  public void testGetByFileName_whenFooTxt() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Configuration.getByFileName("foo.txt", "foo.txt"));
  }

  /**
   * Test {@link Configuration#getByFileName(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#getByFileName(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"com.typesafe.config.Config Configuration.getByFileName(String, String)"})
  public void testGetByFileName_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Configuration.getByFileName(null, "foo.txt"));
  }

  /**
   * Test {@link Configuration#getByFileName(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Configuration#getByFileName(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"com.typesafe.config.Config Configuration.getByFileName(String, String)"})
  public void testGetByFileName_whenNull2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> Configuration.getByFileName(null, null));
  }
}
