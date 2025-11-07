package org.tron.core.net.service.statistics;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MessageCountDiffblueTest {
  /**
   * Method under test: {@link MessageCount#add()}
   */
  @Test
  public void testAdd() {
    // Arrange
    MessageCount messageCount = new MessageCount();

    // Act
    messageCount.add();

    // Assert
    assertEquals(1L, messageCount.getTotalCount());
  }

  /**
   * Method under test: {@link MessageCount#add(int)}
   */
  @Test
  public void testAdd2() {
    // Arrange
    MessageCount messageCount = new MessageCount();

    // Act
    messageCount.add(3);

    // Assert
    assertEquals(3L, messageCount.getTotalCount());
  }

  /**
   * Method under test: {@link MessageCount#getCount(int)}
   */
  @Test
  public void testGetCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new MessageCount()).getCount(42));
    assertEquals(0, (new MessageCount()).getCount(1000));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MessageCount#reset()}
   *   <li>{@link MessageCount#toString()}
   *   <li>{@link MessageCount#getTotalCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    MessageCount messageCount = new MessageCount();

    // Act
    messageCount.reset();
    String actualToStringResult = messageCount.toString();

    // Assert that nothing has changed
    assertEquals("0", actualToStringResult);
    assertEquals(0L, messageCount.getTotalCount());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link MessageCount}
   */
  @Test
  public void testNewMessageCount() {
    // Arrange, Act and Assert
    assertEquals(0L, (new MessageCount()).getTotalCount());
  }
}
