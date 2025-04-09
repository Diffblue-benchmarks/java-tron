package org.tron.consensus.pbft;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.tron.consensus.dpos.MaintenanceManager;
import org.tron.consensus.pbft.message.PbftBaseMessage;
import org.tron.consensus.pbft.message.PbftMessage;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PbftMessageHandleDiffblueTest {
  @InjectMocks
  private PbftMessageHandle pbftMessageHandle;

  /**
   * Test {@link PbftMessageHandle#onPrePrepare(PbftMessage)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link PbftMessage} {@link PbftBaseMessage#getDataString()} return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageHandle#onPrePrepare(PbftMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessageHandle.onPrePrepare(PbftMessage)"})
  public void testOnPrePrepare_given42_whenPbftMessageGetDataStringReturn42() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("42");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");

    // Act
    pbftMessageHandle.onPrePrepare(message);

    // Assert
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Test {@link PbftMessageHandle#onPrePrepare(PbftMessage)}.
   * <ul>
   *   <li>Given {@code Data String}.</li>
   *   <li>When {@link PbftMessage} {@link PbftBaseMessage#getDataString()} return {@code Data String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageHandle#onPrePrepare(PbftMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessageHandle.onPrePrepare(PbftMessage)"})
  public void testOnPrePrepare_givenDataString_whenPbftMessageGetDataStringReturnDataString() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getDataString()).thenReturn("Data String");
    when(message.getNumber()).thenReturn(1L);
    when(message.isSwitch()).thenReturn(true);
    when(message.getNo()).thenReturn("No");

    // Act
    pbftMessageHandle.onPrePrepare(message);

    // Assert
    verify(message).getDataString();
    verify(message).getNumber();
    verify(message).isSwitch();
    verify(message).getNo();
  }

  /**
   * Test {@link PbftMessageHandle#onPrepare(PbftMessage)}.
   * <ul>
   *   <li>Given {@code Key}.</li>
   *   <li>When {@link PbftMessage} {@link PbftBaseMessage#getKey()} return {@code Key}.</li>
   *   <li>Then calls {@link PbftBaseMessage#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageHandle#onPrepare(PbftMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessageHandle.onPrepare(PbftMessage)"})
  public void testOnPrepare_givenKey_whenPbftMessageGetKeyReturnKey_thenCallsGetKey() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getKey()).thenReturn("Key");
    when(message.getNo()).thenReturn("No");

    // Act
    pbftMessageHandle.onPrepare(message);

    // Assert
    verify(message).getKey();
    verify(message).getNo();
  }

  /**
   * Test {@link PbftMessageHandle#onCommit(PbftMessage)}.
   * <ul>
   *   <li>Given {@code Key}.</li>
   *   <li>When {@link PbftMessage} {@link PbftBaseMessage#getKey()} return {@code Key}.</li>
   *   <li>Then calls {@link PbftBaseMessage#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PbftMessageHandle#onCommit(PbftMessage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PbftMessageHandle.onCommit(PbftMessage)"})
  public void testOnCommit_givenKey_whenPbftMessageGetKeyReturnKey_thenCallsGetKey() {
    // Arrange
    PbftMessage message = mock(PbftMessage.class);
    when(message.getKey()).thenReturn("Key");

    // Act
    pbftMessageHandle.onCommit(message);

    // Assert
    verify(message).getKey();
  }

  /**
   * Test {@link PbftMessageHandle#checkIsCanSendMsg(long)}.
   * <p>
   * Method under test: {@link PbftMessageHandle#checkIsCanSendMsg(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PbftMessageHandle.checkIsCanSendMsg(long)"})
  public void testCheckIsCanSendMsg() {
    // Arrange
    PbftMessageHandle pbftMessageHandle = new PbftMessageHandle();
    pbftMessageHandle.setMaintenanceManager(new MaintenanceManager());

    // Act and Assert
    assertFalse(pbftMessageHandle.checkIsCanSendMsg(1L));
  }
}
