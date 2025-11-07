package org.tron.core.services.ratelimiter.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.junit.Test;

public class GlobalPreemptibleStrategyDiffblueTest {
  /**
   * Method under test: {@link GlobalPreemptibleStrategy#defaultParam()}
   */
  @Test
  public void testDefaultParam() {
    // Arrange and Act
    Map<String, Strategy.ParamItem> actualDefaultParamResult = (new GlobalPreemptibleStrategy("Param String"))
        .defaultParam();

    // Assert
    assertEquals(1, actualDefaultParamResult.size());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass,
        actualDefaultParamResult.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT).type);
  }

  /**
   * Method under test: {@link GlobalPreemptibleStrategy#acquire()}
   */
  @Test
  public void testAcquire() {
    // Arrange, Act and Assert
    assertTrue((new GlobalPreemptibleStrategy("Param String")).acquire());
  }

  /**
   * Method under test:
   * {@link GlobalPreemptibleStrategy#GlobalPreemptibleStrategy(String)}
   */
  @Test
  public void testNewGlobalPreemptibleStrategy() {
    // Arrange, Act and Assert
    Map<String, Strategy.ParamItem> mapParams = (new GlobalPreemptibleStrategy("Param String")).getMapParams();
    assertEquals(1, mapParams.size());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, mapParams.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT).type);
  }

  /**
   * Method under test:
   * {@link GlobalPreemptibleStrategy#GlobalPreemptibleStrategy(String)}
   */
  @Test
  public void testNewGlobalPreemptibleStrategy2() {
    // Arrange, Act and Assert
    Map<String, Strategy.ParamItem> mapParams = (new GlobalPreemptibleStrategy(null)).getMapParams();
    assertEquals(1, mapParams.size());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, mapParams.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT).type);
  }

  /**
   * Method under test:
   * {@link GlobalPreemptibleStrategy#GlobalPreemptibleStrategy(String)}
   */
  @Test
  public void testNewGlobalPreemptibleStrategy3() {
    // Arrange, Act and Assert
    Map<String, Strategy.ParamItem> mapParams = (new GlobalPreemptibleStrategy("UUU=UUU")).getMapParams();
    assertEquals(1, mapParams.size());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, mapParams.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT).type);
  }

  /**
   * Method under test:
   * {@link GlobalPreemptibleStrategy#GlobalPreemptibleStrategy(String)}
   */
  @Test
  public void testNewGlobalPreemptibleStrategy4() {
    // Arrange, Act and Assert
    Map<String, Strategy.ParamItem> mapParams = (new GlobalPreemptibleStrategy("")).getMapParams();
    assertEquals(1, mapParams.size());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, mapParams.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT).type);
  }
}
