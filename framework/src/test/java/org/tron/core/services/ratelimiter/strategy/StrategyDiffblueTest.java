package org.tron.core.services.ratelimiter.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.services.ratelimiter.strategy.Strategy.ParamItem;

public class StrategyDiffblueTest {
  /**
   * Test ParamItem getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParamItem#ParamItem(Strategy, Class, Object)}
   *   <li>{@link ParamItem#setValue(Object)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ParamItem.<init>(Strategy, Class, Object)", "void ParamItem.setValue(Object)"})
  public void testParamItemGettersAndSetters() {
    // Arrange
    GlobalPreemptibleStrategy globalPreemptibleStrategy = new GlobalPreemptibleStrategy("Param String");
    Class<Object> type = Object.class;

    // Act
    ParamItem<Object> actualParamItem = globalPreemptibleStrategy.new ParamItem<>(type, "Value");
    actualParamItem.setValue("Value");

    // Assert
    assertEquals("Value", actualParamItem.value);
    Class<Object> expectedResultClass = Object.class;
    assertEquals(expectedResultClass, actualParamItem.type);
  }

  /**
   * Test {@link Strategy#parseStrategyParams(String)}.
   * <ul>
   *   <li>When {@code Arg String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Strategy#parseStrategyParams(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map Strategy.parseStrategyParams(String)"})
  public void testParseStrategyParams_whenArgString() {
    // Arrange and Act
    Map<String, ParamItem> actualParseStrategyParamsResult = (new GlobalPreemptibleStrategy("Param String"))
        .parseStrategyParams("Arg String");

    // Assert
    assertEquals(1, actualParseStrategyParamsResult.size());
    ParamItem getResult = actualParseStrategyParamsResult.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT);
    assertEquals(1, ((Integer) getResult.value).intValue());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link Strategy#parseStrategyParams(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Strategy#parseStrategyParams(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map Strategy.parseStrategyParams(String)"})
  public void testParseStrategyParams_whenEmptyString() {
    // Arrange and Act
    Map<String, ParamItem> actualParseStrategyParamsResult = (new GlobalPreemptibleStrategy("Param String"))
        .parseStrategyParams("");

    // Assert
    assertEquals(1, actualParseStrategyParamsResult.size());
    ParamItem getResult = actualParseStrategyParamsResult.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT);
    assertEquals(1, ((Integer) getResult.value).intValue());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link Strategy#parseStrategyParams(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Strategy#parseStrategyParams(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map Strategy.parseStrategyParams(String)"})
  public void testParseStrategyParams_whenNull() {
    // Arrange and Act
    Map<String, ParamItem> actualParseStrategyParamsResult = (new GlobalPreemptibleStrategy("Param String"))
        .parseStrategyParams(null);

    // Assert
    assertEquals(1, actualParseStrategyParamsResult.size());
    ParamItem getResult = actualParseStrategyParamsResult.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT);
    assertEquals(1, ((Integer) getResult.value).intValue());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link Strategy#parseStrategyParams(String)}.
   * <ul>
   *   <li>When {@code UUU=UUU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Strategy#parseStrategyParams(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map Strategy.parseStrategyParams(String)"})
  public void testParseStrategyParams_whenUuuUuu() {
    // Arrange and Act
    Map<String, ParamItem> actualParseStrategyParamsResult = (new GlobalPreemptibleStrategy("Param String"))
        .parseStrategyParams("UUU=UUU");

    // Assert
    assertEquals(1, actualParseStrategyParamsResult.size());
    ParamItem getResult = actualParseStrategyParamsResult.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT);
    assertEquals(1, ((Integer) getResult.value).intValue());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link Strategy#getMapParams()}.
   * <p>
   * Method under test: {@link Strategy#getMapParams()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map Strategy.getMapParams()"})
  public void testGetMapParams() {
    // Arrange
    GlobalPreemptibleStrategy globalPreemptibleStrategy = new GlobalPreemptibleStrategy("Param String");

    // Act and Assert
    assertSame(globalPreemptibleStrategy.mapParams, globalPreemptibleStrategy.getMapParams());
  }
}
