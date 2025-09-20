package org.tron.core.vm.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.program.Program;
import org.tron.core.vm.program.Program.Exception;
import org.tron.core.vm.program.Program.OutOfTimeException;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class MUtilDiffblueTest {
  /**
   * Test {@link MUtil#transferAllToken(Repository, byte[], byte[])}.
   *
   * <p>Method under test: {@link MUtil#transferAllToken(Repository, byte[], byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MUtil.transferAllToken(Repository, byte[], byte[])"})
  public void testTransferAllToken() throws UnsupportedEncodingException {
    // Arrange
    RepositoryImpl repository = mock(RepositoryImpl.class);
    when(repository.getAccount(Mockito.<byte[]>any())).thenThrow(Exception.alreadyTimeOut());
    RepositoryImpl deposit = new RepositoryImpl(StoreFactory.getInstance(), repository);

    // Act and Assert
    assertThrows(
        OutOfTimeException.class,
        () ->
            MUtil.transferAllToken(
                deposit, "AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8")));
    verify(repository).getAccount(isA(byte[].class));
  }

  /**
   * Test {@link MUtil#isNullOrEmpty(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MUtil#isNullOrEmpty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MUtil.isNullOrEmpty(String)"})
  public void testIsNullOrEmpty_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MUtil.isNullOrEmpty(""));
  }

  /**
   * Test {@link MUtil#isNullOrEmpty(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MUtil#isNullOrEmpty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MUtil.isNullOrEmpty(String)"})
  public void testIsNullOrEmpty_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MUtil.isNullOrEmpty(null));
  }

  /**
   * Test {@link MUtil#isNullOrEmpty(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MUtil#isNullOrEmpty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MUtil.isNullOrEmpty(String)"})
  public void testIsNullOrEmpty_whenStr_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MUtil.isNullOrEmpty("Str"));
  }

  /**
   * Test {@link MUtil#isNotNullOrEmpty(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MUtil#isNotNullOrEmpty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MUtil.isNotNullOrEmpty(String)"})
  public void testIsNotNullOrEmpty_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MUtil.isNotNullOrEmpty(""));
  }

  /**
   * Test {@link MUtil#isNotNullOrEmpty(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MUtil#isNotNullOrEmpty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MUtil.isNotNullOrEmpty(String)"})
  public void testIsNotNullOrEmpty_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MUtil.isNotNullOrEmpty(null));
  }

  /**
   * Test {@link MUtil#isNotNullOrEmpty(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MUtil#isNotNullOrEmpty(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MUtil.isNotNullOrEmpty(String)"})
  public void testIsNotNullOrEmpty_whenStr_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MUtil.isNotNullOrEmpty("Str"));
  }
}
