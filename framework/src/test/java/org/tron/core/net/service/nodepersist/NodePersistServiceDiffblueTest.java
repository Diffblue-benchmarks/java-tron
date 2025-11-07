package org.tron.core.net.service.nodepersist;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.tron.core.capsule.BytesCapsule;
import org.tron.core.db.CommonStore;

@RunWith(MockitoJUnitRunner.class)
public class NodePersistServiceDiffblueTest {
  @Mock
  private CommonStore commonStore;

  @InjectMocks
  private NodePersistService nodePersistService;

  /**
   * Method under test: {@link NodePersistService#dbRead()}
   */
  @Test
  public void testDbRead() throws UnsupportedEncodingException {
    // Arrange
    when(commonStore.get(Mockito.<byte[]>any())).thenReturn(new BytesCapsule("AXAXAXAX".getBytes("UTF-8")));

    // Act
    List<InetSocketAddress> actualDbReadResult = nodePersistService.dbRead();

    // Assert
    verify(commonStore).get(isA(byte[].class));
    assertTrue(actualDbReadResult.isEmpty());
  }

  /**
   * Method under test: {@link NodePersistService#dbRead()}
   */
  @Test
  public void testDbRead2() {
    // Arrange
    when(commonStore.get(Mockito.<byte[]>any())).thenReturn(new BytesCapsule(new byte[]{}));

    // Act
    List<InetSocketAddress> actualDbReadResult = nodePersistService.dbRead();

    // Assert
    verify(commonStore).get(isA(byte[].class));
    assertTrue(actualDbReadResult.isEmpty());
  }

  /**
   * Method under test: {@link NodePersistService#dbRead()}
   */
  @Test
  public void testDbRead3() {
    // Arrange
    when(commonStore.get(Mockito.<byte[]>any())).thenReturn(null);

    // Act
    List<InetSocketAddress> actualDbReadResult = nodePersistService.dbRead();

    // Assert
    verify(commonStore).get(isA(byte[].class));
    assertTrue(actualDbReadResult.isEmpty());
  }
}
