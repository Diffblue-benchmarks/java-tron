package org.tron.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.iq80.leveldb.Options;
import org.junit.Test;

public class PropertyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Property}
   *   <li>{@link Property#setDbOptions(Options)}
   *   <li>{@link Property#setName(String)}
   *   <li>{@link Property#setPath(String)}
   *   <li>{@link Property#getDbOptions()}
   *   <li>{@link Property#getName()}
   *   <li>{@link Property#getPath()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Property actualProperty = new Property();
    Options dbOptions = DbOptionalsUtils.createDefaultDbOptions();
    actualProperty.setDbOptions(dbOptions);
    actualProperty.setName("Name");
    actualProperty.setPath("Path");
    Options actualDbOptions = actualProperty.getDbOptions();
    String actualName = actualProperty.getName();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Path", actualProperty.getPath());
    assertSame(dbOptions, actualDbOptions);
  }
}
