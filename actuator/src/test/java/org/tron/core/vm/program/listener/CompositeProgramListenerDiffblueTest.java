package org.tron.core.vm.program.listener;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CompositeProgramListenerDiffblueTest {
  /**
   * Test {@link CompositeProgramListener#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link CompositeProgramListener} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#isEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CompositeProgramListener.isEmpty()"})
  public void testIsEmpty_givenCompositeProgramListener_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new CompositeProgramListener().isEmpty());
  }

  /**
   * Test {@link CompositeProgramListener#isEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeProgramListener#isEmpty()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CompositeProgramListener.isEmpty()"})
  public void testIsEmpty_thenReturnFalse() {
    // Arrange
    CompositeProgramListener compositeProgramListener = new CompositeProgramListener();
    compositeProgramListener.addListener(new CompositeProgramListener());

    // Act and Assert
    assertFalse(compositeProgramListener.isEmpty());
  }

  /**
   * Test new {@link CompositeProgramListener} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CompositeProgramListener}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompositeProgramListener.<init>()"})
  public void testNewCompositeProgramListener() {
    // Arrange, Act and Assert
    assertTrue(new CompositeProgramListener().isEmpty());
  }
}
