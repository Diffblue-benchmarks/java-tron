package org.tron.consensus.dpos;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.consensus.base.Param;
import org.tron.consensus.base.Param.Miner;

public class DposTaskDiffblueTest {
  /**
   * Test {@link DposTask#init()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then calls {@link DposService#getMiners()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposTask#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DposTask.init()"})
  public void testInit_givenA_thenCallsGetMiners() {
    // Arrange
    HashMap<ByteString, Miner> byteStringMinerMap = new HashMap<>();
    ByteString byteString = mock(ByteString.class);
    byteStringMinerMap.put(byteString,
        Param.getInstance().new Miner(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, null, null));
    DposService dposService = mock(DposService.class);
    when(dposService.getMiners()).thenReturn(byteStringMinerMap);
    when(dposService.isEnable()).thenReturn(true);

    DposTask dposTask = new DposTask();
    dposTask.setDposService(dposService);

    // Act
    dposTask.init();

    // Assert
    verify(dposService).getMiners();
    verify(dposService).isEnable();
  }

  /**
   * Test {@link DposTask#init()}.
   * <ul>
   *   <li>Given {@link DposService} {@link DposService#getMiners()} return {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link DposService#getMiners()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DposTask#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DposTask.init()"})
  public void testInit_givenDposServiceGetMinersReturnHashMap_thenCallsGetMiners() {
    // Arrange
    DposService dposService = mock(DposService.class);
    when(dposService.getMiners()).thenReturn(new HashMap<>());
    when(dposService.isEnable()).thenReturn(true);

    DposTask dposTask = new DposTask();
    dposTask.setDposService(dposService);

    // Act
    dposTask.init();

    // Assert
    verify(dposService).getMiners();
    verify(dposService).isEnable();
  }
}
