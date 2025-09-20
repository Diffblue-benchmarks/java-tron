package org.tron.core.net.service.nodepersist;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.BytesCapsule;
import org.tron.core.db.CommonStore;

@RunWith(MockitoJUnitRunner.class)
public class NodePersistServiceDiffblueTest {
  @Mock private CommonStore commonStore;

  @InjectMocks private NodePersistService nodePersistService;

  /**
   * Test {@link NodePersistService#dbRead()}.
   *
   * <ul>
   *   <li>Given {@link CommonStore} {@link CommonStore#get(byte[])} return {@link
   *       BytesCapsule#BytesCapsule(byte[])} with bytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link NodePersistService#dbRead()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List NodePersistService.dbRead()"})
  public void testDbRead_givenCommonStoreGetReturnBytesCapsuleWithBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    when(commonStore.get(Mockito.<byte[]>any()))
        .thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    List<InetSocketAddress> actualDbReadResult = nodePersistService.dbRead();

    // Assert
    verify(commonStore).get(isA(byte[].class));
    assertTrue(actualDbReadResult.isEmpty());
  }

  /**
   * Test {@link NodePersistService#dbRead()}.
   *
   * <ul>
   *   <li>Given {@link CommonStore} {@link CommonStore#get(byte[])} return {@link
   *       BytesCapsule#BytesCapsule(byte[])} with bytes is empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link NodePersistService#dbRead()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List NodePersistService.dbRead()"})
  public void testDbRead_givenCommonStoreGetReturnBytesCapsuleWithBytesIsEmptyArrayOfByte() {
    // Arrange
    BytesCapsule bytesCapsule = new BytesCapsule(new byte[] {});
    when(commonStore.get(Mockito.<byte[]>any())).thenReturn(bytesCapsule);

    // Act
    List<InetSocketAddress> actualDbReadResult = nodePersistService.dbRead();

    // Assert
    verify(commonStore).get(isA(byte[].class));
    assertTrue(actualDbReadResult.isEmpty());
  }

  /**
   * Test {@link NodePersistService#dbRead()}.
   *
   * <ul>
   *   <li>Given {@link CommonStore} {@link CommonStore#get(byte[])} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NodePersistService#dbRead()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List NodePersistService.dbRead()"})
  public void testDbRead_givenCommonStoreGetReturnNull() {
    // Arrange
    when(commonStore.get(Mockito.<byte[]>any())).thenReturn(null);

    // Act
    List<InetSocketAddress> actualDbReadResult = nodePersistService.dbRead();

    // Assert
    verify(commonStore).get(isA(byte[].class));
    assertTrue(actualDbReadResult.isEmpty());
  }

  /**
   * Test {@link NodePersistService#dbRead()}.
   *
   * <ul>
   *   <li>Given {@link CommonStore} {@link CommonStore#get(byte[])} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link NodePersistService#dbRead()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List NodePersistService.dbRead()"})
  public void testDbRead_givenCommonStoreGetThrowRuntimeException() {
    // Arrange
    when(commonStore.get(Mockito.<byte[]>any())).thenThrow(new RuntimeException());

    // Act
    List<InetSocketAddress> actualDbReadResult = nodePersistService.dbRead();

    // Assert
    verify(commonStore).get(isA(byte[].class));
    assertTrue(actualDbReadResult.isEmpty());
  }
}
