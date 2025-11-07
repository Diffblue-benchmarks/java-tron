package org.tron.core.services.ratelimiter.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.tron.core.services.ratelimiter.strategy.Strategy.ParamItem;

public class GlobalPreemptibleStrategyDiffblueTest {
  /**
   * Test {@link GlobalPreemptibleStrategy#GlobalPreemptibleStrategy(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalPreemptibleStrategy#GlobalPreemptibleStrategy(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GlobalPreemptibleStrategy.<init>(String)"})
  public void testNewGlobalPreemptibleStrategy_whenEmptyString() {
    // Arrange, Act and Assert
    Map<String, ParamItem> mapParams = (new GlobalPreemptibleStrategy("")).getMapParams();
    assertEquals(1, mapParams.size());
    ParamItem getResult = mapParams.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT);
    assertEquals(1, ((Integer) getResult.value).intValue());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link GlobalPreemptibleStrategy#GlobalPreemptibleStrategy(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalPreemptibleStrategy#GlobalPreemptibleStrategy(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GlobalPreemptibleStrategy.<init>(String)"})
  public void testNewGlobalPreemptibleStrategy_whenNull() {
    // Arrange, Act and Assert
    Map<String, ParamItem> mapParams = (new GlobalPreemptibleStrategy(null)).getMapParams();
    assertEquals(1, mapParams.size());
    ParamItem getResult = mapParams.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT);
    assertEquals(1, ((Integer) getResult.value).intValue());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link GlobalPreemptibleStrategy#GlobalPreemptibleStrategy(String)}.
   * <ul>
   *   <li>When {@code Param String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalPreemptibleStrategy#GlobalPreemptibleStrategy(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GlobalPreemptibleStrategy.<init>(String)"})
  public void testNewGlobalPreemptibleStrategy_whenParamString() {
    // Arrange, Act and Assert
    Map<String, ParamItem> mapParams = (new GlobalPreemptibleStrategy("Param String")).getMapParams();
    assertEquals(1, mapParams.size());
    ParamItem getResult = mapParams.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT);
    assertEquals(1, ((Integer) getResult.value).intValue());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link GlobalPreemptibleStrategy#GlobalPreemptibleStrategy(String)}.
   * <ul>
   *   <li>When {@code UUU=UUU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalPreemptibleStrategy#GlobalPreemptibleStrategy(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GlobalPreemptibleStrategy.<init>(String)"})
  public void testNewGlobalPreemptibleStrategy_whenUuuUuu() {
    // Arrange, Act and Assert
    Map<String, ParamItem> mapParams = (new GlobalPreemptibleStrategy("UUU=UUU")).getMapParams();
    assertEquals(1, mapParams.size());
    ParamItem getResult = mapParams.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT);
    assertEquals(1, ((Integer) getResult.value).intValue());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link GlobalPreemptibleStrategy#defaultParam()}.
   * <p>
   * Method under test: {@link GlobalPreemptibleStrategy#defaultParam()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map GlobalPreemptibleStrategy.defaultParam()"})
  public void testDefaultParam() {
    // Arrange and Act
    Map<String, ParamItem> actualDefaultParamResult = (new GlobalPreemptibleStrategy("Param String")).defaultParam();

    // Assert
    assertEquals(1, actualDefaultParamResult.size());
    ParamItem getResult = actualDefaultParamResult.get(GlobalPreemptibleStrategy.STRATEGY_PARAM_PERMIT);
    assertEquals(1, ((Integer) getResult.value).intValue());
    Class<Integer> expectedResultClass = Integer.class;
    assertEquals(expectedResultClass, getResult.type);
  }

  /**
   * Test {@link GlobalPreemptibleStrategy#acquire()}.
   * <p>
   * Method under test: {@link GlobalPreemptibleStrategy#acquire()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean GlobalPreemptibleStrategy.acquire()"})
  public void testAcquire() {
    // Arrange, Act and Assert
    assertTrue((new GlobalPreemptibleStrategy("Param String")).acquire());
  }
}
