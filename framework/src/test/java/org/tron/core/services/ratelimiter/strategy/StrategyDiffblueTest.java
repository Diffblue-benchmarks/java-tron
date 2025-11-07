package org.tron.core.services.ratelimiter.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.util.Map;
import org.junit.Test;

public class StrategyDiffblueTest {
  /**
   * Method under test: {@link Strategy#getMapParams()}
   */
  @Test
  public void testGetMapParams() {
    // Arrange
    GlobalPreemptibleStrategy globalPreemptibleStrategy = new GlobalPreemptibleStrategy("Param String");

    // Act
    Map<String, Strategy.ParamItem> actualMapParams = globalPreemptibleStrategy.getMapParams();

    // Assert
    assertEquals(1, actualMapParams.size());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, actualMapParams.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT).type);
    assertSame(globalPreemptibleStrategy.mapParams, actualMapParams);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Strategy.ParamItem#ParamItem(Strategy, Class, Object)}
   *   <li>{@link Strategy.ParamItem#setValue(Object)}
   * </ul>
   */
  @Test
  public void testParamItemGettersAndSetters() {
    // Arrange
    GlobalPreemptibleStrategy globalPreemptibleStrategy = new GlobalPreemptibleStrategy("Param String");
    Class<Object> type = Object.class;

    // Act
    Strategy.ParamItem<Object> actualParamItem = globalPreemptibleStrategy.new ParamItem(type, "Value");
    actualParamItem.setValue("Value");

    // Assert
    assertEquals("Value", actualParamItem.value);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualParamItem.type);
  }

  /**
   * Method under test: {@link Strategy#parseStrategyParams(String)}
   */
  @Test
  public void testParseStrategyParams() {
    // Arrange and Act
    Map<String, Strategy.ParamItem> actualParseStrategyParamsResult = (new GlobalPreemptibleStrategy("Param String"))
        .parseStrategyParams("Arg String");

    // Assert
    assertEquals(1, actualParseStrategyParamsResult.size());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass,
        actualParseStrategyParamsResult.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT).type);
  }

  /**
   * Method under test: {@link Strategy#parseStrategyParams(String)}
   */
  @Test
  public void testParseStrategyParams2() {
    // Arrange and Act
    Map<String, Strategy.ParamItem> actualParseStrategyParamsResult = (new GlobalPreemptibleStrategy("Param String"))
        .parseStrategyParams("UUU=UUU");

    // Assert
    assertEquals(1, actualParseStrategyParamsResult.size());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass,
        actualParseStrategyParamsResult.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT).type);
  }

  /**
   * Method under test: {@link Strategy#parseStrategyParams(String)}
   */
  @Test
  public void testParseStrategyParams3() {
    // Arrange and Act
    Map<String, Strategy.ParamItem> actualParseStrategyParamsResult = (new GlobalPreemptibleStrategy("Param String"))
        .parseStrategyParams("");

    // Assert
    assertEquals(1, actualParseStrategyParamsResult.size());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass,
        actualParseStrategyParamsResult.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT).type);
  }

  /**
   * Method under test: {@link Strategy#parseStrategyParams(String)}
   */
  @Test
  public void testParseStrategyParams4() {
    // Arrange and Act
    Map<String, Strategy.ParamItem> actualParseStrategyParamsResult = (new GlobalPreemptibleStrategy("Param String"))
        .parseStrategyParams(null);

    // Assert
    assertEquals(1, actualParseStrategyParamsResult.size());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass,
        actualParseStrategyParamsResult.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT).type);
  }
}
