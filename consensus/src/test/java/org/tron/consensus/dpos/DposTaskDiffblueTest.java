package org.tron.consensus.dpos;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.ByteString;
import java.util.HashMap;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.tron.consensus.ConsensusDelegate;
import org.tron.consensus.base.Param;

public class DposTaskDiffblueTest {
  /**
   * Method under test: {@link DposTask#init()}
   */
  @Test
  public void testInit() {
    // Arrange
    DposService dposService = mock(DposService.class);
    when(dposService.getMiners()).thenReturn(new HashMap<>());
    when(dposService.isEnable()).thenReturn(true);

    DposTask dposTask = new DposTask();
    dposTask.setDposService(dposService);
    ReflectionTestUtils.setField(dposTask, "stateManager", mock(StateManager.class));
    ReflectionTestUtils.setField(dposTask, "dposSlot", mock(DposSlot.class));
    ReflectionTestUtils.setField(dposTask, "consensusDelegate", mock(ConsensusDelegate.class));

    // Act
    dposTask.init();

    // Assert that nothing has changed
    verify(dposService).getMiners();
    verify(dposService).isEnable();
  }

  /**
   * Method under test: {@link DposTask#init()}
   */
  @Test
  public void testInit2() {
    // Arrange
    HashMap<ByteString, Param.Miner> byteStringMinerMap = new HashMap<>();
    ByteString byteString = mock(ByteString.class);
    byteStringMinerMap.put(byteString,
        Param.getInstance().new Miner(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, null, null));
    DposService dposService = mock(DposService.class);
    when(dposService.getMiners()).thenReturn(byteStringMinerMap);
    when(dposService.isEnable()).thenReturn(true);

    DposTask dposTask = new DposTask();
    dposTask.setDposService(dposService);
    ReflectionTestUtils.setField(dposTask, "stateManager", mock(StateManager.class));
    ReflectionTestUtils.setField(dposTask, "dposSlot", mock(DposSlot.class));
    ReflectionTestUtils.setField(dposTask, "consensusDelegate", mock(ConsensusDelegate.class));

    // Act
    dposTask.init();

    // Assert
    verify(dposService).getMiners();
    verify(dposService).isEnable();
  }
}
