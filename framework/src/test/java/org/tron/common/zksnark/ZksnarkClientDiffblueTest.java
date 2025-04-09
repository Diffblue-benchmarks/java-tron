package org.tron.common.zksnark;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ZksnarkClientDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Method under test: {@link ZksnarkClient#getInstance()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ZksnarkClient ZksnarkClient.getInstance()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ZksnarkClient actualInstance = ZksnarkClient.getInstance().getInstance();

    // Assert
    assertSame(actualInstance.instance, actualInstance);
  }
}
