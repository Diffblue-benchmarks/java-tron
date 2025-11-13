package org.tron.core.vm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class VMUtilsDiffblueTest {
  /**
   * Test {@link VMUtils#closeQuietly(Closeable)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>When {@link Closeable} {@link Closeable#close()} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link VMUtils#closeQuietly(Closeable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMUtils.closeQuietly(Closeable)"})
  public void testCloseQuietly_givenIOException_whenCloseableCloseThrowIOException()
      throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doThrow(new IOException()).when(closeable).close();

    // Act
    VMUtils.closeQuietly(closeable);

    // Assert
    verify(closeable).close();
  }

  /**
   * Test {@link VMUtils#closeQuietly(Closeable)}.
   *
   * <ul>
   *   <li>When {@link Closeable} {@link Closeable#close()} does nothing.
   *   <li>Then calls {@link Closeable#close()}.
   * </ul>
   *
   * <p>Method under test: {@link VMUtils#closeQuietly(Closeable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void VMUtils.closeQuietly(Closeable)"})
  public void testCloseQuietly_whenCloseableCloseDoesNothing_thenCallsClose() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doNothing().when(closeable).close();

    // Act
    VMUtils.closeQuietly(closeable);

    // Assert
    verify(closeable).close();
  }

  /**
   * Test {@link VMUtils#compress(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code x} and minus one hundred.
   * </ul>
   *
   * <p>Method under test: {@link VMUtils#compress(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] VMUtils.compress(byte[])"})
  public void testCompressWithBytes_thenReturnArrayOfByteWithXAndMinusOneHundred()
      throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'x', -100, 's', -116, 'p', 4, 'C', 0, '\n', -100, 2, 'e'},
        VMUtils.compress("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link VMUtils#compress(String)} with {@code content}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code x} and minus one hundred.
   * </ul>
   *
   * <p>Method under test: {@link VMUtils#compress(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] VMUtils.compress(String)"})
  public void testCompressWithContent_thenReturnArrayOfByteWithXAndMinusOneHundred()
      throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          'x', -100, -13, -53, '/', 'Q', 'H', -52, -55, 'Q', '(', -49, -56, 'W', '(', 'O', -52, 'K',
          'I', '-', 'R', 'H', ',', 'J', 'U', -56, -55, '/', '.', 1, 0, -122, -63, '\t', -44
        },
        VMUtils.compress("Not all who wander are lost"));
  }

  /**
   * Test {@link VMUtils#zipAndEncode(String)}.
   *
   * <ul>
   *   <li>Then return {@code eJzzyy9RSMzJUSjPyFcoT8xLSS1SSCxKVcjJLy4BAIbBCdQ=}.
   * </ul>
   *
   * <p>Method under test: {@link VMUtils#zipAndEncode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String VMUtils.zipAndEncode(String)"})
  public void testZipAndEncode_thenReturnEJzzyy9RSMzJUSjPyFcoT8xLSS1SSCxKVcjJLy4BAIbBCdQ() {
    // Arrange, Act and Assert
    assertEquals(
        "eJzzyy9RSMzJUSjPyFcoT8xLSS1SSCxKVcjJLy4BAIbBCdQ=",
        VMUtils.zipAndEncode("Not all who wander are lost"));
  }

  /**
   * Test {@link VMUtils#zipAndEncode(String)}.
   *
   * <ul>
   *   <li>When {@code Content}.
   *   <li>Then return {@code eJxzzs8rSc0rAQAK6wLc}.
   * </ul>
   *
   * <p>Method under test: {@link VMUtils#zipAndEncode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String VMUtils.zipAndEncode(String)"})
  public void testZipAndEncode_whenContent_thenReturnEJxzzs8rSc0rAQAK6wLc() {
    // Arrange, Act and Assert
    assertEquals("eJxzzs8rSc0rAQAK6wLc", VMUtils.zipAndEncode("Content"));
  }

  /**
   * Test {@link VMUtils#zipAndEncode(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VMUtils#zipAndEncode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String VMUtils.zipAndEncode(String)"})
  public void testZipAndEncode_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(VMUtils.zipAndEncode(null));
  }

  /**
   * Test {@link VMUtils#zipAndEncode(String)}.
   *
   * <ul>
   *   <li>When {@code UTF-8}.
   *   <li>Then return {@code eJwLDXHTtQAABGIBVQ==}.
   * </ul>
   *
   * <p>Method under test: {@link VMUtils#zipAndEncode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String VMUtils.zipAndEncode(String)"})
  public void testZipAndEncode_whenUtf8_thenReturnEJwLDXHTtQAABGIBVQ() {
    // Arrange, Act and Assert
    assertEquals("eJwLDXHTtQAABGIBVQ==", VMUtils.zipAndEncode("UTF-8"));
  }

  /**
   * Test {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], long)} with {@code
   * deposit}, {@code ownerAddress}, {@code toAddress}, {@code amount}.
   *
   * <p>Method under test: {@link VMUtils#validateForSmartContract(Repository, byte[], byte[],
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VMUtils.validateForSmartContract(Repository, byte[], byte[], long)"})
  public void testValidateForSmartContractWithDepositOwnerAddressToAddressAmount()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () ->
            VMUtils.validateForSmartContract(
                RepositoryImpl.createRoot(StoreFactory.getInstance()),
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8"),
                10L));
  }

  /**
   * Test {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], long)} with {@code
   * deposit}, {@code ownerAddress}, {@code toAddress}, {@code amount}.
   *
   * <p>Method under test: {@link VMUtils#validateForSmartContract(Repository, byte[], byte[],
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VMUtils.validateForSmartContract(Repository, byte[], byte[], long)"})
  public void testValidateForSmartContractWithDepositOwnerAddressToAddressAmount2()
      throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () ->
            VMUtils.validateForSmartContract(
                RepositoryImpl.createRoot(StoreFactory.getInstance()),
                new byte[] {},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                0L));
  }

  /**
   * Test {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], long)} with {@code
   * deposit}, {@code ownerAddress}, {@code toAddress}, {@code amount}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VMUtils#validateForSmartContract(Repository, byte[], byte[],
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean VMUtils.validateForSmartContract(Repository, byte[], byte[], long)"})
  public void testValidateForSmartContractWithDepositOwnerAddressToAddressAmount_whenNull()
      throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () ->
            VMUtils.validateForSmartContract(
                RepositoryImpl.createRoot(StoreFactory.getInstance()),
                null,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                0L));
  }

  /**
   * Test {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], byte[], long)} with
   * {@code deposit}, {@code ownerAddress}, {@code toAddress}, {@code tokenId}, {@code amount}.
   *
   * <p>Method under test: {@link VMUtils#validateForSmartContract(Repository, byte[], byte[],
   * byte[], long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VMUtils.validateForSmartContract(Repository, byte[], byte[], byte[], long)"
  })
  public void testValidateForSmartContractWithDepositOwnerAddressToAddressTokenIdAmount()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () ->
            VMUtils.validateForSmartContract(
                RepositoryImpl.createRoot(StoreFactory.getInstance()),
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8"),
                10L));
  }

  /**
   * Test {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], byte[], long)} with
   * {@code deposit}, {@code ownerAddress}, {@code toAddress}, {@code tokenId}, {@code amount}.
   *
   * <p>Method under test: {@link VMUtils#validateForSmartContract(Repository, byte[], byte[],
   * byte[], long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VMUtils.validateForSmartContract(Repository, byte[], byte[], byte[], long)"
  })
  public void testValidateForSmartContractWithDepositOwnerAddressToAddressTokenIdAmount2()
      throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () ->
            VMUtils.validateForSmartContract(
                RepositoryImpl.createRoot(StoreFactory.getInstance()),
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                0L));
  }

  /**
   * Test {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], byte[], long)} with
   * {@code deposit}, {@code ownerAddress}, {@code toAddress}, {@code tokenId}, {@code amount}.
   *
   * <p>Method under test: {@link VMUtils#validateForSmartContract(Repository, byte[], byte[],
   * byte[], long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VMUtils.validateForSmartContract(Repository, byte[], byte[], byte[], long)"
  })
  public void testValidateForSmartContractWithDepositOwnerAddressToAddressTokenIdAmount3()
      throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () ->
            VMUtils.validateForSmartContract(
                RepositoryImpl.createRoot(StoreFactory.getInstance()),
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                null,
                0L));
  }

  /**
   * Test {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], byte[], long)} with
   * {@code deposit}, {@code ownerAddress}, {@code toAddress}, {@code tokenId}, {@code amount}.
   *
   * <p>Method under test: {@link VMUtils#validateForSmartContract(Repository, byte[], byte[],
   * byte[], long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VMUtils.validateForSmartContract(Repository, byte[], byte[], byte[], long)"
  })
  public void testValidateForSmartContractWithDepositOwnerAddressToAddressTokenIdAmount4()
      throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () ->
            VMUtils.validateForSmartContract(
                RepositoryImpl.createRoot(StoreFactory.getInstance()),
                null,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                0L));
  }

  /**
   * Test {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], byte[], long)} with
   * {@code deposit}, {@code ownerAddress}, {@code toAddress}, {@code tokenId}, {@code amount}.
   *
   * <p>Method under test: {@link VMUtils#validateForSmartContract(Repository, byte[], byte[],
   * byte[], long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VMUtils.validateForSmartContract(Repository, byte[], byte[], byte[], long)"
  })
  public void testValidateForSmartContractWithDepositOwnerAddressToAddressTokenIdAmount5()
      throws UnsupportedEncodingException, ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () ->
            VMUtils.validateForSmartContract(
                null,
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8"),
                "AXAXAXAX".getBytes("UTF-8"),
                10L));
  }

  /**
   * Test {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], byte[], long)} with
   * {@code deposit}, {@code ownerAddress}, {@code toAddress}, {@code tokenId}, {@code amount}.
   *
   * <p>Method under test: {@link VMUtils#validateForSmartContract(Repository, byte[], byte[],
   * byte[], long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VMUtils.validateForSmartContract(Repository, byte[], byte[], byte[], long)"
  })
  public void testValidateForSmartContractWithDepositOwnerAddressToAddressTokenIdAmount6()
      throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () ->
            VMUtils.validateForSmartContract(
                RepositoryImpl.createRoot(StoreFactory.getInstance()),
                new byte[] {},
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                0L));
  }

  /**
   * Test {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], byte[], long)} with
   * {@code deposit}, {@code ownerAddress}, {@code toAddress}, {@code tokenId}, {@code amount}.
   *
   * <p>Method under test: {@link VMUtils#validateForSmartContract(Repository, byte[], byte[],
   * byte[], long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VMUtils.validateForSmartContract(Repository, byte[], byte[], byte[], long)"
  })
  public void testValidateForSmartContractWithDepositOwnerAddressToAddressTokenIdAmount7()
      throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(
        ContractValidateException.class,
        () ->
            VMUtils.validateForSmartContract(
                RepositoryImpl.createRoot(StoreFactory.getInstance()),
                null,
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
                new byte[] {0, 'A', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                0L));
  }
}
