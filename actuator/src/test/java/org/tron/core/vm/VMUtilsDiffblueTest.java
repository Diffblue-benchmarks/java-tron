package org.tron.core.vm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.tron.core.exception.ContractValidateException;
import org.tron.core.store.StoreFactory;
import org.tron.core.vm.repository.Repository;
import org.tron.core.vm.repository.RepositoryImpl;

public class VMUtilsDiffblueTest {
  /**
   * Method under test: {@link VMUtils#getAddressSize()}
   */
  @Test
  public void testGetAddressSize() {
    // Arrange, Act and Assert
    assertEquals(Op.EQ, VMUtils.getAddressSize());
  }

  /**
   * Method under test: {@link VMUtils#closeQuietly(Closeable)}
   */
  @Test
  public void testCloseQuietly() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doNothing().when(closeable).close();

    // Act
    VMUtils.closeQuietly(closeable);

    // Assert that nothing has changed
    verify(closeable).close();
  }

  /**
   * Method under test: {@link VMUtils#closeQuietly(Closeable)}
   */
  @Test
  public void testCloseQuietly2() throws IOException {
    // Arrange
    Closeable closeable = mock(Closeable.class);
    doThrow(new IOException("foo")).when(closeable).close();

    // Act
    VMUtils.closeQuietly(closeable);

    // Assert that nothing has changed
    verify(closeable).close();
  }

  /**
   * Method under test: {@link VMUtils#compress(String)}
   */
  @Test
  public void testCompress() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{'x', -100, -13, -53, '/', 'Q', 'H', -52, -55, 'Q', '(', -49, -56, 'W', '(', 'O', -52, 'K', 'I', '-',
            'R', 'H', ',', 'J', 'U', -56, -55, '/', '.', 1, 0, -122, -63, '\t', -44},
        VMUtils.compress("Not all who wander are lost"));
    assertArrayEquals(new byte[]{'x', -100, 's', -116, 'p', 4, 'C', 0, '\n', -100, 2, 'e'},
        VMUtils.compress("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link VMUtils#zipAndEncode(String)}
   */
  @Test
  public void testZipAndEncode() {
    // Arrange, Act and Assert
    assertEquals("eJzzyy9RSMzJUSjPyFcoT8xLSS1SSCxKVcjJLy4BAIbBCdQ=",
        VMUtils.zipAndEncode("Not all who wander are lost"));
    assertEquals("eJwLDXHTtQAABGIBVQ==", VMUtils.zipAndEncode("UTF-8"));
    assertEquals("eJxzzs8rSc0rAQAK6wLc", VMUtils.zipAndEncode("Content"));
    assertNull(VMUtils.zipAndEncode(null));
  }

  /**
   * Method under test:
   * {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], long)}
   */
  @Test
  public void testValidateForSmartContract() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(ContractValidateException.class,
        () -> VMUtils.validateForSmartContract(deposit, ownerAddress, "AXAXAXAX".getBytes("UTF-8"), 10L));
  }

  /**
   * Method under test:
   * {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], long)}
   */
  @Test
  public void testValidateForSmartContract2() throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(ContractValidateException.class,
        () -> VMUtils.validateForSmartContract(RepositoryImpl.createRoot(StoreFactory.getInstance()), null, null, 0L));
  }

  /**
   * Method under test:
   * {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], long)}
   */
  @Test
  public void testValidateForSmartContract3() throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(ContractValidateException.class, () -> VMUtils
        .validateForSmartContract(RepositoryImpl.createRoot(StoreFactory.getInstance()), new byte[]{}, null, 0L));
  }

  /**
   * Method under test:
   * {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], byte[], long)}
   */
  @Test
  public void testValidateForSmartContract4() throws UnsupportedEncodingException, ContractValidateException {
    // Arrange
    RepositoryImpl deposit = RepositoryImpl.createRoot(StoreFactory.getInstance());
    byte[] ownerAddress = "AXAXAXAX".getBytes("UTF-8");
    byte[] toAddress = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(ContractValidateException.class,
        () -> VMUtils.validateForSmartContract(deposit, ownerAddress, toAddress, "AXAXAXAX".getBytes("UTF-8"), 10L));
  }

  /**
   * Method under test:
   * {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], byte[], long)}
   */
  @Test
  public void testValidateForSmartContract5() throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(ContractValidateException.class, () -> VMUtils.validateForSmartContract(null, null, null, null, 0L));
  }

  /**
   * Method under test:
   * {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], byte[], long)}
   */
  @Test
  public void testValidateForSmartContract6() throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(ContractValidateException.class, () -> VMUtils
        .validateForSmartContract(RepositoryImpl.createRoot(StoreFactory.getInstance()), null, null, null, 0L));
  }

  /**
   * Method under test:
   * {@link VMUtils#validateForSmartContract(Repository, byte[], byte[], byte[], long)}
   */
  @Test
  public void testValidateForSmartContract7() throws ContractValidateException {
    // Arrange, Act and Assert
    assertThrows(ContractValidateException.class,
        () -> VMUtils.validateForSmartContract(RepositoryImpl.createRoot(StoreFactory.getInstance()), null, null,
            new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0L));
  }
}
