package org.tron.core.net.service.statistics;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MessageCountDiffblueTest {
  /**
   * Test {@link MessageCount#add()}.
   *
   * <p>Method under test: {@link MessageCount#add()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageCount.add()"})
  public void testAdd() {
    // Arrange
    MessageCount messageCount = new MessageCount();

    // Act
    messageCount.add();

    // Assert
    assertEquals(1L, messageCount.getTotalCount());
  }

  /**
   * Test {@link MessageCount#add(int)} with {@code int}.
   *
   * <p>Method under test: {@link MessageCount#add(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageCount.add(int)"})
  public void testAddWithInt() {
    // Arrange
    MessageCount messageCount = new MessageCount();

    // Act
    messageCount.add(3);

    // Assert
    assertEquals(3L, messageCount.getTotalCount());
  }

  /**
   * Test {@link MessageCount#getCount(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link MessageCount#getCount(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MessageCount.getCount(int)"})
  public void testGetCount_whenFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(0, new MessageCount().getCount(42));
  }

  /**
   * Test {@link MessageCount#getCount(int)}.
   *
   * <ul>
   *   <li>When one thousand.
   * </ul>
   *
   * <p>Method under test: {@link MessageCount#getCount(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MessageCount.getCount(int)"})
  public void testGetCount_whenOneThousand() {
    // Arrange, Act and Assert
    assertEquals(0, new MessageCount().getCount(1000));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MessageCount#reset()}
   *   <li>{@link MessageCount#toString()}
   *   <li>{@link MessageCount#getTotalCount()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long MessageCount.getTotalCount()",
    "void MessageCount.reset()",
    "String MessageCount.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    MessageCount messageCount = new MessageCount();

    // Act
    messageCount.reset();
    String actualToStringResult = messageCount.toString();

    // Assert
    assertEquals("0", actualToStringResult);
    assertEquals(0L, messageCount.getTotalCount());
  }

  /**
   * Test new {@link MessageCount} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MessageCount}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessageCount.<init>()"})
  public void testNewMessageCount() {
    // Arrange, Act and Assert
    assertEquals(0L, new MessageCount().getTotalCount());
  }
}
